package cl.uc.sus3021study.data

import cl.uc.sus3021study.model.*

object DeepStudyRepository {

    val readings = listOf(
        ReadingSheet(
            id = 1,
            moduleId = 1,
            title = "Sistema Vincula: Needfinding",
            author = "Garretón, Mollenhauer, Riveros, Balbontín & Bianchi (2020)",
            source = "Diseño de Sistema Vincula, etapa 1: Needfinding. Material del curso SUS3021, especialmente mapas de actores/3C y matrices lógicas de oferta y demanda.",
            centralQuestion = "¿Qué fricciones concretas impiden que la oferta de conocimiento académico y la demanda parlamentaria se encuentren de manera útil y sostenida?",
            thesis = "Antes de diseñar una plataforma o mecanismo de intercambio hay que comprender la experiencia de ambos lados. El diagnóstico muestra que la brecha no es sólo informacional: incluye falta de contactos, desconocimiento mutuo de procesos, incentivos débiles, tiempos incompatibles, formatos poco utilizables y percepción de impacto limitado.",
            argumentMap = listOf(
                "El proceso parte con needfinding y diseño de servicios: descubrir y definir el problema antes de diseñar la solución.",
                "El ecosistema contiene múltiples actores, pero el diseño focaliza especialmente académicos como oferta y asesores parlamentarios/técnicos como demanda.",
                "Desde la oferta aparecen, entre otros, falta de contactos, desconocimiento del proceso de políticas/legislativo, pocos incentivos académicos y dificultades materiales para participar.",
                "Desde la demanda aparecen problemas simétricos: redes de expertos limitadas, poco tiempo para buscar y evaluar conocimiento, dificultad para traducir requerimientos y frustración ante la disponibilidad o comprensión del rol académico.",
                "La matriz lógica transforma problemas y efectos en requerimientos de diseño: intermediación, contacto directo y bidireccional, coordinación, confianza, guías, alertas y formatos apropiados.",
                "La propuesta conceptual de Vincula surge de co-creación con usuarios; no de asumir desde la academia qué necesita el Congreso."
            ),
            keyConcepts = listOf("Needfinding", "Oferta/demanda de conocimiento", "Mapa de actores", "Mapa 3C", "Matriz lógica de diseño", "Intermediación", "Bidireccionalidad"),
            tensions = listOf(
                "Evidencia científica versus componente político de la decisión: el diagnóstico habla de leyes informadas por evidencia, no determinadas únicamente por ella.",
                "Participación pública versus incentivos académicos: invertir tiempo en el Congreso puede no ser reconocido por los sistemas de evaluación universitaria.",
                "Rapidez legislativa versus tiempos académicos: solicitudes de asesoría pueden requerir respuestas en pocos días.",
                "Formalización versus relaciones personales: los contactos informales ayudan, pero pueden producir redes cerradas, poca diversidad y pérdida de trazabilidad."
            ),
            caseConnections = listOf("Ley de Suelos: necesidad de redes, coordinación y brokers.", "Humedales Urbanos: aprendizaje de una académica al ingresar al proceso legislativo.", "Ouimet: varias barreras/facilitadores del uso de evidencia reaparecen empíricamente en legislaturas."),
            examPrompts = listOf(
                "Explique por qué Vincula no trata la brecha ciencia–Congreso como un simple problema de divulgación.",
                "Compare un problema de la oferta con uno de la demanda y proponga el requerimiento de intermediación correspondiente.",
                "¿Por qué el needfinding es conceptualmente consistente con un enfoque de redes de knowledge brokerage?"
            ),
            mustRemember = "La idea-fuerza: diagnosticar la interfaz desde ambos usuarios antes de diseñar la solución. La brecha es relacional, institucional y temporal, no sólo comunicacional."
        ),
        ReadingSheet(
            id = 2,
            moduleId = 1,
            title = "Knowledge Brokerage for Sustainable Development",
            author = "Martinuzzi & Sedlacko (capítulo final, 2016/2017)",
            source = "Capítulo final del libro Knowledge Brokerage for Sustainable Development. Material mínimo de SUS3021.",
            centralQuestion = "¿Cómo comprender y organizar la intermediación entre ciencia y política cuando ambas operan con racionalidades, instituciones e intereses distintos?",
            thesis = "Los autores descartan una visión puramente lineal de transferencia y distinguen tres conceptualizaciones —simplificada, sistémica y de redes—. Su propuesta empírica se inclina por el enfoque de redes y muestra que el brokerage adopta distintos 'juegos' con beneficios, supuestos y riesgos propios.",
            argumentMap = listOf(
                "Enfoque simplificado: información científica correcta, accesible, relevante y oportuna debería traducirse en decisiones distintas. La metáfora es lanzar paquetes de conocimiento por encima de un muro.",
                "Enfoque de sistemas: ciencia y política son sistemas con códigos distintos; verdad en ciencia, poder y legitimidad en política. Esto explica límites estructurales de traducción.",
                "Enfoque de redes: la conectividad aumenta mediante interacción prolongada, confianza, aprendizaje mutuo, intermediarios, boundary actors y organizaciones de frontera.",
                "Juego preguntas–respuestas: conecta necesidades y respuestas, pero supone que decisores pueden formular preguntas y científicos entregar respuestas claras sin deformar el problema.",
                "Juego de agenda: ciencia y política co-definen agendas; aumenta relevancia y aceptación, pero abre un problema de legitimidad y de eventual delegación de responsabilidad política a expertos.",
                "Juego de formación de comunidad: prioriza aprendizaje, práctica compartida y confianza, aunque puede subestimar contradicciones reales entre ciencia y política.",
                "Juego de reframing: hace explícitos paradigmas y supuestos normativos para permitir marcos alternativos; requiere facilitación y tiempo."
            ),
            keyConcepts = listOf("Modelo lineal", "Teoría de sistemas", "Enfoque de redes", "Boundary work", "Broker", "Co-creación", "Q&A game", "Agenda-setting game", "Community formation", "Re-framing"),
            tensions = listOf(
                "Simplificar para ser útil versus reducir complejidad hasta violar estándares científicos.",
                "Incidencia experta versus legitimidad democrática de quien fija la agenda.",
                "Construir comunidad versus borrar conflictos reales de intereses y racionalidades.",
                "Conectividad relacional versus necesidad de mantener diferencias institucionales entre ciencia y política."
            ),
            caseConnections = listOf("Suelos: co-creación, agenda y comunidad de práctica.", "Regulación térmica: red sostenida entre academia, Estado e industria.", "Neuroderechos: reframing de nuevas capacidades tecnológicas como problema de derechos."),
            examPrompts = listOf(
                "Compare las tres conceptualizaciones de knowledge brokerage.",
                "Aplique dos 'juegos' de brokerage a la Ley de Suelos.",
                "¿Por qué una estrategia de policy briefs puede ser necesaria pero insuficiente según los autores?"
            ),
            mustRemember = "La idea-fuerza: brokerage no es mover información de A a B; es construir conectividad y trabajar sobre fronteras, preguntas, agendas, comunidades y marcos."
        ),
        ReadingSheet(
            id = 3,
            moduleId = 2,
            title = "Four idealized roles of science in policy and politics",
            author = "Roger A. Pielke Jr. (2007)",
            source = "The Honest Broker, cap. 1, pp. 1–7 según el programa SUS3021.",
            centralQuestion = "¿Qué opciones tiene un experto cuando decide cómo relacionarse con un proceso de decisión política?",
            thesis = "Los cuatro roles son tipos ideales que se distinguen principalmente por la relación del experto con la decisión y con el abanico de alternativas: producir información, responder preguntas factuales, reducir opciones mediante advocacy o expandir/clarificar alternativas.",
            argumentMap = listOf(
                "Pure Scientist: produce conocimiento sin involucrarse directamente con la decisión; deja el uso a otros.",
                "Science Arbiter: interactúa con decisores para responder preguntas positivas o factuales delimitadas, sin decir qué deberían preferir.",
                "Issue Advocate: usa expertise para defender una alternativa y reducir el alcance de opciones consideradas.",
                "Honest Broker of Policy Alternatives: expande o clarifica opciones y consecuencias para que el decisor reduzca el rango conforme a sus propios valores.",
                "Pure Scientist y Science Arbiter operan como recursos de información; Issue Advocate y Honest Broker se involucran explícitamente con alternativas de decisión.",
                "Pielke advierte sobre la 'stealth issue advocacy': una aparente neutralidad factual puede esconder la selección implícita de una opción.",
                "Son tipos ideales y forman un continuo; una persona puede aproximarse a roles diferentes en momentos distintos."
            ),
            keyConcepts = listOf("Pure Scientist", "Science Arbiter", "Issue Advocate", "Honest Broker", "Alternativas de decisión", "Stealth issue advocacy"),
            tensions = listOf(
                "Neutralidad declarada versus efectos políticos de seleccionar ciertas preguntas, datos o marcos.",
                "Expertise empírica versus autoridad para elegir entre valores.",
                "Reducir opciones para persuadir versus ampliarlas para preservar la elección del decisor."
            ),
            caseConnections = listOf("Neuroderechos: excelente caso para distinguir preguntas científicas de elecciones normativas.", "Regulación térmica: distintos momentos pueden exigir arbitraje técnico, negociación y presentación de alternativas.", "Don't Look Up: permite detectar desplazamientos de rol y problemas de comunicación/advocacy."),
            examPrompts = listOf(
                "Clasifique tres intervenciones hipotéticas en los roles de Pielke y justifique.",
                "¿Por qué Honest Broker e Issue Advocate no pueden realizar exactamente la misma función al mismo tiempo?",
                "Explique el riesgo de stealth issue advocacy."
            ),
            mustRemember = "No memorices sólo definiciones: pregunta siempre qué hace el experto con el rango de opciones del decisor."
        ),
        ReadingSheet(
            id = 4,
            moduleId = 3,
            title = "The Policy Process Model",
            author = "Michael E. Kraft & Scott R. Furlong (2018)",
            source = "Public Policy: Politics, Analysis, and Alternatives, pp. 154–177 del material del curso.",
            centralQuestion = "¿Cómo descomponer analíticamente un proceso de política pública y ubicar en él la producción y uso de conocimiento?",
            thesis = "El modelo distingue seis etapas —agenda, formulación, legitimación, implementación, evaluación y cambio—, pero funciona como mapa analítico, no como secuencia rígida. Las etapas se superponen, retroalimentan y a veces se omiten.",
            argumentMap = listOf(
                "Agenda setting: cómo problemas son percibidos, definidos, adquieren atención y entran a la agenda política.",
                "Policy formulation: diseño y redacción de objetivos, instrumentos y estrategias; incluye análisis de alternativas.",
                "Policy legitimation: movilización de apoyo, justificación y autorización/formalización de la política.",
                "Policy implementation: provisión de recursos y acción institucional para poner la política en práctica.",
                "Policy/program evaluation: medición y valoración de efectos, éxito o fracaso.",
                "Policy change: modificación de objetivos o medios a la luz de información nueva o cambios políticos.",
                "El ciclo es continuo: ninguna decisión es final; condiciones, evaluación, información y opinión pueden reabrir políticas.",
                "La definición de problemas no es neutral: perspectivas, valores, símbolos y framing condicionan qué soluciones parecen razonables."
            ),
            keyConcepts = listOf("Policy cycle", "Agenda setting", "Problem definition", "Framing", "Formulación", "Legitimación", "Implementación", "Evaluación", "Policy change"),
            tensions = listOf(
                "Claridad del modelo versus complejidad real: utilidad analítica no equivale a secuencia causal universal.",
                "Información objetiva versus definición política del problema.",
                "Aprobación formal versus legitimidad social y política más amplia."
            ),
            caseConnections = listOf("Suelos: agenda, formulación y legitimación se solapan durante años.", "Humedales: evidencia entra en agenda/formulación y acompaña negociación legislativa.", "Regulación térmica: permite seguir hasta implementación y cambio regulatorio."),
            examPrompts = listOf(
                "Reconstruya un caso del curso utilizando las seis etapas sin tratarlo como secuencia mecánica.",
                "Explique por qué problem definition puede ser políticamente decisiva.",
                "¿En qué etapas puede influir el análisis de políticas?"
            ),
            mustRemember = "Seis etapas, sí; linealidad, no. El examen probablemente premie que uses el ciclo como mapa y explicites solapamientos."
        ),
        ReadingSheet(
            id = 5,
            moduleId = 3,
            title = "Trust in Science Is Not the Problem",
            author = "Alan I. Leshner (2021)",
            source = "Issues in Science and Technology, Spring 2021. Lectura mínima de SUS3021.",
            centralQuestion = "¿Por qué personas que confían en la ciencia pueden igualmente rechazar recomendaciones científicas específicas?",
            thesis = "La evidencia disponible no sustenta una caída general de la confianza en ciencia; el problema es que confianza no equivale a obediencia. Las decisiones combinan hechos con valores, intereses, experiencia e identidad, por lo que el modelo de déficit es insuficiente y debe reemplazarse por engagement genuino.",
            argumentMap = listOf(
                "Distingue confianza/confidence en científicos de seguimiento de recomendaciones concretas.",
                "Las decisiones de política rara vez descansan sólo en ciencia: hechos conviven con valores, intereses y experiencia personal.",
                "La incertidumbre y revisión de teorías son normales en ciencia, pero pueden ser interpretadas por no especialistas como falta de autoridad.",
                "Disonancia cognitiva, sesgo de confirmación, sesgo de grupo y sesgo de statu quo ayudan a explicar por qué evidencia y conducta pueden divergir.",
                "Modelo de déficit: asumir que el desacuerdo es ignorancia y que más educación resolverá el problema. Leshner lo considera insuficiente.",
                "Engagement: diálogo genuino, escucha, disposición a trabajar colectivamente, adaptación a audiencia, honestidad sobre incertidumbre y credibilidad.",
                "La ciencia debe hacerse personalmente/localmente significativa sin exagerar resultados."
            ),
            keyConcepts = listOf("Trust vs compliance", "Facts + values", "Uncertainty", "Cognitive dissonance", "Confirmation bias", "In-group bias", "Status quo bias", "Deficit model", "Public engagement"),
            tensions = listOf(
                "Simplificar versus exagerar certeza.",
                "Autoridad científica versus pluralidad de valores legítimos.",
                "Comunicación unidireccional versus diálogo real, que exige escuchar y eventualmente comprometerse."
            ),
            caseConnections = listOf("Audiencias parlamentarias: no asumir que discrepancia es ignorancia.", "Neuroderechos: alta incertidumbre y valores en conflicto.", "Karp: ambos rechazan un público pasivo y deficitario."),
            examPrompts = listOf(
                "Explique la frase 'trust in science is not the problem'.",
                "Diferencie modelo de déficit y public engagement.",
                "Diseñe una intervención ante una comisión parlamentaria coherente con Leshner."
            ),
            mustRemember = "Confianza general en ciencia ≠ aceptación automática de una recomendación. Más información puede ser necesaria, pero no sustituye diálogo sobre valores, intereses e incertidumbre."
        ),
        ReadingSheet(
            id = 6,
            moduleId = 4,
            title = "Use of research evidence in legislatures: a systematic review",
            author = "Ouimet et al. (2023)",
            source = "Evidence & Policy. Revisión sistemática incluida como lectura mínima de SUS3021.",
            centralQuestion = "¿Para qué usan realmente investigación las legislaturas y qué factores facilitan o dificultan ese uso?",
            thesis = "El uso legislativo de investigación es plural y no se agota en la adopción instrumental. La revisión de 21 estudios encuentra con frecuencia uso simbólico/táctico y también funciones específicas del trabajo legislativo; además organiza barreras/facilitadores en cuatro familias.",
            argumentMap = listOf(
                "Revisión sistemática de estudios empíricos sobre legislaturas, enfocada en tipos de uso y factores que facilitan/obstaculizan el uso de investigación.",
                "Uso instrumental: evidencia aplicada de forma relativamente directa a una tarea, decisión, enmienda, pregunta o escrutinio.",
                "Uso conceptual/enlightenment: cambia marcos, comprensión o lenguaje de manera más gradual.",
                "Uso simbólico/táctico/persuasivo: investigación usada para justificar, persuadir o apoyar posiciones; es el tipo observado con mayor frecuencia en los estudios revisados.",
                "Funciones legislativas adicionales incluyen preparar preguntas/debates, verificar información, evaluar factibilidad, explicar votos, impulsar trabajo de comisiones y facilitar consenso.",
                "Cuatro categorías de factores: institución y organización; características de la investigación; contexto de política y política partidaria; características individuales.",
                "La evidencia es contextual: un mismo factor puede operar como barrera o facilitador según el entorno."
            ),
            keyConcepts = listOf("Uso instrumental", "Uso conceptual", "Uso simbólico/táctico", "Consenso", "Fact-checking", "Barreras/facilitadores", "Trust/social relations"),
            tensions = listOf(
                "Impacto directo versus influencia difusa o acumulativa.",
                "Uso persuasivo de evidencia versus ideal de neutralidad científica.",
                "Hallazgos comparables versus fuerte dependencia del contexto legislativo; la propia revisión advierte límites de la evidencia disponible."
            ),
            caseConnections = listOf("Humedales: evidencia utilizada para definir, argumentar y apoyar trabajo legislativo.", "Suelos: construcción de consenso y factibilidad.", "Vincula: las barreras observadas en Chile se pueden ordenar con la tipología de cuatro familias."),
            examPrompts = listOf(
                "Explique por qué 'uso de evidencia' no significa únicamente que un estudio cause una ley.",
                "Aplique las cuatro familias de barreras/facilitadores a un caso chileno.",
                "Distinga uso conceptual y simbólico/táctico con ejemplos."
            ),
            mustRemember = "Si una pregunta habla de 'uso', no respondas sólo impacto instrumental. La revisión amplía el concepto y muestra que en legislaturas la evidencia cumple funciones políticas y deliberativas diversas."
        ),
        ReadingSheet(
            id = 7,
            moduleId = 5,
            title = "Public scholarship as a vocation",
            author = "Ivan Karp (2012)",
            source = "Arts & Humanities in Higher Education 11(3), 285–299. Lectura mínima de SUS3021.",
            centralQuestion = "¿Qué significa producir conocimiento públicamente sin reducir al público a una audiencia ignorante ni abandonar estándares académicos?",
            thesis = "La public scholarship exige trabajar a través de fronteras culturales e institucionales, reconocer una sociedad plural y tratar a los públicos como agentes conocedores. Es una práctica de juicio, mediación y compromiso, no mera simplificación de contenido académico.",
            argumentMap = listOf(
                "Karp parte de la tensión weberiana entre vocación científica —orientada a la verdad— y acción política —marcada por compromiso, juicio y consecuencias trágicas.",
                "El académico que trabaja públicamente entra en un espacio donde no controla objetivos ni puede guiarse sólo por agendas intelectuales.",
                "Critica la idea de que public scholarship sea simplemente contar una historia 'más simple' a una audiencia menos sofisticada.",
                "Los públicos poseen opiniones, conocimientos y criterios de juicio; son agentes activos, no receptores pasivos.",
                "Una concepción pluralista reconoce culturas y estándares incompatibles o inconmensurables y exige situarse simultáneamente dentro y fuera de comunidades.",
                "El conocimiento académico es un punto de partida, no el único conocimiento legítimo; la práctica pública debe conectar expertise producida en contextos diversos.",
                "Cruzar fronteras implica mediación y representación, y requiere juicio y finesse además de dominio disciplinario."
            ),
            keyConcepts = listOf("Public scholarship", "Vocation", "Pluralism", "Knowledgeable agents", "Boundary crossing", "Mediation", "Compromise", "Judgment"),
            tensions = listOf(
                "Fidelidad disciplinaria versus compromiso necesario para actuar públicamente.",
                "Expertise académica versus conocimientos producidos fuera de la academia.",
                "Hablar al público versus trabajar con públicos.",
                "Relevancia pública versus instituciones académicas que pueden premiar poco este trabajo."
            ),
            caseConnections = listOf("Humedales: Carolina Rojas sale de su 'hábitat natural' académico y aprende lógicas legislativas.", "Regulación térmica: Waldo Bustamante articula ingeniería con una vocación explícitamente social.", "Neuroderechos: pluralidad de neurociencia, derecho, bioética y política."),
            examPrompts = listOf(
                "Explique por qué public scholarship no es equivalente a divulgación.",
                "Compare Karp con Leshner respecto de la concepción del público.",
                "Aplique la tensión entre fidelidad disciplinaria y compromiso a Humedales Urbanos."
            ),
            mustRemember = "Karp: trabajar con públicos, no simplemente hablarles. Pluralismo, públicos activos y juicio práctico son el centro."
        ),
        ReadingSheet(
            id = 8,
            moduleId = 3,
            title = "How science and cooperation closed the ozone hole",
            author = "Nature Editorial (2025)",
            source = "Editorial de Nature, 15 mayo 2025. Material complementario disponible en el proyecto.",
            centralQuestion = "¿Qué condiciones hicieron posible una cooperación internacional eficaz frente al agotamiento de la capa de ozono y qué puede aprender la interfaz ciencia–política?",
            thesis = "El Protocolo de Montreal muestra una combinación de evidencia científica, diseño incremental, evaluaciones periódicas, incorporación de industria, financiamiento a países de menores ingresos, monitoreo de cumplimiento y confianza mutua. El editorial advierte que trasladar el modelo a clima es difícil por diferencias estructurales de escala e intereses.",
            argumentMap = listOf(
                "La evidencia del agujero de ozono aceleró una respuesta internacional que ya venía gestándose con la Convención de Viena y estudios previos sobre CFC.",
                "El protocolo siguió una estrategia de empezar gradualmente, aprender haciendo, construir confianza y escalar ambición.",
                "Evaluaciones regulares de ciencia y tecnología mantuvieron la política conectada con conocimiento actualizado.",
                "Países de altos ingresos lideraron y financiaron parte de la transición de países de ingresos bajos y medios.",
                "El sistema de cumplimiento permitió monitoreo recíproco.",
                "El editorial contrasta ozono con cambio climático: combustibles fósiles son más centrales y económicamente masivos que los ODS/CFC, con conflictos distributivos mayores."
            ),
            keyConcepts = listOf("Science diplomacy", "Adaptive governance", "Trust", "Compliance", "Learning by doing", "International cooperation"),
            tensions = listOf("Éxito de un caso no implica transferibilidad mecánica a problemas con estructuras económicas diferentes.", "Consenso científico necesita instituciones, incentivos y recursos para volverse cooperación efectiva."),
            caseConnections = listOf("Martinuzzi: redes, confianza y aprendizaje.", "Kraft: evaluación y policy change como proceso continuo.", "Leshner: credibilidad y confianza no sustituyen instituciones, pero son recursos fundamentales."),
            examPrompts = listOf("Use el caso del ozono para ilustrar por qué evidencia + instituciones + cooperación importan conjuntamente."),
            mustRemember = "Úsalo como ejemplo complementario, no como sustituto de los casos chilenos asignados en el programa.",
            priority = "Complementaria"
        )
    )

