package cl.uc.sus3021study.data

import cl.uc.sus3021study.model.*
import java.text.Normalizer
import java.time.LocalDate
import java.time.temporal.ChronoUnit

object StudySessionRepository {

    fun plan(
        minutes: Int,
        questions: List<QuizQuestion>,
        progress: (Int) -> QuestionProgress
    ): StudySessionPlan {
        val route = AdaptiveStudyRepository.adaptiveRoute(questions, progress, limit = 3)
        val focus = route.joinToString(" · ") { "${it.combination.author} × ${it.combination.caseName}" }
            .ifBlank { "conceptos y casos prioritarios" }
        val weakest = route.firstOrNull()?.combination
        val primary = weakest?.let { "${it.author} + ${it.caseName}" } ?: "tu contenido menos consolidado"

        return when (minutes) {
            15 -> StudySessionPlan(
                15,
                "Sesión express",
                "Recuperación breve y densa. Prioriza errores y el cruce menos consolidado: $primary.",
                listOf(
                    StudySessionTask("Flashcards adaptativas", 4, "FLASHCARDS", "Responde 5 tarjetas sin mirar y marca con rigor si realmente las sabías.", focus),
                    StudySessionTask("Alternativas adaptativas", 6, "QUIZ", "Responde 6 preguntas. En cada error, verbaliza por qué la alternativa correcta es mejor.", primary),
                    StudySessionTask("Respuesta oral", 3, "ORAL", "Explica 1 concepto en 60 segundos y conéctalo a un caso.", primary),
                    StudySessionTask("Cierre", 2, "REFLECTION", "Escribe mentalmente una cadena: concepto → mecanismo → evidencia del caso → conclusión.", primary)
                ),
                "Termina pudiendo explicar una conexión teoría–caso sin consultar apuntes."
            )
            25 -> StudySessionPlan(
                25,
                "Sesión estándar",
                "Combina recuperación, discriminación conceptual y aplicación. Foco actual: $focus.",
                listOf(
                    StudySessionTask("Flashcards adaptativas", 6, "FLASHCARDS", "Haz 8 tarjetas, dando prioridad a vencidas o falladas.", focus),
                    StudySessionTask("Quiz adaptativo", 8, "QUIZ", "Responde 10 preguntas y detente en los distractores plausibles.", focus),
                    StudySessionTask("Modo oral", 4, "ORAL", "Responde 2 prompts breves. Cada explicación debe incluir definición y mecanismo.", primary),
                    StudySessionTask("Mini desarrollo", 7, "DEVELOPMENT", "Redacta sólo tesis + 3 movimientos argumentales + caso. No mires el modelo hasta terminar.", primary)
                ),
                "Comprueba si puedes pasar de definición a mecanismo y luego a evidencia empírica."
            )
            else -> StudySessionPlan(
                45,
                "Sesión profunda",
                "Sesión de consolidación: mezcla recuperación espaciada, examen y escritura. Foco: $focus.",
                listOf(
                    StudySessionTask("Flashcards de precisión", 8, "FLASHCARDS", "Haz 12 tarjetas y formula una contra-diferencia para conceptos que suelas confundir.", focus),
                    StudySessionTask("Bloque de alternativas", 12, "QUIZ", "Responde 15 preguntas adaptativas sin consultar materiales.", focus),
                    StudySessionTask("Explicación oral", 6, "ORAL", "Responde 2 prompts y obliga a que aparezca un caso concreto en cada respuesta.", primary),
                    StudySessionTask("Desarrollo", 14, "DEVELOPMENT", "Redacta una respuesta de 250–400 palabras: tesis, concepto, mecanismo, caso e integración.", primary),
                    StudySessionTask("Revisión de errores", 5, "REFLECTION", "Revisa sólo lo fallado y anota la distinción conceptual que habría evitado cada error.", focus)
                ),
                "La sesión está completa sólo si puedes reconstruir el argumento sin depender del reconocimiento pasivo."
            )
        }
    }

