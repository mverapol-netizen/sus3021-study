package cl.uc.sus3021study.data

import cl.uc.sus3021study.model.*
import kotlin.math.roundToInt

object AdaptiveStudyRepository {

    val flashcards: List<Flashcard> by lazy {
        val matrixCards = StudyToolsRepository.matrixEntries.mapIndexed { index, entry ->
            Flashcard(
                id = index + 1,
                moduleId = moduleForAuthor(entry.author),
                front = "¿Qué significa ${entry.concept} en ${entry.author}?",
                back = "${entry.coreIdea}\n\nUso en prueba: ${entry.examUse}",
                author = entry.author,
                concept = entry.concept,
                caseLinks = entry.caseLinks,
                source = "Matriz conceptual construida desde las lecturas del curso"
            )
        }
        val readingCards = DeepStudyRepository.readings.map { reading ->
            Flashcard(
                id = 100 + reading.id,
                moduleId = reading.moduleId,
                front = "¿Cuál es la tesis central de ${reading.title}?",
                back = reading.thesis,
                author = reading.author,
                concept = reading.keyConcepts.take(3).joinToString(" · "),
                caseLinks = reading.caseConnections,
                source = reading.source
            )
        }
        val caseCards = DeepStudyRepository.cases.flatMap { dossier ->
            listOf(
                Flashcard(
                    id = 200 + dossier.id * 10 + 1,
                    moduleId = 6,
                    front = "${dossier.name}: ¿cuál es el problema público que organiza el caso?",
                    back = dossier.coreProblem,
                    author = "Caso de estudio",
                    concept = "Definición del problema",
                    caseLinks = listOf(dossier.name),
                    source = dossier.source
                ),
                Flashcard(
                    id = 200 + dossier.id * 10 + 2,
                    moduleId = 6,
                    front = "${dossier.name}: menciona dos mecanismos que conectan conocimiento y política.",
                    back = dossier.mechanisms.take(4).joinToString("\n• ", prefix = "• "),
                    author = "Caso de estudio",
                    concept = dossier.concepts.take(3).joinToString(" · "),
                    caseLinks = listOf(dossier.name),
                    source = dossier.source
                ),
                Flashcard(
                    id = 200 + dossier.id * 10 + 3,
                    moduleId = 6,
                    front = "${dossier.name}: ¿qué error analítico debes evitar en una respuesta de prueba?",
                    back = dossier.caution,
                    author = "Caso de estudio",
                    concept = "Uso analítico del caso",
                    caseLinks = listOf(dossier.name),
                    source = dossier.source
                )
            )
        }
        matrixCards + readingCards + caseCards
    }

