package cl.uc.sus3021study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.uc.sus3021study.data.CourseRepository
import cl.uc.sus3021study.data.AdaptiveStudyRepository
import cl.uc.sus3021study.data.DeepStudyRepository
import cl.uc.sus3021study.data.ProgressStore
import cl.uc.sus3021study.data.StudyToolsRepository
import cl.uc.sus3021study.data.StudySessionRepository
import cl.uc.sus3021study.data.IntensivePrepRepository
import cl.uc.sus3021study.data.DevelopmentAnalyzer
import cl.uc.sus3021study.data.DevelopmentIntensiveRepository
import cl.uc.sus3021study.data.GuidedStudyRepository
import cl.uc.sus3021study.data.ProfessorModeAnalyzer
import cl.uc.sus3021study.model.CaseTimeline
import cl.uc.sus3021study.model.CaseDossier
import cl.uc.sus3021study.model.ReadingSheet
import cl.uc.sus3021study.model.DevelopmentExample
import cl.uc.sus3021study.model.MatrixEntry
import cl.uc.sus3021study.model.QuizQuestion
import cl.uc.sus3021study.model.StudyModule
import cl.uc.sus3021study.model.Flashcard
import cl.uc.sus3021study.model.OralPrompt
import cl.uc.sus3021study.model.MasteryStat
import cl.uc.sus3021study.model.AdaptiveRouteItem
import cl.uc.sus3021study.model.StudySessionPlan
import cl.uc.sus3021study.model.StructuralAnalysis
import cl.uc.sus3021study.model.ExamAttempt
import cl.uc.sus3021study.model.ErrorPattern
import cl.uc.sus3021study.model.DailyStudyGoal
import cl.uc.sus3021study.model.IntensiveDevelopmentQuestion
import cl.uc.sus3021study.model.GuidedReadingPlan
import cl.uc.sus3021study.model.ConceptStudyCard
import cl.uc.sus3021study.ui.theme.SUS3021Theme
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { SUS3021Theme { StudyApp() } }
    }
}

enum class Tab { HOME, STUDY, QUIZ, DEVELOPMENT, MAP }
enum class QuizMode { QUICK, MOCK, WRONG, ADAPTIVE, BANK }
enum class ToolView { GUIDED, MATRIX, TIMELINES, READINGS, CASES, COMPARE, MASTERY }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudyApp() {
    var tab by rememberSaveable { mutableStateOf(Tab.HOME) }
    var selectedModule by remember { mutableStateOf<StudyModule?>(null) }
    var selectedDevelopment by remember { mutableStateOf<DevelopmentExample?>(null) }
    var practiceDevelopment by remember { mutableStateOf<DevelopmentExample?>(null) }
    var studyPlanMinutes by rememberSaveable { mutableStateOf<Int?>(null) }
    var dayBeforeActive by rememberSaveable { mutableStateOf(false) }
    var intensivePrepActive by rememberSaveable { mutableStateOf(false) }
    var intensiveDevelopmentActive by rememberSaveable { mutableStateOf(false) }
    var professorModeActive by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current
    val progressStore = remember { ProgressStore(context) }
    var completedModules by remember { mutableStateOf(progressStore.completedModules()) }
    var refreshTick by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("SUS3021 Study", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                        Text("Ciencia, evidencia y Congreso", fontSize = 12.sp)
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                listOf(
                    Tab.HOME to "Inicio",
                    Tab.STUDY to "Estudio",
                    Tab.QUIZ to "Quiz",
                    Tab.DEVELOPMENT to "Desarrollo",
                    Tab.MAP to "Mapa"
                ).forEach { (item, label) ->
                    NavigationBarItem(
                        selected = tab == item,
                        onClick = {
                            selectedModule = null
                            selectedDevelopment = null
                            practiceDevelopment = null
                            studyPlanMinutes = null
                            dayBeforeActive = false
                            intensivePrepActive = false
                            intensiveDevelopmentActive = false
                            professorModeActive = false
                            tab = item
                        },
                        icon = { Text(label.take(1), fontWeight = FontWeight.Bold) },
                        label = { Text(label, maxLines = 1, fontSize = 10.sp) }
                    )
                }
            }
        }
    ) { padding ->
        Box(Modifier.padding(padding)) {
            when {
                studyPlanMinutes != null -> GuidedStudyPlanScreen(
                    minutes = studyPlanMinutes!!,
                    progressStore = progressStore,
                    onExit = { studyPlanMinutes = null; refreshTick++ }
                )
                dayBeforeActive -> DayBeforeStudyScreen(
                    progressStore = progressStore,
                    onExit = { dayBeforeActive = false; refreshTick++ }
                )
                intensivePrepActive -> IntensivePrepScreen(
                    progressStore = progressStore,
                    refreshTick = refreshTick,
                    onExit = { intensivePrepActive = false; refreshTick++ }
                )
                intensiveDevelopmentActive -> IntensiveDevelopmentBankScreen(
                    onExit = { intensiveDevelopmentActive = false }
                )
                professorModeActive -> ProfessorModeScreen(
                    onExit = { professorModeActive = false }
                )
                selectedModule != null -> ModuleDetailScreen(
                    module = selectedModule!!,
                    completed = selectedModule!!.id in completedModules,
                    onBack = { selectedModule = null },
                    onToggleCompleted = { value ->
                        progressStore.setCompleted(selectedModule!!.id, value)
                        completedModules = progressStore.completedModules()
                    }
                )
                selectedDevelopment != null -> DevelopmentDetailScreen(
                    example = selectedDevelopment!!,
                    onBack = { selectedDevelopment = null }
                )
                practiceDevelopment != null -> DevelopmentPracticeScreen(
                    example = practiceDevelopment!!,
                    onBack = { practiceDevelopment = null }
                )
                else -> when (tab) {
                    Tab.HOME -> HomeScreen(
                        completedModules = completedModules,
                        progressStore = progressStore,
                        refreshTick = refreshTick,
                        onOpenStudy = { tab = Tab.STUDY },
                        onOpenQuiz = { tab = Tab.QUIZ },
                        onOpenDevelopment = { tab = Tab.DEVELOPMENT },
                        onOpenMap = { tab = Tab.MAP },
                        onOpenModule = { selectedModule = it },
                        onOpenStudyPlan = { studyPlanMinutes = it },
                        onOpenDayBefore = { dayBeforeActive = true },
                        onOpenIntensivePrep = { intensivePrepActive = true }
                    )
                    Tab.STUDY -> StudyScreen(onOpenModule = { selectedModule = it }, completedModules = completedModules)
                    Tab.QUIZ -> QuizScreen(progressStore = progressStore, onProgressChanged = { refreshTick++ })
                    Tab.DEVELOPMENT -> DevelopmentScreen(
                        onOpen = { selectedDevelopment = it },
                        onPractice = { practiceDevelopment = it },
                        onOpenIntensive = { intensiveDevelopmentActive = true },
                        onOpenProfessor = { professorModeActive = true }
                    )
                    Tab.MAP -> StudyMapScreen(progressStore = progressStore, refreshTick = refreshTick)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    completedModules: Set<Int>,
    progressStore: ProgressStore,
    refreshTick: Int,
    onOpenStudy: () -> Unit,
    onOpenQuiz: () -> Unit,
    onOpenDevelopment: () -> Unit,
    onOpenMap: () -> Unit,
    onOpenModule: (StudyModule) -> Unit,
    onOpenStudyPlan: (Int) -> Unit,
    onOpenDayBefore: () -> Unit,
    onOpenIntensivePrep: () -> Unit
) {
    val examModules = CourseRepository.modules.filter { it.examPriority && it.available }
    val done = examModules.count { it.id in completedModules }
    val progress = if (examModules.isEmpty()) 0f else done.toFloat() / examModules.size
    val examDate = LocalDate.of(2026, 9, 30)
    val days = ChronoUnit.DAYS.between(LocalDate.now(), examDate).coerceAtLeast(0)
    val attempted = remember(refreshTick) { progressStore.attemptedCount() }
    val mastered = remember(refreshTick) { progressStore.masteredCount() }
    val failed = remember(refreshTick) { progressStore.failedQuestionIds().size }
    val due = remember(refreshTick) { progressStore.dueQuestionIds().size }
    val adaptiveRoute = remember(refreshTick) {
        AdaptiveStudyRepository.adaptiveRoute(CourseRepository.questions, { id -> progressStore.questionProgress(id) }, limit = 3)
    }

    Column(
        Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Surface(
            color = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(Modifier.padding(22.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text("Preparación de la prueba", color = Color.White, fontSize = 13.sp)
                Text("Domina conceptos, mecanismos y casos", color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("30 de septiembre · ${days} días restantes · ponderación 20%", color = Color.White.copy(alpha = .84f), fontSize = 13.sp)
                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier.fillMaxWidth().height(7.dp).clip(RoundedCornerShape(8.dp)),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    trackColor = Color.White.copy(alpha = .18f)
                )
                Text("$done de ${examModules.size} módulos prioritarios marcados como estudiados", color = Color.White.copy(alpha = .9f), fontSize = 12.sp)
            }
        }

        Text("Tu progreso de recuperación", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            StatCard("$attempted", "preguntas vistas", Modifier.weight(1f))
            StatCard("$mastered", "dominadas", Modifier.weight(1f))
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            StatCard("$failed", "falladas", Modifier.weight(1f))
            StatCard("$due", "para repasar", Modifier.weight(1f))
        }

        Text("Ruta adaptativa", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Se recalcula con tus respuestas y prioriza cruces de autor + caso que todavía no están consolidados.", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.65f))
        adaptiveRoute.forEach { item -> AdaptiveRouteCard(item) }
        TextButton(onClick = onOpenMap, modifier = Modifier.align(Alignment.End)) { Text("Ver dominio completo") }

        Text("Ruta rápida", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            ActionCard("Repasar", "Puntos clave y conceptos", Modifier.weight(1f), onOpenStudy)
            ActionCard("Practicar", "120 preguntas + modos adaptativos", Modifier.weight(1f), onOpenQuiz)
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            ActionCard("Desarrollo", "Responder con rúbrica", Modifier.weight(1f), onOpenDevelopment)
            ActionCard("Mapa", "Conceptos × autores × casos", Modifier.weight(1f), onOpenMap)
        }

        Text("Sesión automática", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Elige el tiempo disponible. La app arma una secuencia usando tus debilidades registradas.", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.65f))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ActionCard("15 min", "Express", Modifier.weight(1f)) { onOpenStudyPlan(15) }
            ActionCard("25 min", "Estándar", Modifier.weight(1f)) { onOpenStudyPlan(25) }
            ActionCard("45 min", "Profunda", Modifier.weight(1f)) { onOpenStudyPlan(45) }
        }
        Surface(
            shape = RoundedCornerShape(18.dp),
            color = MaterialTheme.colorScheme.secondaryContainer,
            modifier = Modifier.fillMaxWidth().clickable(onClick = onOpenDayBefore)
        ) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("Modo día antes", fontWeight = FontWeight.Bold)
                Text("Repaso de alto rendimiento: errores, flashcards, simulacro corto y esqueletos de desarrollo. No agrega materia nueva.", fontSize = 13.sp)
                Text(if (days <= 1) "Recomendado para hoy." else "Disponible desde ahora para ensayarlo; úsalo especialmente el 29 de septiembre.", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
            }
        }

        Surface(
            shape = RoundedCornerShape(18.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha=.35f)),
            modifier = Modifier.fillMaxWidth().clickable(onClick = onOpenIntensivePrep)
        ) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("Plan intensivo hasta la prueba", fontWeight = FontWeight.Bold)
                Text(IntensivePrepRepository.dailyTargetSummary(CourseRepository.questions) { id -> progressStore.questionProgress(id) }, fontSize = 13.sp)
                Text("Calendario diario · historial de simulacros · errores recurrentes · metas adaptativas", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
            }
        }

        Text("Prioridad para la prueba", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        examModules.forEach { module ->
            ModuleCompactCard(module, module.id in completedModules) { onOpenModule(module) }
        }
        Spacer(Modifier.height(8.dp))
    }
}

@Composable
fun StatCard(value: String, label: String, modifier: Modifier = Modifier) {
    Surface(modifier = modifier, shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = .55f)) {
        Column(Modifier.padding(14.dp)) {
            Text(value, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(label, fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .65f))
        }
    }
}

@Composable
fun ActionCard(title: String, subtitle: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Surface(
        modifier = modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(18.dp),
        tonalElevation = 1.dp,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .25f))
    ) {
        Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Text(title, fontWeight = FontWeight.Bold)
            Text(subtitle, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .65f))
        }
    }
}

@Composable
fun ModuleCompactCard(module: StudyModule, completed: Boolean, onClick: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .18f))
    ) {
        Row(Modifier.padding(15.dp), verticalAlignment = Alignment.CenterVertically) {
            Surface(
                color = if (completed) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    if (completed) "OK" else module.id.toString(),
                    Modifier.padding(horizontal = 11.dp, vertical = 9.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(module.title, fontWeight = FontWeight.SemiBold)
                Text(module.subtitle, fontSize = 12.sp, maxLines = 2, overflow = TextOverflow.Ellipsis, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .65f))
            }
        }
    }
}

@Composable
fun StudyScreen(onOpenModule: (StudyModule) -> Unit, completedModules: Set<Int>) {
    var priorityOnly by rememberSaveable { mutableStateOf(true) }
    val modules = CourseRepository.modules.filter { !priorityOnly || it.examPriority }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Plan de estudio", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        Text("Organizado según el programa. La vista prioritaria cubre el bloque hasta la prueba del 30 de septiembre.", fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .68f))
        Spacer(Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(selected = priorityOnly, onClick = { priorityOnly = true }, label = { Text("Para la prueba") })
            FilterChip(selected = !priorityOnly, onClick = { priorityOnly = false }, label = { Text("Curso completo") })
        }
        Spacer(Modifier.height(10.dp))
        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            modules.forEach { module ->
                Surface(
                    modifier = Modifier.fillMaxWidth().clickable(enabled = module.available) { onOpenModule(module) },
                    shape = RoundedCornerShape(18.dp),
                    color = if (module.available) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = .6f),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .18f))
                ) {
                    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                            Text("Módulo ${module.id}", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.weight(1f))
                            when {
                                !module.available -> Text("Pendiente de materiales", fontSize = 11.sp)
                                module.id in completedModules -> Text("Estudiado", fontSize = 11.sp, color = MaterialTheme.colorScheme.primary)
                                module.examPriority -> Text("Prioritario", fontSize = 11.sp, color = MaterialTheme.colorScheme.secondary)
                            }
                        }
                        Text(module.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(module.subtitle, fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .7f))
                        Text(module.sessions, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .55f))
                    }
                }
            }
            Spacer(Modifier.height(12.dp))
        }
    }
}