    val cases = listOf(
        CaseDossier(
            id = 1,
            name = "Anteproyecto / Ley de Suelos",
            source = "Caso de estudio Nº2, Tres mujeres, un destino: La creación del Anteproyecto de la Ley de Suelo.",
            coreProblem = "Chile carecía de una regulación integral capaz de proteger el suelo frente a degradación, erosión, desertificación, contaminación y conflictos de uso. El conocimiento científico existía desde hacía años, pero convertirlo en una propuesta políticamente procesable tomó una trayectoria prolongada.",
            actors = listOf(
                ActorRole("Mónica Antilén y Sociedad Chilena de la Ciencia del Suelo", "Articulan comunidad científica y dan continuidad institucional a una agenda histórica."),
                ActorRole("Miriam Llona / ONG Suelo Sustentable", "Conecta conocimiento técnico, sociedad civil y acceso al Senado; usa mecanismos institucionales como Ley de Lobby."),
                ActorRole("Sen. Antonio Horvath", "Puente político temprano y emprendedor ambiental para las primeras conversaciones legislativas."),
                ActorRole("Sen. Carmen Gloria Aravena", "Actor político decisivo para reactivar/encauzar la oportunidad legislativa y ampliar apoyos."),
                ActorRole("María Emilia Undurraga / MINAGRI", "Conexión con Ejecutivo y dimensión gubernamental de la propuesta."),
                ActorRole("Rodrigo Herrera y abogados", "Coordinación del proceso y funciones de brokerage/traducción para convertir consensos técnico-científicos en texto jurídico.")
            ),
            knowledgeBase = listOf("Décadas de investigación sobre calidad, funciones, degradación y uso sustentable de suelos.", "Experiencia acumulada de sociedades científicas, universidades y sociedad civil.", "Mesas y comités que permiten sistematizar aportes heterogéneos en un lenguaje regulatorio."),
            mechanisms = listOf("Construcción de redes de largo plazo.", "Ley de Lobby y reuniones parlamentarias.", "Ventana de oportunidad política.", "Metodología de consensos, mesas de trabajo y comité editor.", "Brokers jurídicos y coordinación para traducir evidencia a articulado."),
            barriers = listOf("Más de veinte años de avances y retrocesos.", "Lógicas y tiempos diferentes entre academia y política.", "Necesidad de resolver disensos científicos, sectoriales y jurídicos.", "Riesgo de frustración cuando evidencia no determina la decisión."),
            facilitators = listOf("Comunidad científica organizada.", "Actores políticos con disposición a patrocinar/impulsar el tema.", "Sociedad civil con capacidad de articulación.", "Proceso deliberativo estructurado para producir un texto compartido."),
            outcome = "El caso alcanza la construcción de un proyecto y la aprobación de la idea de legislar en el Senado el 12 de enero de 2022; el propio relato subraya que la tramitación y negociación continúan más allá de ese hito.",
            concepts = listOf("Knowledge brokerage", "Enfoque de redes", "Agenda setting", "Formulación", "Legitimación", "Ventana de oportunidad", "Co-creación"),
            examAngles = listOf("Caso paradigmático para refutar el modelo lineal.", "Excelente para explicar agenda de larga duración + ventana política.", "Permite identificar brokers, redes y producción de consenso.", "Útil para mostrar solapamiento entre agenda, formulación y legitimación."),
            caution = "No lo narres como una cadena causal simple 'ciencia → ley'. El valor del caso está en las redes, disensos, traducción y temporalidad larga."
        ),
        CaseDossier(
            id = 2,
            name = "Ley de Humedales Urbanos",
            source = "Caso de estudio Nº3, Dos corazones unidos por un sueño: La historia de la Ley de Humedales Urbanos.",
            coreProblem = "La expansión urbana amenazaba humedales relevantes para biodiversidad, manejo de riesgos y calidad urbana. El desafío fue convertir conocimiento científico y experiencia territorial en una categoría jurídicamente protegible y políticamente viable.",
            actors = listOf(
                ActorRole("Carolina Rojas", "Geógrafa e investigadora que produce evidencia, la comunica públicamente y aprende a operar en la interfaz legislativa."),
                ActorRole("Sen. Alfonso de Urresti", "Emprendedor político que convierte la preocupación ambiental en iniciativa y estrategia legislativa."),
                ActorRole("Melissa Mallega y asesores parlamentarios", "Traducción legislativa, seguimiento, coordinación y manejo de tiempos/indicaciones."),
                ActorRole("Otros parlamentarios, Ejecutivo y actores ambientales", "Participan en apoyos, indicaciones, negociación y legitimación del proyecto.")
            ),
            knowledgeBase = listOf("Investigación sobre urbanización, riesgo y humedales, incluida la trayectoria de Carolina Rojas en Concepción.", "Experiencias comparadas de planificación y conservación urbana.", "Conocimiento experto presentado en seminarios, medios y comisiones."),
            mechanisms = listOf("Difusión pública que vuelve visible el problema.", "Relación sostenida entre académica y actores legislativos.", "Presentación ante comisión y traducción de conocimiento a preguntas legislativas.", "Negociación política, indicaciones y adaptación estratégica del proyecto."),
            barriers = listOf("Desconocimiento inicial de códigos y tiempos políticos por parte de la academia.", "Resistencias e intereses contrapuestos durante la tramitación.", "Costos personales y profesionales de salir de la academia.", "La evidencia no controla el resultado final ni evita cambios al proyecto."),
            facilitators = listOf("Vínculo personal y profesional entre conocimiento experto y emprendimiento político.", "Persistencia y capacidad de aprendizaje de los actores.", "Problema territorial con alta relevancia pública.", "Asesoría legislativa capaz de convertir evidencia en insumos utilizables."),
            outcome = "La trayectoria culmina en la Ley 21.202 sobre Humedales Urbanos, después de una tramitación en que el conocimiento científico se combina con negociación, coaliciones y decisiones políticas.",
            concepts = listOf("Public scholarship", "Enfoque de redes", "Uso conceptual/instrumental", "Legitimación", "Brokerage", "Público activo"),
            examAngles = listOf("Caso principal para Karp y el costo de la vocación pública.", "Permite aplicar Ouimet sin reducir uso de evidencia a causalidad directa.", "Muestra el encuentro de 'ciencia de lo probable' con 'arte de lo posible'.", "Útil para distinguir expertise científica y estrategia legislativa."),
            caution = "No atribuyas la ley a una sola persona ni a un único paper: el propio caso reconstruye una coalición y una trayectoria política."
        ),
        CaseDossier(
            id = 3,
            name = "Regulación térmica de viviendas",
            source = "Caso de estudio Nº4, Del cielo al suelo construyendo una misión: Cuando dos caminos se cruzan para abrigar a Chile.",
            coreProblem = "La política habitacional priorizaba cantidad y cobertura, mientras muchas viviendas presentaban bajo desempeño térmico con efectos de confort, salud y gasto energético. El desafío fue transformar evidencia de ingeniería y bienestar en estándares regulatorios progresivos.",
            actors = listOf(
                ActorRole("Waldo Bustamante", "Académico con vocación pública; produce conocimiento, participa en normas y actúa persistentemente en la interfaz ciencia–política."),
                ActorRole("José Pedro Campos", "Emprendedor público y puente temprano entre experimentación local, estándares y aparato estatal."),
                ActorRole("MINVU / DITEC", "Autoridad y burocracia técnica que formula, negocia e implementa regulación."),
                ActorRole("Industria de la construcción", "Actor cuya factibilidad tecnológica/económica condiciona ritmos y contenidos regulatorios."),
                ActorRole("Equipos académicos y técnicos", "Generan estudios, zonificación térmica, mediciones y propuestas de actualización.")
            ),
            knowledgeBase = listOf("Termodinámica y desempeño de envolventes de vivienda.", "Estudios aplicados, zonificación y mediciones de condiciones térmicas.", "Experiencia de vivienda social y efectos de frío, humedad y baja eficiencia sobre bienestar."),
            mechanisms = listOf("Conocimiento con propósito explícitamente orientado a política pública.", "Estrategia gradual: comenzar por techos antes de ampliar a muros, ventanas y pisos.", "Negociación con Estado e industria para construir factibilidad.", "Persistencia de décadas, repetidos estudios y actualización de estándares."),
            barriers = listOf("Urgencia histórica por construir volumen de viviendas por sobre calidad térmica.", "Costos y resistencia frente a estándares más exigentes.", "Distancia entre investigación, promulgación e implementación.", "Desgaste/aislamiento asociado a sostener posiciones técnicas incómodas."),
            facilitators = listOf("Académico capaz de moverse entre investigación y discusión regulatoria.", "Puentes institucionales en MINVU y organismos técnicos.", "Estrategia incremental que hace políticamente viable el avance.", "Acumulación de evidencia y aprendizaje regulatorio."),
            outcome = "El caso sigue varias fases regulatorias desde la incorporación de exigencias térmicas en la OGUC, su ampliación posterior y una actualización publicada en 2024 con entrada en vigencia en 2025.",
            concepts = listOf("Public scholarship", "Knowledge brokerage", "Formulación", "Implementación", "Policy change", "Factibilidad", "Temporalidad"),
            examAngles = listOf("Mejor caso para mostrar que incidencia puede tardar décadas.", "Permite vincular expertise, industria y factibilidad política.", "Excelente para policy cycle hasta implementación y cambio.", "Ejemplo de gradualismo y conocimiento con propósito."),
            caution = "No confundir éxito técnico con implementación inmediata: el caso destaca retrasos, negociación y revisiones sucesivas."
        ),
        CaseDossier(
            id = 4,
            name = "Ley de Neuroderechos",
            source = "Caso de estudio Nº5, La historia de la Ley de Neuroderechos: Cuando ciencia y política se encuentran para legislar el futuro.",
            coreProblem = "El avance de neurotecnologías abre posibilidades terapéuticas y, simultáneamente, riesgos sobre datos cerebrales, identidad, privacidad y libertad mental. La política enfrenta un problema anticipatorio: regular capacidades emergentes antes de que sus efectos estén plenamente estabilizados.",
            actors = listOf(
                ActorRole("Rafael Yuste / Morningside Group", "Origina y difunde el marco de neuroderechos desde neurociencia y ética internacional."),
                ActorRole("Sen. Guido Girardi", "Emprendedor político que conecta la propuesta científica con Congreso Futuro y la agenda legislativa chilena."),
                ActorRole("Paulina Ramos", "Bioeticista que cumple una función mediadora entre ciencia, ética y derecho en un campo controvertido."),
                ActorRole("Académicos de neurociencia, bioética y derecho", "Aportan expertise, pero también expresan desacuerdos sobre necesidad, alcance y arquitectura regulatoria."),
                ActorRole("Congreso y comisiones", "Transforman la preocupación emergente en reforma constitucional y proyecto legal con trayectorias diferentes.")
            ),
            knowledgeBase = listOf("Desarrollo de interfaces cerebro–computadora y capacidad de registrar/decodificar actividad neuronal.", "Debate ético internacional sobre identidad, agencia, privacidad mental y protección de datos neuronales.", "Argumentos jurídicos a favor y en contra de crear categorías específicas de protección."),
            mechanisms = listOf("Congreso Futuro como espacio de encuentro ciencia–política.", "Red interdisciplinaria y transnacional.", "Framing anticipatorio: convertir riesgo tecnológico emergente en cuestión de derechos.", "Traducción de debate científico/ético a reforma constitucional y proyecto legal.", "Mediación entre posiciones académicas divergentes."),
            barriers = listOf("Incertidumbre sobre capacidades futuras y ritmo tecnológico.", "Desacuerdo normativo y jurídico: protección necesaria versus posible redundancia de derechos existentes.", "Riesgo de extrapolar más allá de la evidencia disponible.", "Dos instrumentos legislativos con destinos y ritmos distintos."),
            facilitators = listOf("Alta visibilidad pública y política de la neurotecnología.", "Emprendimiento político conectado con redes científicas internacionales.", "Capacidad de anticipación y framing de derechos.", "Participación interdisciplinaria que amplía el debate."),
            outcome = "Chile aprobó la reforma constitucional asociada a la protección de la actividad cerebral/información proveniente de ella (Ley 21.383), mientras el caso enfatiza que el proyecto legal más amplio siguió una trayectoria distinta y que la academia permaneció dividida.",
            concepts = listOf("Science Arbiter", "Issue Advocate", "Honest Broker", "Public scholarship", "Pluralismo", "Re-framing", "Incertidumbre"),
            examAngles = listOf("Mejor caso para Pielke y la distinción hechos/valores.", "Permite mostrar pluralismo disciplinario en Karp.", "Excelente para discutir incertidumbre y regulación anticipatoria.", "Útil para analizar cómo una idea científica internacional se transforma en arquitectura jurídica."),
            caution = "No presentes la existencia de debate académico como defecto: es precisamente una característica analítica del caso y limita la posibilidad de una 'respuesta científica única'."
        )
    )

