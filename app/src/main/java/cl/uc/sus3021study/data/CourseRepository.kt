package cl.uc.sus3021study.data

import cl.uc.sus3021study.model.*

object CourseRepository {

    val modules = listOf(
        StudyModule(
            id = 1,
            title = "Movilizar conocimiento",
            subtitle = "Por qué la evidencia no viaja sola desde la academia a la política",
            sessions = "Sesión 2 · 12 agosto",
            readings = listOf(
                "Garretón et al. (2020), Sistema Vincula: Needfinding",
                "Martinuzzi & Sedlacko (2016/2017), Knowledge Brokerage for Sustainable Development, capítulo final"
            ),
            keyPoints = listOf(
                "El problema ciencia–política no es sólo falta de información: intervienen tiempos, incentivos, lenguajes, intereses, legitimidad y relaciones de confianza.",
                "El modelo lineal supone que producir y comunicar evidencia correcta genera automáticamente mejores decisiones; el curso problematiza ese supuesto.",
                "Martinuzzi distingue enfoques simplificados, sistémicos y de redes para comprender la interfaz ciencia–política.",
                "El enfoque de redes enfatiza interacción sostenida, confianza, conocimiento mutuo, intermediarios y organizaciones de frontera.",
                "Vincula parte desde needfinding: antes de diseñar una solución, identifica actores, necesidades, fricciones y recorridos en el ecosistema academia–Congreso."
            ),
            concepts = listOf(
                Concept(
                    "Knowledge brokerage",
                    "Conjunto de prácticas e instituciones que facilitan el intercambio, traducción, co-creación y uso de conocimiento entre investigación y toma de decisiones.",
                    "Permite abandonar la imagen de una transferencia automática y observar las condiciones sociales e institucionales del intercambio.",
                    "Un académico que mantiene una relación estable con asesores legislativos y adapta el formato de sus resultados sin alterar su contenido actúa en una interfaz de brokerage."
                ),
                Concept(
                    "Modelo lineal",
                    "Visión según la cual la ciencia produce evidencia y la política la recibe y aplica de manera relativamente directa.",
                    "Es útil como contraste porque subestima conflictos de valores, temporalidades, poder, legitimidad y selección política de la evidencia.",
                    "Enviar un policy brief y asumir que por ser científicamente sólido modificará una votación reproduce la lógica lineal."
                ),
                Concept(
                    "Enfoque de redes",
                    "Perspectiva que entiende la conexión ciencia–política como una relación social sostenida y no como un envío puntual de información.",
                    "Hace visibles la confianza, los intermediarios, las comunidades de práctica y la co-creación.",
                    "Mesas de trabajo recurrentes entre investigadores, asesores y actores sectoriales que permiten ajustar preguntas y respuestas."
                ),
                Concept(
                    "Boundary work",
                    "Trabajo realizado en la frontera entre comunidades con reglas, lenguajes y criterios distintos, como ciencia y política.",
                    "Explica por qué se necesitan actores capaces de operar entre mundos sin borrar sus diferencias.",
                    "Un broker que ayuda a traducir una controversia científica en opciones legislativas, manteniendo explícita la incertidumbre."
                )
            ),
            cases = listOf(
                CaseStudy(
                    "Sistema Vincula",
                    "El diseño se inicia con un proceso de needfinding y mapeo de actores, focalizando la interacción entre oferta académica y demanda parlamentaria.",
                    "Sirve para mostrar que el problema debe diagnosticarse desde ambos lados de la interfaz antes de diseñar canales de intercambio."
                )
            ),
            practicalExamples = listOf(
                "Pregunta aplicada: ¿por qué un paper excelente puede tener bajo impacto legislativo? Respuesta: porque calidad científica y usabilidad política son dimensiones diferentes.",
                "Diagnóstico rápido: si el problema es falta de confianza y relaciones, mejorar sólo el formato del documento es insuficiente.",
                "Comparación: modelo lineal = transferencia; enfoque de redes = interacción y aprendizaje mutuo."
            ),
            examPriority = true
        ),
        StudyModule(
            id = 2,
            title = "Roles del científico",
            subtitle = "Pielke y las cuatro formas ideal-típicas de intervenir en política",
            sessions = "Sesión 3 · 19 agosto",
            readings = listOf(
                "Pielke Jr. (2007), The Honest Broker, cap. 1",
                "Película: Don’t Look Up (2021), usada como material de discusión"
            ),
            keyPoints = listOf(
                "Pielke no prescribe un único rol correcto: propone tipos ideales para hacer visibles decisiones y consecuencias del posicionamiento experto.",
                "Pure Scientist produce conocimiento sin involucrarse directamente en la decisión.",
                "Science Arbiter responde preguntas factuales delimitadas que los decisores formulan.",
                "Issue Advocate busca reducir el rango de opciones defendiendo una alternativa o preferencia.",
                "Honest Broker of Policy Alternatives amplía o clarifica el conjunto de opciones disponibles y sus consecuencias, dejando la elección a los decisores."
            ),
            concepts = listOf(
                Concept(
                    "Pure Scientist",
                    "Investigador centrado en producir conocimiento, manteniendo distancia respecto de su uso político inmediato.",
                    "Permite distinguir producción de evidencia de asesoría explícita.",
                    "Publicar resultados sobre riesgo ambiental sin recomendar una alternativa regulatoria concreta."
                ),
                Concept(
                    "Science Arbiter",
                    "Experto que responde preguntas empíricas específicas planteadas por quien decide.",
                    "Es apropiado cuando la controversia puede acotarse a cuestiones positivas o técnicas.",
                    "Responder cuál es la concentración observada de un contaminante o qué incertidumbre tiene una estimación."
                ),
                Concept(
                    "Issue Advocate",
                    "Experto que usa su conocimiento para argumentar a favor de una opción o curso de acción.",
                    "Hace explícito que la expertise puede combinarse con una preferencia normativa o política.",
                    "Defender públicamente una prohibición regulatoria específica y tratar de persuadir al decisor de adoptarla."
                ),
                Concept(
                    "Honest Broker",
                    "Experto que ayuda a identificar, ampliar y comparar alternativas de decisión y sus implicancias.",
                    "Es central cuando existen valores en disputa y varias alternativas políticamente relevantes.",
                    "Presentar distintas arquitecturas de protección de neurodatos, sus ventajas, costos y riesgos, sin seleccionar la opción final."
                )
            ),
            cases = listOf(
                CaseStudy(
                    "Don’t Look Up",
                    "Material pedagógico para discutir cómo expertos se relacionan con medios, decisores, incertidumbre, conflicto y advocacy.",
                    "Permite identificar cambios de rol y tensiones entre comunicación científica, urgencia y estrategia política."
                )
            ),
            practicalExamples = listOf(
                "Clasificación: responder '¿cuánto aumentó el riesgo?' se aproxima a Science Arbiter; responder 'deben aprobar esta ley' se aproxima a Issue Advocate.",
                "Una misma persona puede desplazarse entre roles; los tipos son analíticos, no identidades permanentes.",
                "En una respuesta de desarrollo conviene explicar qué hace cada rol y luego justificar cuál describe mejor una intervención concreta."
            ),
            examPriority = true
        ),
        StudyModule(
            id = 3,
            title = "Ciclo de política pública y confianza",
            subtitle = "Dónde entra la evidencia y por qué conocer ciencia no determina una decisión",
            sessions = "Sesión 5 · 2 septiembre",
            readings = listOf(
                "Kraft & Furlong (2018), The Policy Process Model, pp. 154–177",
                "Leshner (2021), Trust in Science Is Not the Problem",
                "Casos: Ley de Humedales Urbanos y Anteproyecto de Ley de Suelos"
            ),
            keyPoints = listOf(
                "Kraft y Furlong presentan seis etapas analíticas: agenda setting, formulación, legitimación, implementación, evaluación y cambio de política.",
                "El ciclo no describe una secuencia rígida: las etapas se superponen, pueden omitirse y la política se revisa continuamente.",
                "La evidencia puede ingresar en distintas etapas y con funciones diferentes.",
                "Leshner distingue confianza general en la ciencia de obediencia a recomendaciones concretas.",
                "Las decisiones públicas combinan hechos con valores, intereses, experiencias y política; por eso el déficit de información no explica por sí solo el desacuerdo.",
                "El modelo de déficit es insuficiente: el engagement requiere diálogo, escucha y reconocimiento de valores e incertidumbre."
            ),
            concepts = listOf(
                Concept(
                    "Agenda setting",
                    "Proceso por el cual ciertos problemas son definidos, reciben atención y entran en la agenda política.",
                    "La evidencia puede ayudar a visibilizar un problema, pero competir por atención es un proceso político.",
                    "Investigación sobre riesgo urbano que convierte un fenómeno antes técnico en un problema público."
                ),
                Concept(
                    "Policy formulation",
                    "Diseño de objetivos, instrumentos y estrategias de política.",
                    "Es una fase donde evidencia comparada y conocimiento experto pueden estructurar alternativas.",
                    "Traducir evidencia ecológica en criterios jurídicos para proteger humedales urbanos."
                ),
                Concept(
                    "Policy legitimation",
                    "Proceso de otorgar autoridad y aceptación a una decisión, mediante aprobación formal y justificación pública.",
                    "Recuerda que una solución técnicamente sólida también necesita apoyo institucional y político.",
                    "Una propuesta puede estar científicamente justificada y aun requerir negociación, mayorías y compatibilidad jurídica."
                ),
                Concept(
                    "Modelo de déficit",
                    "Supuesto de que el desacuerdo público con la ciencia se debe principalmente a falta de conocimiento y se corrige entregando más información.",
                    "Leshner lo cuestiona porque valores, identidades, intereses y sesgos también estructuran la recepción de evidencia.",
                    "Una campaña que sólo agrega datos puede fracasar si el conflicto real es distributivo o valórico."
                ),
                Concept(
                    "Public engagement",
                    "Interacción de doble vía entre comunidad científica y públicos, basada en diálogo y escucha.",
                    "Desplaza la comunicación desde la enseñanza unilateral hacia la construcción de entendimiento y trabajo conjunto.",
                    "Sesiones pequeñas donde expertos y comunidades discuten evidencia, preocupaciones y alternativas."
                )
            ),
            cases = listOf(
                CaseStudy(
                    "Ley de Humedales Urbanos",
                    "El caso sigue la trayectoria de Carolina Rojas y el encuentro entre investigación sobre humedales y actores parlamentarios hasta la Ley 21.202.",
                    "Permite reconstruir agenda, formulación, negociación y costos del involucramiento académico, mostrando que la ciencia de lo probable entra en la política de lo posible."
                ),
                CaseStudy(
                    "Anteproyecto de Ley de Suelos",
                    "Una agenda científica de larga duración se articula con sociedad civil, actores políticos, mesas de trabajo y una metodología de consensos.",
                    "Ilustra ventana de oportunidad, redes, brokers y diferencias entre temporalidades académicas y políticas."
                )
            ),
            practicalExamples = listOf(
                "Si aparece nueva evidencia después de implementar una ley, el modelo cíclico permite pensar evaluación y cambio, no un proceso cerrado.",
                "Que una persona confíe en científicos no implica que acepte una política específica: puede discrepar por costos, valores o distribución de riesgos.",
                "Caso Suelos: una idea científicamente defendida durante años necesitó redes, coordinación, consenso y oportunidad política."
            ),
            examPriority = true
        ),
        StudyModule(
            id = 4,
            title = "Uso de evidencia en legislaturas",
            subtitle = "Usos instrumentales, conceptuales y simbólico-tácticos; barreras y facilitadores",
            sessions = "Sesión 6 · 9 septiembre",
            readings = listOf(
                "Ouimet et al. (2023), Use of Research Evidence in Legislatures: A Systematic Review",
                "Casos: Humedales Urbanos y Ley de Suelos"
            ),
            keyPoints = listOf(
                "La revisión sistemática de Ouimet et al. incluyó 21 estudios sobre uso de evidencia en legislaturas.",
                "El uso simbólico/táctico/persuasivo fue el tipo observado con mayor frecuencia.",
                "También existen usos instrumentales y conceptuales, además de usos legislativos específicos: preparar preguntas y debates, construir consenso, verificar información o apoyar trabajo de comisión.",
                "Las barreras y facilitadores se agrupan en cuatro categorías: institución/organización; características de la investigación; contexto de política y político; características individuales.",
                "La evidencia no se 'usa' de una sola manera: puede cambiar una decisión, estructurar cómo se entiende un problema o servir estratégicamente en una disputa."
            ),
            concepts = listOf(
                Concept(
                    "Uso instrumental",
                    "Uso relativamente directo de evidencia para informar una acción, decisión, enmienda o tarea legislativa.",
                    "Es la imagen más intuitiva del impacto, pero no es la única.",
                    "Usar resultados de investigación para redactar una indicación concreta a un proyecto de ley."
                ),
                Concept(
                    "Uso conceptual",
                    "Uso que modifica marcos, comprensión o lenguaje con que se interpreta un problema, sin producir necesariamente una decisión inmediata.",
                    "Captura impactos graduales y cognitivos de la investigación.",
                    "Una comisión comienza a entender un asunto como problema de riesgo sistémico después de múltiples exposiciones a evidencia."
                ),
                Concept(
                    "Uso simbólico/táctico",
                    "Uso de investigación para justificar, persuadir, legitimar o fortalecer una posición ya sostenida.",
                    "Es especialmente relevante en instituciones representativas y competitivas.",
                    "Citar un estudio en debate para reforzar una posición partidaria previamente definida."
                ),
                Concept(
                    "Facilitadores y barreras",
                    "Condiciones que aumentan o reducen la posibilidad de que la investigación sea accesible y usada.",
                    "Permiten diagnosticar el problema sin reducirlo a 'los políticos no leen'.",
                    "Tiempo disponible, confianza, acceso, forma del producto, experiencia del usuario de evidencia y contexto político."
                )
            ),
            cases = listOf(
                CaseStudy(
                    "Humedales Urbanos",
                    "La interacción entre academia y asesores legislativos muestra que la evidencia puede contribuir a definir el problema, diseñar argumentos y sostener negociaciones.",
                    "Útil para diferenciar uso instrumental de efectos conceptuales y relacionales."
                ),
                CaseStudy(
                    "Ley de Suelos",
                    "La construcción del anteproyecto combinó comunidad científica, sociedad civil, senadores, coordinación y búsqueda de consensos.",
                    "Permite pensar evidencia como insumo de deliberación y construcción de acuerdos, no sólo como dato técnico."
                )
            ),
            practicalExamples = listOf(
                "Un senador usa un paper para justificar públicamente una posición ya adoptada: uso simbólico/táctico.",
                "Un equipo legislativo cambia su definición del problema tras meses de contacto con investigadores: uso conceptual.",
                "Un estudio entrega el parámetro que se incorpora a una indicación: uso instrumental."
            ),
            examPriority = true
        ),
        StudyModule(
            id = 5,
            title = "El académico como actor público",
            subtitle = "Karp: vocación pública, pluralismo, compromiso y fronteras entre academia y sociedad",
            sessions = "Sesión 8 · 23 septiembre",
            readings = listOf(
                "Karp (2012), Public Scholarship as a Vocation",
                "Caso: Historia de la Ley de Neuroderechos",
                "Clips de entrevista a Carolina Rojas"
            ),
            keyPoints = listOf(
                "Karp distingue la lógica académica de la práctica pública: el trabajo público exige juicio, negociación y convivencia con fines plurales.",
                "Public scholarship no consiste simplemente en 'explicar más fácil' a una audiencia pasiva.",
                "Los públicos son agentes con conocimientos, criterios, valores y opiniones propios.",
                "El académico público trabaja cruzando fronteras culturales, retóricas e institucionales sin abandonar estándares de su disciplina.",
                "La vocación pública implica tensiones: relevancia, fidelidad disciplinar, compromiso, pluralismo y costos personales/institucionales."
            ),
            concepts = listOf(
                Concept(
                    "Public scholarship",
                    "Producción y circulación de conocimiento atravesando la frontera entre comunidades académicas y distintos públicos.",
                    "Requiere reconocer agencia y pluralidad en quienes reciben y co-producen conocimiento.",
                    "Una investigadora que participa en una comisión no sólo traduce su paper: aprende las reglas, preguntas y restricciones del espacio legislativo."
                ),
                Concept(
                    "Pluralismo",
                    "Reconocimiento de que la vida social contiene valores, bienes y perspectivas diferentes, incluso incompatibles.",
                    "Obliga al académico público a trabajar sin asumir que el conocimiento científico elimina el desacuerdo político legítimo.",
                    "En neuroderechos, evidencia científica, ética, derecho y diseño institucional pueden producir desacuerdos razonables."
                ),
                Concept(
                    "Compromiso",
                    "Necesidad práctica de negociar entre fines y restricciones cuando se busca producir efectos en el mundo público.",
                    "Contrasta con la imagen de una actividad académica guiada únicamente por la búsqueda desinteresada de verdad.",
                    "Aceptar una redacción jurídicamente viable que no reproduce exactamente el lenguaje preferido por la comunidad científica."
                ),
                Concept(
                    "Público activo",
                    "Idea de que las audiencias no son recipientes vacíos: poseen experiencia, conocimiento, valores y criterios propios.",
                    "Cuestiona estrategias unidireccionales de comunicación.",
                    "Una audiencia parlamentaria formula preguntas que obligan al experto a redefinir qué información es pertinente."
                )
            ),
            cases = listOf(
                CaseStudy(
                    "Ley de Neuroderechos",
                    "El caso conecta avances neurotecnológicos con una discusión pública y legislativa sobre nuevos riesgos, derechos, regulación y desacuerdo académico.",
                    "Permite analizar intermediación entre ciencia, ética, derecho y política, además de roles expertos en una controversia con alta incertidumbre y valores en disputa."
                ),
                CaseStudy(
                    "Carolina Rojas y Humedales Urbanos",
                    "La trayectoria expone el paso desde la academia hacia el Congreso y los costos de salir de la zona institucional habitual.",
                    "Es útil para discutir la vocación pública y la tensión entre producción científica, advocacy, negociación y reconocimiento académico."
                )
            ),
            practicalExamples = listOf(
                "No es public scholarship simplemente sustituir palabras técnicas por palabras simples; debe existir comprensión del público y del contexto de uso.",
                "En un conflicto normativo, el experto puede clarificar evidencia sin pretender que ésta resuelva por sí sola qué valor debe prevalecer.",
                "Relaciona Karp con Pielke: Karp se centra en la vocación y las fronteras del trabajo público; Pielke, en el rol adoptado frente a la decisión."
            ),
            examPriority = true
        ),
        StudyModule(
            id = 6,
            title = "Casos integradores",
            subtitle = "Suelos, humedales, regulación térmica y neuroderechos como laboratorio de conceptos",
            sessions = "Transversal · Sesiones 5, 6 y 8",
            readings = listOf(
                "Caso 2: Tres mujeres, un destino — Anteproyecto de Ley de Suelos",
                "Caso 3: Dos corazones unidos por un sueño — Ley de Humedales Urbanos",
                "Caso 4: Del cielo al suelo construyendo una misión — regulación térmica",
                "Caso 5: Historia de la Ley de Neuroderechos"
            ),
            keyPoints = listOf(
                "Los casos muestran trayectorias no lineales: evidencia, relaciones, oportunidades, negociación, instituciones y persistencia se combinan.",
                "Los intermediarios aparecen como actores estratégicos para traducir lenguajes y conectar comunidades.",
                "La temporalidad política puede ser muy distinta de la temporalidad académica.",
                "La evidencia puede definir problemas, expandir opciones, apoyar acuerdos o ser usada estratégicamente.",
                "Los casos también muestran costos del involucramiento público: desgaste, aislamiento, tiempo y tensión con incentivos académicos."
            ),
            concepts = listOf(
                Concept(
                    "Ventana de oportunidad",
                    "Momento en que condiciones políticas, institucionales y problemáticas permiten avanzar una propuesta antes estancada.",
                    "Ayuda a explicar por qué evidencia acumulada durante años puede adquirir relevancia súbita.",
                    "En el caso de Suelos, una agenda de larga duración logra articular actores y alcanzar tramitación cuando se alinean condiciones."
                ),
                Concept(
                    "Broker/intermediario",
                    "Actor capaz de conectar espacios y facilitar traducción, coordinación y confianza.",
                    "Reduce fricciones entre comunidades con códigos y restricciones diferentes.",
                    "Abogados, asesores, coordinadores o académicos que logran convertir conocimiento técnico en opciones discutibles legislativamente."
                ),
                Concept(
                    "Conocimiento con propósito",
                    "Investigación producida o movilizada con atención explícita a un problema público y a sus condiciones de uso.",
                    "No elimina la autonomía científica, pero incorpora relevancia, formato, oportunidad y usuario.",
                    "Mapear condiciones térmicas para apoyar una norma de desempeño habitacional."
                )
            ),
            cases = listOf(
                CaseStudy(
                    "Suelos",
                    "Más de dos décadas de preocupación científica convergen en redes, sociedad civil, coordinación, metodología de consensos y articulación política.",
                    "Ideal para ventana de oportunidad, brokerage, co-creación y temporalidades."
                ),
                CaseStudy(
                    "Humedales Urbanos",
                    "Una investigación territorial se conecta con un emprendedor político y asesores legislativos hasta una solución legal.",
                    "Ideal para ciclo de política, roles expertos, redes y costos de la vocación pública."
                ),
                CaseStudy(
                    "Regulación térmica",
                    "Waldo Bustamante construye durante décadas conocimiento y redes para incidir en estándares de vivienda, interactuando con Estado e industria.",
                    "Ideal para conocimiento con propósito, persistencia, intermediación y tensión entre factibilidad técnica y política."
                ),
                CaseStudy(
                    "Neuroderechos",
                    "La emergencia neurotecnológica activa una propuesta regulatoria chilena con participación científica, política, bioética y jurídica, además de desacuerdo académico.",
                    "Ideal para Pielke, Karp, incertidumbre, pluralismo y ciencia en controversias normativas."
                )
            ),
            practicalExamples = listOf(
                "Ejercicio: toma un concepto —por ejemplo broker— y busca una manifestación distinta en cada caso.",
                "Ejercicio: reconstruye cada caso como secuencia problema → actores → evidencia → interfaz → negociación → resultado.",
                "Ejercicio: identifica dónde un modelo lineal sería incapaz de explicar lo ocurrido."
            ),
            examPriority = true
        ),
        StudyModule(
            id = 7,
            title = "Vías de acceso al Congreso",
            subtitle = "Formación de la ley, comisiones y canales institucionales",
            sessions = "Sesiones 10–11 · 7 y 14 octubre",
            readings = listOf(
                "Infografías del curso sobre formación de la ley, comisiones y actores",
                "Guajardo & Reyes (2020), recomendaciones para académicos"
            ),
            keyPoints = listOf(
                "Módulo preparado en la estructura de la app; el contenido detallado debe cargarse desde las infografías y lectura completa asignadas por el curso."
            ),
            concepts = emptyList(), cases = emptyList(), practicalExamples = emptyList(), available = false
        ),
        StudyModule(
            id = 8,
            title = "Comunicación para audiencias parlamentarias",
            subtitle = "Estrategias, message box y presentación de 3 minutos",
            sessions = "Sesiones 12–13 · 21 y 28 octubre",
            readings = listOf(
                "Tyler (2013), Top 20 things scientists need to know about policymaking",
                "Oliver & Cairney (2019), dos and don’ts of influencing policy"
            ),
            keyPoints = listOf(
                "Módulo programado para incorporar técnicas de message box, adecuación al usuario y comunicación oral breve."
            ),
            concepts = emptyList(), cases = emptyList(), practicalExamples = emptyList(), available = false
        ),
        StudyModule(
            id = 9,
            title = "Simulación y Ley de Lobby",
            subtitle = "Preparación estratégica para reuniones y audiencias",
            sessions = "Sesiones 14–16 · 4, 11 y 18 noviembre",
            readings = listOf("Materiales y roles de simulación entregados por el curso"),
            keyPoints = listOf("Módulo listo para ser completado cuando se entreguen los roles y materiales de simulación."),
            concepts = emptyList(), cases = emptyList(), practicalExamples = emptyList(), available = false
        ),
        StudyModule(
            id = 10,
            title = "Cierre y reflexión",
            subtitle = "Debriefing: informar con conocimiento la formación de la ley",
            sessions = "Sesión 17 · 25 noviembre",
            readings = listOf("DePace (2021), The Scientific Citizen Initiative"),
            keyPoints = listOf("Módulo final para integrar aprendizajes, desempeño en simulaciones y reflexión sobre rol público."),
            concepts = emptyList(), cases = emptyList(), practicalExamples = emptyList(), available = false
        )
    )