    val oralPrompts = listOf(
        OralPrompt(1, 1, "En 60 segundos: ¿por qué un buen policy brief puede ser necesario pero insuficiente?", listOf("Criticar el supuesto lineal de transferencia.", "Nombrar contexto, relaciones, intereses y oportunidad.", "Conectar con enfoque de redes o brokerage."), "Martinuzzi & Sedlacko", listOf("Modelo lineal", "Enfoque de redes", "Knowledge brokerage"), "Suelos o regulación térmica"),
        OralPrompt(2, 1, "Define needfinding y explica por qué importa para una interfaz ciencia–Congreso.", listOf("Descubrir/definir antes de diseñar.", "Comprender oferta y demanda.", "Identificar fricciones reales y no asumir la solución."), "Garretón et al.", listOf("Needfinding", "Oferta/demanda", "Intermediación"), "Sistema Vincula"),
        OralPrompt(3, 1, "Compara enfoque sistémico y enfoque de redes en una respuesta breve.", listOf("Sistemas: códigos distintos, verdad versus poder/legitimidad.", "Redes: conectividad mediante interacción y confianza.", "Explicar que la diferencia cambia la estrategia de brokerage."), "Martinuzzi & Sedlacko", listOf("Teoría de sistemas", "Enfoque de redes")),
        OralPrompt(4, 1, "¿Qué hace un broker que no hace una estrategia de difusión simple?", listOf("Traduce lenguajes y necesidades.", "Conecta actores y organiza interacción.", "Construye confianza y ajusta formatos/procesos."), "Martinuzzi & Sedlacko", listOf("Broker", "Boundary work"), "Ley de Suelos"),

        OralPrompt(5, 2, "Diferencia Science Arbiter y Honest Broker con un ejemplo.", listOf("Arbiter responde preguntas empíricas delimitadas.", "Broker aclara/expande alternativas y consecuencias.", "La elección normativa queda en el decisor."), "Pielke", listOf("Science Arbiter", "Honest Broker"), "Neuroderechos"),
        OralPrompt(6, 2, "¿Por qué Issue Advocate no significa necesariamente mala ciencia?", listOf("La categoría describe relación con alternativas.", "Puede usar evidencia rigurosa.", "Lo distintivo es defender o estrechar opciones preferidas."), "Pielke", listOf("Issue Advocate", "Alternativas de decisión")),
        OralPrompt(7, 2, "Explica el riesgo de stealth issue advocacy.", listOf("Presentar una preferencia normativa como conclusión puramente científica.", "Ocultar la selección de valores o alternativas.", "Distinguir información de elección política."), "Pielke", listOf("Stealth issue advocacy", "Valores"), "Neuroderechos"),
        OralPrompt(8, 2, "Clasifica a un experto que presenta tres opciones regulatorias con costos e incertidumbres.", listOf("Honest Broker.", "Expande o clarifica alternativas.", "No sustituye al decisor democrático."), "Pielke", listOf("Honest Broker")),

        OralPrompt(9, 3, "Enumera las seis etapas del policy cycle y agrega la advertencia metodológica central.", listOf("Agenda, formulación, legitimación, implementación, evaluación, cambio.", "Son categorías analíticas.", "Pueden solaparse, retroalimentarse u omitirse."), "Kraft & Furlong", listOf("Policy cycle"), "Regulación térmica"),
        OralPrompt(10, 3, "¿Qué significa que confianza en ciencia no equivale a obediencia?", listOf("Puede existir confianza general sin seguir una recomendación específica.", "Decisiones incluyen valores, intereses y experiencia.", "Evitar diagnosticar todo desacuerdo como ignorancia."), "Leshner", listOf("Trust vs compliance", "Facts + values")),
        OralPrompt(11, 3, "Contrasta modelo de déficit y public engagement.", listOf("Déficit: desacuerdo como falta de información.", "Engagement: diálogo y escucha.", "Adaptar a audiencia y representar incertidumbre honestamente."), "Leshner", listOf("Deficit model", "Public engagement")),
        OralPrompt(12, 3, "Usa un caso para mostrar que el ciclo de políticas no es lineal.", listOf("Identificar al menos dos etapas que se superponen.", "Mostrar retroalimentación o demora.", "Explicar por qué el modelo sigue siendo útil como mapa."), "Kraft & Furlong", listOf("Policy cycle", "No linealidad"), "Suelos, Humedales o regulación térmica"),

        OralPrompt(13, 4, "Distingue uso instrumental, conceptual y simbólico/táctico de evidencia.", listOf("Instrumental: tarea o decisión relativamente directa.", "Conceptual: cambia comprensión o lenguaje.", "Simbólico/táctico: justifica, persuade o fortalece posiciones."), "Ouimet et al.", listOf("Uso instrumental", "Uso conceptual", "Uso simbólico/táctico")),
        OralPrompt(14, 4, "Nombra las cuatro familias de barreras/facilitadores de Ouimet.", listOf("Institución/organización.", "Características de la investigación.", "Contexto de política y político.", "Características individuales."), "Ouimet et al.", listOf("Barreras/facilitadores"), "Humedales"),
        OralPrompt(15, 4, "¿Por qué el uso simbólico de evidencia no debe confundirse automáticamente con falsificación?", listOf("Describe una función política/persuasiva.", "Puede movilizar evidencia verdadera.", "El análisis debe observar propósito y contexto de uso."), "Ouimet et al.", listOf("Uso simbólico/táctico")),
        OralPrompt(16, 4, "Aplica dos barreras y dos facilitadores al caso de Humedales.", listOf("Elegir factores de categorías distintas.", "Vincularlos con actores/relaciones concretas.", "Explicar el mecanismo, no sólo enumerar."), "Ouimet et al.", listOf("Barreras/facilitadores", "Trust/social relations"), "Humedales Urbanos"),

        OralPrompt(17, 5, "¿Por qué public scholarship no es simplemente divulgación?", listOf("Cruza fronteras institucionales/culturales.", "Trabaja con públicos activos y conocedores.", "Exige juicio, mediación y compromiso sin abandonar estándares."), "Karp", listOf("Public scholarship", "Boundary crossing"), "Humedales"),
        OralPrompt(18, 5, "¿Qué significa tratar a los públicos como knowledgeable agents?", listOf("Reconocer saberes, criterios y experiencias propias.", "No asumir audiencia vacía o pasiva.", "Diseñar interacción y no sólo transmisión."), "Karp", listOf("Knowledgeable agents", "Pluralism")),
        OralPrompt(19, 5, "Explica la tensión entre fidelidad disciplinaria y compromiso en Karp.", listOf("Mantener estándares de conocimiento.", "Aceptar restricciones y negociación del trabajo público.", "Compromiso no equivale a falsificar evidencia."), "Karp", listOf("Compromise", "Judgment"), "Regulación térmica"),
        OralPrompt(20, 5, "Conecta Karp y Leshner en una sola tesis.", listOf("Ambos rechazan el público pasivo/deficitario.", "Ambos exigen escuchar valores y perspectivas.", "Karp enfatiza vocación/pluralismo; Leshner, engagement y comunicación."), "Karp + Leshner", listOf("Public scholarship", "Public engagement", "Pluralism")),

        OralPrompt(21, 6, "¿Qué distingue analíticamente al caso de Suelos de los otros tres?", listOf("Temporalidad muy larga.", "Metodología explícita de consensos/co-creación.", "Redes científicas, sociedad civil y actores legislativos."), "Casos de estudio", listOf("Consenso", "Brokerage", "Ventana de oportunidad"), "Ley de Suelos"),
        OralPrompt(22, 6, "¿Cuál es la principal lección de Humedales para pensar incidencia académica?", listOf("La evidencia entra en relaciones, negociación y estrategia.", "Importan asesores y emprendimiento político.", "Hay costos y aprendizajes al salir de la academia."), "Casos de estudio", listOf("Public scholarship", "Legitimación", "Uso de evidencia"), "Humedales Urbanos"),
        OralPrompt(23, 6, "¿Por qué regulación térmica es un buen caso de temporalidad e implementación?", listOf("Trayectoria de décadas.", "Estándares graduales y revisiones sucesivas.", "Distancia entre conocimiento, norma e implementación."), "Casos de estudio", listOf("Implementación", "Policy change", "Factibilidad"), "Regulación térmica"),
        OralPrompt(24, 6, "¿Por qué Neuroderechos es especialmente útil para Pielke y Karp?", listOf("Expertise no elimina desacuerdos normativos.", "Hay pluralidad disciplinaria y debate jurídico/ético.", "Permite distinguir roles expertos y trabajo público entre fronteras."), "Casos de estudio", listOf("Pielke", "Pluralism", "Uncertainty"), "Neuroderechos")
    )