@Composable
fun ModuleDetailScreen(module: StudyModule, completed: Boolean, onBack: () -> Unit, onToggleCompleted: (Boolean) -> Unit) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
        TextButton(onClick = onBack) { Text("Volver al plan") }
        Text(module.title, fontSize = 27.sp, fontWeight = FontWeight.Bold)
        Text(module.subtitle, fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .68f))
        Text(module.sessions, fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)

        Button(onClick = { onToggleCompleted(!completed) }, modifier = Modifier.fillMaxWidth()) {
            Text(if (completed) "Marcar como pendiente" else "Marcar módulo como estudiado")
        }

        SectionTitle("Lecturas y materiales")
        module.readings.forEach { Bullet(it) }

        SectionTitle("Puntos clave")
        module.keyPoints.forEach { Bullet(it) }

        if (module.concepts.isNotEmpty()) {
            SectionTitle("Conceptos")
            module.concepts.forEach { concept ->
                Surface(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = .48f), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(concept.name, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                        Text(concept.definition, fontSize = 14.sp)
                        Text("Por qué importa", fontWeight = FontWeight.SemiBold, fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
                        Text(concept.whyItMatters, fontSize = 13.sp)
                        Text("Ejemplo", fontWeight = FontWeight.SemiBold, fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
                        Text(concept.example, fontSize = 13.sp)
                    }
                }
            }
        }

        if (module.cases.isNotEmpty()) {
            SectionTitle("Casos de estudio")
            module.cases.forEach { case ->
                Surface(shape = RoundedCornerShape(16.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.22f)), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(case.name, fontWeight = FontWeight.Bold)
                        Text(case.summary, fontSize = 13.sp)
                        Text("Uso analítico", fontWeight = FontWeight.SemiBold, fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary)
                        Text(case.analyticalUse, fontSize = 13.sp)
                    }
                }
            }
        }

        if (module.practicalExamples.isNotEmpty()) {
            SectionTitle("Ejemplos prácticos")
            module.practicalExamples.forEach { Bullet(it) }
        }

        if (module.concepts.isNotEmpty()) {
            SectionTitle("Recuperación activa")
            Surface(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = .6f), modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Cierra la pantalla e intenta responder sin mirar:", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    module.concepts.take(4).forEach { concept -> Bullet("Define ${concept.name} y aplícalo a un caso del curso.") }
                    Bullet("Explica en una frase qué mecanismo conecta este módulo con el intercambio de conocimiento en el Congreso.")
                }
            }
        }
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
fun SectionTitle(text: String) {
    Text(text, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 4.dp))
}

@Composable
fun Bullet(text: String) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
        Text("•", fontWeight = FontWeight.Bold, modifier = Modifier.padding(end = 8.dp))
        Text(text, fontSize = 14.sp, lineHeight = 20.sp)
    }
}

@Composable
fun QuizScreen(progressStore: ProgressStore, onProgressChanged: () -> Unit) {
    val all = CourseRepository.questions
    var active by rememberSaveable { mutableStateOf(false) }
    var sessionIds by remember { mutableStateOf<List<Int>>(emptyList()) }
    var modeLabel by remember { mutableStateOf("") }
    var index by rememberSaveable { mutableIntStateOf(0) }
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    var score by rememberSaveable { mutableIntStateOf(0) }
    var answered by rememberSaveable { mutableStateOf(false) }
    var refresh by remember { mutableIntStateOf(0) }
    var mixedActive by rememberSaveable { mutableStateOf(false) }
    var flashcardsActive by rememberSaveable { mutableStateOf(false) }
    var oralActive by rememberSaveable { mutableStateOf(false) }
    var filterActive by rememberSaveable { mutableStateOf(false) }
    var finalExamActive by rememberSaveable { mutableStateOf(false) }
    var examAttemptSaved by rememberSaveable { mutableStateOf(false) }

    if (flashcardsActive) {
        FlashcardPracticeScreen(
            progressStore = progressStore,
            onExit = { flashcardsActive = false; refresh++; onProgressChanged() }
        )
        return
    }

    if (oralActive) {
        OralPracticeScreen(
            progressStore = progressStore,
            onExit = { oralActive = false; refresh++; onProgressChanged() }
        )
        return
    }

    if (mixedActive) {
        MixedExamScreen(
            progressStore = progressStore,
            onExit = { mixedActive = false; refresh++; onProgressChanged() }
        )
        return
    }

    if (finalExamActive) {
        FinalExamScreen(
            progressStore = progressStore,
            onExit = { finalExamActive = false; refresh++; onProgressChanged() }
        )
        return
    }

    if (filterActive) {
        FilteredQuestionBankScreen(
            questions = all,
            onStart = { ids, label ->
                sessionIds = ids
                modeLabel = label
                active = ids.isNotEmpty()
                filterActive = false
                index = 0
                selected = -1
                score = 0
                answered = false
            },
            onExit = { filterActive = false }
        )
        return
    }

    val questionById = remember { all.associateBy { it.id } }
    val failedCount = remember(refresh) { progressStore.failedQuestionIds().size }
    val dueCount = remember(refresh) { progressStore.dueQuestionIds().size }
    val masteredCount = remember(refresh) { progressStore.masteredCount() }

    fun start(mode: QuizMode) {
        val ids = when (mode) {
            QuizMode.QUICK -> all.shuffled().take(15).map { it.id }
            QuizMode.MOCK -> {
                val generated = AdaptiveStudyRepository.generateDistinctExam(
                    questions = all,
                    moduleCounts = (1..6).associateWith { 5 },
                    previousIds = progressStore.lastExamIds("mock30")
                )
                progressStore.saveLastExamIds("mock30", generated.map { it.id })
                generated.map { it.id }
            }
            QuizMode.WRONG -> progressStore.failedQuestionIds().toList().shuffled()
            QuizMode.ADAPTIVE -> progressStore.adaptiveIds(all.map { it.id }, 20)
            QuizMode.BANK -> all.map { it.id }
        }
        sessionIds = ids
        modeLabel = when (mode) {
            QuizMode.QUICK -> "Quiz rápido · 15"
            QuizMode.MOCK -> "Simulacro · 30"
            QuizMode.WRONG -> "Preguntas falladas"
            QuizMode.ADAPTIVE -> "Repaso adaptativo · 20"
            QuizMode.BANK -> "Banco completo · ${all.size}"
        }
        active = ids.isNotEmpty()
        index = 0
        selected = -1
        score = 0
        answered = false
        examAttemptSaved = false
    }

    val sessionQuestions = sessionIds.mapNotNull { questionById[it] }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        if (!active) {
            Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Preguntas de alternativa", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("Banco ampliado a ${all.size} preguntas. Cada respuesta actualiza una cola de repaso espaciado local en el teléfono.", fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.68f))

                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    StatCard("$failedCount", "falladas", Modifier.weight(1f))
                    StatCard("$dueCount", "vencidas", Modifier.weight(1f))
                    StatCard("$masteredCount", "dominadas", Modifier.weight(1f))
                }

                QuizModeCard("Quiz rápido", "15 preguntas aleatorias para una sesión de 8–10 minutos.") { start(QuizMode.QUICK) }
                QuizModeCard("Simulacro de prueba", "30 preguntas balanceadas: 5 por cada módulo prioritario.") { start(QuizMode.MOCK) }
                QuizModeCard("Simulacro mixto", "50 minutos · 20 alternativas sin feedback inmediato + 1 pregunta de desarrollo con rúbrica.") { mixedActive = true }
                QuizModeCard("Examen final de práctica", "60 minutos · 30 alternativas balanceadas + 1 desarrollo. Prioriza ítems no vistos; blueprint pedagógico interno, no formato oficial.") { finalExamActive = true }
                QuizModeCard("Repaso adaptativo", "20 preguntas priorizando errores, vencidas y contenidos aún no vistos.") { start(QuizMode.ADAPTIVE) }
                QuizModeCard("Sólo falladas", if (failedCount == 0) "Aún no hay preguntas falladas registradas." else "$failedCount preguntas cuya última respuesta fue incorrecta.", enabled = failedCount > 0) { start(QuizMode.WRONG) }
                QuizModeCard("Banco completo", "Recorre las ${all.size} preguntas con feedback inmediato.") { start(QuizMode.BANK) }
                QuizModeCard("Banco filtrable", "Filtra por autor, concepto o caso y genera una sesión sólo con ese contenido.") { filterActive = true }
                QuizModeCard("Flashcards adaptativas", "${AdaptiveStudyRepository.flashcards.size} tarjetas de recuperación activa con repetición espaciada propia.") { flashcardsActive = true }
                QuizModeCard("Modo oral", "${AdaptiveStudyRepository.oralPrompts.size} preguntas breves cronometradas para explicar conceptos en voz alta.") { oralActive = true }

                Text("Sistema de repaso", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text("Una respuesta correcta aumenta el nivel de dominio y programa un repaso a 1, 3, 7, 14 o 30 días. Un error vuelve la pregunta al nivel inicial y la deja disponible para revisión inmediata.", fontSize = 13.sp)
                Spacer(Modifier.height(16.dp))
            }
        } else if (index >= sessionQuestions.size) {
            Text(modeLabel, fontSize = 13.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
            Text("Resultado", fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(12.dp))
            Surface(shape = RoundedCornerShape(22.dp), color = MaterialTheme.colorScheme.primaryContainer, modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(22.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("$score / ${sessionQuestions.size}", fontSize = 40.sp, fontWeight = FontWeight.Bold)
                    Text("${(score * 100 / sessionQuestions.size.coerceAtLeast(1))}% de respuestas correctas")
                }
            }
            LaunchedEffect(modeLabel, sessionIds, score, examAttemptSaved) {
                if (modeLabel == "Simulacro · 30" && !examAttemptSaved) {
                    progressStore.recordExamAttempt("Simulacro 30", score, sessionQuestions.size, questionIds = sessionIds)
                    examAttemptSaved = true
                    onProgressChanged()
                }
            }
            Spacer(Modifier.height(16.dp))
            Button(onClick = {
                val previous = sessionIds
                sessionIds = previous.shuffled()
                index = 0; selected = -1; score = 0; answered = false; active = true; examAttemptSaved = false
            }, modifier = Modifier.fillMaxWidth()) { Text("Repetir sesión") }
            OutlinedButton(onClick = { active = false }, modifier = Modifier.fillMaxWidth()) { Text("Elegir otro modo") }
        } else {
            val q = sessionQuestions[index]
            val qp = remember(q.id, refresh) { progressStore.questionProgress(q.id) }
            Text(modeLabel, fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
            Row(Modifier.fillMaxWidth()) {
                Text("Pregunta ${index + 1} de ${sessionQuestions.size}", fontSize = 12.sp)
                Spacer(Modifier.weight(1f))
                Text("${q.difficulty} · nivel ${qp.box}/5", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.6f))
            }
            LinearProgressIndicator(progress = { (index + 1).toFloat() / sessionQuestions.size }, modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
            Text(q.prompt, fontSize = 21.sp, fontWeight = FontWeight.Bold, lineHeight = 28.sp)
            Spacer(Modifier.height(14.dp))
            q.options.forEachIndexed { optionIndex, option ->
                val isSelected = selected == optionIndex
                val borderColor = when {
                    answered && optionIndex == q.correctIndex -> MaterialTheme.colorScheme.primary
                    answered && isSelected && optionIndex != q.correctIndex -> MaterialTheme.colorScheme.error
                    isSelected -> MaterialTheme.colorScheme.secondary
                    else -> MaterialTheme.colorScheme.outline.copy(alpha=.28f)
                }
                Surface(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp).clickable(enabled = !answered) { selected = optionIndex },
                    shape = RoundedCornerShape(14.dp),
                    border = BorderStroke(if (isSelected || answered) 2.dp else 1.dp, borderColor),
                    color = if (isSelected) MaterialTheme.colorScheme.surfaceVariant.copy(alpha=.6f) else MaterialTheme.colorScheme.surface
                ) {
                    Text("${('A'.code + optionIndex).toChar()}. $option", Modifier.padding(14.dp), fontSize = 14.sp)
                }
            }
            Spacer(Modifier.height(8.dp))
            if (!answered) {
                Button(
                    onClick = {
                        answered = true
                        val correct = selected == q.correctIndex
                        if (correct) score++
                        progressStore.recordAnswer(q.id, correct)
                        refresh++
                        onProgressChanged()
                    },
                    enabled = selected >= 0,
                    modifier = Modifier.fillMaxWidth()
                ) { Text("Responder") }
            } else {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = if (selected == q.correctIndex) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.errorContainer,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        Text(if (selected == q.correctIndex) "Correcto" else "Revisar", fontWeight = FontWeight.Bold)
                        Text(q.explanation, fontSize = 13.sp)
                        val updated = progressStore.questionProgress(q.id)
                        Text("Nivel de dominio: ${updated.box}/5 · intentos: ${updated.attempts}", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.65f))
                    }
                }
                Spacer(Modifier.height(10.dp))
                Button(onClick = { index++; selected = -1; answered = false }, modifier = Modifier.fillMaxWidth()) {
                    Text(if (index == sessionQuestions.lastIndex) "Ver resultado" else "Siguiente")
                }
            }
        }
    }
}

@Composable
fun QuizModeCard(title: String, subtitle: String, enabled: Boolean = true, onClick: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxWidth().clickable(enabled = enabled, onClick = onClick),
        shape = RoundedCornerShape(17.dp),
        color = if (enabled) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceVariant.copy(alpha=.5f),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.2f))
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(title, fontWeight = FontWeight.Bold, fontSize = 17.sp)
            Text(subtitle, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.67f))
        }
    }
}

