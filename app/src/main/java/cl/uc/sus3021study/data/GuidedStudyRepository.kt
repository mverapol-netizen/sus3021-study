package cl.uc.sus3021study.data
import cl.uc.sus3021study.model.ConceptStudyCard
import cl.uc.sus3021study.model.GuidedReadingPlan
object GuidedStudyRepository {
    val readingPlans = listOf(
        GuidedReadingPlan(
            id = 1,
            readingId = 1,
            durationMinutes = 15,
            orientation = "Lee Vincula como un diagnóstico de la interfaz academia–Congreso, no como la descripción de una plataforma. La pregunta guía es qué fricciones viven los usuarios de oferta y demanda antes de diseñar una solución.",
            focusSteps = listOf("Ubica el problema: la brecha no es sólo falta de información; también hay tiempos, incentivos, contactos, formatos y expectativas incompatibles.", "Identifica los usuarios foco: académicos como oferta y asesores parlamentarios/técnicos como demanda, dentro de un ecosistema más amplio.", "Sigue la lógica del needfinding: mapa de actores → 3C/customer journey → validación de problemas → matriz lógica de diseño → propuesta conceptual.", "Convierte cada fricción en un requerimiento: contacto, intermediación, bidireccionalidad, confianza, coordinación o formato utilizable.", "Cierra vinculando Vincula con Martinuzzi: si la brecha es relacional e institucional, un enfoque puramente lineal resulta insuficiente."),
            selfTest = listOf("¿Por qué Vincula no puede reducirse a un problema de divulgación científica?", "¿Quiénes son los usuarios foco de oferta y demanda?", "¿Qué función cumple el needfinding antes de proponer una solución?", "Da un ejemplo de cómo una barrera concreta se transforma en un requerimiento de diseño."),
            answerKey = listOf("Porque el diagnóstico incluye barreras relacionales, institucionales, temporales y de incentivos, además de accesibilidad de la información.", "Académicos en la oferta y asesores parlamentarios/técnicos parlamentarios en la demanda.", "Permite observar experiencias, validar problemas y construir la solución desde necesidades reales de los usuarios en vez de asumirlas desde la academia.", "Ejemplo: redes expertas limitadas o falta de contactos → intermediación y contacto bidireccional; poco tiempo legislativo → formatos breves y mecanismos de respuesta rápida."),
            synthesisPrompt = "En 60 segundos, explica qué problema intenta resolver Vincula y por qué su metodología anticipa una visión de knowledge brokerage basada en redes.",
            modelSynthesis = "Vincula parte de que la distancia entre academia y Congreso no se explica sólo por falta de información. El needfinding identifica fricciones de ambos lados —contactos, tiempos, incentivos, comprensión de procesos y formatos— y las traduce en requerimientos de diseño. Por eso la solución requiere intermediación, bidireccionalidad y confianza, rasgos compatibles con una concepción relacional del knowledge brokerage."
        ),
        GuidedReadingPlan(
            id = 2,
            readingId = 2,
            durationMinutes = 18,
            orientation = "Estudia este texto como un mapa de tres formas de entender la relación ciencia–política. La clave no es memorizar nombres aislados, sino explicar qué supone cada enfoque sobre cómo circula el conocimiento.",
            focusSteps = listOf("Primero separa el modelo simplificado: la evidencia correcta, accesible, relevante y oportuna debería viajar hacia la decisión.", "Luego contrasta teoría de sistemas: ciencia y política operan con códigos distintos; verdad frente a poder y legitimidad.", "Después estudia el enfoque de redes: conectividad mediante relaciones prolongadas, confianza, aprendizaje mutuo e intermediarios.", "Distingue boundary work, boundary actors y organizaciones de frontera como dispositivos de interacción sin borrar diferencias institucionales.", "Finalmente ubica los juegos de brokerage: preguntas–respuestas, agenda, formación de comunidad y reframing; cada uno organiza de manera distinta la interacción."),
            selfTest = listOf("¿Qué supuesto hace ingenuo al modelo lineal simplificado?", "¿Qué códigos diferencian ciencia y política en la lectura sistémica?", "¿Qué agrega el enfoque de redes que los dos anteriores no capturan bien?", "¿Por qué brokerage no equivale simplemente a enviar un policy brief?"),
            answerKey = listOf("Supone que disponer de evidencia adecuada basta para cambiar la decisión, subestimando intereses, racionalidades, instituciones y valores.", "La ciencia se organiza alrededor de la verdad; la política alrededor de poder y legitimidad.", "Introduce relaciones de largo plazo, confianza, comprensión mutua, co-creación e intermediarios que aumentan conectividad entre sistemas distintos.", "Porque un documento puede mejorar accesibilidad, pero no crea por sí mismo relaciones, confianza, traducción de necesidades ni espacios de co-definición de problemas."),
            synthesisPrompt = "Compara en una frase cada una de las tres conceptualizaciones y explica cuál permite entender mejor el caso de Suelos.",
            modelSynthesis = "El modelo lineal concibe la incidencia como transferencia de evidencia; la teoría de sistemas enfatiza la distancia estructural entre códigos; el enfoque de redes explica cómo actores e intermediarios construyen conectividad pese a esa distancia. Suelos se entiende especialmente bien desde redes porque el avance dependió de relaciones sostenidas, brokers, mesas de trabajo y construcción de consensos."
        ),
        GuidedReadingPlan(
            id = 3,
            readingId = 3,
            durationMinutes = 15,
            orientation = "La lectura debe dominarse como una tipología de roles ideales. La pregunta decisiva es qué hace el experto con el espacio de alternativas de decisión.",
            focusSteps = listOf("Pure Scientist: produce conocimiento sin involucrarse directamente con la decisión concreta.", "Science Arbiter: responde preguntas factuales delimitadas planteadas por decisores, sin decirles qué deberían preferir.", "Issue Advocate: usa expertise para defender una alternativa y reducir el rango de opciones.", "Honest Broker: expande o clarifica alternativas y consecuencias para que el decisor elija según sus valores.", "Cierra con stealth issue advocacy: una presentación aparentemente neutral puede seleccionar preguntas o marcos que, de hecho, estrechan opciones."),
            selfTest = listOf("¿Qué diferencia al Science Arbiter del Honest Broker?", "¿Qué hace un Issue Advocate con el rango de opciones?", "¿Por qué los roles son tipos ideales y no identidades personales fijas?", "¿Qué problema intenta capturar la idea de stealth issue advocacy?"),
            answerKey = listOf("El Science Arbiter responde preguntas empíricas delimitadas; el Honest Broker organiza alternativas de política y sus consecuencias.", "Busca reducirlo defendiendo una opción o un subconjunto de opciones.", "Porque describen modos de actuación; una misma persona puede aproximarse a roles distintos según el contexto y momento.", "Que un experto puede presentarse como neutral mientras la selección de evidencia, preguntas o marcos favorece implícitamente una alternativa."),
            synthesisPrompt = "Explica los cuatro roles usando una sola pregunta política y muestra cómo cambia la conducta del experto en cada rol.",
            modelSynthesis = "Ante una misma decisión, el Pure Scientist ofrece conocimiento sin entrar a la elección; el Science Arbiter responde preguntas factuales específicas; el Issue Advocate recomienda y defiende una alternativa; el Honest Broker ordena y amplía opciones y consecuencias para que la autoridad decida. La diferencia central es la relación entre expertise y espacio de elección."
        ),
        GuidedReadingPlan(
            id = 4,
            readingId = 4,
            durationMinutes = 15,
            orientation = "Usa el policy process model como una herramienta analítica, no como una cronología rígida. Debes poder definir las seis etapas y, al mismo tiempo, explicar por qué se superponen o retroalimentan.",
            focusSteps = listOf("Agenda setting: cómo un problema es definido, adquiere atención y entra a la agenda política.", "Policy formulation: diseño de objetivos, instrumentos y estrategias.", "Policy legitimation: construcción de autoridad y apoyo suficiente para adoptar la política.", "Implementation: traducción de la decisión en acciones, reglas, capacidades y prácticas administrativas.", "Evaluation: valoración de resultados, efectos, costos, legitimidad y consecuencias esperadas o no.", "Policy change: revisión, ajuste, reemplazo o terminación; recuerda que el ciclo es continuo y las etapas pueden solaparse o saltarse."),
            selfTest = listOf("¿Por qué Kraft y Furlong hablan de ciclo y no de una secuencia única?", "¿Qué diferencia agenda setting de formulation?", "¿Qué diferencia legitimation de implementation?", "¿Dónde puede entrar evidencia científica en el modelo?"),
            answerKey = listOf("Porque ninguna decisión es final: cambian condiciones, información, evaluaciones y opiniones, y las etapas pueden superponerse o incluso omitirse.", "Agenda setting trata de definir y priorizar el problema; formulation diseña objetivos y estrategias para responderlo.", "Legitimation da autoridad y apoyo a la decisión; implementation convierte esa decisión en ejecución administrativa y práctica.", "Potencialmente en todas las etapas: definición del problema, diseño, legitimación, implementación, evaluación y cambio."),
            synthesisPrompt = "Aplica las seis etapas a un caso del curso sin forzar una cronología perfecta.",
            modelSynthesis = "El modelo sirve para ordenar funciones del proceso, no para afirmar que todos los casos avanzan linealmente. En regulación térmica, por ejemplo, evidencia y formulación reaparecen en distintas fases, la implementación se retrasa y la evaluación de estándares alimenta cambios posteriores. Eso ilustra precisamente el carácter cíclico y superpuesto del proceso."
        ),
        GuidedReadingPlan(
            id = 5,
            readingId = 5,
            durationMinutes = 15,
            orientation = "El argumento central de Leshner es contraintuitivo: que una persona no siga una recomendación científica no demuestra por sí solo falta de confianza en la ciencia.",
            focusSteps = listOf("Distingue confianza/confidence de obediencia a recomendaciones: no son equivalentes.", "Recuerda que decisiones públicas combinan hechos con valores, intereses y experiencia; la evidencia no monopoliza la decisión.", "Estudia incertidumbre y revisión como rasgos normales de la ciencia que pueden ser interpretados por públicos no expertos como debilidad.", "Ubica disonancia cognitiva y sesgos de confirmación, grupo y statu quo como mecanismos que pueden desplazar evidencia.", "Contrasta modelo de déficit con public engagement: explicar más no basta; se requiere diálogo, escucha, adaptación a la audiencia y comunicación honesta de incertidumbre."),
            selfTest = listOf("¿Por qué no seguir una recomendación no equivale automáticamente a desconfiar de la ciencia?", "¿Qué problema tiene el modelo de déficit?", "¿Qué papel cumplen valores y sesgos en la recepción de evidencia?", "Nombra dos principios de public engagement propuestos por Leshner."),
            answerKey = listOf("Porque la decisión incorpora otras entradas además de ciencia: valores, intereses, experiencia, creencias y consideraciones políticas.", "Asume que el desacuerdo deriva principalmente de ignorancia y que más información resolverá el problema, algo que el autor considera insuficiente.", "Pueden orientar qué información se acepta, cómo se interpreta y qué conflicto se resuelve a favor de creencias previas o grupos de pertenencia.", "Escucha y diálogo genuino; reconocer incertidumbre sin exagerar; adaptar la estrategia a la audiencia; usar grupos pequeños; hacer la ciencia localmente significativa."),
            synthesisPrompt = "Explica por qué “más información” puede fracasar y qué alternativa propone Leshner.",
            modelSynthesis = "Más información puede fracasar porque desacuerdo y conducta no dependen sólo de conocimiento factual: intervienen valores, identidades, sesgos y la forma en que se percibe la incertidumbre científica. Leshner propone pasar del modelo de déficit a un engagement bidireccional basado en escucha, credibilidad, adecuación al público y comunicación fiel de lo que se sabe y lo que no."
        ),
        GuidedReadingPlan(
            id = 6,
            readingId = 6,
            durationMinutes = 18,
            orientation = "Lee la revisión sistemática preguntándote dos cosas: qué significa “usar evidencia” en una legislatura y qué condiciones favorecen o dificultan ese uso.",
            focusSteps = listOf("Ubica la base empírica: revisión sistemática de 21 estudios; evita convertir frecuencia de mención en importancia causal.", "Uso instrumental: evidencia facilita una decisión o acción concreta.", "Uso conceptual: cambia comprensión, marcos o reflexión sobre problemas y soluciones.", "Uso simbólico/táctico: evidencia sirve objetivos estratégicos o políticos; fue el tipo observado con mayor frecuencia en los estudios que examinaron usos.", "Añade usos legislativos específicos: preparar preguntas/debates, construir consenso, fact-checking y apoyar trabajo legislativo o de escrutinio.", "Ordena barreras/facilitadores en cuatro familias: institución/organización, características de la investigación, contexto político/de política e individuo."),
            selfTest = listOf("¿Qué diferencia uso instrumental, conceptual y simbólico/táctico?", "¿Qué usos aparecen como particularmente propios del entorno legislativo?", "¿Cuáles son las cuatro familias de factores?", "¿Por qué no debes interpretar “número de estudios que menciona un factor” como medida de su importancia?"),
            answerKey = listOf("Instrumental incide en una acción; conceptual modifica comprensión o reflexión; simbólico/táctico utiliza evidencia para fines estratégicos o políticos.", "Preparar preguntas y debates, ayudar a construir consenso, verificar hechos y apoyar funciones legislativas o de escrutinio.", "Institución y organización; características de la investigación; contexto político y de política; características individuales.", "Porque una revisión de frecuencia de aparición no identifica tamaño de efecto ni peso causal comparable entre factores."),
            synthesisPrompt = "Explica por qué una ley que no copia literalmente una investigación todavía puede mostrar uso de evidencia.",
            modelSynthesis = "Ouimet amplía el concepto de uso más allá del impacto instrumental directo. La investigación puede cambiar cómo se entiende un problema, proveer argumentos, preparar preguntas, facilitar consenso o verificar afirmaciones. Por eso la ausencia de una relación lineal paper→ley no implica ausencia de uso de evidencia."
        ),
        GuidedReadingPlan(
            id = 7,
            readingId = 7,
            durationMinutes = 15,
            orientation = "Estudia Karp como una teoría de la relación entre académico y públicos. La oposición clave es entre “hablar a una audiencia menos sofisticada” y “trabajar con públicos activos y plurales”.",
            focusSteps = listOf("Parte de la tensión entre vocación académica y acción pública: la segunda exige juicio, compromiso y trabajo con consecuencias e intereses.", "Public scholarship no es mera simplificación ni divulgación descendente.", "Los públicos son knowledgeable agents: tienen experiencias, criterios, valores y conocimientos propios.", "El pluralismo obliga a reconocer culturas, estándares y bienes incompatibles o inconmensurables.", "El académico debe sostener fidelidad a estándares disciplinarios mientras cruza fronteras, media y negocia en contextos donde no controla todos los fines."),
            selfTest = listOf("¿Por qué Karp rechaza definir public scholarship como simplificación?", "¿Qué significa tratar a los públicos como agentes conocedores?", "¿Qué exige una concepción pluralista de la sociedad?", "¿Cuál es la tensión entre fidelidad disciplinaria y compromiso público?"),
            answerKey = listOf("Porque supone un público pasivo y deficitario; la práctica pública real implica interacción con actores que ya poseen conocimientos y criterios.", "Reconocer que interpretan, evalúan y producen conocimiento y que no son receptores vacíos de expertise académico.", "Aceptar diversidad e incompatibilidad de valores y estándares, y trabajar entre comunidades sin asumir un único punto de vista dominante.", "Participar públicamente exige negociación y juicio, pero sin abandonar estándares de rigor ni convertir la expertise en autoridad total sobre la decisión."),
            synthesisPrompt = "Compara Karp con Leshner en su concepción del público.",
            modelSynthesis = "Ambos cuestionan un modelo unidireccional. Leshner critica el déficit y propone engagement basado en diálogo y escucha; Karp profundiza el argumento al describir públicos como agentes activos dentro de un mundo plural. En ambos, la eficacia pública del conocimiento requiere interacción, no simple transmisión."
        ),
        GuidedReadingPlan(
            id = 8,
            readingId = 8,
            durationMinutes = 10,
            orientation = "Trata esta lectura como complemento. Su función es mostrar un caso de cooperación ciencia–política internacional, no sustituir los textos y casos centrales del curso.",
            focusSteps = listOf("Identifica la combinación de evidencia científica, instituciones internacionales y cooperación sostenida.", "Observa el diseño incremental: empezar, aprender, revisar y aumentar ambición.", "Relaciona evaluaciones periódicas y monitoreo con aprendizaje y policy change.", "Distingue cooperación, financiamiento y cumplimiento como condiciones institucionales adicionales a la evidencia.", "Evita trasladar mecánicamente el caso al cambio climático: el editorial subraya diferencias estructurales de escala económica e intereses."),
            selfTest = listOf("¿Qué elementos, además de ciencia, sostuvieron la cooperación sobre ozono?", "¿Qué significa aprender haciendo en este caso?", "¿Por qué el editorial advierte contra copiar mecánicamente el modelo al cambio climático?"),
            answerKey = listOf("Diseño institucional, cooperación, financiamiento, monitoreo de cumplimiento, participación industrial y confianza.", "Adoptar medidas, revisar conocimiento y tecnología periódicamente y escalar la ambición a partir de experiencia acumulada.", "Porque los combustibles fósiles tienen una centralidad económica y distributiva mucho mayor, por lo que intereses y costos de transición son distintos."),
            synthesisPrompt = "Resume qué enseña el caso del ozono sobre la relación entre evidencia e instituciones.",
            modelSynthesis = "El caso muestra que evidencia sólida puede ser decisiva, pero necesita instituciones que conviertan conocimiento en cooperación, monitoreo, financiamiento y ajuste continuo. El éxito no deriva de ciencia sola ni es automáticamente transferible a otros problemas."
        )
    )

