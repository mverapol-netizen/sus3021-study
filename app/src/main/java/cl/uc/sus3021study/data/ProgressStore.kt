package cl.uc.sus3021study.data

import android.content.Context
import cl.uc.sus3021study.model.QuestionProgress
import cl.uc.sus3021study.model.ExamAttempt
import java.time.LocalDate

class ProgressStore(context: Context) {
    private val prefs = context.getSharedPreferences("sus3021_progress", Context.MODE_PRIVATE)

    fun completedModules(): Set<Int> = prefs.getStringSet("completed_modules", emptySet())
        ?.mapNotNull { it.toIntOrNull() }
        ?.toSet() ?: emptySet()

    fun setCompleted(moduleId: Int, completed: Boolean) {
        val current = completedModules().toMutableSet()
        if (completed) current.add(moduleId) else current.remove(moduleId)
        prefs.edit().putStringSet("completed_modules", current.map { it.toString() }.toSet()).apply()
    }

    fun questionProgress(questionId: Int): QuestionProgress = progressForKey("q_$questionId")

    fun recordAnswer(questionId: Int, wasCorrect: Boolean): QuestionProgress =
        recordProgress("q_$questionId", wasCorrect)

    fun flashcardProgress(cardId: Int): QuestionProgress = progressForKey("f_$cardId")

    fun recordFlashcard(cardId: Int, knewIt: Boolean): QuestionProgress =
        recordProgress("f_$cardId", knewIt)

    fun oralProgress(promptId: Int): QuestionProgress = progressForKey("o_$promptId")

    fun recordOral(promptId: Int, explainedWell: Boolean): QuestionProgress =
        recordProgress("o_$promptId", explainedWell)

    fun failedQuestionIds(): Set<Int> = idsForPrefix("q_") { it.lastWasCorrect == false }

    fun dueQuestionIds(): Set<Int> {
        val today = LocalDate.now().toEpochDay()
        return idsForPrefix("q_") { it.attempts > 0 && it.nextDueEpochDay <= today }
    }

    fun dueFlashcardIds(): Set<Int> {
        val today = LocalDate.now().toEpochDay()
        return idsForPrefix("f_") { it.attempts > 0 && it.nextDueEpochDay <= today }
    }

    fun failedFlashcardIds(): Set<Int> = idsForPrefix("f_") { it.lastWasCorrect == false }

    fun attemptedCount(): Int = countProgress("q_") { it.attempts > 0 }

    fun masteredCount(): Int = countProgress("q_") { it.box >= 4 }

    fun attemptedFlashcards(): Int = countProgress("f_") { it.attempts > 0 }

    fun masteredFlashcards(): Int = countProgress("f_") { it.box >= 4 }

    fun attemptedOralPrompts(): Int = countProgress("o_") { it.attempts > 0 }

    fun adaptiveIds(allIds: List<Int>, limit: Int = 20): List<Int> {
        val today = LocalDate.now().toEpochDay()
        return allIds.sortedWith(
            compareBy<Int> {
                val q = questionProgress(it)
                when {
                    q.lastWasCorrect == false -> 0
                    q.attempts > 0 && q.nextDueEpochDay <= today -> 1
                    q.attempts == 0 -> 2
                    else -> 3
                }
            }.thenBy { questionProgress(it).box }
             .thenBy { questionProgress(it).attempts }
        ).take(limit)
    }

    fun adaptiveFlashcardIds(allIds: List<Int>, limit: Int = 15): List<Int> {
        val today = LocalDate.now().toEpochDay()
        return allIds.sortedWith(
            compareBy<Int> {
                val q = flashcardProgress(it)
                when {
                    q.lastWasCorrect == false -> 0
                    q.attempts > 0 && q.nextDueEpochDay <= today -> 1
                    q.attempts == 0 -> 2
                    else -> 3
                }
            }.thenBy { flashcardProgress(it).box }
             .thenBy { flashcardProgress(it).attempts }
        ).take(limit)
    }

    fun lastExamIds(mode: String): Set<Int> = prefs.getStringSet("exam_$mode", emptySet())
        ?.mapNotNull { it.toIntOrNull() }
        ?.toSet() ?: emptySet()

    fun saveLastExamIds(mode: String, ids: List<Int>) {
        prefs.edit().putStringSet("exam_$mode", ids.map { it.toString() }.toSet()).apply()
    }

    fun recordExamAttempt(
        mode: String,
        correct: Int,
        total: Int,
        developmentScore: Int? = null,
        developmentMax: Int? = null,
        elapsedSeconds: Int? = null,
        questionIds: List<Int> = emptyList()
    ): Long {
        val id = System.currentTimeMillis()
        val attempt = ExamAttempt(id, mode, correct, total, developmentScore, developmentMax, elapsedSeconds, questionIds)
        val current = prefs.getStringSet("exam_attempts_v1", emptySet())?.toMutableSet() ?: mutableSetOf()
        current += serializeAttempt(attempt)
        prefs.edit().putStringSet("exam_attempts_v1", current).apply()
        return id
    }

    fun updateExamDevelopment(id: Long, score: Int, max: Int) {
        val current = prefs.getStringSet("exam_attempts_v1", emptySet())?.toMutableSet() ?: return
        val existingRaw = current.firstOrNull { parseAttempt(it)?.id == id } ?: return
        val existing = parseAttempt(existingRaw) ?: return
        current.remove(existingRaw)
        current += serializeAttempt(existing.copy(developmentScore = score, developmentMax = max))
        prefs.edit().putStringSet("exam_attempts_v1", current).apply()
    }