@Composable
fun DevelopmentScreen(
    onOpen: (DevelopmentExample) -> Unit,
    onPractice: (DevelopmentExample) -> Unit,
    onOpenIntensive: () -> Unit,
    onOpenProfessor: () -> Unit
) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Repositorio de desarrollo", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        Text("Modelos para integrar argumento, autor, mecanismo, caso y conclusión. La sección práctica permite redactar primero y comparar después con una rúbrica.", fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.68f))
        Surface(shape = RoundedCornerShape(18.dp), color = MaterialTheme.colorScheme.secondaryContainer, modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Text("Plantilla de respuesta", fontWeight = FontWeight.Bold)
                Text("1. Tesis. 2. Concepto. 3. Mecanismo. 4. Caso. 5. Integración de un segundo marco cuando agregue poder explicativo. 6. Conclusión que responda nuevamente la pregunta.", fontSize = 13.sp)
            }
        }
        Button(onClick = { onPractice(CourseRepository.developmentExamples.random()) }, modifier = Modifier.fillMaxWidth()) {
            Text("Practicar una pregunta al azar")
        }
        Surface(shape = RoundedCornerShape(18.dp), color = MaterialTheme.colorScheme.primaryContainer.copy(alpha=.72f), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(9.dp)) {
                Text("Preparación intensiva v0.7", fontWeight = FontWeight.Bold, fontSize = 17.sp)
                Text("30 preguntas plausibles derivadas del programa, lecturas y casos. No son una predicción del instrumento oficial. Cada una tiene modelo de 5, 10 y 20 minutos.", fontSize = 12.sp)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(onClick = onOpenIntensive, modifier = Modifier.weight(1f)) { Text("Banco intensivo") }
                    OutlinedButton(onClick = onOpenProfessor, modifier = Modifier.weight(1f)) { Text("Modo profesor") }
                }
            }
        }
        CourseRepository.developmentExamples.forEach { item ->
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.2f))
            ) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(item.title, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    Text(item.prompt, fontSize = 13.sp, maxLines = 4, overflow = TextOverflow.Ellipsis)
                    Text(item.concepts.joinToString(" · "), fontSize = 11.sp, color = MaterialTheme.colorScheme.primary)
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedButton(onClick = { onOpen(item) }, modifier = Modifier.weight(1f)) { Text("Ver modelo") }
                        Button(onClick = { onPractice(item) }, modifier = Modifier.weight(1f)) { Text("Responder") }
                    }
                }
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun IntensiveDevelopmentBankScreen(onExit: () -> Unit) {
    var selected by remember { mutableStateOf<IntensiveDevelopmentQuestion?>(null) }
    var query by rememberSaveable { mutableStateOf("") }
    var theme by rememberSaveable { mutableStateOf("Todos") }

    if (selected != null) {
        IntensiveDevelopmentQuestionScreen(question = selected!!, onBack = { selected = null })
    } else {
        val themes = listOf("Todos") + DevelopmentIntensiveRepository.questions.map { it.theme }.distinct()
        val filtered = DevelopmentIntensiveRepository.questions.filter { item ->
            (theme == "Todos" || item.theme == theme) &&
                (query.isBlank() || listOf(item.title, item.prompt, item.keyConcepts.joinToString(" "), item.cases.joinToString(" "))
                    .any { it.contains(query, ignoreCase = true) })
        }
        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            TextButton(onClick = onExit) { Text("Volver a Desarrollo") }
            Text("Banco intensivo de desarrollo", fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Text("30 preguntas de práctica plausibles construidas desde el programa, las lecturas y los casos cargados. Sirven para estudiar; no constituyen una predicción del formato ni de las preguntas oficiales.", fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.68f))
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Buscar autor, concepto o caso") },
                modifier = Modifier.fillMaxWidth()
            )
            themes.chunked(3).forEach { row ->
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.fillMaxWidth()) {
                    row.forEach { item ->
                        FilterChip(
                            selected = theme == item,
                            onClick = { theme = item },
                            label = { Text(item, maxLines = 1, fontSize = 10.sp) }
                        )
                    }
                }
            }
            Text("${filtered.size} preguntas", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
            filtered.forEach { item ->
                Surface(
                    modifier = Modifier.fillMaxWidth().clickable { selected = item },
                    shape = RoundedCornerShape(17.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.2f))
                ) {
                    Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(item.theme, fontSize = 10.sp, color = MaterialTheme.colorScheme.primary, modifier = Modifier.weight(1f))
                            Text("5 · 10 · 20 min", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.55f))
                        }
                        Text(item.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Text(item.prompt, fontSize = 12.sp, maxLines = 4, overflow = TextOverflow.Ellipsis)
                        Text(item.keyConcepts.take(4).joinToString(" · "), fontSize = 10.sp, color = MaterialTheme.colorScheme.secondary)
                    }
                }
            }
            Spacer(Modifier.height(20.dp))
        }
    }
}

@Composable
fun IntensiveDevelopmentQuestionScreen(question: IntensiveDevelopmentQuestion, onBack: () -> Unit) {
    var minutes by rememberSaveable(question.id) { mutableIntStateOf(10) }
    val model = remember(question.id, minutes) { DevelopmentIntensiveRepository.timedAnswer(question, minutes) }
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        TextButton(onClick = onBack) { Text("Volver al banco") }
        Text(question.title, fontSize = 25.sp, fontWeight = FontWeight.Bold)
        Text(question.theme, fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
        Surface(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha=.65f), modifier = Modifier.fillMaxWidth()) {
            Text(question.prompt, Modifier.padding(15.dp), fontSize = 15.sp, lineHeight = 22.sp)
        }
        SectionTitle("Elegir extensión")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf(5, 10, 20).forEach { value ->
                FilterChip(selected = minutes == value, onClick = { minutes = value }, label = { Text("$value min") })
            }
        }
        Surface(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.primaryContainer.copy(alpha=.68f), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Text("Objetivo: ${model.targetWords}", fontWeight = FontWeight.Bold)
                Text(model.strategy, fontSize = 12.sp)
            }
        }
        SectionTitle("Tesis nuclear")
        Text(question.thesis, fontSize = 14.sp, lineHeight = 21.sp)
        SectionTitle("Esqueleto")
        question.outline.forEachIndexed { index, step -> Bullet("${index + 1}. $step") }
        SectionTitle("Respuesta modelo · ${model.minutes} minutos")
        Text(model.answer, fontSize = 14.sp, lineHeight = 22.sp)
        SectionTitle("Conceptos esperados")
        Text(question.keyConcepts.joinToString(" · "), fontSize = 13.sp, color = MaterialTheme.colorScheme.primary)
        if (question.cases.isNotEmpty()) {
            SectionTitle("Casos útiles")
            Text(question.cases.joinToString(" · "), fontSize = 13.sp)
        }
        if (question.commonPitfalls.isNotEmpty()) {
            SectionTitle("Errores a evitar")
            question.commonPitfalls.forEach { Bullet(it) }
        }
        Text("Base de la ficha: ${question.sourceBasis.joinToString(" · ")}", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.55f))
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
fun ProfessorModeScreen(onExit: () -> Unit) {
    var question by remember { mutableStateOf(DevelopmentIntensiveRepository.randomQuestion()) }
    var answer by rememberSaveable(question.id) { mutableStateOf("") }
    var submitted by rememberSaveable(question.id) { mutableStateOf(false) }
    var minutes by rememberSaveable { mutableIntStateOf(10) }
    var remaining by rememberSaveable(question.id, minutes) { mutableIntStateOf(minutes * 60) }
    var timerRunning by rememberSaveable(question.id) { mutableStateOf(false) }

    LaunchedEffect(timerRunning, remaining) {
        if (timerRunning && remaining > 0) {
            delay(1000)
            remaining -= 1
        } else if (remaining <= 0) {
            timerRunning = false
        }
    }

    val feedback = remember(answer, submitted, question.id) {
        if (submitted) ProfessorModeAnalyzer.analyze(answer, question) else null
    }
    val model = remember(question.id, minutes) { DevelopmentIntensiveRepository.timedAnswer(question, minutes) }

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextButton(onClick = onExit) { Text("Salir") }
            Spacer(Modifier.weight(1f))
            Text("Modo profesor", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        }
        Text("Pregunta sin pistas", fontSize = 27.sp, fontWeight = FontWeight.Bold)
        Text("Antes de entregar tu respuesta, la app oculta autor, conceptos, mecanismos, casos y modelo. Después compara cobertura y estructura contra la pauta de estudio.", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.65f))

        if (!submitted) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf(5, 10, 20).forEach { value ->
                    FilterChip(
                        selected = minutes == value,
                        onClick = {
                            if (!timerRunning) {
                                minutes = value
                                remaining = value * 60
                            }
                        },
                        label = { Text("$value min") },
                        enabled = !timerRunning
                    )
                }
            }
            Surface(shape = RoundedCornerShape(18.dp), color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha=.7f), modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(question.prompt, fontSize = 16.sp, lineHeight = 23.sp, fontWeight = FontWeight.Medium)
                    val mm = remaining / 60
                    val ss = remaining % 60
                    Text("Tiempo: %02d:%02d".format(mm, ss), fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedButton(onClick = { timerRunning = !timerRunning }, modifier = Modifier.weight(1f)) {
                            Text(if (timerRunning) "Pausar" else if (remaining == minutes * 60) "Iniciar" else "Continuar")
                        }
                        OutlinedButton(onClick = { remaining = minutes * 60; timerRunning = false }, modifier = Modifier.weight(1f)) { Text("Reiniciar") }
                    }
                }
            }
            OutlinedTextField(
                value = answer,
                onValueChange = { answer = it },
                label = { Text("Tu respuesta") },
                modifier = Modifier.fillMaxWidth().heightIn(min = 300.dp)
            )
            Button(
                onClick = { submitted = true; timerRunning = false },
                enabled = answer.trim().length >= 100,
                modifier = Modifier.fillMaxWidth()
            ) { Text("Entregar al profesor") }
            Text("La entrega se habilita con 100 caracteres. No se muestran pistas antes de responder.", fontSize = 11.sp)
        } else {
            feedback?.let { result ->
                Surface(shape = RoundedCornerShape(18.dp), color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha=.68f), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        Text("Comparación de pauta: ${result.structuralCoverage}%", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                        Text("${result.wordCount} palabras. Este porcentaje mide cobertura de señales esperadas, no una nota ni la verdad del argumento.", fontSize = 11.sp)
                    }
                }
                ProfessorFeedbackBlock("Conceptos", result.detectedConcepts, result.missingConcepts)
                ProfessorFeedbackBlock("Mecanismos", result.detectedMechanisms, result.missingMechanisms)
                if (question.cases.isNotEmpty()) ProfessorFeedbackBlock("Casos", result.detectedCases, result.missingCases)
                SectionTitle("Observaciones")
                result.comments.forEach { Bullet(it) }
            }
            SectionTitle("Tesis esperada")
            Text(question.thesis, fontSize = 14.sp, lineHeight = 21.sp)
            SectionTitle("Estructura de alto rendimiento")
            question.outline.forEachIndexed { index, step -> Bullet("${index + 1}. $step") }
            SectionTitle("Modelo de ${model.minutes} minutos")
            Text(model.answer, fontSize = 14.sp, lineHeight = 22.sp)
            if (question.commonPitfalls.isNotEmpty()) {
                SectionTitle("Errores frecuentes")
                question.commonPitfalls.forEach { Bullet(it) }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                OutlinedButton(
                    onClick = {
                        answer = ""
                        submitted = false
                        remaining = minutes * 60
                        timerRunning = false
                    },
                    modifier = Modifier.weight(1f)
                ) { Text("Reintentar") }
                Button(
                    onClick = {
                        val previous = question.id
                        question = DevelopmentIntensiveRepository.randomQuestion(previous)
                        answer = ""
                        submitted = false
                        remaining = minutes * 60
                        timerRunning = false
                    },
                    modifier = Modifier.weight(1f)
                ) { Text("Otra pregunta") }
            }
        }
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
fun ProfessorFeedbackBlock(label: String, detected: List<String>, missing: List<String>) {
    Surface(shape = RoundedCornerShape(15.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.2f)), modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(13.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Text(label, fontWeight = FontWeight.Bold)
            Text("Detectado: ${detected.joinToString(" · ").ifBlank { "ninguno" }}", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
            Text("Por revisar: ${missing.joinToString(" · ").ifBlank { "ninguno" }}", fontSize = 12.sp, color = if (missing.isEmpty()) MaterialTheme.colorScheme.onSurface.copy(alpha=.6f) else MaterialTheme.colorScheme.error)
        }
    }
}