    val conceptCards = listOf(
        ConceptStudyCard(
            id = 1, moduleId = 1, name = "Needfinding", author = "Garretón et al.",
            definition = "Proceso de descubrimiento y definición de necesidades de usuarios antes de diseñar una solución.",
            distinction = "No es una encuesta de satisfacción ni una fase de comunicación posterior; antecede al diseño y busca comprender experiencias, fricciones y objetivos.",
            mechanism = "Observa actores y trayectorias, valida problemas y traduce hallazgos en requerimientos de diseño.",
            caseExample = "Vincula usa talleres, mapa de actores, 3C, customer journey y matrices lógicas para caracterizar oferta y demanda.",
            examUse = "Úsalo para explicar por qué una interfaz ciencia–Congreso debe diseñarse desde necesidades reales y no desde supuestos de la academia.",
            commonError = "Definirlo simplemente como “preguntar qué quiere el usuario”.",
            recallPrompts = listOf("¿Qué ocurre antes y después del needfinding?", "¿Qué problema metodológico evita?"),
            sourceBasis = "Garretón et al. 2020, Diseño de Sistema Vincula: etapa Needfinding."
        ),
        ConceptStudyCard(
            id = 2, moduleId = 1, name = "Oferta y demanda de conocimiento", author = "Garretón et al.",
            definition = "Distinción funcional entre quienes producen/ofrecen conocimiento y quienes lo requieren para tareas parlamentarias.",
            distinction = "No supone un mercado simple ni que ambos lados tengan necesidades ya formuladas con claridad.",
            mechanism = "Permite identificar barreras simétricas y asimétricas: contactos, tiempos, incentivos, formatos, comprensión del proceso y capacidad de traducir preguntas.",
            caseExample = "Académicos aparecen como usuarios foco de oferta; asesores parlamentarios y técnicos, como demanda.",
            examUse = "Sirve para estructurar barreras y diseñar mecanismos de encuentro específicos para cada lado.",
            commonError = "Asumir que la demanda legislativa siempre sabe exactamente qué evidencia necesita.",
            recallPrompts = listOf("Nombra dos barreras de la oferta y dos de la demanda.", "¿Por qué la distinción no implica un modelo lineal?"),
            sourceBasis = "Garretón et al. 2020."
        ),
        ConceptStudyCard(
            id = 3, moduleId = 1, name = "Intermediación y bidireccionalidad", author = "Garretón et al.; Martinuzzi & Sedlacko",
            definition = "Diseño de vínculos que permiten contacto, traducción y retroalimentación entre productores y usuarios de conocimiento.",
            distinction = "No equivale a un canal unidireccional de difusión ni a “mandar papers” al Congreso.",
            mechanism = "La interacción de ida y vuelta permite reformular preguntas, ajustar formatos y construir comprensión mutua.",
            caseExample = "Ley de Suelos: coordinación y brokers jurídicos traducen insumos heterogéneos a un texto procesable.",
            examUse = "Úsalo para explicar por qué las interfaces efectivas requieren relaciones y traducción, no sólo acceso documental.",
            commonError = "Confundir bidireccionalidad con neutralidad o con ausencia de intereses.",
            recallPrompts = listOf("¿Qué cambia cuando la comunicación es bidireccional?", "¿Qué actor puede cumplir una función intermediaria?"),
            sourceBasis = "Vincula; Martinuzzi & Sedlacko."
        ),
        ConceptStudyCard(
            id = 4, moduleId = 1, name = "Knowledge brokerage", author = "Martinuzzi & Sedlacko",
            definition = "Conjunto de procesos que conectan investigación y política mediante intercambio, traducción, relaciones, agendas, comunidades y reframing.",
            distinction = "Es más amplio que transferencia de conocimiento y no garantiza que la evidencia determine la decisión.",
            mechanism = "Trabaja sobre fronteras y formas de interacción para aumentar conectividad entre mundos con racionalidades distintas.",
            caseExample = "Suelos combina redes, brokers, mesas de consenso y traducción jurídica.",
            examUse = "Define primero brokerage y luego muestra qué mecanismo específico opera en el caso.",
            commonError = "Reducirlo a “comunicar resultados científicos de manera simple”.",
            recallPrompts = listOf("¿Qué agrega brokerage a la idea de transferencia?", "Nombra dos formas o juegos de brokerage."),
            sourceBasis = "Martinuzzi & Sedlacko, capítulo final."
        ),
        ConceptStudyCard(
            id = 5, moduleId = 1, name = "Modelo lineal simplificado", author = "Martinuzzi & Sedlacko",
            definition = "Concepción según la cual evidencia correcta, relevante, accesible y oportuna puede transferirse hacia la política y cambiar decisiones.",
            distinction = "Contrasta con sistemas y redes; su problema no es que comunicación sea irrelevante, sino tratarla como explicación suficiente.",
            mechanism = "Prioriza productos y canales para mover información desde investigación hacia decisores.",
            caseExample = "Un policy brief puede mejorar accesibilidad, pero por sí solo no resuelve intereses, tiempos o confianza.",
            examUse = "Úsalo como punto de contraste: “necesario pero insuficiente”.",
            commonError = "Caricaturizarlo como completamente inútil; los autores critican su simplificación, no la necesidad de comunicar bien.",
            recallPrompts = listOf("¿Qué supuesto causal hace el modelo?", "¿Qué variables deja fuera?"),
            sourceBasis = "Martinuzzi & Sedlacko."
        ),
        ConceptStudyCard(
            id = 6, moduleId = 1, name = "Teoría de sistemas", author = "Martinuzzi & Sedlacko",
            definition = "Lectura en la que ciencia y política son sistemas autorreferenciales con códigos y comunicaciones propios.",
            distinction = "Ciencia prioriza verdad; política, poder y legitimidad. No es lo mismo que decir que “los políticos no entienden ciencia”.",
            mechanism = "La diferencia de códigos impone límites estructurales a la traducción directa entre sistemas.",
            caseExample = "En Neuroderechos, una afirmación científica debe convertirse también en argumento jurídico y políticamente legítimo.",
            examUse = "Úsala para explicar por qué incluso evidencia clara necesita traducción institucional.",
            commonError = "Usar la teoría para concluir que toda intermediación es imposible; el libro muestra que, en la práctica, existen formas de conexión.",
            recallPrompts = listOf("¿Cuáles son los códigos centrales?", "¿Qué explica mejor esta perspectiva que el modelo lineal?"),
            sourceBasis = "Martinuzzi & Sedlacko."
        ),
        ConceptStudyCard(
            id = 7, moduleId = 1, name = "Enfoque de redes", author = "Martinuzzi & Sedlacko",
            definition = "Concepción de la interfaz ciencia–política basada en interacción sostenida, confianza, aprendizaje mutuo y actores/organizaciones intermediarias.",
            distinction = "No elimina diferencias entre ciencia y política; busca aumentar conectividad entre ellas.",
            mechanism = "Relaciones repetidas permiten conocer contextos, racionalidades e intereses y facilitan co-creación.",
            caseExample = "Regulación térmica: décadas de relación entre academia, MINVU, técnicos e industria.",
            examUse = "Es el concepto central para explicar incidencia acumulativa y de largo plazo.",
            commonError = "Confundir red con una lista de contactos; importan estabilidad, confianza y procesos de interacción.",
            recallPrompts = listOf("¿Qué recursos relacionales produce una red?", "¿Por qué requiere inversión sostenida?"),
            sourceBasis = "Martinuzzi & Sedlacko."
        ),
        ConceptStudyCard(
            id = 8, moduleId = 1, name = "Boundary work", author = "Martinuzzi & Sedlacko",
            definition = "Trabajo realizado en la frontera entre ciencia y política mediante formatos, actores y estructuras que permiten interacción sin fusionar ambos mundos.",
            distinction = "No significa borrar la frontera ni convertir científicos en autoridades políticas.",
            mechanism = "Crea espacios donde preguntas, evidencia, restricciones y opciones pueden ser traducidas y negociadas.",
            caseExample = "Mesas de trabajo y comité editor en Suelos funcionan como espacios de frontera.",
            examUse = "Úsalo para identificar dónde y cómo ocurre la interacción concreta.",
            commonError = "Usarlo como sinónimo genérico de “trabajo interdisciplinario”.",
            recallPrompts = listOf("¿Qué frontera se está gestionando?", "¿Qué dispositivo del caso actúa como espacio de frontera?"),
            sourceBasis = "Martinuzzi & Sedlacko."
        ),
        ConceptStudyCard(
            id = 9, moduleId = 2, name = "Pure Scientist", author = "Roger Pielke Jr.",
            definition = "Rol ideal que produce conocimiento sin vincularse directamente con una decisión específica ni con su uso político.",
            distinction = "Se diferencia del Science Arbiter porque no responde preguntas concretas de decisores en un contexto de decisión.",
            mechanism = "Contribuye al stock de conocimiento y deja a otros la conexión con alternativas de política.",
            caseExample = "Un investigador publica resultados sobre humedales sin participar en comisiones ni asesorar una decisión concreta.",
            examUse = "Úsalo para marcar el extremo de menor involucramiento con la decisión.",
            commonError = "Llamarlo “neutral” en sentido absoluto; la tipología describe relación con la decisión, no ausencia de valores humanos.",
            recallPrompts = listOf("¿Qué relación tiene con la decisión?", "¿En qué se diferencia del Science Arbiter?"),
            sourceBasis = "Pielke 2007, The Honest Broker, cap. 1."
        ),
        ConceptStudyCard(
            id = 10, moduleId = 2, name = "Science Arbiter", author = "Roger Pielke Jr.",
            definition = "Rol que responde preguntas factuales delimitadas planteadas por decisores sin indicar qué alternativa deberían preferir.",
            distinction = "A diferencia del Honest Broker, no organiza el conjunto de opciones de política; responde cuestiones empíricas específicas.",
            mechanism = "Reduce incertidumbre factual cuando una pregunta puede ser tratada con expertise.",
            caseExample = "Una comisión pregunta qué efectos térmicos produce cierto estándar y el experto responde dentro de la evidencia disponible.",
            examUse = "Úsalo cuando la consulta sea “qué sabemos” más que “qué debemos hacer”.",
            commonError = "Convertir cualquier asesoría científica en Science Arbiter aunque incluya recomendación normativa.",
            recallPrompts = listOf("¿Qué tipo de pregunta responde?", "¿Qué evita hacer respecto de preferencias?"),
            sourceBasis = "Pielke 2007."
        ),
        ConceptStudyCard(
            id = 11, moduleId = 2, name = "Issue Advocate", author = "Roger Pielke Jr.",
            definition = "Rol en que el experto defiende una alternativa o un conjunto restringido de opciones y busca reducir el espacio de elección.",
            distinction = "Se diferencia del Honest Broker por la dirección del efecto sobre opciones: reduce en vez de expandir/clarificar.",
            mechanism = "Usa conocimiento y argumentación para persuadir a favor de una decisión.",
            caseExample = "Un experto sostiene públicamente que una única solución regulatoria debe adoptarse y argumenta contra alternativas.",
            examUse = "Úsalo sin carga peyorativa: es un rol legítimo cuando se hace explícito.",
            commonError = "Equipararlo automáticamente con manipulación o mala ciencia.",
            recallPrompts = listOf("¿Qué hace con el rango de opciones?", "¿Cuándo puede ser transparente y legítimo?"),
            sourceBasis = "Pielke 2007."
        ),
        ConceptStudyCard(
            id = 12, moduleId = 2, name = "Honest Broker of Policy Alternatives", author = "Roger Pielke Jr.",
            definition = "Rol que expande o clarifica alternativas y consecuencias para que el decisor reduzca opciones según sus propios valores y preferencias.",
            distinction = "No es “el experto neutral que decide correctamente”; preserva la elección política al organizar posibilidades.",
            mechanism = "Hace visibles opciones, trade-offs y consecuencias relevantes.",
            caseExample = "En Neuroderechos, un experto podría exponer alternativas regulatorias y riesgos sin convertir su preferencia en la única salida.",
            examUse = "Úsalo para discutir cómo expertise puede informar decisiones cargadas de valores sin sustituir al decisor.",
            commonError = "Definirlo como alguien que simplemente “dice la verdad”.",
            recallPrompts = listOf("¿Qué hace con el espacio de elección?", "¿Qué papel conservan los valores del decisor?"),
            sourceBasis = "Pielke 2007."
        ),
        ConceptStudyCard(
            id = 13, moduleId = 2, name = "Stealth issue advocacy", author = "Roger Pielke Jr.",
            definition = "Situación en que un experto aparenta limitarse a información neutral pero selecciona preguntas, marcos o evidencia de modo que empuja implícitamente una alternativa.",
            distinction = "Se distingue del Issue Advocate explícito porque la advocacy no se reconoce abiertamente.",
            mechanism = "La selección de qué evidencia cuenta y qué alternativas se omiten puede estrechar decisiones sin declararlo.",
            caseExample = "Presentar sólo riesgos de una opción y no de sus alternativas bajo la etiqueta de “hechos” puede producir este efecto.",
            examUse = "Úsalo para analizar tensiones entre autoridad experta y transparencia del rol.",
            commonError = "Acusarlo sin evidencia; es un riesgo conceptual, no una etiqueta que deba aplicarse automáticamente.",
            recallPrompts = listOf("¿Por qué “stealth”?", "¿Qué conducta concreta podría revelar el problema?"),
            sourceBasis = "Pielke 2007."
        ),
        ConceptStudyCard(
            id = 14, moduleId = 3, name = "Policy cycle", author = "Kraft & Furlong",
            definition = "Modelo que organiza el proceso de política pública en seis etapas analíticas conectadas y continuas.",
            distinction = "No es una descripción rígida ni necesariamente cronológica; las etapas pueden superponerse o saltarse.",
            mechanism = "Permite ubicar funciones, actores y momentos donde información y decisiones interactúan.",
            caseExample = "Regulación térmica atraviesa formulación, implementación, evaluación y cambio en varias rondas.",
            examUse = "Úsalo como mapa analítico y explicita sus límites de linealidad.",
            commonError = "Contar un caso como si cada etapa ocurriera una sola vez y en orden perfecto.",
            recallPrompts = listOf("¿Cuáles son las seis etapas?", "¿Por qué es un ciclo?"),
            sourceBasis = "Kraft & Furlong 2018."
        ),
        ConceptStudyCard(
            id = 15, moduleId = 3, name = "Agenda setting", author = "Kraft & Furlong",
            definition = "Etapa en que problemas son percibidos, definidos, ganan atención e ingresan a la agenda política.",
            distinction = "No es todavía diseñar la solución; eso corresponde a formulation.",
            mechanism = "La definición del problema condiciona qué causas y soluciones parecen plausibles.",
            caseExample = "Humedales: investigación, visibilidad pública y emprendimiento político contribuyen a convertir un problema territorial en asunto legislativo.",
            examUse = "Úsalo para explicar cómo un problema llega a ser políticamente tratable.",
            commonError = "Reducir agenda setting a “poner un tema en una tabla”.",
            recallPrompts = listOf("¿Qué dos operaciones incluye además de atención?", "¿Cómo influye la definición en soluciones?"),
            sourceBasis = "Kraft & Furlong 2018."
        ),
        ConceptStudyCard(
            id = 16, moduleId = 3, name = "Policy formulation", author = "Kraft & Furlong",
            definition = "Diseño y redacción de objetivos, instrumentos y estrategias para enfrentar un problema público.",
            distinction = "Se diferencia de agenda setting porque trabaja sobre soluciones, y de legitimation porque aún no trata principalmente de autoridad/apoyo para adoptar.",
            mechanism = "Convierte diagnóstico en alternativas y diseños concretos sujetos a información, factibilidad e intereses.",
            caseExample = "Suelos: mesas de trabajo y comité editor transforman conocimiento y consensos en un texto legislativo.",
            examUse = "Úsalo cuando el caso muestre diseño, articulado, estándares o alternativas de política.",
            commonError = "Confundir cualquier producción de evidencia con formulación.",
            recallPrompts = listOf("¿Qué producto típico emerge de formulation?", "¿Qué la separa de legitimation?"),
            sourceBasis = "Kraft & Furlong 2018."
        ),
        ConceptStudyCard(
            id = 17, moduleId = 3, name = "Policy legitimation", author = "Kraft & Furlong",
            definition = "Proceso por el cual una política adquiere autoridad, aprobación y apoyo suficientes para ser adoptada.",
            distinction = "No es sinónimo de evidencia científica ni de implementación administrativa.",
            mechanism = "Opera mediante instituciones, votaciones, procedimientos, coaliciones y argumentos de legitimidad.",
            caseExample = "Humedales: la evidencia entra a una tramitación que requiere acuerdos, indicaciones y decisión legislativa.",
            examUse = "Úsalo para mostrar por qué conocimiento no sustituye autorización política.",
            commonError = "Presentar legitimidad como si fuera una propiedad técnica de la evidencia.",
            recallPrompts = listOf("¿Qué necesita una propuesta además de estar bien diseñada?", "¿Qué actores suelen ser centrales?"),
            sourceBasis = "Kraft & Furlong 2018."
        ),
        ConceptStudyCard(
            id = 18, moduleId = 3, name = "Policy implementation", author = "Kraft & Furlong",
            definition = "Conversión de una política adoptada en reglas, capacidades, decisiones administrativas y prácticas efectivas.",
            distinction = "Aprobación no equivale a implementación; entre ambas pueden existir demoras, capacidades limitadas y reinterpretaciones.",
            mechanism = "Agencias y organizaciones traducen objetivos generales a acciones y procedimientos.",
            caseExample = "Regulación térmica: publicación de estándares y entrada en vigencia muestran que el impacto depende de la ejecución posterior.",
            examUse = "Úsalo para evitar terminar el análisis cuando se aprueba una ley o norma.",
            commonError = "Asumir que promulgación = resultados.",
            recallPrompts = listOf("¿Qué ocurre entre adopción e impacto?", "¿Qué tipos de problemas pueden aparecer?"),
            sourceBasis = "Kraft & Furlong 2018."
        ),
        ConceptStudyCard(
            id = 19, moduleId = 3, name = "Policy evaluation", author = "Kraft & Furlong",
            definition = "Valoración de si una política o programa funciona, logra objetivos, genera efectos no previstos y justifica sus costos o legitimidad.",
            distinction = "No es sólo evaluación técnica; también incluye juicios políticos sobre valor y continuidad.",
            mechanism = "Resultados y nueva información alimentan aprendizaje y decisiones posteriores.",
            caseExample = "Mediciones de desempeño térmico permiten valorar estándares y justificar ajustes.",
            examUse = "Úsalo para conectar evidencia posterior a la adopción con policy change.",
            commonError = "Reducir evaluación a un indicador único de éxito.",
            recallPrompts = listOf("¿Qué preguntas hace la evaluación?", "¿Cómo se conecta con cambio?"),
            sourceBasis = "Kraft & Furlong 2018."
        ),
        ConceptStudyCard(
            id = 20, moduleId = 3, name = "Policy change", author = "Kraft & Furlong",
            definition = "Revisión, ajuste, reemplazo o terminación de políticas a partir de nuevas condiciones, información, evaluaciones u opiniones.",
            distinction = "No es una etapa “final” definitiva; puede reiniciar el ciclo.",
            mechanism = "Retroalimenta agenda, formulación e implementación.",
            caseExample = "Regulación térmica avanza por sucesivas fases y actualizaciones de estándares.",
            examUse = "Úsalo para casos con trayectoria larga y regulación incremental.",
            commonError = "Tratar policy change como sinónimo de fracaso de la política anterior.",
            recallPrompts = listOf("¿Qué puede gatillar cambio?", "¿Por qué reabre el ciclo?"),
            sourceBasis = "Kraft & Furlong 2018."
        ),
        ConceptStudyCard(
            id = 21, moduleId = 3, name = "Confianza no equivale a obediencia", author = "Alan Leshner",
            definition = "Distinción según la cual una persona puede confiar o tener confianza en científicos y, aun así, no seguir una recomendación concreta.",
            distinction = "Evita inferir “desconfianza en la ciencia” desde cualquier desacuerdo o conducta.",
            mechanism = "Las decisiones incorporan hechos junto con valores, intereses, experiencia y política.",
            caseExample = "Un actor puede aceptar evidencia de riesgo y aun preferir otra política por costos, valores o prioridades distintas.",
            examUse = "Úsalo para separar evaluación de credibilidad científica y elección política.",
            commonError = "Diagnosticar automáticamente falta de confianza cuando alguien no adopta una recomendación.",
            recallPrompts = listOf("¿Qué otras entradas participan en una decisión?", "¿Qué inferencia rechaza Leshner?"),
            sourceBasis = "Leshner 2021."
        ),
        ConceptStudyCard(
            id = 22, moduleId = 3, name = "Hechos y valores", author = "Alan Leshner; conexión con Pielke",
            definition = "Idea de que decisiones públicas rara vez se basan sólo en ciencia; combinan evidencia con valores, intereses y experiencia.",
            distinction = "No implica relativizar los hechos ni sostener que cualquier afirmación factual vale igual.",
            mechanism = "La ciencia informa consecuencias y estados del mundo, mientras la elección entre objetivos incorpora juicios normativos y políticos.",
            caseExample = "Neuroderechos combina evidencia sobre capacidades tecnológicas con decisiones sobre privacidad, autonomía y diseño constitucional.",
            examUse = "Úsalo para explicar por qué expertise es necesaria pero no suficiente.",
            commonError = "Usar “hay valores” para negar la relevancia de evidencia establecida.",
            recallPrompts = listOf("¿Qué puede informar la ciencia y qué no decide por sí sola?", "¿Cómo se conecta con Honest Broker?"),
            sourceBasis = "Leshner 2021; Pielke 2007."
        ),
        ConceptStudyCard(
            id = 23, moduleId = 3, name = "Incertidumbre científica", author = "Alan Leshner",
            definition = "Reconocimiento de que evidencia y teorías pueden contener incertidumbre, desacuerdo o revisión sin dejar de constituir conocimiento válido.",
            distinction = "Incertidumbre no equivale a ignorancia total ni a ausencia de consenso.",
            mechanism = "La percepción pública de cambios científicos puede interpretarlos como falta de autoridad, por lo que comunicar grados de certeza es parte de la credibilidad.",
            caseExample = "Neuroderechos enfrenta tecnologías emergentes donde riesgos futuros son discutidos bajo incertidumbre.",
            examUse = "Úsalo para explicar tensiones entre ciencia en evolución y decisiones que no pueden esperar certeza absoluta.",
            commonError = "Presentar toda incertidumbre como razón para no decidir.",
            recallPrompts = listOf("¿Por qué revisar una teoría no prueba incompetencia?", "¿Cómo debe comunicarse incertidumbre?"),
            sourceBasis = "Leshner 2021."
        ),
        ConceptStudyCard(
            id = 24, moduleId = 3, name = "Disonancia cognitiva y sesgos", author = "Alan Leshner",
            definition = "Mecanismos psicológicos que influyen en cómo personas procesan información que entra en tensión con creencias, identidad o statu quo.",
            distinction = "No son equivalentes a ignorancia ni constituyen una explicación total de toda discrepancia.",
            mechanism = "La tensión se puede resolver favoreciendo información familiar; sesgos de confirmación, grupo y statu quo orientan atención y aceptación.",
            caseExample = "Una audiencia puede descartar evidencia de un experto externo y privilegiar una fuente de su propio grupo.",
            examUse = "Úsalo para mostrar por qué corregir datos no garantiza cambio de conducta.",
            commonError = "Etiquetar a quien discrepa como “sesgado” sin analizar contexto ni evidencia.",
            recallPrompts = listOf("Nombra tres sesgos mencionados.", "¿Qué diferencia disonancia de déficit informativo?"),
            sourceBasis = "Leshner 2021."
        ),
        ConceptStudyCard(
            id = 25, moduleId = 3, name = "Modelo de déficit", author = "Alan Leshner",
            definition = "Supuesto de que el desacuerdo público con ciencia se debe principalmente a falta de conocimiento y se corrige entregando más información.",
            distinction = "Se contrapone al engagement, que reconoce valores, identidades, conocimientos previos y necesidad de diálogo.",
            mechanism = "Produce estrategias unidireccionales de educación que pueden fallar cuando el problema no es factual.",
            caseExample = "Una charla que sólo agrega datos sin escuchar preocupaciones de una comunidad reproduce el modelo.",
            examUse = "Úsalo para criticar explicaciones comunicacionales demasiado simples.",
            commonError = "Decir que educación nunca importa; Leshner señala que cierto conocimiento mínimo es necesario, pero insuficiente.",
            recallPrompts = listOf("¿Cuál es su supuesto causal?", "¿Qué alternativa propone Leshner?"),
            sourceBasis = "Leshner 2021."
        ),
        ConceptStudyCard(
            id = 26, moduleId = 3, name = "Public engagement", author = "Alan Leshner",
            definition = "Estrategia de diálogo genuino entre comunidad científica y públicos basada en escucha, adaptación, credibilidad y trabajo conjunto.",
            distinction = "No es marketing ni divulgación con una ronda final de preguntas.",
            mechanism = "La bidireccionalidad permite comprender valores y marcos de la audiencia, ajustar comunicación y construir terreno común.",
            caseExample = "Pequeños grupos, demostraciones, escucha y reconocimiento explícito de incertidumbre son principios sugeridos por Leshner.",
            examUse = "Úsalo junto a Karp para sostener una concepción activa del público.",
            commonError = "Presentarlo como técnica para manipular o “convencer mejor” a cualquier costo.",
            recallPrompts = listOf("¿Qué hace que el engagement sea genuino?", "¿Qué papel tiene la credibilidad?"),
            sourceBasis = "Leshner 2021."
        ),
        ConceptStudyCard(
            id = 27, moduleId = 4, name = "Uso instrumental de evidencia", author = "Ouimet et al.",
            definition = "Uso de investigación para facilitar una decisión, acción o tarea concreta.",
            distinction = "Se diferencia del uso conceptual, que cambia comprensión sin traducirse necesariamente en una acción inmediata.",
            mechanism = "La evidencia entra directamente en una elección, diseño, enmienda o trabajo legislativo.",
            caseExample = "Un estudio sustenta un cambio específico en un estándar o una indicación legislativa.",
            examUse = "Úsalo cuando puedas mostrar vínculo concreto entre evidencia y acción, sin asumir causalidad exclusiva.",
            commonError = "Llamar instrumental a cualquier mención de un estudio.",
            recallPrompts = listOf("¿Qué evidencia mostraría un uso instrumental?", "¿Qué lo distingue del conceptual?"),
            sourceBasis = "Ouimet et al. 2023."
        ),
        ConceptStudyCard(
            id = 28, moduleId = 4, name = "Uso conceptual de evidencia", author = "Ouimet et al.",
            definition = "Uso que modifica comprensión, reflexión o encuadre de un problema o solución.",
            distinction = "Puede existir aunque no haya una decisión inmediata ni una cita textual en una ley.",
            mechanism = "La investigación cambia preguntas, categorías o percepción de causalidad de los actores.",
            caseExample = "Humedales: conocimiento experto puede transformar cómo se entiende el valor y la vulnerabilidad de estos ecosistemas.",
            examUse = "Úsalo para captar influencia difusa y acumulativa.",
            commonError = "Considerarlo un impacto “menor” sólo porque no produce una decisión inmediata.",
            recallPrompts = listOf("¿Cómo observarías empíricamente uso conceptual?", "¿Puede coexistir con uso instrumental?"),
            sourceBasis = "Ouimet et al. 2023."
        ),
        ConceptStudyCard(
            id = 29, moduleId = 4, name = "Uso simbólico o táctico", author = "Ouimet et al.",
            definition = "Uso de evidencia para alcanzar objetivos estratégicos o políticos, como justificar, persuadir, sostener una posición o disputar argumentos.",
            distinction = "No es necesariamente uso falso de evidencia; describe la función que cumple en el contexto político.",
            mechanism = "La investigación aporta autoridad o recursos argumentativos dentro de competencia y deliberación.",
            caseExample = "Un parlamentario cita un estudio para reforzar una posición en debate.",
            examUse = "Úsalo para mostrar que el uso legislativo de investigación puede ser político sin dejar de ser uso.",
            commonError = "Convertir “simbólico” en sinónimo de irrelevante o fraudulento.",
            recallPrompts = listOf("¿Qué objetivo persigue este uso?", "¿Por qué es especialmente plausible en legislaturas?"),
            sourceBasis = "Ouimet et al. 2023."
        ),
        ConceptStudyCard(
            id = 30, moduleId = 4, name = "Usos específicos de legislaturas", author = "Ouimet et al.",
            definition = "Funciones de evidencia observadas en trabajo parlamentario, como preparar preguntas y debates, construir consenso, verificar hechos y apoyar escrutinio o elaboración legislativa.",
            distinction = "Amplían la tipología general de instrumental/conceptual/simbólico al contexto institucional del Parlamento.",
            mechanism = "La evidencia puede servir a tareas procedimentales y deliberativas, no sólo a elegir una política final.",
            caseExample = "Suelos: información técnica contribuye a construir consenso y preparar un texto común.",
            examUse = "Úsalo cuando la pregunta enfatice Congreso o comisión legislativa.",
            commonError = "Buscar sólo “impacto en la ley aprobada” y perder usos previos o laterales.",
            recallPrompts = listOf("Nombra tres usos legislativos específicos.", "¿Qué muestra esto sobre la idea de impacto?"),
            sourceBasis = "Ouimet et al. 2023."
        ),
        ConceptStudyCard(
            id = 31, moduleId = 4, name = "Cuatro familias de barreras y facilitadores", author = "Ouimet et al.",
            definition = "Clasificación de factores que afectan uso de evidencia: institución/organización; características de la investigación; contexto político/de política; características individuales.",
            distinction = "No es un ranking causal ni una lista exhaustiva de variables con igual peso.",
            mechanism = "Permite ordenar mecanismos desde reglas y relaciones institucionales hasta formato de evidencia, controversia política y capacidades personales.",
            caseExample = "Vincula puede releerse con estas cuatro familias: redes y apoyo institucional, formatos, contexto legislativo y habilidades/actitudes.",
            examUse = "Úsalo como matriz para analizar sistemáticamente un caso.",
            commonError = "Afirmar que el factor más mencionado en estudios es necesariamente el más importante.",
            recallPrompts = listOf("¿Cuáles son las cuatro familias?", "Da un ejemplo de cada una."),
            sourceBasis = "Ouimet et al. 2023."
        ),
        ConceptStudyCard(
            id = 32, moduleId = 5, name = "Public scholarship", author = "Ivan Karp",
            definition = "Práctica académica orientada a trabajar con públicos y problemas sociales manteniendo fidelidad crítica a estándares disciplinares.",
            distinction = "No es mera divulgación ni traducción simplificada para una audiencia supuestamente ignorante.",
            mechanism = "Cruza fronteras institucionales y culturales, combina expertise con escucha, mediación, juicio y responsabilidad pública.",
            caseExample = "Carolina Rojas participa en el proceso de Humedales y aprende códigos políticos fuera de su entorno académico habitual.",
            examUse = "Úsalo para analizar el rol público del académico y sus costos/tensiones.",
            commonError = "Equipararlo automáticamente a advocacy política.",
            recallPrompts = listOf("¿Qué conserva de la vocación académica?", "¿Qué cambia al trabajar públicamente?"),
            sourceBasis = "Karp 2012."
        ),
        ConceptStudyCard(
            id = 33, moduleId = 5, name = "Pluralismo", author = "Ivan Karp",
            definition = "Concepción según la cual la sociedad contiene culturas, valores, bienes y estándares distintos e incluso incompatibles.",
            distinction = "No equivale a relativismo total ni a renunciar a todo juicio.",
            mechanism = "Obliga al public scholar a reconocer múltiples perspectivas y a mediar sin asumir que su cultura disciplinaria agota los criterios legítimos.",
            caseExample = "Neuroderechos reúne neurociencia, derecho, bioética y política con criterios distintos sobre riesgo y derechos.",
            examUse = "Úsalo para explicar por qué la interacción pública exige más que precisión técnica.",
            commonError = "Presentarlo como “todas las posiciones son igualmente correctas”.",
            recallPrompts = listOf("¿Qué reconoce el pluralismo?", "¿Por qué complica la acción pública del académico?"),
            sourceBasis = "Karp 2012."
        ),
        ConceptStudyCard(
            id = 34, moduleId = 5, name = "Públicos como agentes conocedores", author = "Ivan Karp",
            definition = "Idea de que los públicos poseen conocimientos, experiencias, opiniones y criterios propios y participan activamente en interpretación y juicio.",
            distinction = "Contrasta con el público pasivo del modelo de déficit.",
            mechanism = "La interacción cambia de transmisión a colaboración, negociación y reconocimiento de saberes situados.",
            caseExample = "En una discusión territorial, comunidades pueden aportar experiencia local que la investigación académica no contiene por sí sola.",
            examUse = "Úsalo para conectar Karp con Leshner y justificar enfoques bidireccionales.",
            commonError = "Idealizar a los públicos como si toda creencia tuviera la misma base empírica.",
            recallPrompts = listOf("¿Qué cambia en la relación experto–público?", "¿Cómo se diferencia de relativismo?"),
            sourceBasis = "Karp 2012."
        ),
        ConceptStudyCard(
            id = 35, moduleId = 5, name = "Compromiso y juicio público", author = "Ivan Karp",
            definition = "Reconocimiento de que actuar públicamente exige compromiso, negociación y juicio práctico en contextos con fines múltiples y consecuencias inciertas.",
            distinction = "Se diferencia de abandonar rigor: el académico debe negociar sin renunciar a estándares disciplinares.",
            mechanism = "La acción pública transforma conocimiento en decisiones situadas y obliga a considerar factibilidad, representación y consecuencias.",
            caseExample = "Humedales muestra costos y aprendizaje asociados a salir de la academia y entrar a tramitación política.",
            examUse = "Úsalo para analizar la tensión entre vocación científica y acción pública.",
            commonError = "Suponer que compromiso significa acomodar evidencia para agradar a actores políticos.",
            recallPrompts = listOf("¿Qué debe mantenerse sin compromiso?", "¿Qué sí requiere negociación?"),
            sourceBasis = "Karp 2012."
        ),
        ConceptStudyCard(
            id = 36, moduleId = 6, name = "Ventana de oportunidad", author = "Casos del curso",
            definition = "Momento en que condiciones políticas, institucionales o sociales permiten que un problema o propuesta avance con mayor probabilidad.",
            distinction = "No es sinónimo de “momento perfecto” ni explica por sí sola el éxito; requiere actores y preparación previa.",
            mechanism = "Conecta trabajo acumulado con un contexto político favorable que vuelve procesable una agenda.",
            caseExample = "Ley de Suelos: una agenda científica de décadas encuentra una coyuntura y actores capaces de impulsarla.",
            examUse = "Úsalo para explicar timing sin caer en determinismo.",
            commonError = "Atribuir todo el avance a la coyuntura e ignorar redes y trabajo previo.",
            recallPrompts = listOf("¿Qué debe existir antes de que se abra la ventana?", "¿Qué actores la aprovechan?"),
            sourceBasis = "Caso Ley de Suelos."
        ),
        ConceptStudyCard(
            id = 37, moduleId = 6, name = "Broker / intermediario", author = "Martinuzzi & Sedlacko; casos",
            definition = "Actor que conecta mundos, traduce necesidades y lenguajes, coordina relaciones o ayuda a convertir conocimiento en formatos procesables.",
            distinction = "No es necesariamente neutral ni un simple mensajero.",
            mechanism = "Reduce costos de búsqueda y traducción y permite que actores con racionalidades distintas trabajen sobre un objeto común.",
            caseExample = "Suelos: abogados y coordinación cumplen funciones de brokerage al transformar consensos técnico-científicos en lenguaje jurídico.",
            examUse = "Úsalo identificando siempre qué traduce, entre quiénes y con qué efecto.",
            commonError = "Llamar broker a cualquier participante con contactos.",
            recallPrompts = listOf("¿Qué frontera cruza?", "¿Qué producto o relación hace posible?"),
            sourceBasis = "Martinuzzi & Sedlacko; caso Suelos."
        ),
        ConceptStudyCard(
            id = 38, moduleId = 6, name = "Conocimiento con propósito", author = "Caso regulación térmica",
            definition = "Orientación explícita de investigación y expertise hacia un problema público y una trayectoria de cambio institucional.",
            distinction = "No significa que todo conocimiento deba ser aplicado ni que el propósito garantice incidencia.",
            mechanism = "Sostiene investigación, participación normativa y aprendizaje durante periodos largos.",
            caseExample = "Waldo Bustamante combina producción técnica con una misión sostenida de mejorar desempeño térmico de viviendas.",
            examUse = "Úsalo para discutir vocación pública, persistencia y temporalidad de impacto.",
            commonError = "Confundir propósito social con derecho del experto a decidir la política.",
            recallPrompts = listOf("¿Qué diferencia esta orientación de Pure Scientist?", "¿Qué costos puede generar?"),
            sourceBasis = "Caso regulación térmica."
        ),
        ConceptStudyCard(
            id = 39, moduleId = 6, name = "La ciencia es necesaria pero no suficiente", author = "Síntesis transversal del curso",
            definition = "Principio según el cual evidencia puede iluminar problemas y consecuencias, pero las decisiones requieren además legitimidad, valores, recursos, negociación, instituciones y factibilidad.",
            distinction = "No significa que ciencia sea decorativa ni que hechos y opiniones sean equivalentes.",
            mechanism = "La incidencia depende de cómo evidencia interactúa con actores, reglas, intereses, temporalidades y opciones políticas.",
            caseExample = "Regulación térmica: estudios técnicos justifican cambios, pero decisiones finales también responden a costos, industria, prioridades habitacionales y ciclo político.",
            examUse = "Úsalo como tesis integradora para conectar Martinuzzi, Leshner, Pielke, Kraft, Ouimet y los casos.",
            commonError = "Convertirlo en una frase vacía sin especificar qué mecanismo adicional explica el caso.",
            recallPrompts = listOf("¿Qué elementos además de evidencia aparecen en los casos?", "¿Qué autor ayuda a precisar cada elemento?"),
            sourceBasis = "Síntesis de lecturas y casos SUS3021."
        )
    )

    fun planForReading(readingId: Int): GuidedReadingPlan? = readingPlans.firstOrNull { it.readingId == readingId }
}