    val comparisonRows = listOf(
        CaseComparisonRow("Problema", "Protección integral del suelo y degradación acumulada.", "Urbanización y pérdida de humedales con efectos ecológicos y de riesgo.", "Viviendas frías/ineficientes y estándar constructivo insuficiente.", "Riesgos emergentes de neurotecnologías sobre mente, datos e identidad."),
        CaseComparisonRow("Temporalidad", "Muy larga: agenda científica por décadas antes de hitos legislativos.", "Intermedia: investigación previa + ventana legislativa y negociación de varios años.", "Muy larga e incremental: varias fases regulatorias durante décadas.", "Rápida/anticipatoria: idea global entra velozmente a agenda constitucional y legal."),
        CaseComparisonRow("Puente principal", "Sociedades científicas, ONG, senadores, coordinadores y brokers jurídicos.", "Relación entre Carolina Rojas, senador y asesores legislativos.", "Waldo Bustamante y redes técnicas entre academia, MINVU e industria.", "Yuste–Girardi + red interdisciplinaria y bioética."),
        CaseComparisonRow("Mecanismo dominante", "Consenso y co-creación de texto entre múltiples actores.", "Traducción de evidencia + emprendimiento político + negociación legislativa.", "Gradualismo regulatorio, estudios aplicados y persistencia institucional.", "Re-framing anticipatorio como derechos + traducción interdisciplinaria."),
        CaseComparisonRow("Barrera distintiva", "Disensos, larga trayectoria y lógicas políticas diferentes.", "Costos de salir de academia, resistencia y cambios durante tramitación.", "Factibilidad/costos, implementación lenta y resistencia a estándares.", "Incertidumbre tecnológica y desacuerdo jurídico/ético sobre necesidad y alcance."),
        CaseComparisonRow("Conceptos fuertes", "Brokerage · redes · ventana · agenda/formulación.", "Public scholarship · usos de evidencia · legitimación.", "Brokerage · implementación · policy change · factibilidad.", "Pielke · pluralismo · reframing · incertidumbre."),
        CaseComparisonRow("Lección común", "La evidencia necesita redes e instituciones.", "La evidencia adquiere efecto dentro de relaciones y negociación.", "La evidencia se vuelve regulación mediante persistencia, traducción y factibilidad.", "La expertise informa pero no elimina elecciones normativas."),
        CaseComparisonRow("Error de examen a evitar", "Contarlo como éxito lineal de científicos.", "Atribuir la ley a un solo actor o paper.", "Confundir norma aprobada con implementación inmediata.", "Tratar la controversia normativa como si tuviera una respuesta puramente científica.")
    )
}