    val questions = QuestionBank.questions

    val developmentExamples = listOf(
        DevelopmentExample(
            1,
            "Por qué la evidencia no se traduce automáticamente en política",
            "Explique por qué la producción de evidencia científica de alta calidad no garantiza su uso en políticas públicas. Integre al menos dos autores y un caso del curso.",
            "La brecha entre ciencia y política no es principalmente un problema de información faltante, sino una interfaz entre comunidades con temporalidades, códigos, incentivos y criterios de legitimidad diferentes; por ello, el impacto depende de relaciones, intermediación y contexto político.",
            listOf(
                "Definir la crítica al modelo lineal desde Martinuzzi.",
                "Introducir a Leshner: decisiones públicas combinan hechos con valores e intereses; más información no basta.",
                "Aplicar al caso de Suelos o Humedales mostrando redes, oportunidad e intermediación.",
                "Cerrar señalando qué condiciones aumentan la usabilidad de la evidencia."
            ),
            "Martinuzzi y Sedlacko permiten cuestionar la intuición según la cual el principal obstáculo entre ciencia y política sería la falta de transmisión de información. En el modelo lineal, la ciencia produce evidencia correcta y la política debería incorporarla; sin embargo, este esquema no explica por qué resultados rigurosos pueden permanecer sin uso durante años. La interfaz está atravesada por diferencias de lenguaje, tiempos, intereses, legitimidad y capacidad institucional. Por ello, el enfoque de redes pone el acento en interacciones sostenidas, confianza e intermediarios. Leshner complementa esta crítica al mostrar que las decisiones públicas no se derivan sólo de hechos: también intervienen valores, experiencias e intereses. El caso del Anteproyecto de Ley de Suelos muestra esta dinámica. La preocupación científica tenía una trayectoria prolongada, pero avanzar requirió redes, participación de sociedad civil, articulación con actores políticos y una metodología de consensos. La lección es que la calidad científica es necesaria, pero no suficiente: para que la evidencia sea movilizable debe entrar en una arquitectura relacional e institucional que la vuelva pertinente, oportuna y políticamente procesable.",
            listOf("Modelo lineal", "Enfoque de redes", "Knowledge brokerage", "Modelo de déficit"),
            listOf("Ley de Suelos")
        ),
        DevelopmentExample(
            2,
            "Comparar los roles de Pielke",
            "Compare el Science Arbiter, el Issue Advocate y el Honest Broker. ¿Cómo podrían aparecer estos roles en una controversia como la Ley de Neuroderechos?",
            "Los roles se distinguen por la relación que el experto establece con el rango de opciones del decisor: responder preguntas factuales, defender una opción o ampliar/clarificar alternativas.",
            listOf(
                "Explicar que son tipos ideales, no identidades fijas.",
                "Definir los tres roles por su relación con las opciones de decisión.",
                "Aplicarlos a neuroderechos sin afirmar que una persona real encarna necesariamente un tipo puro.",
                "Concluir sobre utilidad y límites del esquema en controversias normativas."
            ),
            "Pielke propone tipos ideales para analizar cómo los expertos se sitúan frente a decisiones políticas. El Science Arbiter mantiene una relación directa con el decisor, pero procura responder preguntas positivas delimitadas: por ejemplo, qué capacidades actuales tienen determinadas neurotecnologías o con qué grado de incertidumbre se estima un riesgo. El Issue Advocate da un paso distinto: usa su expertise para defender una opción y, por tanto, busca estrechar el rango de alternativas. En una discusión de neuroderechos podría argumentar que una protección constitucional específica es la única respuesta adecuada. El Honest Broker, en cambio, intenta ampliar o clarificar las opciones: podría distinguir varias arquitecturas regulatorias, sus riesgos, costos y efectos, explicitando incertidumbres y dejando la elección final a la autoridad democrática. El caso es especialmente útil porque combina ciencia emergente, ética, derecho y desacuerdo académico. Esto muestra que la evidencia puede informar la decisión sin eliminar la dimensión normativa de escoger entre cursos de acción.",
            listOf("Science Arbiter", "Issue Advocate", "Honest Broker", "Tipos ideales"),
            listOf("Ley de Neuroderechos")
        ),
        DevelopmentExample(
            3,
            "Uso de evidencia en el Congreso",
            "A partir de Ouimet et al., explique por qué 'usar evidencia' no equivale solamente a adoptar una recomendación científica. Ilustre con un caso.",
            "El uso de evidencia es multidimensional: puede ser instrumental, conceptual, simbólico/táctico o cumplir funciones legislativas específicas como estructurar preguntas, debate y consenso.",
            listOf(
                "Presentar la tipología de usos.",
                "Explicar que el simbólico/táctico aparece con alta frecuencia en la revisión.",
                "Agregar las cuatro categorías de barreras/facilitadores.",
                "Aplicar a Humedales o Suelos."
            ),
            "Ouimet et al. muestran que el uso legislativo de investigación no puede medirse sólo preguntando si un estudio produjo directamente una ley. Existe un uso instrumental cuando la evidencia informa de manera relativamente directa una enmienda, decisión o acción; un uso conceptual cuando transforma gradualmente la forma en que los actores entienden un problema; y un uso simbólico o táctico cuando se moviliza para justificar, persuadir o fortalecer una posición. La revisión identifica además usos propios del trabajo legislativo, como preparar preguntas y debates, verificar información o contribuir a construir consenso. El caso de Humedales Urbanos permite ver esta pluralidad. La investigación no opera como una orden que el Congreso simplemente ejecuta: ayuda a definir el problema, aporta lenguaje y conocimiento a los actores, interactúa con asesores y se inserta en una negociación. Por ello, evaluar la incidencia exige observar procesos de aprendizaje, relaciones y usos estratégicos, además del resultado legal final.",
            listOf("Uso instrumental", "Uso conceptual", "Uso simbólico/táctico", "Barreras y facilitadores"),
            listOf("Ley de Humedales Urbanos")
        ),
        DevelopmentExample(
            4,
            "Confianza, valores y engagement",
            "Leshner sostiene que la confianza en la ciencia no es el problema central. Explique el argumento y sus implicancias para la comunicación con audiencias parlamentarias.",
            "La confianza general puede coexistir con desacuerdo sobre recomendaciones específicas porque las decisiones públicas integran evidencia con valores, intereses, identidad, experiencia e incertidumbre.",
            listOf(
                "Distinguir confianza general de aceptación de recomendaciones.",
                "Explicar el modelo de déficit y por qué es insuficiente.",
                "Introducir sesgos, valores e incertidumbre como mecanismos.",
                "Derivar una estrategia de engagement: escucha, diálogo y adaptación al contexto."
            ),
            "El argumento de Leshner parte de una distinción clave: una persona puede confiar en la capacidad o honestidad de la comunidad científica y, aun así, rechazar una recomendación concreta. Esto ocurre porque las decisiones públicas no se construyen exclusivamente sobre hechos. Intervienen valores, intereses, experiencias y consideraciones políticas, además de la incertidumbre propia de la ciencia. Por eso, diagnosticar el desacuerdo como simple ignorancia conduce al modelo de déficit: si el público supiera más, aceptaría la conclusión experta. Leshner rechaza esa expectativa y propone desplazar la estrategia hacia el engagement. Para una audiencia parlamentaria, esto implica no limitarse a aumentar la densidad técnica de una presentación. El investigador debe escuchar qué problema intenta resolver la comisión, explicitar incertidumbres relevantes, comprender restricciones y responder a preocupaciones normativas sin confundirlas con preguntas empíricas. La comunicación efectiva es, por tanto, una interacción de doble vía y no una clase impartida a un receptor pasivo.",
            listOf("Confianza", "Modelo de déficit", "Public engagement", "Valores e incertidumbre"),
            listOf("Aplicación transversal a audiencias parlamentarias")
        ),
        DevelopmentExample(
            5,
            "Public scholarship y costos de salir de la academia",
            "Explique la idea de public scholarship de Karp y aplíquela al caso de la Ley de Humedales Urbanos.",
            "La vocación pública exige cruzar fronteras institucionales y culturales, reconocer públicos activos y plurales y aceptar compromisos prácticos sin abandonar estándares disciplinarios.",
            listOf(
                "Contrastar vocación académica y trabajo público.",
                "Explicar la crítica a la audiencia pasiva.",
                "Aplicar a la trayectoria de Carolina Rojas.",
                "Incorporar costos, negociación y relevancia como tensiones del rol público."
            ),
            "Karp entiende la public scholarship como una práctica distinta de la simple divulgación. El académico público produce y moviliza conocimiento atravesando fronteras entre comunidades que poseen lenguajes, valores y criterios de juicio diferentes. Esto exige una concepción pluralista de la sociedad y el reconocimiento de que los públicos son agentes con saberes y opiniones propios, no receptores vacíos que sólo requieren una explicación simplificada. La Ley de Humedales Urbanos ilustra esta transición. La trayectoria de Carolina Rojas muestra cómo una investigadora sale del espacio académico habitual y se inserta en una red de actores parlamentarios, asesores y problemas públicos. El conocimiento conserva su fundamento científico, pero su uso requiere aprender reglas, tiempos y formas de negociación propias del Congreso. El caso también explicita costos de esa salida de la academia. Así, la vocación pública no significa abandonar la ciencia por la política, sino desarrollar juicio para operar responsablemente entre ambas esferas.",
            listOf("Public scholarship", "Pluralismo", "Público activo", "Compromiso"),
            listOf("Ley de Humedales Urbanos")
        ),
        DevelopmentExample(
            6,
            "Respuesta integradora: explicar un caso con varios marcos",
            "Analice el Anteproyecto de Ley de Suelos usando el ciclo de políticas, knowledge brokerage y la noción de uso de evidencia en legislaturas.",
            "El caso se entiende mejor como una trayectoria no lineal donde definición del problema, redes, brokerage, ventana política, construcción de consenso y distintos usos de evidencia se refuerzan mutuamente.",
            listOf(
                "Usar el ciclo de Kraft como mapa, no como secuencia rígida.",
                "Mostrar por qué el enfoque de redes explica mejor la conexión ciencia–política que el modelo lineal.",
                "Distinguir usos de evidencia posibles con Ouimet.",
                "Cerrar con una explicación causal del avance del anteproyecto."
            ),
            "El Anteproyecto de Ley de Suelos puede reconstruirse con el ciclo de políticas como un proceso en que un problema de larga data logra adquirir atención, se transforma en una propuesta y busca legitimación política. Sin embargo, el propio modelo de Kraft y Furlong advierte que estas fases no deben leerse mecánicamente: la formulación, la construcción de agenda y la legitimación pueden superponerse. Esta no linealidad se vuelve más clara desde Martinuzzi y Sedlacko. La evidencia acumulada durante años no produjo automáticamente legislación; fue necesario construir redes entre comunidad científica, sociedad civil y actores políticos, además de contar con coordinadores e intermediarios capaces de traducir y organizar el trabajo. Desde Ouimet, la evidencia puede haber cumplido simultáneamente funciones instrumentales —aportar contenido a la propuesta—, conceptuales —consolidar una comprensión compartida del problema— y persuasivas o de construcción de consenso. Por eso, el avance del caso no se explica por un paper decisivo, sino por la articulación entre conocimiento, actores, procesos de consenso y oportunidad política.",
            listOf("Policy cycle", "Knowledge brokerage", "Enfoque de redes", "Usos de evidencia"),
            listOf("Ley de Suelos")
        ),
        DevelopmentExample(
            7,
            "Martinuzzi y Pielke: dos preguntas distintas",
            "Compare el enfoque de knowledge brokerage de Martinuzzi y Sedlacko con la tipología de roles de Pielke. ¿Qué explica cada marco y cómo podrían combinarse en el caso de Humedales Urbanos?",
            "Los marcos son complementarios: Martinuzzi y Sedlacko explican la arquitectura relacional de la interfaz ciencia–política; Pielke clasifica la posición que adopta el experto frente al rango de opciones del decisor.",
            listOf(
                "Definir brokerage y enfoque de redes.",
                "Definir la lógica de los roles de Pielke.",
                "Mostrar que uno explica relaciones y el otro posicionamiento experto.",
                "Aplicar ambos a la trayectoria de Humedales sin convertir actores reales en tipos puros."
            ),
            "Martinuzzi y Sedlacko y Pielke responden preguntas analíticas diferentes. El enfoque de knowledge brokerage se concentra en cómo se conectan comunidades con tiempos, lenguajes e incentivos distintos. Su unidad de análisis son las relaciones, las redes, los intermediarios y las prácticas de frontera que vuelven utilizable el conocimiento. Pielke, en cambio, pregunta qué hace el experto frente a las opciones de decisión: puede responder preguntas delimitadas, defender una alternativa o ampliar el conjunto de opciones. En Humedales Urbanos, el enfoque de redes explica por qué la investigación de Carolina Rojas necesitó vínculos con asesores, aprendizaje institucional y una relación sostenida con el equipo parlamentario para adquirir incidencia. Pielke permite analizar, en distintos momentos, si la intervención experta se orienta a responder preguntas, a persuadir o a clarificar alternativas. Juntos, ambos marcos muestran que la incidencia depende tanto de la arquitectura de la relación como de la forma específica en que el experto usa su autoridad en la decisión.",
            listOf("Knowledge brokerage", "Enfoque de redes", "Science Arbiter", "Issue Advocate", "Honest Broker"),
            listOf("Ley de Humedales Urbanos")
        ),
        DevelopmentExample(
            8,
            "No linealidad del proceso de política",
            "Explique por qué el policy cycle de Kraft y Furlong debe usarse como heurística y no como cronología rígida. Aplique la respuesta a la Ley de Suelos.",
            "El ciclo ordena analíticamente funciones del proceso, pero los casos reales presentan solapamientos, retroalimentación y retornos entre agenda, formulación y legitimación.",
            listOf(
                "Nombrar las seis etapas.",
                "Explicar la advertencia de no linealidad del modelo.",
                "Mostrar solapamientos concretos en Suelos.",
                "Concluir sobre la utilidad del ciclo como mapa analítico."
            ),
            "Kraft y Furlong distinguen agenda setting, formulación, legitimación, implementación, evaluación y cambio de política. Sin embargo, el valor del modelo no reside en predecir una secuencia universal. Los autores advierten que las etapas pueden superponerse, retroalimentarse o incluso omitirse. La Ley de Suelos lo muestra con claridad. La definición pública del problema no terminó antes de que comenzara la formulación: seminarios, redes científicas y mesas de trabajo siguieron redefiniendo el diagnóstico mientras se elaboraban propuestas. Del mismo modo, la búsqueda de apoyo político y legitimidad ocurrió al mismo tiempo que se afinaba el contenido del proyecto. La aprobación de la idea de legislar tampoco cerró el proceso, porque continuaron ajustes y negociación. Por eso, el ciclo es útil si se emplea como lenguaje para identificar funciones y momentos, no como una cronología mecánica que el caso deba obedecer.",
            listOf("Policy cycle", "Agenda setting", "Formulación", "Legitimación", "No linealidad"),
            listOf("Ley de Suelos")
        ),
        DevelopmentExample(
            9,
            "Leshner y Karp: qué significa reconocer al público",
            "Compare la crítica de Leshner al modelo de déficit con la concepción de public scholarship de Karp. ¿Qué implicancias tienen para una intervención académica ante una comisión parlamentaria?",
            "Ambos rechazan una audiencia pasiva: Leshner muestra que más información no elimina valores e intereses; Karp exige tratar a los públicos como agentes con criterios propios y trabajar responsablemente a través de fronteras institucionales.",
            listOf(
                "Explicar modelo de déficit y engagement.",
                "Explicar público activo y pluralismo en Karp.",
                "Identificar convergencias y diferencias.",
                "Derivar reglas prácticas para una comisión parlamentaria."
            ),
            "Leshner y Karp convergen en cuestionar una idea transmisiva de la relación entre expertos y públicos. Leshner critica el modelo de déficit porque supone que el desacuerdo desaparecerá si las personas reciben suficiente información. Para él, las decisiones también expresan valores, intereses, identidades y experiencias, de modo que la comunicación debe convertirse en engagement. Karp llega a una conclusión semejante desde la public scholarship: los públicos no son recipientes vacíos, sino agentes con conocimientos y criterios de juicio propios. La diferencia es de énfasis. Leshner se ocupa de comunicación y aceptación de recomendaciones científicas; Karp, de la vocación y las obligaciones del académico que cruza fronteras institucionales. Ante una comisión parlamentaria, ambos marcos aconsejan escuchar antes de exponer, identificar la pregunta real de política, adaptar el formato sin distorsionar la evidencia y reconocer que el desacuerdo normativo no es un simple error cognitivo que la ciencia pueda borrar.",
            listOf("Modelo de déficit", "Public engagement", "Public scholarship", "Público activo", "Pluralismo"),
            listOf("Aplicación a audiencias parlamentarias")
        ),
        DevelopmentExample(
            10,
            "Neuroderechos como controversia ciencia–política",
            "Analice la trayectoria de los neuroderechos utilizando Pielke y Karp. ¿Qué desafíos aparecen cuando un campo científico emergente entra rápidamente al proceso legislativo?",
            "El caso combina incertidumbre empírica y desacuerdo normativo, por lo que exige distinguir la clarificación experta de la defensa de opciones y, al mismo tiempo, reconocer la pluralidad de disciplinas y públicos que participan en la construcción regulatoria.",
            listOf(
                "Explicar incertidumbre y opciones desde Pielke.",
                "Introducir pluralismo y trabajo público desde Karp.",
                "Aplicar a la interacción entre neurociencia, bioética, derecho y Congreso.",
                "Cerrar con los riesgos de confundir expertise con autoridad normativa final."
            ),
            "Los neuroderechos son un caso especialmente exigente para la asesoría científica porque la tecnología avanza mientras las categorías jurídicas y éticas todavía están en disputa. Pielke ayuda a distinguir dos tareas. Una consiste en responder preguntas empíricas sobre capacidades y riesgos de las neurotecnologías; otra, diferente, consiste en escoger entre diseños normativos. Un experto puede actuar como Science Arbiter al clarificar evidencia, como Issue Advocate si defiende una protección determinada o como Honest Broker si compara alternativas y consecuencias. Karp permite agregar otra dimensión: la regulación no se construye dentro de una sola comunidad epistémica. Neurocientíficos, bioeticistas, juristas y parlamentarios poseen lenguajes y criterios distintos, de modo que el académico público debe trabajar en un espacio plural y aceptar que otros actores también poseen agencia. El desafío central es, entonces, movilizar conocimiento sin convertir la autoridad científica en sustituto de la deliberación democrática.",
            listOf("Science Arbiter", "Issue Advocate", "Honest Broker", "Public scholarship", "Pluralismo"),
            listOf("Ley de Neuroderechos")
        ),
        DevelopmentExample(
            11,
            "Regulación térmica: evidencia, factibilidad y persistencia",
            "Explique cómo el caso de regulación térmica de viviendas muestra que la incidencia científica depende de conocimiento con propósito, intermediación y temporalidades largas.",
            "La trayectoria de regulación térmica no es una aplicación instantánea de evidencia, sino una secuencia de décadas en que investigación, estándares técnicos, intereses productivos, capacidades estatales y estrategias de gradualidad se combinan.",
            listOf(
                "Reconstruir las tres grandes fases del caso.",
                "Identificar el papel de Waldo Bustamante como intermediario.",
                "Explicar la estrategia gradual y la negociación con Estado e industria.",
                "Relacionar temporalidad con formulación e implementación."
            ),
            "La regulación térmica permite observar el knowledge brokerage como práctica sostenida. Waldo Bustamante no aporta sólo resultados de laboratorio: vincula mediciones, normas técnicas, bienestar de los hogares y decisiones regulatorias. La primera fase muestra una estrategia gradual —comenzar por los techos— que combina una base técnica defendible con factibilidad política e industrial. Las etapas posteriores amplían la envolvente y elevan la complejidad del conflicto. El caso también revela una fuerte separación temporal entre investigación y decisión: estudios realizados en 2013–2014 alimentan una actualización normativa publicada una década después y con entrada en vigencia posterior. Desde el ciclo de políticas, esto permite distinguir formulación, legitimación e implementación; desde el enfoque de redes, muestra por qué la persistencia, la traducción entre lenguajes y la confianza institucional son condiciones de impacto. La evidencia importa, pero opera dentro de una trayectoria política y organizacional prolongada.",
            listOf("Knowledge brokerage", "Intermediario", "Policy cycle", "Factibilidad", "Temporalidad"),
            listOf("Regulación térmica")
        ),
        DevelopmentExample(
            12,
            "Comparar condiciones de incidencia entre casos",
            "Compare Suelos, Humedales, regulación térmica y Neuroderechos. ¿Qué condiciones comunes y qué mecanismos distintos explican que el conocimiento científico entre en procesos de política?",
            "Los cuatro casos comparten la necesidad de actores capaces de conectar conocimiento e instituciones, pero difieren en temporalidad, grado de controversia, arquitectura de intermediación y tipo de oportunidad política.",
            listOf(
                "Identificar un patrón común de no linealidad.",
                "Comparar redes e intermediarios.",
                "Distinguir temporalidades y tipos de controversia.",
                "Cerrar proponiendo condiciones generales sin borrar las diferencias entre casos."
            ),
            "Los cuatro casos cuestionan la idea de transferencia automática. En Suelos, una agenda científica prolongada requiere metodología de consensos, coordinación y una ventana política para traducirse en propuesta legislativa. En Humedales, la evidencia adquiere fuerza mediante la relación entre una académica, asesores y un senador capaz de convertir conocimiento en estrategia legislativa. En regulación térmica, el mecanismo central es la persistencia de largo plazo y la intermediación entre academia, MINVU e industria, con avances graduales y períodos extensos entre estudios e implementación. Neuroderechos, en cambio, muestra una trayectoria acelerada de gobernanza anticipatoria en un campo emergente, pero también una controversia normativa y académica intensa. El patrón común es la presencia de redes, traducción y actores de frontera; lo que cambia es la temporalidad, el tipo de conflicto y la estructura de oportunidad. Por ello, una teoría útil de incidencia debe combinar condiciones relacionales generales con mecanismos específicos de cada caso.",
            listOf("No linealidad", "Brokerage", "Ventana de oportunidad", "Public scholarship", "Usos de evidencia"),
            listOf("Ley de Suelos", "Ley de Humedales Urbanos", "Regulación térmica", "Ley de Neuroderechos")
        )
    )
}