@Composable
fun DevelopmentPracticeScreen(example: DevelopmentExample, onBack: () -> Unit) {
    var answer by rememberSaveable(example.id) { mutableStateOf("") }
    var reveal by rememberSaveable(example.id) { mutableStateOf(false) }
    var checked by remember { mutableStateOf(setOf<Int>()) }
    val rubric = if (example.rubric.isNotEmpty()) example.rubric else StudyToolsRepository.developmentRubric
    val score = checked.sumOf { rubric[it].maxPoints }
    val maxScore = rubric.sumOf { it.maxPoints }
    val structural = remember(answer, reveal, example.id) { if (reveal) DevelopmentAnalyzer.analyze(answer, example) else null }

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        TextButton(onClick = onBack) { Text("Volver") }
        Text("Simulador de desarrollo", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Text(example.title, fontSize = 13.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)
        Surface(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha=.65f), modifier = Modifier.fillMaxWidth()) {
            Text(example.prompt, Modifier.padding(15.dp), fontSize = 15.sp, lineHeight = 22.sp)
        }
        Text("Escribe primero sin abrir el modelo. Intenta 8–12 minutos.", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.65f))
        OutlinedTextField(
            value = answer,
            onValueChange = { answer = it },
            label = { Text("Tu respuesta") },
            modifier = Modifier.fillMaxWidth().heightIn(min = 250.dp),
            enabled = !reveal
        )
        if (!reveal) {
            Button(onClick = { reveal = true }, enabled = answer.trim().length >= 80, modifier = Modifier.fillMaxWidth()) {
                Text("Comparar con rúbrica y modelo")
            }
            Text("El botón se habilita al escribir al menos 80 caracteres para evitar mirar el modelo antes de intentar responder.", fontSize = 11.sp)
        } else {
            SectionTitle("Diagnóstico estructural automático")
            Text("El detector sólo identifica señales de estructura y vocabulario. No evalúa si tu argumento es verdadero, preciso o suficiente; por eso la rúbrica manual sigue siendo obligatoria.", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.68f))
            structural?.let { result ->
                Surface(shape = RoundedCornerShape(18.dp), color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha=.62f), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text("Cobertura estructural: ${result.coverageScore}%", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text("${result.wordCount} palabras · conceptos detectados: ${result.detectedConcepts.joinToString(" · ").ifBlank { "ninguno" }} · casos: ${result.detectedCases.joinToString(" · ").ifBlank { "ninguno" }}", fontSize = 11.sp)
                    }
                }
                result.checks.forEach { check ->
                    Surface(shape = RoundedCornerShape(14.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.2f)), modifier = Modifier.fillMaxWidth()) {
                        Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text((if (check.detected) "Detectado · " else "Revisar · ") + check.label, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = if (check.detected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error)
                            Text(check.evidence, fontSize = 12.sp)
                            if (!check.detected) Text(check.suggestion, fontSize = 11.sp, color = MaterialTheme.colorScheme.secondary)
                        }
                    }
                }
            }
            SectionTitle("Autocorrección guiada")
            Text("Marca sólo los criterios que tu respuesta cumple de forma explícita. La puntuación es una guía de estudio, no una calificación automática.", fontSize = 12.sp)
            rubric.forEachIndexed { idx, criterion ->
                Surface(shape = RoundedCornerShape(14.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.2f)), modifier = Modifier.fillMaxWidth()) {
                    Row(Modifier.padding(12.dp), verticalAlignment = Alignment.Top) {
                        Checkbox(checked = idx in checked, onCheckedChange = { value -> checked = if (value) checked + idx else checked - idx })
                        Column(Modifier.padding(start = 6.dp)) {
                            Text("${criterion.label} · ${criterion.maxPoints} pts", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                            Text(criterion.description, fontSize = 12.sp)
                        }
                    }
                }
            }
            Surface(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.primaryContainer, modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(15.dp)) {
                    Text("Autoevaluación: $score / $maxScore", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Text("Busca sobre todo precisión conceptual, mecanismo y aplicación del caso.", fontSize = 12.sp)
                }
            }
            SectionTitle("Tesis esperada")
            Text(example.thesis, fontSize = 14.sp, lineHeight = 21.sp)
            SectionTitle("Estructura esperada")
            example.structure.forEachIndexed { i, step -> Bullet("${i + 1}. $step") }
            SectionTitle("Respuesta modelo")
            Text(example.modelAnswer, fontSize = 14.sp, lineHeight = 22.sp)
            OutlinedButton(onClick = { answer = ""; reveal = false; checked = emptySet() }, modifier = Modifier.fillMaxWidth()) {
                Text("Intentar de nuevo")
            }
        }
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
fun DevelopmentDetailScreen(example: DevelopmentExample, onBack: () -> Unit) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(13.dp)) {
        TextButton(onClick = onBack) { Text("Volver al repositorio") }
        Text(example.title, fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Surface(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha=.7f), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(15.dp)) {
                Text("Pregunta", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
                Text(example.prompt, fontSize = 15.sp, lineHeight = 21.sp)
            }
        }
        SectionTitle("Tesis de respuesta")
        Text(example.thesis, fontSize = 14.sp, lineHeight = 21.sp)
        SectionTitle("Estructura")
        example.structure.forEachIndexed { i, step -> Bullet("${i + 1}. $step") }
        SectionTitle("Respuesta modelo")
        Text(example.modelAnswer, fontSize = 14.sp, lineHeight = 22.sp)
        SectionTitle("Conceptos que integra")
        Text(example.concepts.joinToString(" · "), fontSize = 13.sp, color = MaterialTheme.colorScheme.primary)
        SectionTitle("Casos")
        Text(example.cases.joinToString(" · "), fontSize = 13.sp)
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
fun StudyMapScreen(progressStore: ProgressStore, refreshTick: Int) {
    var view by rememberSaveable { mutableStateOf(ToolView.GUIDED) }
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Biblioteca de integración", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        Text("Cruza lecturas, conceptos y casos. Las fichas se basan en los materiales cargados del curso y distinguen la lectura asignada de aplicaciones analíticas.", fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.68f))
        Spacer(Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = view == ToolView.GUIDED, onClick = { view = ToolView.GUIDED }, label = { Text("Guiado") })
            FilterChip(selected = view == ToolView.MATRIX, onClick = { view = ToolView.MATRIX }, label = { Text("Matriz") })
            FilterChip(selected = view == ToolView.TIMELINES, onClick = { view = ToolView.TIMELINES }, label = { Text("Líneas") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = view == ToolView.READINGS, onClick = { view = ToolView.READINGS }, label = { Text("Lecturas") })
            FilterChip(selected = view == ToolView.CASES, onClick = { view = ToolView.CASES }, label = { Text("Casos") })
            FilterChip(selected = view == ToolView.COMPARE, onClick = { view = ToolView.COMPARE }, label = { Text("Comparar") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = view == ToolView.MASTERY, onClick = { view = ToolView.MASTERY }, label = { Text("Dominio") })
        }
        Spacer(Modifier.height(10.dp))
        when (view) {
            ToolView.GUIDED -> GuidedStudyScreen(progressStore)
            ToolView.MATRIX -> ConceptMatrixScreen()
            ToolView.TIMELINES -> TimelineScreen()
            ToolView.READINGS -> ReadingLibraryScreen()
            ToolView.CASES -> CaseRepositoryScreen()
            ToolView.COMPARE -> CaseComparatorScreen()
            ToolView.MASTERY -> MasteryDashboardScreen(progressStore, refreshTick)
        }
    }
}


@Composable
fun GuidedStudyScreen(progressStore: ProgressStore) {
    var mode by rememberSaveable { mutableIntStateOf(0) } // 0 lecturas, 1 conceptos
    var selectedPlan by remember { mutableStateOf<GuidedReadingPlan?>(null) }
    var selectedConcept by remember { mutableStateOf<ConceptStudyCard?>(null) }
    var refresh by remember { mutableIntStateOf(0) }

    if (selectedPlan != null) {
        GuidedReadingDetail(
            plan = selectedPlan!!,
            progressStore = progressStore,
            onBack = { selectedPlan = null },
            onProgressChanged = { refresh++ }
        )
        return
    }
    if (selectedConcept != null) {
        GuidedConceptDetail(
            card = selectedConcept!!,
            progressStore = progressStore,
            onBack = { selectedConcept = null },
            onProgressChanged = { refresh++ }
        )
        return
    }

    val readingsDone = remember(refresh) { progressStore.completedGuidedReadingIds() }
    val conceptsDone = remember(refresh) { progressStore.completedConceptCardIds() }
    var query by rememberSaveable { mutableStateOf("") }

    Column(Modifier.fillMaxSize()) {
        Text("Estudio guiado", fontSize = 21.sp, fontWeight = FontWeight.Bold)
        Text(
            "Dos rutas finales: fichas de lectura para reconstruir el argumento y fichas conceptuales para recuperar, distinguir y aplicar sin mirar.",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = .68f)
        )
        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(selected = mode == 0, onClick = { mode = 0 }, label = { Text("Lecturas") })
            FilterChip(selected = mode == 1, onClick = { mode = 1 }, label = { Text("Conceptos") })
        }
        Spacer(Modifier.height(8.dp))

        if (mode == 0) {
            val total = GuidedStudyRepository.readingPlans.size.coerceAtLeast(1)
            val done = readingsDone.size.coerceAtMost(total)
            Text("$done / $total fichas completadas", fontSize = 11.sp, color = MaterialTheme.colorScheme.primary)
            LinearProgressIndicator(progress = { done.toFloat() / total }, modifier = Modifier.fillMaxWidth().padding(vertical = 7.dp))
            Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(9.dp)) {
                GuidedStudyRepository.readingPlans.forEach { plan ->
                    val sheet = DeepStudyRepository.readings.firstOrNull { it.id == plan.readingId } ?: return@forEach
                    val completed = plan.readingId in readingsDone
                    Surface(
                        modifier = Modifier.fillMaxWidth().clickable { selectedPlan = plan },
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .2f))
                    ) {
                        Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                                Text(sheet.title, fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.weight(1f))
                                Surface(shape = RoundedCornerShape(9.dp), color = if (completed) MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.surfaceVariant) {
                                    Text(if (completed) "Hecha" else "${plan.durationMinutes} min", Modifier.padding(horizontal = 8.dp, vertical = 4.dp), fontSize = 10.sp)
                                }
                            }
                            Text(sheet.author, fontSize = 11.sp, color = MaterialTheme.colorScheme.primary)
                            Text(plan.orientation, fontSize = 12.sp, lineHeight = 17.sp, maxLines = 3, overflow = TextOverflow.Ellipsis)
                        }
                    }
                }
                Spacer(Modifier.height(14.dp))
            }
        } else {
            val total = GuidedStudyRepository.conceptCards.size.coerceAtLeast(1)
            val done = conceptsDone.size.coerceAtMost(total)
            Text("$done / $total conceptos estudiados", fontSize = 11.sp, color = MaterialTheme.colorScheme.primary)
            LinearProgressIndicator(progress = { done.toFloat() / total }, modifier = Modifier.fillMaxWidth().padding(vertical = 7.dp))
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Buscar concepto, autor o caso") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(7.dp))
            val cards = GuidedStudyRepository.conceptCards.filter { c ->
                query.isBlank() || listOf(c.name, c.author, c.definition, c.caseExample, c.sourceBasis).any { it.contains(query, ignoreCase = true) }
            }
            Text("${cards.size} conceptos", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .6f))
            Spacer(Modifier.height(6.dp))
            Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                cards.forEach { card ->
                    val completed = card.id in conceptsDone
                    Surface(
                        modifier = Modifier.fillMaxWidth().clickable { selectedConcept = card },
                        shape = RoundedCornerShape(15.dp),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .2f))
                    ) {
                        Column(Modifier.padding(13.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                                Text(card.name, fontWeight = FontWeight.Bold, fontSize = 15.sp, modifier = Modifier.weight(1f))
                                if (completed) Text("✓", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                            }
                            Text(card.author, fontSize = 11.sp, color = MaterialTheme.colorScheme.primary)
                            Text(card.definition, fontSize = 12.sp, maxLines = 2, overflow = TextOverflow.Ellipsis)
                        }
                    }
                }
                Spacer(Modifier.height(14.dp))
            }
        }
    }
}

@Composable
fun GuidedReadingDetail(
    plan: GuidedReadingPlan,
    progressStore: ProgressStore,
    onBack: () -> Unit,
    onProgressChanged: () -> Unit
) {
    val sheet = DeepStudyRepository.readings.firstOrNull { it.id == plan.readingId } ?: return
    var reveal by rememberSaveable(plan.id) { mutableStateOf(false) }
    var completed by remember(plan.id) { mutableStateOf(plan.readingId in progressStore.completedGuidedReadingIds()) }

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(11.dp)) {
        TextButton(onClick = onBack) { Text("Volver al estudio guiado") }
        Text(sheet.title, fontSize = 23.sp, fontWeight = FontWeight.Bold)
        Text(sheet.author, fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
        Text("Ruta guiada · ${plan.durationMinutes} min", fontSize = 11.sp, color = MaterialTheme.colorScheme.secondary, fontWeight = FontWeight.SemiBold)

        Surface(shape = RoundedCornerShape(15.dp), color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = .55f), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(13.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Text("Antes de empezar", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Text(plan.orientation, fontSize = 13.sp, lineHeight = 19.sp)
            }
        }

        SectionTitle("1. Reconstruye el argumento")
        plan.focusSteps.forEachIndexed { i, step -> Bullet("${i + 1}. $step") }

        SectionTitle("2. Recuperación sin mirar")
        Text("Responde mentalmente o en voz alta antes de abrir la pauta.", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .65f))
        plan.selfTest.forEachIndexed { i, q ->
            Surface(shape = RoundedCornerShape(13.dp), color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = .45f), modifier = Modifier.fillMaxWidth()) {
                Text("${i + 1}. $q", Modifier.padding(11.dp), fontSize = 13.sp, lineHeight = 18.sp)
            }
        }
        Button(onClick = { reveal = !reveal }, modifier = Modifier.fillMaxWidth()) {
            Text(if (reveal) "Ocultar pauta" else "Revelar pauta")
        }
        if (reveal) {
            plan.answerKey.forEachIndexed { i, a ->
                Column(Modifier.fillMaxWidth().padding(vertical = 3.dp)) {
                    Text("Respuesta ${i + 1}", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                    Text(a, fontSize = 12.sp, lineHeight = 18.sp)
                }
            }
            HorizontalDivider()
            SectionTitle("3. Síntesis de 60 segundos")
            Text(plan.synthesisPrompt, fontSize = 13.sp, lineHeight = 19.sp)
            Surface(shape = RoundedCornerShape(14.dp), color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = .5f), modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("Modelo de síntesis", fontWeight = FontWeight.Bold, fontSize = 11.sp)
                    Text(plan.modelSynthesis, fontSize = 12.sp, lineHeight = 18.sp)
                }
            }
        }

        SectionTitle("4. Conexiones de prueba")
        sheet.caseConnections.forEach { Bullet(it) }
        Text("Conceptos: ${sheet.keyConcepts.joinToString(" · ")}", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)

        Button(
            onClick = {
                completed = !completed
                progressStore.setGuidedReadingCompleted(plan.readingId, completed)
                onProgressChanged()
            },
            modifier = Modifier.fillMaxWidth(),
            colors = if (completed) ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary) else ButtonDefaults.buttonColors()
        ) {
            Text(if (completed) "✓ Ficha estudiada" else "Marcar ficha como estudiada")
        }
        Spacer(Modifier.height(18.dp))
    }
}

@Composable
fun GuidedConceptDetail(
    card: ConceptStudyCard,
    progressStore: ProgressStore,
    onBack: () -> Unit,
    onProgressChanged: () -> Unit
) {
    var reveal by rememberSaveable(card.id) { mutableStateOf(false) }
    var completed by remember(card.id) { mutableStateOf(card.id in progressStore.completedConceptCardIds()) }

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(11.dp)) {
        TextButton(onClick = onBack) { Text("Volver a conceptos") }
        Text(card.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(card.author, fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)

        Surface(shape = RoundedCornerShape(15.dp), color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = .5f), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(13.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("Primero: recupéralo sin mirar", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                card.recallPrompts.forEach { Bullet(it) }
            }
        }
        Button(onClick = { reveal = !reveal }, modifier = Modifier.fillMaxWidth()) {
            Text(if (reveal) "Ocultar ficha" else "Revelar ficha conceptual")
        }

        if (reveal) {
            SectionTitle("Definición")
            Text(card.definition, fontSize = 14.sp, lineHeight = 20.sp)
            SectionTitle("Distinción decisiva")
            Text(card.distinction, fontSize = 13.sp, lineHeight = 19.sp)
            SectionTitle("Mecanismo")
            Text(card.mechanism, fontSize = 13.sp, lineHeight = 19.sp)
            SectionTitle("Caso")
            Text(card.caseExample, fontSize = 13.sp, lineHeight = 19.sp)
            SectionTitle("Frase útil para una respuesta")
            Surface(shape = RoundedCornerShape(14.dp), color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = .55f), modifier = Modifier.fillMaxWidth()) {
                Text(card.examUse, Modifier.padding(12.dp), fontSize = 13.sp, lineHeight = 19.sp)
            }
            SectionTitle("Error frecuente")
            Surface(shape = RoundedCornerShape(14.dp), color = MaterialTheme.colorScheme.errorContainer.copy(alpha = .42f), modifier = Modifier.fillMaxWidth()) {
                Text(card.commonError, Modifier.padding(12.dp), fontSize = 13.sp, lineHeight = 19.sp)
            }
            Text("Base: ${card.sourceBasis}", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .55f))
        }

        Button(
            onClick = {
                completed = !completed
                progressStore.setConceptCardCompleted(card.id, completed)
                onProgressChanged()
            },
            modifier = Modifier.fillMaxWidth(),
            colors = if (completed) ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary) else ButtonDefaults.buttonColors()
        ) {
            Text(if (completed) "✓ Concepto estudiado" else "Marcar concepto como estudiado")
        }
        Spacer(Modifier.height(18.dp))
    }
}

@Composable
fun ConceptMatrixScreen() {
    var query by rememberSaveable { mutableStateOf("") }
    val entries = StudyToolsRepository.matrixEntries.filter { entry ->
        query.isBlank() || listOf(entry.concept, entry.author, entry.coreIdea, entry.caseLinks.joinToString(" "), entry.examUse)
            .any { it.contains(query, ignoreCase = true) }
    }
    Column(Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Buscar autor, concepto o caso") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        Text("${entries.size} conexiones", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.6f))
        Spacer(Modifier.height(6.dp))
        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            entries.forEach { MatrixCard(it) }
            Spacer(Modifier.height(14.dp))
        }
    }
}

@Composable
fun MatrixCard(entry: MatrixEntry) {
    Surface(shape = RoundedCornerShape(16.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.2f)), modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(entry.concept, fontWeight = FontWeight.Bold, fontSize = 17.sp)
            Text(entry.author, fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)
            Text(entry.coreIdea, fontSize = 13.sp, lineHeight = 19.sp)
            Text("Casos", fontSize = 11.sp, fontWeight = FontWeight.Bold)
            Text(entry.caseLinks.joinToString(" · "), fontSize = 12.sp)
            Text("Cómo usarlo en prueba", fontSize = 11.sp, color = MaterialTheme.colorScheme.secondary, fontWeight = FontWeight.Bold)
            Text(entry.examUse, fontSize = 12.sp)
        }
    }
}

@Composable
fun TimelineScreen() {
    var expanded by rememberSaveable { mutableStateOf<String?>(StudyToolsRepository.timelines.firstOrNull()?.caseName) }
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        StudyToolsRepository.timelines.forEach { timeline ->
            TimelineCard(timeline, expanded == timeline.caseName) {
                expanded = if (expanded == timeline.caseName) null else timeline.caseName
            }
        }
        Spacer(Modifier.height(14.dp))
    }
}