    fun examAttempts(limit: Int = 20): List<ExamAttempt> = prefs.getStringSet("exam_attempts_v1", emptySet())
        ?.mapNotNull { parseAttempt(it) }
        ?.sortedByDescending { it.id }
        ?.take(limit)
        ?: emptyList()

    fun completedDailyPlanDates(): Set<Long> = prefs.getStringSet("daily_plan_done", emptySet())
        ?.mapNotNull { it.toLongOrNull() }
        ?.toSet() ?: emptySet()

    fun setDailyPlanCompleted(epochDay: Long, completed: Boolean) {
        val current = completedDailyPlanDates().toMutableSet()
        if (completed) current += epochDay else current -= epochDay
        prefs.edit().putStringSet("daily_plan_done", current.map { it.toString() }.toSet()).apply()
    }


    fun completedGuidedReadingIds(): Set<Int> = prefs.getStringSet("guided_readings_done", emptySet())
        ?.mapNotNull { it.toIntOrNull() }
        ?.toSet() ?: emptySet()

    fun setGuidedReadingCompleted(readingId: Int, completed: Boolean) {
        val current = completedGuidedReadingIds().toMutableSet()
        if (completed) current += readingId else current -= readingId
        prefs.edit().putStringSet("guided_readings_done", current.map { it.toString() }.toSet()).apply()
    }

    fun completedConceptCardIds(): Set<Int> = prefs.getStringSet("concept_cards_done", emptySet())
        ?.mapNotNull { it.toIntOrNull() }
        ?.toSet() ?: emptySet()

    fun setConceptCardCompleted(cardId: Int, completed: Boolean) {
        val current = completedConceptCardIds().toMutableSet()
        if (completed) current += cardId else current -= cardId
        prefs.edit().putStringSet("concept_cards_done", current.map { it.toString() }.toSet()).apply()
    }

    fun resetQuestionProgress() {
        val editor = prefs.edit()
        prefs.all.keys.filter { it.startsWith("q_") }.forEach { editor.remove(it) }
        editor.apply()
    }

    fun resetAllPracticeProgress() {
        val editor = prefs.edit()
        prefs.all.keys.filter { it.startsWith("q_") || it.startsWith("f_") || it.startsWith("o_") }
            .forEach { editor.remove(it) }
        editor.apply()
    }

    private fun serializeAttempt(a: ExamAttempt): String = listOf(
        a.id.toString(),
        a.mode.replace("~", "-"),
        a.correct.toString(),
        a.total.toString(),
        (a.developmentScore ?: -1).toString(),
        (a.developmentMax ?: -1).toString(),
        (a.elapsedSeconds ?: -1).toString(),
        a.questionIds.joinToString(",")
    ).joinToString("~")

    private fun parseAttempt(raw: String): ExamAttempt? {
        val p = raw.split("~", limit = 8)
        if (p.size < 8) return null
        val devScore = p[4].toIntOrNull()?.takeIf { it >= 0 }
        val devMax = p[5].toIntOrNull()?.takeIf { it >= 0 }
        val elapsed = p[6].toIntOrNull()?.takeIf { it >= 0 }
        val ids = if (p[7].isBlank()) emptyList() else p[7].split(",").mapNotNull { it.toIntOrNull() }
        return ExamAttempt(
            id = p[0].toLongOrNull() ?: return null,
            mode = p[1],
            correct = p[2].toIntOrNull() ?: 0,
            total = p[3].toIntOrNull() ?: 0,
            developmentScore = devScore,
            developmentMax = devMax,
            elapsedSeconds = elapsed,
            questionIds = ids
        )
    }

    private fun progressForKey(key: String): QuestionProgress {
        val raw = prefs.getString(key, null) ?: return QuestionProgress()
        val p = raw.split("|")
        if (p.size < 6) return QuestionProgress()
        return QuestionProgress(
            attempts = p[0].toIntOrNull() ?: 0,
            correct = p[1].toIntOrNull() ?: 0,
            streak = p[2].toIntOrNull() ?: 0,
            box = p[3].toIntOrNull() ?: 0,
            nextDueEpochDay = p[4].toLongOrNull() ?: 0L,
            lastWasCorrect = when (p[5]) { "1" -> true; "0" -> false; else -> null }
        )
    }

    private fun recordProgress(key: String, wasCorrect: Boolean): QuestionProgress {
        val old = progressForKey(key)
        val newBox = if (wasCorrect) (old.box + 1).coerceAtMost(5) else 0
        val intervals = longArrayOf(0, 1, 3, 7, 14, 30)
        val due = LocalDate.now().toEpochDay() + intervals[newBox]
        val next = QuestionProgress(
            attempts = old.attempts + 1,
            correct = old.correct + if (wasCorrect) 1 else 0,
            streak = if (wasCorrect) old.streak + 1 else 0,
            box = newBox,
            nextDueEpochDay = due,
            lastWasCorrect = wasCorrect
        )
        val last = when (next.lastWasCorrect) { true -> "1"; false -> "0"; null -> "-" }
        prefs.edit().putString(
            key,
            listOf(next.attempts, next.correct, next.streak, next.box, next.nextDueEpochDay, last).joinToString("|")
        ).apply()
        return next
    }

    private fun idsForPrefix(prefix: String, predicate: (QuestionProgress) -> Boolean): Set<Int> = prefs.all.keys
        .filter { it.startsWith(prefix) }
        .mapNotNull { key ->
            val id = key.removePrefix(prefix).toIntOrNull() ?: return@mapNotNull null
            if (predicate(progressForKey(key))) id else null
        }.toSet()

    private fun countProgress(prefix: String, predicate: (QuestionProgress) -> Boolean): Int = prefs.all.keys.count { key ->
        key.startsWith(prefix) && predicate(progressForKey(key))
    }
}
