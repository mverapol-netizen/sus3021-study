package cl.uc.sus3021study.model

data class Concept(
    val name: String,
    val definition: String,
    val whyItMatters: String,
    val example: String
)

data class CaseStudy(
    val name: String,
    val summary: String,
    val analyticalUse: String
)

data class StudyModule(
    val id: Int,
    val title: String,
    val subtitle: String,
    val sessions: String,
    val readings: List<String>,
    val keyPoints: List<String>,
    val concepts: List<Concept>,
    val cases: List<CaseStudy>,
    val practicalExamples: List<String>,
    val examPriority: Boolean = false,
    val available: Boolean = true
)

data class QuizQuestion(
    val id: Int,
    val moduleId: Int,
    val prompt: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String,
    val difficulty: String
)

data class RubricCriterion(
    val label: String,
    val description: String,
    val maxPoints: Int
)

data class DevelopmentExample(
    val id: Int,
    val title: String,
    val prompt: String,
    val thesis: String,
    val structure: List<String>,
    val modelAnswer: String,
    val concepts: List<String>,
    val cases: List<String>,
    val rubric: List<RubricCriterion> = emptyList()
)

data class MatrixEntry(
    val concept: String,
    val author: String,
    val coreIdea: String,
    val caseLinks: List<String>,
    val examUse: String
)

data class TimelineEvent(
    val period: String,
    val title: String,
    val detail: String,
    val concepts: List<String> = emptyList()
)

data class CaseTimeline(
    val caseName: String,
    val subtitle: String,
    val events: List<TimelineEvent>
)

data class QuestionProgress(
    val attempts: Int = 0,
    val correct: Int = 0,
    val streak: Int = 0,
    val box: Int = 0,
    val nextDueEpochDay: Long = 0L,
    val lastWasCorrect: Boolean? = null
)


data class ReadingSheet(
    val id: Int,
    val moduleId: Int,
    val title: String,
    val author: String,
    val source: String,
    val centralQuestion: String,
    val thesis: String,
    val argumentMap: List<String>,
    val keyConcepts: List<String>,
    val tensions: List<String>,
    val caseConnections: List<String>,
    val examPrompts: List<String>,
    val mustRemember: String,
    val priority: String = "Alta"
)

data class ActorRole(
    val actor: String,
    val role: String
)

data class CaseDossier(
    val id: Int,
    val name: String,
    val source: String,
    val coreProblem: String,
    val actors: List<ActorRole>,
    val knowledgeBase: List<String>,
    val mechanisms: List<String>,
    val barriers: List<String>,
    val facilitators: List<String>,
    val outcome: String,
    val concepts: List<String>,
    val examAngles: List<String>,
    val caution: String
)

data class CaseComparisonRow(
    val dimension: String,
    val soil: String,
    val wetlands: String,
    val thermal: String,
    val neuro: String
)

data class Flashcard(
    val id: Int,
    val moduleId: Int,
    val front: String,
    val back: String,
    val author: String,
    val concept: String,
    val caseLinks: List<String> = emptyList(),
    val source: String = ""
)

data class OralPrompt(
    val id: Int,
    val moduleId: Int,
    val question: String,
    val expectedPoints: List<String>,
    val author: String,
    val concepts: List<String>,
    val caseSuggestion: String? = null,
    val seconds: Int = 60
)

data class MasteryStat(
    val label: String,
    val kind: String,
    val linkedQuestions: Int,
    val attemptedQuestions: Int,
    val totalAttempts: Int,
    val totalCorrect: Int,
    val meanBox: Double,
    val score: Int
)

data class KnowledgeCombination(
    val author: String,
    val caseName: String,
    val concepts: List<String>,
    val rationale: String
)

data class AdaptiveRouteItem(
    val combination: KnowledgeCombination,
    val score: Int,
    val reason: String,
    val suggestedAction: String
)

data class StudySessionTask(
    val title: String,
    val minutes: Int,
    val type: String,
    val instructions: String,
    val focus: String
)

data class StudySessionPlan(
    val durationMinutes: Int,
    val title: String,
    val rationale: String,
    val tasks: List<StudySessionTask>,
    val finishPrompt: String
)

data class StructuralCheck(
    val label: String,
    val detected: Boolean,
    val evidence: String,
    val suggestion: String
)

data class StructuralAnalysis(
    val checks: List<StructuralCheck>,
    val coverageScore: Int,
    val detectedConcepts: List<String>,
    val detectedCases: List<String>,
    val wordCount: Int
)

data class DailyStudyGoal(
    val dateEpochDay: Long,
    val label: String,
    val phase: String,
    val minutes: Int,
    val focus: String,
    val goals: List<String>,
    val rationale: String,
    val isExamDay: Boolean = false
)

data class ExamAttempt(
    val id: Long,
    val mode: String,
    val correct: Int,
    val total: Int,
    val developmentScore: Int? = null,
    val developmentMax: Int? = null,
    val elapsedSeconds: Int? = null,
    val questionIds: List<Int> = emptyList()
) {
    val objectivePercent: Int
        get() = if (total <= 0) 0 else (correct * 100 / total)
}

data class ErrorPattern(
    val label: String,
    val kind: String,
    val linkedQuestions: Int,
    val attempts: Int,
    val errors: Int,
    val errorRate: Int,
    val recurring: Boolean,
    val suggestion: String
)

data class FinalExamBlueprint(
    val title: String,
    val minutes: Int,
    val moduleCounts: Map<Int, Int>,
    val developmentCount: Int,
    val note: String
)


data class IntensiveDevelopmentQuestion(
    val id: Int,
    val theme: String,
    val title: String,
    val prompt: String,
    val thesis: String,
    val keyConcepts: List<String>,
    val mechanisms: List<String>,
    val cases: List<String>,
    val outline: List<String>,
    val answerBlocks: List<String>,
    val sourceBasis: List<String>,
    val commonPitfalls: List<String> = emptyList()
)

data class TimedModelAnswer(
    val minutes: Int,
    val targetWords: String,
    val strategy: String,
    val answer: String
)

data class ProfessorFeedback(
    val wordCount: Int,
    val detectedConcepts: List<String>,
    val missingConcepts: List<String>,
    val detectedMechanisms: List<String>,
    val missingMechanisms: List<String>,
    val detectedCases: List<String>,
    val missingCases: List<String>,
    val structuralCoverage: Int,
    val comments: List<String>
)

data class GuidedReadingPlan(
    val id: Int,
    val readingId: Int,
    val durationMinutes: Int,
    val orientation: String,
    val focusSteps: List<String>,
    val selfTest: List<String>,
    val answerKey: List<String>,
    val synthesisPrompt: String,
    val modelSynthesis: String
)

data class ConceptStudyCard(
    val id: Int,
    val moduleId: Int,
    val name: String,
    val author: String,
    val definition: String,
    val distinction: String,
    val mechanism: String,
    val caseExample: String,
    val examUse: String,
    val commonError: String,
    val recallPrompts: List<String>,
    val sourceBasis: String,
    val priority: String = "Alta"
)