@Composable
fun TimelineCard(timeline: CaseTimeline, isExpanded: Boolean, onToggle: () -> Unit) {
    Surface(
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.2f)),
        modifier = Modifier.fillMaxWidth().clickable(onClick = onToggle)
    ) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(timeline.caseName, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(timeline.subtitle, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.65f))
            Text(if (isExpanded) "Ocultar hitos" else "Ver ${timeline.events.size} hitos", fontSize = 11.sp, color = MaterialTheme.colorScheme.primary)
            if (isExpanded) {
                HorizontalDivider()
                timeline.events.forEach { event ->
                    Row(Modifier.fillMaxWidth().padding(vertical = 4.dp), verticalAlignment = Alignment.Top) {
                        Surface(shape = RoundedCornerShape(10.dp), color = MaterialTheme.colorScheme.primaryContainer) {
                            Text(event.period, Modifier.padding(horizontal = 8.dp, vertical = 5.dp), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                        Spacer(Modifier.width(10.dp))
                        Column(Modifier.weight(1f)) {
                            Text(event.title, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                            Text(event.detail, fontSize = 12.sp, lineHeight = 18.sp)
                            if (event.concepts.isNotEmpty()) Text(event.concepts.joinToString(" · "), fontSize = 10.sp, color = MaterialTheme.colorScheme.secondary)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MixedExamScreen(progressStore: ProgressStore, onExit: () -> Unit) {
    val all = CourseRepository.questions
    val questions = remember {
        val counts = mapOf(1 to 4, 2 to 4, 3 to 3, 4 to 3, 5 to 3, 6 to 3)
        val generated = AdaptiveStudyRepository.generateDistinctExam(
            questions = all,
            moduleCounts = counts,
            previousIds = progressStore.lastExamIds("mixed20")
        )
        progressStore.saveLastExamIds("mixed20", generated.map { it.id })
        generated
    }
    val development = remember { CourseRepository.developmentExamples.filter { it.id <= 12 }.random() }
    var index by rememberSaveable { mutableIntStateOf(0) }
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    var score by rememberSaveable { mutableIntStateOf(0) }
    var wrongIds by remember { mutableStateOf<List<Int>>(emptyList()) }
    var stage by rememberSaveable { mutableIntStateOf(0) } // 0 alternativas, 1 desarrollo, 2 resultados
    var answer by rememberSaveable { mutableStateOf("") }
    var remaining by rememberSaveable { mutableIntStateOf(50 * 60) }
    var checked by remember { mutableStateOf<Set<Int>>(emptySet()) }
    var attemptId by rememberSaveable { mutableLongStateOf(0L) }
    val rubric = if (development.rubric.isNotEmpty()) development.rubric else StudyToolsRepository.developmentRubric
    val devScore = rubric.mapIndexed { i, r -> if (i in checked) r.maxPoints else 0 }.sum()
    val maxDev = rubric.sumOf { it.maxPoints }

    LaunchedEffect(stage) {
        while (stage != 2 && remaining > 0) {
            delay(1000)
            remaining--
        }
    }

    val min = remaining / 60
    val sec = remaining % 60

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text("Simulacro mixto", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("20 alternativas + 1 desarrollo · 50 minutos", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.65f))
            }
            Surface(shape = RoundedCornerShape(12.dp), color = if (remaining > 0) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.errorContainer) {
                Text(String.format("%02d:%02d", min, sec), Modifier.padding(horizontal = 12.dp, vertical = 8.dp), fontWeight = FontWeight.Bold)
            }
        }
        if (remaining == 0 && stage != 2) {
            Text("Tiempo agotado. Puedes terminar la respuesta para revisar tu desempeño, pero considera el ejercicio fuera de tiempo.", color = MaterialTheme.colorScheme.error, fontSize = 12.sp)
        }

        when (stage) {
            0 -> {
                val q = questions[index]
                Text("Alternativas · ${index + 1}/${questions.size}", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                LinearProgressIndicator(progress = { (index + 1).toFloat() / questions.size }, modifier = Modifier.fillMaxWidth())
                Text(q.prompt, fontSize = 20.sp, lineHeight = 27.sp, fontWeight = FontWeight.Bold)
                q.options.forEachIndexed { optionIndex, option ->
                    Surface(
                        modifier = Modifier.fillMaxWidth().clickable { selected = optionIndex },
                        shape = RoundedCornerShape(14.dp),
                        border = BorderStroke(if (selected == optionIndex) 2.dp else 1.dp, if (selected == optionIndex) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline.copy(alpha=.25f)),
                        color = if (selected == optionIndex) MaterialTheme.colorScheme.primaryContainer.copy(alpha=.45f) else MaterialTheme.colorScheme.surface
                    ) {
                        Text("${('A'.code + optionIndex).toChar()}. $option", Modifier.padding(14.dp), fontSize = 14.sp)
                    }
                }
                Text("No se muestra feedback hasta el final, para simular condiciones de prueba.", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.58f))
                Button(
                    onClick = {
                        val correct = selected == q.correctIndex
                        if (correct) score++ else wrongIds = wrongIds + q.id
                        progressStore.recordAnswer(q.id, correct)
                        if (index == questions.lastIndex) {
                            stage = 1
                        } else {
                            index++
                            selected = -1
                        }
                    },
                    enabled = selected >= 0,
                    modifier = Modifier.fillMaxWidth()
                ) { Text(if (index == questions.lastIndex) "Ir a desarrollo" else "Guardar y siguiente") }
            }
            1 -> {
                Text("Desarrollo", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                Surface(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha=.65f), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        Text(development.title, fontWeight = FontWeight.Bold)
                        Text(development.prompt, fontSize = 14.sp, lineHeight = 21.sp)
                    }
                }
                Text("Escribe una respuesta cerrada: tesis explícita, conceptos definidos, mecanismo, caso y conclusión.", fontSize = 12.sp)
                OutlinedTextField(
                    value = answer,
                    onValueChange = { answer = it },
                    label = { Text("Tu respuesta") },
                    modifier = Modifier.fillMaxWidth().heightIn(min = 300.dp)
                )
                Button(onClick = {
                    if (attemptId == 0L) {
                        attemptId = progressStore.recordExamAttempt(
                            mode = "Simulacro mixto",
                            correct = score,
                            total = questions.size,
                            developmentScore = 0,
                            developmentMax = maxDev,
                            elapsedSeconds = 50 * 60 - remaining,
                            questionIds = questions.map { it.id }
                        )
                    }
                    stage = 2
                }, enabled = answer.trim().length >= 120, modifier = Modifier.fillMaxWidth()) { Text("Finalizar simulacro") }
                Text("Se requieren al menos 120 caracteres para cerrar el examen; la respuesta de desarrollo se autocorrige con rúbrica.", fontSize = 11.sp)
            }
            else -> {
                Surface(shape = RoundedCornerShape(20.dp), color = MaterialTheme.colorScheme.primaryContainer, modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(18.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Alternativas", fontSize = 12.sp)
                        Text("$score / ${questions.size}", fontSize = 36.sp, fontWeight = FontWeight.Bold)
                        Text("${score * 100 / questions.size}% correctas", fontSize = 13.sp)
                    }
                }
                if (wrongIds.isNotEmpty()) {
                    SectionTitle("Errores del simulacro")
                    wrongIds.mapNotNull { id -> all.find { it.id == id } }.forEach { q ->
                        Surface(shape = RoundedCornerShape(14.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.2f)), modifier = Modifier.fillMaxWidth()) {
                            Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text(q.prompt, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                                Text("Correcta: ${('A'.code + q.correctIndex).toChar()}. ${q.options[q.correctIndex]}", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
                                Text(q.explanation, fontSize = 12.sp)
                            }
                        }
                    }
                }
                SectionTitle("Autocorrección del desarrollo")
                Text("Marca sólo aquello que efectivamente aparece en tu respuesta. Puntaje orientativo: $devScore / $maxDev.", fontSize = 12.sp)
                rubric.forEachIndexed { i, criterion ->
                    Surface(shape = RoundedCornerShape(14.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.2f)), modifier = Modifier.fillMaxWidth()) {
                        Row(Modifier.padding(10.dp), verticalAlignment = Alignment.Top) {
                            Checkbox(checked = i in checked, onCheckedChange = { v ->
                                val updated = if (v) checked + i else checked - i
                                checked = updated
                                if (attemptId > 0L) {
                                    val updatedScore = rubric.mapIndexed { idx, r -> if (idx in updated) r.maxPoints else 0 }.sum()
                                    progressStore.updateExamDevelopment(attemptId, updatedScore, maxDev)
                                }
                            })
                            Column(Modifier.padding(start = 4.dp)) {
                                Text("${criterion.label} · ${criterion.maxPoints} pts", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                                Text(criterion.description, fontSize = 12.sp)
                            }
                        }
                    }
                }
                SectionTitle("Tesis esperada")
                Text(development.thesis, fontSize = 14.sp, lineHeight = 21.sp)
                SectionTitle("Estructura de referencia")
                development.structure.forEachIndexed { i, item -> Bullet("${i + 1}. $item") }
                SectionTitle("Modelo de respuesta")
                Text(development.modelAnswer, fontSize = 14.sp, lineHeight = 22.sp)
                OutlinedButton(onClick = onExit, modifier = Modifier.fillMaxWidth()) { Text("Volver a modos de práctica") }
            }
        }
        if (stage != 2) {
            OutlinedButton(onClick = onExit, modifier = Modifier.fillMaxWidth()) { Text("Salir del simulacro") }
        }
        Spacer(Modifier.height(24.dp))
    }
}

@Composable
fun ReadingLibraryScreen() {
    var selected by remember { mutableStateOf<ReadingSheet?>(null) }
    var query by rememberSaveable { mutableStateOf("") }
    if (selected != null) {
        ReadingSheetDetail(selected!!) { selected = null }
        return
    }
    val readings = DeepStudyRepository.readings.filter { r ->
        query.isBlank() || listOf(r.title, r.author, r.thesis, r.keyConcepts.joinToString(" "), r.caseConnections.joinToString(" ")).any { it.contains(query, ignoreCase = true) }
    }
    Column(Modifier.fillMaxSize()) {
        OutlinedTextField(value = query, onValueChange = { query = it }, label = { Text("Buscar lectura, autor o concepto") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(8.dp))
        Text("${readings.size} fichas de lectura", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.6f))
        Spacer(Modifier.height(6.dp))
        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(9.dp)) {
            readings.forEach { r ->
                Surface(modifier = Modifier.fillMaxWidth().clickable { selected = r }, shape = RoundedCornerShape(16.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.2f))) {
                    Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Row(Modifier.fillMaxWidth()) {
                            Text("Módulo ${r.moduleId}", fontSize = 11.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.weight(1f))
                            Text(r.priority, fontSize = 10.sp, color = MaterialTheme.colorScheme.secondary)
                        }
                        Text(r.title, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                        Text(r.author, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.65f))
                        Text(r.mustRemember, fontSize = 12.sp, maxLines = 3, overflow = TextOverflow.Ellipsis)
                    }
                }
            }
            Spacer(Modifier.height(14.dp))
        }
    }
}

@Composable
fun ReadingSheetDetail(sheet: ReadingSheet, onBack: () -> Unit) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(11.dp)) {
        TextButton(onClick = onBack) { Text("Volver a lecturas") }
        Text(sheet.title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(sheet.author, fontSize = 13.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)
        Surface(shape = RoundedCornerShape(14.dp), color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha=.55f), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(13.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Text("Fuente utilizada", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Text(sheet.source, fontSize = 12.sp)
            }
        }
        SectionTitle("Pregunta central")
        Text(sheet.centralQuestion, fontSize = 14.sp, lineHeight = 21.sp)
        SectionTitle("Tesis")
        Text(sheet.thesis, fontSize = 14.sp, lineHeight = 21.sp)
        SectionTitle("Mapa argumental")
        sheet.argumentMap.forEach { Bullet(it) }
        SectionTitle("Conceptos que debes manejar")
        Text(sheet.keyConcepts.joinToString(" · "), fontSize = 13.sp, color = MaterialTheme.colorScheme.primary)
        SectionTitle("Tensiones")
        sheet.tensions.forEach { Bullet(it) }
        SectionTitle("Conexiones con casos")
        sheet.caseConnections.forEach { Bullet(it) }
        SectionTitle("Posibles preguntas")
        sheet.examPrompts.forEach { Bullet(it) }
        Surface(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha=.65f), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(14.dp)) {
                Text("Si sólo recuerdas una cosa", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Text(sheet.mustRemember, fontSize = 14.sp, lineHeight = 20.sp)
            }
        }
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
fun CaseRepositoryScreen() {
    var selected by remember { mutableStateOf<CaseDossier?>(null) }
    if (selected != null) {
        CaseDossierDetail(selected!!) { selected = null }
        return
    }
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Repositorio de casos", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Cada ficha separa hechos del caso de la lectura analítica que puedes hacer con los autores del curso.", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.65f))
        DeepStudyRepository.cases.forEach { c ->
            Surface(modifier = Modifier.fillMaxWidth().clickable { selected = c }, shape = RoundedCornerShape(17.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.2f))) {
                Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text(c.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text(c.coreProblem, fontSize = 12.sp, maxLines = 4, overflow = TextOverflow.Ellipsis)
                    Text(c.concepts.take(4).joinToString(" · "), fontSize = 11.sp, color = MaterialTheme.colorScheme.primary)
                }
            }
        }
        Spacer(Modifier.height(14.dp))
    }
}

@Composable
fun CaseDossierDetail(case: CaseDossier, onBack: () -> Unit) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(11.dp)) {
        TextButton(onClick = onBack) { Text("Volver a casos") }
        Text(case.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(case.source, fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.6f))
        SectionTitle("Problema central")
        Text(case.coreProblem, fontSize = 14.sp, lineHeight = 21.sp)
        SectionTitle("Actores y funciones")
        case.actors.forEach { a ->
            Surface(shape = RoundedCornerShape(13.dp), color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha=.5f), modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                    Text(a.actor, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    Text(a.role, fontSize = 12.sp)
                }
            }
        }
        SectionTitle("Base de conocimiento")
        case.knowledgeBase.forEach { Bullet(it) }
        SectionTitle("Mecanismos de incidencia")
        case.mechanisms.forEach { Bullet(it) }
        SectionTitle("Barreras")
        case.barriers.forEach { Bullet(it) }
        SectionTitle("Facilitadores")
        case.facilitators.forEach { Bullet(it) }
        SectionTitle("Resultado")
        Text(case.outcome, fontSize = 14.sp, lineHeight = 21.sp)
        SectionTitle("Conceptos para aplicar")
        Text(case.concepts.joinToString(" · "), fontSize = 13.sp, color = MaterialTheme.colorScheme.primary)
        SectionTitle("Cómo usarlo en desarrollo")
        case.examAngles.forEach { Bullet(it) }
        Surface(shape = RoundedCornerShape(15.dp), color = MaterialTheme.colorScheme.errorContainer.copy(alpha=.45f), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(13.dp)) {
                Text("Error que conviene evitar", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Text(case.caution, fontSize = 13.sp)
            }
        }
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
fun CaseComparatorScreen() {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Comparador de casos", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("No busca declarar un caso 'mejor': organiza diferencias relevantes para escoger el ejemplo que mejor demuestra un mecanismo en una respuesta.", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.65f))
        DeepStudyRepository.comparisonRows.forEach { row ->
            Surface(shape = RoundedCornerShape(17.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.2f)), modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(row.dimension, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = MaterialTheme.colorScheme.primary)
                    CaseComparisonCell("Suelos", row.soil)
                    CaseComparisonCell("Humedales", row.wetlands)
                    CaseComparisonCell("Regulación térmica", row.thermal)
                    CaseComparisonCell("Neuroderechos", row.neuro)
                }
            }
        }
        Spacer(Modifier.height(14.dp))
    }
}