    fun dayBeforePlan(
        questions: List<QuizQuestion>,
        progress: (Int) -> QuestionProgress
    ): StudySessionPlan {
        val route = AdaptiveStudyRepository.adaptiveRoute(questions, progress, limit = 3)
        val focus = route.joinToString(" · ") { "${it.combination.author} × ${it.combination.caseName}" }
            .ifBlank { "errores, conceptos centrales y casos" }
        return StudySessionPlan(
            55,
            "Día antes de la prueba",
            "No incorpora materia nueva. Consolida errores, distinciones conceptuales y estructuras de respuesta. Prioridades: $focus.",
            listOf(
                StudySessionTask("Errores y vencidas", 10, "QUIZ", "Revisa primero preguntas falladas y vencidas. No abras el banco completo.", focus),
                StudySessionTask("Flashcards de alto rendimiento", 10, "FLASHCARDS", "Haz 12–15 tarjetas. Si dudas, marca revisar: no conviertas familiaridad en falsa seguridad.", focus),
                StudySessionTask("Simulacro corto", 15, "QUIZ", "Haz 15 alternativas sin feedback inmediato y revisa sólo los errores al final.", "Todos los módulos prioritarios"),
                StudySessionTask("Dos esqueletos de desarrollo", 14, "DEVELOPMENT", "Para dos preguntas: tesis + conceptos + mecanismo + caso + conclusión. No redactes ensayos completos.", focus),
                StudySessionTask("Cierre oral", 6, "ORAL", "Explica 3 distinciones críticas: Pielke, tipos de uso de evidencia y ciencia/política no lineal.", "Distinciones de alto rendimiento")
            ),
            "Objetivo: llegar a la prueba con estructuras recuperables, no con más material recién leído."
        )
    }

    fun daysUntilExam(exam: LocalDate = LocalDate.of(2026, 9, 30)): Long =
        ChronoUnit.DAYS.between(LocalDate.now(), exam)
}

object DevelopmentAnalyzer {
    fun analyze(answer: String, example: DevelopmentExample): StructuralAnalysis {
        val raw = answer.trim()
        val normalized = normalize(raw)
        val words = raw.split(Regex("\\s+")).filter { it.isNotBlank() }
        val wordCount = words.size

        val thesisTerms = listOf("sostengo", "argumento", "planteo", "puede entenderse", "la tesis", "centralmente", "en este sentido", "la respuesta")
        val mechanismTerms = listOf("porque", "mediante", "a traves", "permite", "genera", "explica", "facilita", "obstaculiza", "conecta", "opera", "mecanismo")
        val comparisonTerms = listOf("mientras", "a diferencia", "en contraste", "por su parte", "sin embargo", "en cambio", "comparado")
        val conclusionTerms = listOf("en suma", "por tanto", "en conclusion", "en sintesis", "por consiguiente", "asi,", "de este modo")

        val detectedConcepts = example.concepts.filter { concept -> conceptTokens(concept).any { normalized.contains(it) } }
        val knownCases = listOf("Ley de Suelos", "Humedales Urbanos", "Regulación térmica", "Neuroderechos")
        val detectedCases = knownCases.filter { case -> caseTokens(case).any { normalized.contains(it) } }
        val expectedCaseDetected = example.cases.any { expected -> caseTokens(expected).any { normalized.contains(it) } }

        val firstPart = normalize(words.take((words.size * .30).toInt().coerceAtLeast(1)).joinToString(" "))
        val lastPart = normalize(words.drop((words.size * .70).toInt()).joinToString(" "))
        val thesis = wordCount >= 45 && (thesisTerms.any { firstPart.contains(normalize(it)) } || firstPart.contains("debe") || firstPart.contains("no puede"))
        val concept = detectedConcepts.isNotEmpty()
        val mechanism = mechanismTerms.any { normalized.contains(normalize(it)) }
        val case = expectedCaseDetected || detectedCases.isNotEmpty()
        val integration = comparisonTerms.any { normalized.contains(normalize(it)) } || detectedConcepts.size >= 2
        val conclusion = wordCount >= 80 && (conclusionTerms.any { lastPart.contains(normalize(it)) } || lastPart.contains("esto muestra") || lastPart.contains("esto permite"))

        val checks = listOf(
            StructuralCheck("Tesis explícita", thesis, if (thesis) "Se detecta una toma de posición en el tramo inicial." else "No se detecta una tesis suficientemente visible al inicio.", "Abre con una afirmación que responda directamente la pregunta y anticipe tu criterio."),
            StructuralCheck("Conceptos del curso", concept, if (concept) "Detectados: ${detectedConcepts.joinToString(" · ")}." else "No se detectan con claridad los conceptos esperados.", "Nombra y define al menos uno de los conceptos centrales antes de aplicarlo."),
            StructuralCheck("Mecanismo explicativo", mechanism, if (mechanism) "Hay conectores causales o lenguaje de mecanismo." else "Predomina la descripción; falta explicar cómo o por qué ocurre la conexión.", "Usa una frase causal: X influye en Y mediante Z."),
            StructuralCheck("Caso de estudio", case, if (case) "Casos detectados: ${detectedCases.joinToString(" · ").ifBlank { "un caso esperado" }}." else "No se reconoce una aplicación empírica clara.", "Introduce un episodio concreto del caso y explica qué demuestra."),
            StructuralCheck("Integración/comparación", integration, if (integration) "Se detecta contraste o uso de más de un concepto." else "La respuesta parece apoyarse en un único movimiento conceptual.", "Integra un segundo marco sólo si agrega poder explicativo o permite contrastar."),
            StructuralCheck("Cierre", conclusion, if (conclusion) "El tramo final contiene una síntesis o retorno al argumento." else "No se detecta un cierre claramente orientado a responder la pregunta.", "Cierra retomando la tesis y explicando qué muestra el caso respecto del problema."),
        )
        val score = (checks.count { it.detected } * 100 / checks.size)
        return StructuralAnalysis(checks, score, detectedConcepts, detectedCases, wordCount)
    }