    val combinations = listOf(
        KnowledgeCombination("Pielke", "Neuroderechos", listOf("Science Arbiter", "Issue Advocate", "Honest Broker"), "Obliga a separar evidencia, incertidumbre, alternativas y elección normativa."),
        KnowledgeCombination("Ouimet et al.", "Humedales Urbanos", listOf("Usos de evidencia", "Barreras/facilitadores"), "Permite observar múltiples funciones legislativas de investigación y condiciones de uso."),
        KnowledgeCombination("Martinuzzi & Sedlacko", "Ley de Suelos", listOf("Enfoque de redes", "Brokerage", "Agenda-setting game"), "El caso muestra redes, coordinación, consensos y traducción sostenida."),
        KnowledgeCombination("Karp", "Humedales Urbanos", listOf("Public scholarship", "Público activo", "Compromise"), "Carolina Rojas permite analizar el tránsito desde academia a trabajo público."),
        KnowledgeCombination("Kraft & Furlong", "Regulación térmica", listOf("Policy cycle", "Implementación", "Policy change"), "La trayectoria permite seguir formulación, implementación y revisiones durante décadas."),
        KnowledgeCombination("Leshner", "Neuroderechos", listOf("Facts + values", "Uncertainty", "Public engagement"), "El caso muestra por qué información científica no resuelve por sí sola desacuerdos normativos."),
        KnowledgeCombination("Martinuzzi & Sedlacko", "Regulación térmica", listOf("Boundary work", "Enfoque de redes", "Factibilidad"), "Academia, Estado e industria interactúan de forma sostenida para hacer posible regulación."),
        KnowledgeCombination("Karp", "Neuroderechos", listOf("Pluralism", "Boundary crossing", "Judgment"), "La controversia interdisciplinaria exige trabajar con desacuerdo legítimo sin borrar estándares."),
        KnowledgeCombination("Garretón et al.", "Ley de Suelos", listOf("Needfinding", "Intermediación", "Oferta/demanda"), "Ayuda a pensar qué fricciones y requerimientos institucionales hacen posible el encuentro ciencia–Congreso."),
        KnowledgeCombination("Ouimet et al.", "Ley de Suelos", listOf("Consenso", "Factibilidad", "Uso conceptual"), "El proceso colectivo muestra usos de evidencia que exceden una causalidad instrumental simple.")
    )

