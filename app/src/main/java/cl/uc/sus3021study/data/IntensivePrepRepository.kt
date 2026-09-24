package cl.uc.sus3021study.data

import cl.uc.sus3021study.model.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.math.roundToInt

object IntensivePrepRepository {
    val examDate: LocalDate = LocalDate.of(2026, 9, 30)

    val finalBlueprint = FinalExamBlueprint(
        title = "Examen final de práctica",
        minutes = 60,
        moduleCounts = (1..6).associateWith { 5 },
        developmentCount = 1,
        note = "Blueprint pedagógico interno: 30 alternativas balanceadas entre los seis módulos prioritarios + 1 desarrollo. El programa del curso fija la prueba y su ponderación, pero no entrega en los materiales disponibles una distribución oficial de ítems; por eso este formato no pretende reproducir el examen real."
    )

    fun calendar(
        questions: List<QuizQuestion>,
        progress: (Int) -> QuestionProgress,
        today: LocalDate = LocalDate.now(),
        exam: LocalDate = examDate
    ): List<DailyStudyGoal> {
        if (today.isAfter(exam)) return emptyList()
        val route = AdaptiveStudyRepository.adaptiveRoute(questions, progress, limit = 10)
        val weakAuthors = AdaptiveStudyRepository.masteryByAuthor(questions, progress).take(4)
        val weakCases = AdaptiveStudyRepository.masteryByCase(questions, progress).take(4)
        val dates = generateSequence(today) { it.plusDays(1) }.takeWhile { !it.isAfter(exam) }.toList()
        val fmt = DateTimeFormatter.ofPattern("EEE d MMM", Locale("es", "CL"))

        return dates.mapIndexed { index, date ->
            val remaining = java.time.temporal.ChronoUnit.DAYS.between(date, exam).toInt()
            val combo = route.getOrNull(index % route.size.coerceAtLeast(1))?.combination
            val author = weakAuthors.getOrNull(index % weakAuthors.size.coerceAtLeast(1))?.label
            val caseName = weakCases.getOrNull(index % weakCases.size.coerceAtLeast(1))?.label
            val focus = combo?.let { "${it.author} × ${it.caseName}" }
                ?: listOfNotNull(author, caseName).joinToString(" × ").ifBlank { "conceptos y casos prioritarios" }

            when {
                remaining == 0 -> DailyStudyGoal(
                    date.toEpochDay(), fmt.format(date).replaceFirstChar { it.uppercase() }, "Día de prueba", 15,
                    "Recuperación ligera",
                    listOf(
                        "Repasa sólo 8–10 flashcards ya conocidas.",
                        "Reconstruye mentalmente las cuatro distinciones más importantes sin abrir apuntes.",
                        "No hagas un simulacro completo ni incorpores materia nueva."
                    ),
                    "La meta es llegar con estructuras recuperables y baja carga cognitiva, no aumentar volumen.",
                    isExamDay = true
                )
                remaining == 1 -> DailyStudyGoal(
                    date.toEpochDay(), fmt.format(date).replaceFirstChar { it.uppercase() }, "Consolidación final", 55,
                    focus,
                    listOf(
                        "Revisa preguntas falladas y vencidas.",
                        "Haz 12–15 flashcards de alto rendimiento.",
                        "Resuelve un simulacro corto sin feedback inmediato.",
                        "Escribe dos esqueletos de desarrollo: tesis → concepto → mecanismo → caso → cierre."
                    ),
                    "No se agrega materia nueva. Se consolida recuperación, discriminación conceptual y estructura de respuesta."
                )
                remaining <= 3 -> DailyStudyGoal(
                    date.toEpochDay(), fmt.format(date).replaceFirstChar { it.uppercase() }, "Integración y examen", 45,
                    focus,
                    listOf(
                        "Responde 15 alternativas priorizando preguntas no vistas o falladas.",
                        "Explica oralmente dos conceptos y aplica cada uno a un caso distinto.",
                        "Escribe una respuesta de desarrollo de 250–400 palabras.",
                        "Cierra revisando sólo errores y la distinción que los habría evitado."
                    ),
                    "A pocos días de la prueba conviene pasar de reconocimiento a producción: comparar, explicar mecanismos y usar evidencia del caso."
                )
                remaining <= 5 -> DailyStudyGoal(
                    date.toEpochDay(), fmt.format(date).replaceFirstChar { it.uppercase() }, "Consolidación teoría–caso", 35,
                    focus,
                    listOf(
                        "Haz 8 flashcards del foco más débil.",
                        "Responde 10 preguntas de alternativa del mismo eje.",
                        "Formula una cadena concepto → mecanismo → episodio del caso.",
                        "Contrasta el foco con un segundo autor o caso."
                    ),
                    "El objetivo es convertir conocimiento aislado en relaciones explicativas que puedan usarse en desarrollo."
                )
                else -> DailyStudyGoal(
                    date.toEpochDay(), fmt.format(date).replaceFirstChar { it.uppercase() }, "Cobertura y precisión", 25,
                    focus,
                    listOf(
                        "Repasa la ficha de lectura asociada al foco.",
                        "Haz 6 flashcards y 8 alternativas.",
                        "Define sin mirar dos conceptos centrales.",
                        "Identifica qué caso ilustra mejor cada concepto y por qué."
                    ),
                    "La prioridad inicial es cerrar lagunas conceptuales antes de exigir integración compleja."
                )
            }
        }
    }