@Composable
fun CaseComparisonCell(label: String, text: String) {
    Column {
        Text(label, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.secondary)
        Text(text, fontSize = 12.sp, lineHeight = 18.sp)
    }
}

@Composable
fun AdaptiveRouteCard(item: AdaptiveRouteItem) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .2f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text("${item.combination.author} × ${item.combination.caseName}", fontWeight = FontWeight.Bold, fontSize = 14.sp, modifier = Modifier.weight(1f))
                Surface(shape = RoundedCornerShape(10.dp), color = MaterialTheme.colorScheme.primaryContainer) {
                    Text("${item.score}%", Modifier.padding(horizontal = 8.dp, vertical = 4.dp), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }
            Text(item.combination.concepts.joinToString(" · "), fontSize = 11.sp, color = MaterialTheme.colorScheme.primary)
            Text(item.reason, fontSize = 12.sp)
            Text(item.suggestedAction, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .68f))
        }
    }
}

@Composable
fun FlashcardPracticeScreen(progressStore: ProgressStore, onExit: () -> Unit, limit: Int = 15, header: String = "Flashcards adaptativas") {
    val all = remember { AdaptiveStudyRepository.flashcards }
    var sessionIds by remember(limit) { mutableStateOf(progressStore.adaptiveFlashcardIds(all.map { it.id }, limit)) }
    val byId = remember { all.associateBy { it.id } }
    var index by rememberSaveable { mutableIntStateOf(0) }
    var revealed by rememberSaveable { mutableStateOf(false) }
    var refresh by remember { mutableIntStateOf(0) }
    val cards = sessionIds.mapNotNull { byId[it] }
    val due = remember(refresh) { progressStore.dueFlashcardIds().size }
    val mastered = remember(refresh) { progressStore.masteredFlashcards() }
    val attempted = remember(refresh) { progressStore.attemptedFlashcards() }

    fun next(knew: Boolean) {
        val card = cards.getOrNull(index) ?: return
        progressStore.recordFlashcard(card.id, knew)
        refresh++
        if (index < cards.lastIndex) {
            index++
            revealed = false
        } else {
            index = cards.size
        }
    }

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(header, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("Recuperación activa + repetición espaciada", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .65f))
            }
            TextButton(onClick = onExit) { Text("Salir") }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            StatCard("$attempted", "vistas", Modifier.weight(1f))
            StatCard("$due", "vencidas", Modifier.weight(1f))
            StatCard("$mastered", "dominadas", Modifier.weight(1f))
        }

        if (index >= cards.size) {
            Surface(shape = RoundedCornerShape(20.dp), color = MaterialTheme.colorScheme.primaryContainer, modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text("Sesión completada", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Text("La siguiente sesión volverá a priorizar tarjetas falladas, vencidas y aún no vistas.", fontSize = 13.sp)
                }
            }
            Button(onClick = {
                sessionIds = progressStore.adaptiveFlashcardIds(all.map { it.id }, limit)
                index = 0
                revealed = false
            }, modifier = Modifier.fillMaxWidth()) { Text("Generar otra sesión") }
            OutlinedButton(onClick = onExit, modifier = Modifier.fillMaxWidth()) { Text("Volver a práctica") }
        } else {
            val card = cards[index]
            val cp = remember(card.id, refresh) { progressStore.flashcardProgress(card.id) }
            Row(Modifier.fillMaxWidth()) {
                Text("Tarjeta ${index + 1} de ${cards.size}", fontSize = 12.sp)
                Spacer(Modifier.weight(1f))
                Text("nivel ${cp.box}/5", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .6f))
            }
            LinearProgressIndicator(progress = { (index + 1).toFloat() / cards.size.coerceAtLeast(1) }, modifier = Modifier.fillMaxWidth())
            Surface(
                modifier = Modifier.fillMaxWidth().heightIn(min = 240.dp).clickable { revealed = true },
                shape = RoundedCornerShape(24.dp),
                color = if (revealed) MaterialTheme.colorScheme.secondaryContainer.copy(alpha = .62f) else MaterialTheme.colorScheme.primaryContainer.copy(alpha = .58f),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .18f))
            ) {
                Column(Modifier.padding(22.dp), verticalArrangement = Arrangement.spacedBy(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(card.author, fontSize = 11.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                    Text(card.front, fontSize = 21.sp, lineHeight = 28.sp, fontWeight = FontWeight.Bold)
                    if (!revealed) {
                        Text("Intenta responder sin mirar y toca la tarjeta para comprobar.", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .62f))
                    } else {
                        HorizontalDivider()
                        Text(card.back, fontSize = 14.sp, lineHeight = 21.sp)
                        if (card.caseLinks.isNotEmpty()) Text("Casos: ${card.caseLinks.joinToString(" · ")}", fontSize = 11.sp, color = MaterialTheme.colorScheme.secondary)
                    }
                }
            }
            if (!revealed) {
                Button(onClick = { revealed = true }, modifier = Modifier.fillMaxWidth()) { Text("Mostrar respuesta") }
            } else {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    OutlinedButton(onClick = { next(false) }, modifier = Modifier.weight(1f)) { Text("Revisar") }
                    Button(onClick = { next(true) }, modifier = Modifier.weight(1f)) { Text("Lo sabía") }
                }
                Text("'Lo sabía' aumenta el nivel y programa el próximo repaso. 'Revisar' devuelve la tarjeta al nivel inicial.", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .6f))
            }
        }
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
fun OralPracticeScreen(progressStore: ProgressStore, onExit: () -> Unit, limit: Int = 8, header: String = "Modo oral") {
    val all = remember { AdaptiveStudyRepository.oralPrompts }
    val session = remember(limit) {
        all.sortedWith(compareBy<OralPrompt> {
            val p = progressStore.oralProgress(it.id)
            when {
                p.lastWasCorrect == false -> 0
                p.attempts == 0 -> 1
                else -> 2
            }
        }.thenBy { progressStore.oralProgress(it.id).box }).take(limit).shuffled()
    }
    var index by rememberSaveable { mutableIntStateOf(0) }
    var revealed by rememberSaveable { mutableStateOf(false) }
    var remaining by rememberSaveable { mutableIntStateOf(session.firstOrNull()?.seconds ?: 60) }
    var refresh by remember { mutableIntStateOf(0) }

    LaunchedEffect(index) {
        remaining = session.getOrNull(index)?.seconds ?: 60
        revealed = false
        while (index < session.size && remaining > 0 && !revealed) {
            delay(1000)
            remaining--
        }
    }

    fun next(success: Boolean) {
        val prompt = session.getOrNull(index) ?: return
        progressStore.recordOral(prompt.id, success)
        refresh++
        index++
        revealed = false
    }

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(header, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("${session.size} preguntas · 60 segundos por explicación", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .65f))
            }
            TextButton(onClick = onExit) { Text("Salir") }
        }
        if (index >= session.size) {
            Surface(shape = RoundedCornerShape(20.dp), color = MaterialTheme.colorScheme.primaryContainer, modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text("Sesión oral completada", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Text("Tus autoevaluaciones quedan guardadas para priorizar preguntas que marcaste como débiles.", fontSize = 13.sp)
                }
            }
            OutlinedButton(onClick = onExit, modifier = Modifier.fillMaxWidth()) { Text("Volver a práctica") }
        } else {
            val prompt = session[index]
            val pp = remember(prompt.id, refresh) { progressStore.oralProgress(prompt.id) }
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text("Pregunta ${index + 1}/${session.size} · nivel ${pp.box}/5", fontSize = 12.sp, modifier = Modifier.weight(1f))
                Surface(shape = RoundedCornerShape(10.dp), color = if (remaining > 10) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.errorContainer) {
                    Text("${remaining}s", Modifier.padding(horizontal = 10.dp, vertical = 6.dp), fontWeight = FontWeight.Bold)
                }
            }
            LinearProgressIndicator(progress = { (index + 1).toFloat() / session.size }, modifier = Modifier.fillMaxWidth())
            Surface(shape = RoundedCornerShape(22.dp), color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = .55f), modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(prompt.author, fontSize = 11.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                    Text(prompt.question, fontSize = 21.sp, lineHeight = 28.sp, fontWeight = FontWeight.Bold)
                    Text(prompt.concepts.joinToString(" · "), fontSize = 11.sp, color = MaterialTheme.colorScheme.secondary)
                    prompt.caseSuggestion?.let { Text("Caso sugerido: $it", fontSize = 12.sp) }
                }
            }
            if (!revealed) {
                Text("Explica en voz alta. Cuando termines —o se acabe el tiempo— revela los puntos mínimos esperados.", fontSize = 12.sp)
                Button(onClick = { revealed = true }, modifier = Modifier.fillMaxWidth()) { Text("Ver puntos esperados") }
            } else {
                SectionTitle("Puntos que debían aparecer")
                prompt.expectedPoints.forEach { Bullet(it) }
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    OutlinedButton(onClick = { next(false) }, modifier = Modifier.weight(1f)) { Text("Necesito repasar") }
                    Button(onClick = { next(true) }, modifier = Modifier.weight(1f)) { Text("Lo expliqué") }
                }
            }
        }
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
fun MasteryDashboardScreen(progressStore: ProgressStore, refreshTick: Int) {
    var view by rememberSaveable { mutableIntStateOf(0) } // 0 autores, 1 conceptos, 2 casos, 3 ruta
    val questions = CourseRepository.questions
    val authors = remember(refreshTick) { AdaptiveStudyRepository.masteryByAuthor(questions) { progressStore.questionProgress(it) } }
    val concepts = remember(refreshTick) { AdaptiveStudyRepository.masteryByConcept(questions) { progressStore.questionProgress(it) } }
    val cases = remember(refreshTick) { AdaptiveStudyRepository.masteryByCase(questions) { progressStore.questionProgress(it) } }
    val route = remember(refreshTick) { AdaptiveStudyRepository.adaptiveRoute(questions, { progressStore.questionProgress(it) }, 10) }

    Column(Modifier.fillMaxSize()) {
        Text("Dominio adaptativo", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("El índice combina cobertura, precisión histórica y nivel de repetición espaciada. No es una nota del curso: sirve para decidir qué repasar.", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .65f))
        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = view == 0, onClick = { view = 0 }, label = { Text("Autores") })
            FilterChip(selected = view == 1, onClick = { view = 1 }, label = { Text("Conceptos") })
            FilterChip(selected = view == 2, onClick = { view = 2 }, label = { Text("Casos") })
            FilterChip(selected = view == 3, onClick = { view = 3 }, label = { Text("Ruta") })
        }
        Spacer(Modifier.height(8.dp))
        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(9.dp)) {
            when (view) {
                0 -> authors.forEach { MasteryStatCard(it) }
                1 -> concepts.forEach { MasteryStatCard(it) }
                2 -> cases.forEach { MasteryStatCard(it) }
                else -> route.forEach { AdaptiveRouteCard(it) }
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
fun MasteryStatCard(stat: MasteryStat) {
    Surface(shape = RoundedCornerShape(16.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .2f)), modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)) {
                    Text(stat.label, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    Text(stat.kind, fontSize = 10.sp, color = MaterialTheme.colorScheme.primary)
                }
                Text(if (stat.attemptedQuestions == 0) "Sin datos" else "${stat.score}%", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            LinearProgressIndicator(progress = { stat.score / 100f }, modifier = Modifier.fillMaxWidth())
            val accuracy = if (stat.totalAttempts == 0) 0 else (stat.totalCorrect * 100 / stat.totalAttempts)
            Text("Cobertura: ${stat.attemptedQuestions}/${stat.linkedQuestions} preguntas · precisión histórica: $accuracy% · nivel medio: ${String.format("%.1f", stat.meanBox)}/5", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .65f))
        }
    }
}

@Composable
fun GuidedStudyPlanScreen(minutes: Int, progressStore: ProgressStore, onExit: () -> Unit) {
    val plan = remember(minutes) {
        StudySessionRepository.plan(minutes, CourseRepository.questions) { id -> progressStore.questionProgress(id) }
    }
    StudySessionRunner(plan = plan, progressStore = progressStore, dayBefore = false, onExit = onExit)
}

@Composable
fun DayBeforeStudyScreen(progressStore: ProgressStore, onExit: () -> Unit) {
    val plan = remember {
        StudySessionRepository.dayBeforePlan(CourseRepository.questions) { id -> progressStore.questionProgress(id) }
    }
    StudySessionRunner(plan = plan, progressStore = progressStore, dayBefore = true, onExit = onExit)
}