    fun authorTags(question: QuizQuestion): Set<String> {
        val t = questionText(question)
        val tags = mutableSetOf<String>()
        if (question.moduleId == 1) {
            if (containsAny(t, "vincula", "needfinding", "3c", "mapa de actores", "oferta", "demanda")) tags += "Garretón et al."
            if (!containsAny(t, "vincula", "needfinding", "3c") || containsAny(t, "broker", "redes", "sistém", "muro", "questions-and-answers", "agenda-setting", "boundary")) tags += "Martinuzzi & Sedlacko"
        }
        if (question.moduleId == 2 || containsAny(t, "pielke", "science arbiter", "honest broker", "issue advocate", "pure scientist", "stealth")) tags += "Pielke"
        if (question.moduleId == 3) {
            if (containsAny(t, "trust", "confianza", "déficit", "deficit", "engagement", "sesgo", "disonancia", "valores", "obediencia", "público")) tags += "Leshner"
            if (containsAny(t, "agenda", "formulación", "legitim", "implement", "evaluación", "policy cycle", "ciclo", "cambio de política")) tags += "Kraft & Furlong"
            if (tags.isEmpty()) tags += setOf("Kraft & Furlong", "Leshner")
        }
        if (question.moduleId == 4 || containsAny(t, "ouimet", "instrumental", "conceptual", "simbólico", "táctico", "barreras", "facilitadores")) tags += "Ouimet et al."
        if (question.moduleId == 5 || containsAny(t, "karp", "public scholarship", "pluralismo", "knowledgeable", "vocación", "compromiso")) tags += "Karp"
        return tags
    }