    private fun normalize(text: String): String = Normalizer.normalize(text.lowercase(), Normalizer.Form.NFD)
        .replace(Regex("\\p{Mn}+"), "")
        .replace(Regex("[^a-z0-9\\s]+"), " ")
        .replace(Regex("\\s+"), " ")
        .trim()

    private fun conceptTokens(concept: String): List<String> {
        val n = normalize(concept)
        val aliases = mutableListOf(n)
        when {
            n.contains("honest broker") -> aliases += listOf("honest broker", "corredor honesto", "alternativas")
            n.contains("science arbiter") -> aliases += listOf("science arbiter", "arbitro cientifico")
            n.contains("issue advocate") -> aliases += listOf("issue advocate", "advocacy", "defensor")
            n.contains("knowledge brokerage") -> aliases += listOf("knowledge brokerage", "brokerage", "intermediacion")
            n.contains("policy cycle") -> aliases += listOf("policy cycle", "ciclo de politica", "ciclo de politicas")
            n.contains("public scholarship") -> aliases += listOf("public scholarship", "academico publico", "vocacion publica")
            n.contains("uso simbolico") -> aliases += listOf("simbolico", "tactico", "persuasivo")
            n.contains("uso conceptual") -> aliases += listOf("conceptual", "iluminador", "enlightenment")
            n.contains("uso instrumental") -> aliases += listOf("instrumental", "uso directo")
        }
        return aliases.distinct().filter { it.length >= 4 }
    }

    private fun caseTokens(caseName: String): List<String> {
        val n = normalize(caseName)
        return when {
            n.contains("suelo") -> listOf("ley de suelos", "ley de suelo", "suelo", "antilen")
            n.contains("humedal") -> listOf("humedales", "humedal", "carolina rojas", "de urresti")
            n.contains("termica") -> listOf("regulacion termica", "termica", "waldo bustamante", "vivienda")
            n.contains("neuro") -> listOf("neuroderechos", "neuroderecho", "yuste", "girardi", "morningside")
            else -> listOf(n)
        }
    }
}