@Composable
fun StudySessionRunner(plan: StudySessionPlan, progressStore: ProgressStore, dayBefore: Boolean, onExit: () -> Unit) {
    var completed by remember(plan.title) { mutableStateOf(setOf<Int>()) }
    var remaining by rememberSaveable(plan.title) { mutableIntStateOf(plan.durationMinutes * 60) }
    var running by rememberSaveable(plan.title) { mutableStateOf(false) }
    var activeTask by rememberSaveable(plan.title) { mutableStateOf<Int?>(null) }

    LaunchedEffect(running, remaining) {
        if (running && remaining > 0) {
            delay(1000)
            remaining--
        }
    }

    val taskIndex = activeTask
    if (taskIndex != null) {
        val task = plan.tasks[taskIndex]
        val flashLimit = when {
            plan.durationMinutes <= 15 -> 5
            plan.durationMinutes <= 25 -> 8
            else -> 12
        }
        val oralLimit = if (plan.durationMinutes <= 15) 1 else 2
        val quizCount = when {
            task.title.contains("simulacro", ignoreCase = true) -> 15
            plan.durationMinutes <= 15 -> 6
            plan.durationMinutes <= 25 -> 10
            else -> 15
        }
        when (task.type) {
            "FLASHCARDS" -> FlashcardPracticeScreen(
                progressStore = progressStore,
                onExit = { completed = completed + taskIndex; activeTask = null },
                limit = flashLimit,
                header = task.title
            )
            "ORAL" -> OralPracticeScreen(
                progressStore = progressStore,
                onExit = { completed = completed + taskIndex; activeTask = null },
                limit = oralLimit,
                header = task.title
            )
            "QUIZ" -> MiniAdaptiveQuizScreen(
                progressStore = progressStore,
                count = quizCount,
                errorsFirst = task.title.contains("errores", ignoreCase = true),
                examMode = task.title.contains("simulacro", ignoreCase = true),
                title = task.title,
                onExit = { completed = completed + taskIndex; activeTask = null }
            )
            "DEVELOPMENT" -> if (dayBefore) {
                DevelopmentSkeletonScreen(
                    count = 2,
                    onExit = { completed = completed + taskIndex; activeTask = null }
                )
            } else {
                DevelopmentPracticeScreen(
                    example = CourseRepository.developmentExamples.random(),
                    onBack = { completed = completed + taskIndex; activeTask = null }
                )
            }
            else -> { completed = completed + taskIndex; activeTask = null }
        }
        return
    }

    val min = remaining / 60
    val sec = remaining % 60
    val progress = if (plan.tasks.isEmpty()) 0f else completed.size.toFloat() / plan.tasks.size

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(plan.title, fontSize = 26.sp, fontWeight = FontWeight.Bold)
                Text("${plan.durationMinutes} minutos · plan adaptativo", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
            }
            TextButton(onClick = onExit) { Text("Salir") }
        }
        Surface(shape = RoundedCornerShape(18.dp), color = MaterialTheme.colorScheme.primaryContainer.copy(alpha=.55f), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(plan.rationale, fontSize = 13.sp, lineHeight = 19.sp)
                LinearProgressIndicator(progress = { progress }, modifier = Modifier.fillMaxWidth())
                Text("${completed.size}/${plan.tasks.size} bloques completados", fontSize = 11.sp)
            }
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Surface(shape = RoundedCornerShape(12.dp), color = if (remaining > 0) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.errorContainer) {
                Text(String.format("%02d:%02d", min, sec), Modifier.padding(horizontal = 14.dp, vertical = 9.dp), fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
            Spacer(Modifier.width(10.dp))
            Button(onClick = { running = !running }, enabled = remaining > 0, modifier = Modifier.weight(1f)) { Text(if (running) "Pausar" else "Iniciar cronómetro") }
            Spacer(Modifier.width(8.dp))
            OutlinedButton(onClick = { remaining = plan.durationMinutes * 60; running = false }) { Text("Reiniciar") }
        }
        if (dayBefore) {
            Text("Regla del modo día antes: no abras material nuevo. Si aparece una duda, resuélvela con la ficha ya estudiada y vuelve a recuperación activa.", fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary)
        }

        plan.tasks.forEachIndexed { idx, task ->
            val done = idx in completed
            Surface(
                shape = RoundedCornerShape(18.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.2f)),
                color = if (done) MaterialTheme.colorScheme.primaryContainer.copy(alpha=.38f) else MaterialTheme.colorScheme.surface,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Text("${idx + 1}. ${task.title}", fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.weight(1f))
                        Text("${task.minutes} min", fontSize = 11.sp, color = MaterialTheme.colorScheme.primary)
                    }
                    Text(task.instructions, fontSize = 13.sp, lineHeight = 19.sp)
                    Text("Foco: ${task.focus}", fontSize = 11.sp, color = MaterialTheme.colorScheme.secondary)
                    if (done) {
                        Text("Completado", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                    } else if (task.type == "REFLECTION") {
                        Button(onClick = { completed = completed + idx }, modifier = Modifier.fillMaxWidth()) { Text("Marcar cierre completado") }
                    } else {
                        Button(onClick = { activeTask = idx }, modifier = Modifier.fillMaxWidth()) { Text("Iniciar bloque") }
                    }
                }
            }
        }
        Surface(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha=.6f), modifier = Modifier.fillMaxWidth()) {
            Text(plan.finishPrompt, Modifier.padding(15.dp), fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
        }
        if (completed.size == plan.tasks.size) {
            Button(onClick = onExit, modifier = Modifier.fillMaxWidth()) { Text("Cerrar sesión") }
        }
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
fun MiniAdaptiveQuizScreen(
    progressStore: ProgressStore,
    count: Int,
    errorsFirst: Boolean,
    examMode: Boolean,
    title: String,
    onExit: () -> Unit
) {
    val all = CourseRepository.questions
    val questions = remember(title, count) {
        val ids = if (errorsFirst) {
            val priority = (progressStore.failedQuestionIds() + progressStore.dueQuestionIds()).toList().shuffled()
            (priority + progressStore.adaptiveIds(all.map { it.id }, count * 2)).distinct().take(count)
        } else {
            progressStore.adaptiveIds(all.map { it.id }, count)
        }
        ids.mapNotNull { id -> all.find { it.id == id } }
    }
    var index by rememberSaveable(title) { mutableIntStateOf(0) }
    var selected by rememberSaveable(title) { mutableIntStateOf(-1) }
    var answered by rememberSaveable(title) { mutableStateOf(false) }
    var score by rememberSaveable(title) { mutableIntStateOf(0) }
    var wrong by remember { mutableStateOf<List<Int>>(emptyList()) }

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(title, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text(if (examMode) "Sin feedback inmediato" else "Feedback y repetición espaciada", fontSize = 11.sp, color = MaterialTheme.colorScheme.primary)
            }
            TextButton(onClick = onExit) { Text("Salir") }
        }
        if (questions.isEmpty()) {
            Text("No hay preguntas disponibles para este bloque.")
            Button(onClick = onExit, modifier = Modifier.fillMaxWidth()) { Text("Volver") }
        } else if (index >= questions.size) {
            Surface(shape = RoundedCornerShape(20.dp), color = MaterialTheme.colorScheme.primaryContainer, modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("$score / ${questions.size}", fontSize = 36.sp, fontWeight = FontWeight.Bold)
                    Text("${score * 100 / questions.size}% correctas", fontSize = 13.sp)
                }
            }
            if (examMode && wrong.isNotEmpty()) {
                SectionTitle("Errores")
                wrong.mapNotNull { id -> all.find { it.id == id } }.forEach { q ->
                    Surface(shape = RoundedCornerShape(14.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.2f)), modifier = Modifier.fillMaxWidth()) {
                        Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(q.prompt, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                            Text("Correcta: ${('A'.code + q.correctIndex).toChar()}. ${q.options[q.correctIndex]}", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
                            Text(q.explanation, fontSize = 12.sp)
                        }
                    }
                }
            }
            Button(onClick = onExit, modifier = Modifier.fillMaxWidth()) { Text("Terminar bloque") }
        } else {
            val q = questions[index]
            Text("Pregunta ${index + 1}/${questions.size}", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
            LinearProgressIndicator(progress = { (index + 1).toFloat() / questions.size }, modifier = Modifier.fillMaxWidth())
            Text(q.prompt, fontSize = 20.sp, fontWeight = FontWeight.Bold, lineHeight = 27.sp)
            q.options.forEachIndexed { i, option ->
                Surface(
                    modifier = Modifier.fillMaxWidth().clickable(enabled = !answered || examMode) { selected = i },
                    shape = RoundedCornerShape(14.dp),
                    border = BorderStroke(if (selected == i) 2.dp else 1.dp, if (selected == i) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline.copy(alpha=.25f)),
                    color = if (selected == i) MaterialTheme.colorScheme.primaryContainer.copy(alpha=.4f) else MaterialTheme.colorScheme.surface
                ) { Text("${('A'.code + i).toChar()}. $option", Modifier.padding(13.dp), fontSize = 14.sp) }
            }
            if (!answered || examMode) {
                Button(onClick = {
                    val correct = selected == q.correctIndex
                    if (correct) score++ else wrong = wrong + q.id
                    progressStore.recordAnswer(q.id, correct)
                    if (examMode) {
                        index++; selected = -1
                    } else answered = true
                }, enabled = selected >= 0, modifier = Modifier.fillMaxWidth()) {
                    Text(if (examMode) "Guardar y siguiente" else "Responder")
                }
            } else {
                Surface(shape = RoundedCornerShape(14.dp), color = if (selected == q.correctIndex) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.errorContainer, modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(13.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(if (selected == q.correctIndex) "Correcto" else "Revisar", fontWeight = FontWeight.Bold)
                        Text(q.explanation, fontSize = 12.sp)
                    }
                }
                Button(onClick = { index++; selected = -1; answered = false }, modifier = Modifier.fillMaxWidth()) { Text("Siguiente") }
            }
        }
    }
}

@Composable
fun DevelopmentSkeletonScreen(count: Int, onExit: () -> Unit) {
    val examples = remember { CourseRepository.developmentExamples.shuffled().take(count) }
    var answers by remember { mutableStateOf(examples.associate { it.id to "" }) }
    var revealed by rememberSaveable { mutableStateOf(false) }
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text("Esqueletos de desarrollo", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("Tesis + conceptos + mecanismo + caso + cierre. No redactes el ensayo completo.", fontSize = 12.sp)
            }
            TextButton(onClick = onExit) { Text("Salir") }
        }
        examples.forEach { ex ->
            Surface(shape = RoundedCornerShape(18.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.2f)), modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(7.dp)) {
                    Text(ex.title, fontWeight = FontWeight.Bold)
                    Text(ex.prompt, fontSize = 13.sp, lineHeight = 19.sp)
                    OutlinedTextField(
                        value = answers[ex.id].orEmpty(),
                        onValueChange = { answers = answers + (ex.id to it) },
                        label = { Text("Esqueleto de 5 movimientos") },
                        modifier = Modifier.fillMaxWidth().heightIn(min = 150.dp),
                        enabled = !revealed
                    )
                    if (revealed) {
                        Text("Tesis esperada", fontSize = 11.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                        Text(ex.thesis, fontSize = 12.sp)
                        Text("Estructura", fontSize = 11.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                        ex.structure.take(6).forEach { Bullet(it) }
                    }
                }
            }
        }
        if (!revealed) {
            Button(
                onClick = { revealed = true },
                enabled = examples.all { answers[it.id].orEmpty().trim().length >= 60 },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Comparar esqueletos") }
            Text("Se habilita cuando cada esquema tiene al menos 60 caracteres.", fontSize = 11.sp)
        } else {
            Button(onClick = onExit, modifier = Modifier.fillMaxWidth()) { Text("Terminar bloque") }
        }
        Spacer(Modifier.height(18.dp))
    }
}

@Composable
fun FilteredQuestionBankScreen(
    questions: List<QuizQuestion>,
    onStart: (List<Int>, String) -> Unit,
    onExit: () -> Unit
) {
    var query by rememberSaveable { mutableStateOf("") }
    var mode by rememberSaveable { mutableIntStateOf(0) } // 0 todo, 1 autor, 2 concepto, 3 caso
    val filtered = remember(query, mode) {
        val q = query.trim()
        questions.filter { item ->
            if (q.isBlank()) true else {
                val values = when (mode) {
                    1 -> AdaptiveStudyRepository.authorTags(item).toList()
                    2 -> AdaptiveStudyRepository.conceptTags(item).toList()
                    3 -> AdaptiveStudyRepository.caseTags(item).toList()
                    else -> AdaptiveStudyRepository.authorTags(item).toList() +
                        AdaptiveStudyRepository.conceptTags(item).toList() +
                        AdaptiveStudyRepository.caseTags(item).toList() +
                        listOf(item.prompt, item.explanation)
                }
                values.any { it.contains(q, ignoreCase = true) }
            }
        }
    }
    val suggestions = when (mode) {
        1 -> listOf("Pielke", "Karp", "Ouimet", "Leshner", "Kraft", "Martinuzzi")
        2 -> listOf("Honest Broker", "Policy cycle", "Public engagement", "Uso simbólico", "Public scholarship", "Knowledge brokerage")
        3 -> listOf("Humedales", "Suelos", "Neuroderechos", "Regulación térmica")
        else -> listOf("Pielke", "Honest Broker", "Humedales", "Ouimet", "Policy cycle", "Neuroderechos")
    }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text("Banco filtrable", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("Busca una combinación concreta y genera una sesión de hasta 30 preguntas.", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.65f))
            }
            TextButton(onClick = onExit) { Text("Volver") }
        }
        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = mode == 0, onClick = { mode = 0 }, label = { Text("Todo") })
            FilterChip(selected = mode == 1, onClick = { mode = 1 }, label = { Text("Autor") })
            FilterChip(selected = mode == 2, onClick = { mode = 2 }, label = { Text("Concepto") })
            FilterChip(selected = mode == 3, onClick = { mode = 3 }, label = { Text("Caso") })
        }
        OutlinedTextField(value = query, onValueChange = { query = it }, label = { Text("Buscar") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(6.dp))
        Text("Atajos", fontSize = 11.sp, fontWeight = FontWeight.Bold)
        suggestions.chunked(3).forEach { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                row.forEach { label -> AssistChip(onClick = { query = label }, label = { Text(label, fontSize = 10.sp) }) }
            }
        }
        Spacer(Modifier.height(8.dp))
        Text("${filtered.size} preguntas encontradas", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
        Button(
            onClick = { onStart(filtered.shuffled().take(30).map { it.id }, "Filtro: ${query.ifBlank { "todos" }} · ${minOf(filtered.size, 30)}") },
            enabled = filtered.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        ) { Text("Iniciar sesión filtrada") }
        Spacer(Modifier.height(8.dp))
        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            filtered.take(12).forEach { item ->
                Surface(shape = RoundedCornerShape(14.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.18f)), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                        Text(item.prompt, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, maxLines = 3, overflow = TextOverflow.Ellipsis)
                        val tags = (AdaptiveStudyRepository.authorTags(item) + AdaptiveStudyRepository.conceptTags(item) + AdaptiveStudyRepository.caseTags(item)).take(4)
                        Text(tags.joinToString(" · "), fontSize = 10.sp, color = MaterialTheme.colorScheme.secondary)
                    }
                }
            }
            if (filtered.size > 12) Text("Vista previa: 12 de ${filtered.size}. La sesión usa hasta 30 preguntas.", fontSize = 11.sp)
            Spacer(Modifier.height(14.dp))
        }
    }
}