    fun conceptTags(question: QuizQuestion): Set<String> {
        val t = questionText(question)
        val rules = listOf(
            "Modelo lineal" to listOf("lineal", "transferencia", "paquetes", "muro"),
            "Enfoque de redes" to listOf("enfoque de redes", "redes", "confianza", "interacción sostenida"),
            "Knowledge brokerage" to listOf("brokerage", "broker", "intermediario", "intermediación", "traducción"),
            "Needfinding" to listOf("needfinding", "descubrir", "definir", "oferta", "demanda", "vincula"),
            "Boundary work" to listOf("boundary", "frontera", "interfaz"),
            "Science Arbiter" to listOf("science arbiter", "arbiter"),
            "Issue Advocate" to listOf("issue advocate", "advocate", "advocacy"),
            "Honest Broker" to listOf("honest broker", "alternativas"),
            "Policy cycle" to listOf("policy cycle", "ciclo", "seis etapas", "agenda", "formulación", "legitimación", "implementación", "evaluación"),
            "Agenda setting" to listOf("agenda setting", "agenda", "entra en la agenda"),
            "Legitimación" to listOf("legitimación", "legitimidad", "voto", "apoyo"),
            "Modelo de déficit" to listOf("déficit", "deficit", "más información", "ignorancia"),
            "Public engagement" to listOf("engagement", "diálogo", "escucha", "audiencia"),
            "Facts + values" to listOf("hechos", "valores", "intereses", "obediencia", "confianza"),
            "Uso instrumental" to listOf("instrumental", "directamente"),
            "Uso conceptual" to listOf("conceptual", "marcos", "comprensión", "lenguaje"),
            "Uso simbólico/táctico" to listOf("simbólico", "táctico", "persuas", "justificar"),
            "Barreras/facilitadores" to listOf("barreras", "facilitadores", "institución", "organización", "características individuales"),
            "Public scholarship" to listOf("public scholarship", "académico público", "vocación pública", "fuera de la academia"),
            "Pluralismo" to listOf("pluralismo", "plural", "incompatibles", "públicos activos", "knowledgeable"),
            "Compromise/Judgment" to listOf("compromiso", "judgment", "juicio", "fines prácticos"),
            "Ventana de oportunidad" to listOf("ventana", "oportunidad", "timing"),
            "Factibilidad" to listOf("factibilidad", "viable", "industria", "gradual"),
            "Incertidumbre" to listOf("incertidumbre", "certeza", "consenso científico")
        )
        val out = mutableSetOf<String>()
        rules.forEach { (label, keys) -> if (keys.any { t.contains(it) }) out += label }
        if (question.moduleId == 6 && out.isEmpty()) out += "Integración teoría–caso"
        return out
    }

    fun caseTags(question: QuizQuestion): Set<String> {
        val t = questionText(question)
        val tags = mutableSetOf<String>()
        if (containsAny(t, "suelo", "suelos")) tags += "Ley de Suelos"
        if (containsAny(t, "humedal", "humedales", "carolina rojas")) tags += "Humedales Urbanos"
        if (containsAny(t, "térmica", "termica", "waldo", "minvu", "vivienda")) tags += "Regulación térmica"
        if (containsAny(t, "neuro", "yuste", "girardi", "morningside", "21.383")) tags += "Neuroderechos"
        return tags
    }

    fun masteryByAuthor(questions: List<QuizQuestion>, progress: (Int) -> QuestionProgress): List<MasteryStat> {
        val labels = listOf("Garretón et al.", "Martinuzzi & Sedlacko", "Pielke", "Kraft & Furlong", "Leshner", "Ouimet et al.", "Karp")
        return labels.map { label -> mastery(label, "Autor", questions.filter { label in authorTags(it) }, progress) }
            .sortedWith(compareBy<MasteryStat> { it.score }.thenBy { it.label })
    }

    fun masteryByConcept(questions: List<QuizQuestion>, progress: (Int) -> QuestionProgress): List<MasteryStat> {
        val labels = questions.flatMap { conceptTags(it) }.distinct()
        return labels.map { label -> mastery(label, "Concepto", questions.filter { label in conceptTags(it) }, progress) }
            .filter { it.linkedQuestions >= 2 }
            .sortedWith(compareBy<MasteryStat> { it.score }.thenBy { it.label })
    }

    fun masteryByCase(questions: List<QuizQuestion>, progress: (Int) -> QuestionProgress): List<MasteryStat> {
        val labels = listOf("Ley de Suelos", "Humedales Urbanos", "Regulación térmica", "Neuroderechos")
        return labels.map { label -> mastery(label, "Caso", questions.filter { label in caseTags(it) }, progress) }
            .sortedWith(compareBy<MasteryStat> { it.score }.thenBy { it.label })
    }