    fun errorPatterns(
        questions: List<QuizQuestion>,
        progress: (Int) -> QuestionProgress,
        limit: Int = 16
    ): List<ErrorPattern> {
        data class Bucket(val kind: String, val label: String, val ids: MutableSet<Int> = mutableSetOf())
        val buckets = linkedMapOf<String, Bucket>()
        fun add(kind: String, label: String, id: Int) {
            val key = "$kind|$label"
            buckets.getOrPut(key) { Bucket(kind, label) }.ids += id
        }
        questions.forEach { q ->
            AdaptiveStudyRepository.authorTags(q).forEach { add("Autor", it, q.id) }
            AdaptiveStudyRepository.conceptTags(q).forEach { add("Concepto", it, q.id) }
            AdaptiveStudyRepository.caseTags(q).forEach { add("Caso", it, q.id) }
        }
        return buckets.values.mapNotNull { b ->
            val ps = b.ids.map { progress(it) }
            val attempts = ps.sumOf { it.attempts }
            val errors = ps.sumOf { (it.attempts - it.correct).coerceAtLeast(0) }
            if (attempts == 0 || errors == 0) return@mapNotNull null
            val rate = (errors * 100.0 / attempts).roundToInt().coerceIn(0, 100)
            val suggestion = when (b.kind) {
                "Autor" -> "Relee la tesis del autor y responde 3 preguntas que exijan distinguirlo de otro marco."
                "Caso" -> "Reconstruye actores, mecanismo y resultado del caso antes de volver a las alternativas."
                else -> "Escribe definición + contraste + ejemplo de caso en tres líneas y vuelve a practicar."
            }
            ErrorPattern(b.label, b.kind, b.ids.size, attempts, errors, rate, errors >= 2, suggestion)
        }.sortedWith(compareByDescending<ErrorPattern> { it.errors }.thenByDescending { it.errorRate }).take(limit)
    }

    fun freshFinalExam(
        questions: List<QuizQuestion>,
        progress: (Int) -> QuestionProgress,
        previousIds: Set<Int> = emptySet(),
        counts: Map<Int, Int> = finalBlueprint.moduleCounts
    ): List<QuizQuestion> {
        return counts.flatMap { (module, n) ->
            val pool = questions.filter { it.moduleId == module }
            val ranked = pool.shuffled().sortedWith(
                compareBy<QuizQuestion> {
                    val p = progress(it.id)
                    when {
                        p.attempts == 0 && it.id !in previousIds -> 0
                        p.attempts == 0 -> 1
                        it.id !in previousIds -> 2
                        else -> 3
                    }
                }.thenBy { progress(it.id).attempts }
                 .thenBy { progress(it.id).box }
            )
            ranked.take(n)
        }.shuffled()
    }

    fun dailyTargetSummary(questions: List<QuizQuestion>, progress: (Int) -> QuestionProgress): String {
        val author = AdaptiveStudyRepository.masteryByAuthor(questions, progress).firstOrNull()
        val caseName = AdaptiveStudyRepository.masteryByCase(questions, progress).firstOrNull()
        return when {
            author == null && caseName == null -> "Comienza con cobertura general de los seis módulos prioritarios."
            author != null && caseName != null -> "Prioridad actual: ${author.label} (${author.score}%) + ${caseName.label} (${caseName.score}%)."
            author != null -> "Prioridad actual: ${author.label} (${author.score}%)."
            else -> "Prioridad actual: ${caseName!!.label} (${caseName.score}%)."
        }
    }
}