@Composable
fun IntensivePrepScreen(progressStore: ProgressStore, refreshTick: Int, onExit: () -> Unit) {
    var view by rememberSaveable { mutableIntStateOf(0) } // 0 calendario, 1 rendimiento, 2 errores
    var localRefresh by remember { mutableIntStateOf(0) }
    val questions = CourseRepository.questions
    val calendar = remember(refreshTick, localRefresh) {
        IntensivePrepRepository.calendar(questions) { id -> progressStore.questionProgress(id) }
    }
    val attempts = remember(refreshTick, localRefresh) { progressStore.examAttempts(20) }
    val patterns = remember(refreshTick, localRefresh) {
        IntensivePrepRepository.errorPatterns(questions, { id -> progressStore.questionProgress(id) }, limit = 18)
    }
    val completed = remember(localRefresh) { progressStore.completedDailyPlanDates() }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text("Preparación intensiva", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("Plan dinámico hasta el 30 de septiembre según dominio, errores e historial de práctica.", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.65f))
            }
            TextButton(onClick = onExit) { Text("Volver") }
        }
        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = view == 0, onClick = { view = 0 }, label = { Text("Calendario") })
            FilterChip(selected = view == 1, onClick = { view = 1 }, label = { Text("Rendimiento") })
            FilterChip(selected = view == 2, onClick = { view = 2 }, label = { Text("Errores") })
        }
        Spacer(Modifier.height(10.dp))

        when (view) {
            0 -> Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Surface(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.primaryContainer.copy(alpha=.65f), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("Meta adaptativa de hoy", fontWeight = FontWeight.Bold)
                        Text(IntensivePrepRepository.dailyTargetSummary(questions) { id -> progressStore.questionProgress(id) }, fontSize = 13.sp)
                        Text("El calendario se recalcula a partir del estado actual; marcar un día como completado sólo registra cumplimiento, no altera tus respuestas.", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.62f))
                    }
                }
                if (calendar.isEmpty()) {
                    Text("La fecha de la prueba ya pasó. El historial y la matriz de errores siguen disponibles.", fontSize = 13.sp)
                } else {
                    calendar.forEach { goal ->
                        DailyGoalCard(goal, goal.dateEpochDay in completed) { checked ->
                            progressStore.setDailyPlanCompleted(goal.dateEpochDay, checked)
                            localRefresh++
                        }
                    }
                }
                Spacer(Modifier.height(16.dp))
            }
            1 -> Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                if (attempts.isEmpty()) {
                    Surface(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha=.6f), modifier = Modifier.fillMaxWidth()) {
                        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text("Aún no hay simulacros registrados", fontWeight = FontWeight.Bold)
                            Text("Completa un Simulacro de 30, un Simulacro mixto o el Examen final de práctica. Aquí aparecerá la curva de rendimiento objetivo.", fontSize = 13.sp)
                        }
                    }
                } else {
                    SectionTitle("Curva de rendimiento")
                    Text("Porcentaje de aciertos en alternativas. El desarrollo se conserva como autoevaluación separada cuando corresponde.", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.65f))
                    PerformanceChart(attempts)
                    SectionTitle("Historial")
                    attempts.forEach { ExamAttemptCard(it) }
                }
                Spacer(Modifier.height(16.dp))
            }
            else -> Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Surface(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha=.55f), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("Matriz de errores recurrentes", fontWeight = FontWeight.Bold)
                        Text("Agrupa errores acumulados por autor, concepto y caso. No infiere que un tema esté 'mal aprendido': sólo identifica dónde se concentran respuestas incorrectas registradas.", fontSize = 12.sp)
                    }
                }
                if (patterns.isEmpty()) {
                    Text("Todavía no hay errores suficientes para construir un patrón. Practica algunas preguntas y vuelve aquí.", fontSize = 13.sp)
                } else {
                    patterns.forEach { ErrorPatternCard(it) }
                }
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun DailyGoalCard(goal: DailyStudyGoal, completed: Boolean, onCompletedChange: (Boolean) -> Unit) {
    Surface(
        shape = RoundedCornerShape(17.dp),
        border = BorderStroke(1.dp, if (goal.isExamDay) MaterialTheme.colorScheme.primary.copy(alpha=.5f) else MaterialTheme.colorScheme.outline.copy(alpha=.2f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)) {
                    Text(goal.label, fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                    Text("${goal.phase} · ${goal.minutes} min", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Checkbox(checked = completed, onCheckedChange = onCompletedChange)
            }
            Text(goal.focus, fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary, fontWeight = FontWeight.SemiBold)
            goal.goals.forEach { Bullet(it) }
            Text(goal.rationale, fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.62f))
        }
    }
}

@Composable
fun PerformanceChart(attempts: List<ExamAttempt>) {
    val ordered = attempts.sortedBy { it.id }.takeLast(10)
    val primary = MaterialTheme.colorScheme.primary
    val outline = MaterialTheme.colorScheme.outline.copy(alpha=.25f)
    Surface(shape = RoundedCornerShape(18.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.18f)), modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Canvas(modifier = Modifier.fillMaxWidth().height(150.dp)) {
                if (ordered.isNotEmpty()) {
                    val left = 8f
                    val right = size.width - 8f
                    val top = 8f
                    val bottom = size.height - 12f
                    drawLine(outline, Offset(left, bottom), Offset(right, bottom), strokeWidth = 2f)
                    drawLine(outline, Offset(left, top), Offset(left, bottom), strokeWidth = 2f)
                    val path = Path()
                    ordered.forEachIndexed { i, a ->
                        val x = if (ordered.size == 1) (left + right) / 2f else left + (right - left) * i / (ordered.size - 1).toFloat()
                        val y = bottom - (bottom - top) * (a.objectivePercent / 100f)
                        if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
                    }
                    drawPath(path, primary, style = androidx.compose.ui.graphics.drawscope.Stroke(width = 5f))
                    ordered.forEachIndexed { i, a ->
                        val x = if (ordered.size == 1) (left + right) / 2f else left + (right - left) * i / (ordered.size - 1).toFloat()
                        val y = bottom - (bottom - top) * (a.objectivePercent / 100f)
                        drawCircle(primary, radius = 7f, center = Offset(x, y))
                    }
                }
            }
            Text(ordered.joinToString("  →  ") { "${it.objectivePercent}%" }, fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.66f))
        }
    }
}

@Composable
fun ExamAttemptCard(attempt: ExamAttempt) {
    val date = remember(attempt.id) {
        java.time.Instant.ofEpochMilli(attempt.id).atZone(java.time.ZoneId.systemDefault())
            .format(java.time.format.DateTimeFormatter.ofPattern("dd MMM · HH:mm", java.util.Locale("es", "CL")))
    }
    Surface(shape = RoundedCornerShape(15.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.18f)), modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(13.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Row(Modifier.fillMaxWidth()) {
                Text(attempt.mode, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                Text("${attempt.objectivePercent}%", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
            }
            Text("$date · ${attempt.correct}/${attempt.total} alternativas", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.62f))
            if (attempt.developmentScore != null && attempt.developmentMax != null) {
                Text("Desarrollo autoevaluado: ${attempt.developmentScore}/${attempt.developmentMax}", fontSize = 11.sp)
            }
            attempt.elapsedSeconds?.let { seconds ->
                Text("Tiempo usado: ${seconds / 60} min ${seconds % 60} s", fontSize = 11.sp)
            }
        }
    }
}

@Composable
fun ErrorPatternCard(pattern: ErrorPattern) {
    Surface(shape = RoundedCornerShape(15.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.18f)), modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(13.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)) {
                    Text(pattern.label, fontWeight = FontWeight.Bold)
                    Text(pattern.kind, fontSize = 10.sp, color = MaterialTheme.colorScheme.secondary)
                }
                Surface(shape = RoundedCornerShape(10.dp), color = if (pattern.recurring) MaterialTheme.colorScheme.errorContainer else MaterialTheme.colorScheme.surfaceVariant) {
                    Text("${pattern.errors} errores", Modifier.padding(horizontal = 8.dp, vertical = 4.dp), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }
            }
            LinearProgressIndicator(progress = { pattern.errorRate / 100f }, modifier = Modifier.fillMaxWidth())
            Text("${pattern.errorRate}% de error en ${pattern.attempts} intentos · ${pattern.linkedQuestions} preguntas vinculadas", fontSize = 11.sp)
            Text(pattern.suggestion, fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.65f))
        }
    }
}

@Composable
fun FinalExamScreen(progressStore: ProgressStore, onExit: () -> Unit) {
    val all = CourseRepository.questions
    val blueprint = IntensivePrepRepository.finalBlueprint
    val questions = remember {
        val generated = IntensivePrepRepository.freshFinalExam(
            questions = all,
            progress = { id -> progressStore.questionProgress(id) },
            previousIds = progressStore.lastExamIds("final30")
        )
        progressStore.saveLastExamIds("final30", generated.map { it.id })
        generated
    }
    val development = remember {
        val leastPracticedModule = AdaptiveStudyRepository.masteryByAuthor(all) { id -> progressStore.questionProgress(id) }
            .firstOrNull()?.label
        CourseRepository.developmentExamples.filter { it.id <= 12 }.shuffled().firstOrNull { ex ->
            leastPracticedModule == null || ex.concepts.any { it.contains(leastPracticedModule, ignoreCase = true) }
        } ?: CourseRepository.developmentExamples.filter { it.id <= 12 }.random()
    }
    var index by rememberSaveable { mutableIntStateOf(0) }
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    var score by rememberSaveable { mutableIntStateOf(0) }
    var wrongIds by remember { mutableStateOf<List<Int>>(emptyList()) }
    var stage by rememberSaveable { mutableIntStateOf(0) }
    var answer by rememberSaveable { mutableStateOf("") }
    var remaining by rememberSaveable { mutableIntStateOf(blueprint.minutes * 60) }
    var checked by remember { mutableStateOf<Set<Int>>(emptySet()) }
    var attemptId by rememberSaveable { mutableLongStateOf(0L) }
    val rubric = if (development.rubric.isNotEmpty()) development.rubric else StudyToolsRepository.developmentRubric
    val devScore = rubric.mapIndexed { i, r -> if (i in checked) r.maxPoints else 0 }.sum()
    val maxDev = rubric.sumOf { it.maxPoints }

    LaunchedEffect(stage) {
        while (stage != 2 && remaining > 0) {
            delay(1000)
            remaining--
        }
    }

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(blueprint.title, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("30 alternativas + 1 desarrollo · ${blueprint.minutes} minutos", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.65f))
            }
            Surface(shape = RoundedCornerShape(12.dp), color = if (remaining > 0) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.errorContainer) {
                Text(String.format("%02d:%02d", remaining / 60, remaining % 60), Modifier.padding(horizontal = 12.dp, vertical = 8.dp), fontWeight = FontWeight.Bold)
            }
        }
        Surface(shape = RoundedCornerShape(14.dp), color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha=.55f), modifier = Modifier.fillMaxWidth()) {
            Text(blueprint.note, Modifier.padding(12.dp), fontSize = 11.sp, lineHeight = 16.sp)
        }

        when (stage) {
            0 -> {
                val q = questions[index]
                Text("Alternativas · ${index + 1}/${questions.size}", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                LinearProgressIndicator(progress = { (index + 1).toFloat() / questions.size }, modifier = Modifier.fillMaxWidth())
                Text(q.prompt, fontSize = 20.sp, lineHeight = 27.sp, fontWeight = FontWeight.Bold)
                q.options.forEachIndexed { optionIndex, option ->
                    Surface(
                        modifier = Modifier.fillMaxWidth().clickable { selected = optionIndex },
                        shape = RoundedCornerShape(14.dp),
                        border = BorderStroke(if (selected == optionIndex) 2.dp else 1.dp, if (selected == optionIndex) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline.copy(alpha=.25f)),
                        color = if (selected == optionIndex) MaterialTheme.colorScheme.primaryContainer.copy(alpha=.45f) else MaterialTheme.colorScheme.surface
                    ) { Text("${('A'.code + optionIndex).toChar()}. $option", Modifier.padding(14.dp), fontSize = 14.sp) }
                }
                Text("Sin feedback durante el examen. La selección prioriza preguntas no vistas y reduce repetición respecto del intento final anterior.", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha=.58f))
                Button(
                    onClick = {
                        val correct = selected == q.correctIndex
                        if (correct) score++ else wrongIds = wrongIds + q.id
                        progressStore.recordAnswer(q.id, correct)
                        if (index == questions.lastIndex) stage = 1 else { index++; selected = -1 }
                    },
                    enabled = selected >= 0,
                    modifier = Modifier.fillMaxWidth()
                ) { Text(if (index == questions.lastIndex) "Ir a desarrollo" else "Guardar y siguiente") }
            }
            1 -> {
                Text("Desarrollo", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                Surface(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha=.65f), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        Text(development.title, fontWeight = FontWeight.Bold)
                        Text(development.prompt, fontSize = 14.sp, lineHeight = 21.sp)
                    }
                }
                OutlinedTextField(value = answer, onValueChange = { answer = it }, label = { Text("Tu respuesta") }, modifier = Modifier.fillMaxWidth().heightIn(min = 320.dp))
                Button(onClick = {
                    if (attemptId == 0L) {
                        attemptId = progressStore.recordExamAttempt(
                            mode = "Examen final",
                            correct = score,
                            total = questions.size,
                            developmentScore = 0,
                            developmentMax = maxDev,
                            elapsedSeconds = blueprint.minutes * 60 - remaining,
                            questionIds = questions.map { it.id }
                        )
                    }
                    stage = 2
                }, enabled = answer.trim().length >= 160, modifier = Modifier.fillMaxWidth()) { Text("Entregar examen") }
                Text("Mínimo técnico: 160 caracteres. La calidad del desarrollo se revisa después con rúbrica; el detector no reemplaza evaluación docente.", fontSize = 11.sp)
            }
            else -> {
                Surface(shape = RoundedCornerShape(20.dp), color = MaterialTheme.colorScheme.primaryContainer, modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(18.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Alternativas", fontSize = 12.sp)
                        Text("$score / ${questions.size}", fontSize = 36.sp, fontWeight = FontWeight.Bold)
                        Text("${score * 100 / questions.size}% correctas", fontSize = 13.sp)
                    }
                }
                val analysis = remember(answer) { DevelopmentAnalyzer.analyze(answer, development) }
                SectionTitle("Diagnóstico estructural")
                Text("Cobertura detectada: ${analysis.coverageScore}% · ${analysis.wordCount} palabras", fontSize = 12.sp)
                analysis.checks.forEach { c ->
                    Text("${if (c.detected) "✓" else "·"} ${c.label}: ${c.evidence}", fontSize = 11.sp)
                }
                if (wrongIds.isNotEmpty()) {
                    SectionTitle("Errores objetivos")
                    wrongIds.mapNotNull { id -> all.find { it.id == id } }.take(10).forEach { q ->
                        Surface(shape = RoundedCornerShape(12.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.18f)), modifier = Modifier.fillMaxWidth()) {
                            Column(Modifier.padding(11.dp)) {
                                Text(q.prompt, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                                Text(q.explanation, fontSize = 11.sp)
                            }
                        }
                    }
                    if (wrongIds.size > 10) Text("Se muestran 10 de ${wrongIds.size} errores. La matriz completa queda registrada en Preparación intensiva → Errores.", fontSize = 11.sp)
                }
                SectionTitle("Rúbrica del desarrollo")
                Text("Autoevaluación: $devScore / $maxDev", fontSize = 12.sp)
                rubric.forEachIndexed { i, criterion ->
                    Surface(shape = RoundedCornerShape(13.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha=.18f)), modifier = Modifier.fillMaxWidth()) {
                        Row(Modifier.padding(9.dp), verticalAlignment = Alignment.Top) {
                            Checkbox(checked = i in checked, onCheckedChange = { v ->
                                val updated = if (v) checked + i else checked - i
                                checked = updated
                                if (attemptId > 0L) {
                                    val updatedScore = rubric.mapIndexed { idx, r -> if (idx in updated) r.maxPoints else 0 }.sum()
                                    progressStore.updateExamDevelopment(attemptId, updatedScore, maxDev)
                                }
                            })
                            Column(Modifier.padding(start = 4.dp)) {
                                Text("${criterion.label} · ${criterion.maxPoints} pts", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                                Text(criterion.description, fontSize = 11.sp)
                            }
                        }
                    }
                }
                SectionTitle("Tesis esperada")
                Text(development.thesis, fontSize = 13.sp, lineHeight = 20.sp)
                SectionTitle("Modelo de respuesta")
                Text(development.modelAnswer, fontSize = 13.sp, lineHeight = 21.sp)
                OutlinedButton(onClick = onExit, modifier = Modifier.fillMaxWidth()) { Text("Volver") }
            }
        }
        if (stage != 2) OutlinedButton(onClick = onExit, modifier = Modifier.fillMaxWidth()) { Text("Salir del examen") }
        Spacer(Modifier.height(20.dp))
    }
}