    fun adaptiveRoute(questions: List<QuizQuestion>, progress: (Int) -> QuestionProgress, limit: Int = 4): List<AdaptiveRouteItem> {
        val authors = masteryByAuthor(questions, progress).associateBy { it.label }
        val cases = masteryByCase(questions, progress).associateBy { it.label }
        return combinations.map { combo ->
            val a = authors[combo.author]?.score ?: 0
            val c = cases[combo.caseName]?.score ?: 0
            val conceptQuestions = questions.filter { q -> combo.concepts.any { it in conceptTags(q) } }
            val cs = if (conceptQuestions.isEmpty()) 0 else mastery(combo.concepts.joinToString(" + "), "Combinación", conceptQuestions, progress).score
            val score = ((a * 0.45) + (c * 0.30) + (cs * 0.25)).roundToInt()
            val reason = when {
                (authors[combo.author]?.attemptedQuestions ?: 0) == 0 -> "Aún no hay suficiente práctica registrada sobre ${combo.author}."
                (cases[combo.caseName]?.attemptedQuestions ?: 0) == 0 -> "El caso ${combo.caseName} todavía tiene baja cobertura en tus respuestas."
                score < 45 -> "La combinación presenta baja consolidación entre teoría y caso."
                score < 70 -> "Hay conocimiento parcial, pero conviene practicar la aplicación del mecanismo al caso."
                else -> "Está relativamente consolidada; una respuesta oral breve sirve para mantenerla activa."
            }
            val action = when {
                score < 35 -> "Repasa la ficha del autor, estudia el dossier del caso y luego responde 5 preguntas relacionadas."
                score < 60 -> "Haz 3 flashcards de los conceptos y responde una pregunta oral usando el caso."
                else -> "Escribe una mini respuesta de 5 líneas que conecte concepto → mecanismo → evidencia del caso."
            }
            AdaptiveRouteItem(combo, score, reason, action)
        }.sortedBy { it.score }.take(limit)
    }

    fun generateDistinctExam(
        questions: List<QuizQuestion>,
        moduleCounts: Map<Int, Int>,
        previousIds: Set<Int> = emptySet()
    ): List<QuizQuestion> {
        fun build(): List<QuizQuestion> = moduleCounts.flatMap { (module, n) ->
            questions.filter { it.moduleId == module }.shuffled().take(n)
        }.shuffled()
        var candidate = build()
        repeat(12) {
            val overlap = if (previousIds.isEmpty()) 0.0 else candidate.count { it.id in previousIds }.toDouble() / candidate.size.coerceAtLeast(1)
            if (overlap <= 0.65) return candidate
            candidate = build()
        }
        return candidate
    }

    private fun mastery(label: String, kind: String, qs: List<QuizQuestion>, progress: (Int) -> QuestionProgress): MasteryStat {
        if (qs.isEmpty()) return MasteryStat(label, kind, 0, 0, 0, 0, 0.0, 0)
        val ps = qs.map { progress(it.id) }
        val attempted = ps.count { it.attempts > 0 }
        val totalAttempts = ps.sumOf { it.attempts }
        val correct = ps.sumOf { it.correct }
        val accuracy = if (totalAttempts == 0) 0.0 else correct.toDouble() / totalAttempts
        val coverage = attempted.toDouble() / qs.size
        val meanBox = ps.map { it.box }.average()
        val score = ((meanBox / 5.0) * 55 + accuracy * 30 + coverage * 15).roundToInt().coerceIn(0, 100)
        return MasteryStat(label, kind, qs.size, attempted, totalAttempts, correct, meanBox, score)
    }

    private fun questionText(question: QuizQuestion): String =
        (question.prompt + " " + question.options.joinToString(" ") + " " + question.explanation).lowercase()

    private fun containsAny(text: String, vararg keys: String): Boolean = keys.any { text.contains(it.lowercase()) }

    private fun moduleForAuthor(author: String): Int = when {
        author.contains("Garretón", ignoreCase = true) || author.contains("Martinuzzi", ignoreCase = true) -> 1
        author.contains("Pielke", ignoreCase = true) -> 2
        author.contains("Kraft", ignoreCase = true) || author.contains("Leshner", ignoreCase = true) -> 3
        author.contains("Ouimet", ignoreCase = true) -> 4
        author.contains("Karp", ignoreCase = true) -> 5
        else -> 6
    }
}
