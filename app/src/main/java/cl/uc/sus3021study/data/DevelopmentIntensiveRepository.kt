package cl.uc.sus3021study.data

import cl.uc.sus3021study.model.IntensiveDevelopmentQuestion
import cl.uc.sus3021study.model.ProfessorFeedback
import cl.uc.sus3021study.model.TimedModelAnswer
import java.text.Normalizer

object DevelopmentIntensiveRepository {
    val questions: List<IntensiveDevelopmentQuestion> = listOf(
        q(
            101, "Knowledge brokerage", "Del modelo lineal a la interfaz",
            "¿Por qué Martinuzzi y Sedlacko consideran insuficiente una concepción lineal de la relación entre ciencia y política? Explique la alternativa de redes y aplíquela a un caso del curso.",
            "La crítica central es que la evidencia no se transfiere automáticamente a la política: la incidencia depende de interacciones sostenidas, confianza, comprensión mutua e intermediación entre comunidades con racionalidades distintas.",
            listOf("Modelo lineal", "Enfoque de redes", "Knowledge brokerage"),
            listOf("diferencias de racionalidad", "interacciones sostenidas", "confianza", "intermediación"),
            listOf("Ley de Suelos", "Ley de Humedales Urbanos"),
            listOf("Definir el supuesto del modelo lineal.", "Explicar por qué intereses, códigos y contextos rompen esa linealidad.", "Presentar la alternativa de redes.", "Mostrar el mecanismo en Suelos o Humedales."),
            listOf(
                "El modelo lineal supone que la ciencia produce conocimiento correcto y que el principal problema consiste en hacerlo llegar de manera clara, pertinente y oportuna a los decisores. Martinuzzi y Sedlacko consideran ingenua esa expectativa cuando se la toma como explicación general de la incidencia, porque la política no es un receptor neutro de hechos: opera con intereses, restricciones, criterios de legitimidad y temporalidades propias.",
                "El enfoque de redes desplaza la atención desde la transmisión de productos hacia la conectividad entre comunidades. Importan las interacciones formales e informales sostenidas, la confianza acumulada, el aprendizaje mutuo sobre lenguajes y restricciones, y la existencia de intermediarios, actores de frontera u organizaciones que faciliten el intercambio.",
                "La Ley de Suelos ilustra el mecanismo. Una preocupación científica de más de veinte años no produjo automáticamente una ley. El avance exigió una coalición de más de cincuenta especialistas y actores de sociedad civil, coordinación, abogados que cumplieron funciones de brokerage, mesas de trabajo, un comité editor y una metodología explícita para procesar disensos.",
                "La inferencia analítica es que la calidad científica es necesaria pero no suficiente. La evidencia adquiere capacidad de incidencia cuando se vuelve social e institucionalmente utilizable: debe entrar en relaciones de confianza, procesos de traducción y oportunidades políticas que permitan convertir un diagnóstico en alternativas procesables por la decisión pública."
            ),
            listOf("Martinuzzi & Sedlacko, capítulo final", "Caso Ley de Suelos", "Caso Humedales Urbanos"),
            listOf("Reducir la crítica a 'falta de comunicación'.", "Afirmar que las redes garantizan incidencia.", "Describir el caso sin explicar el mecanismo relacional.")
        ),
        q(
            102, "Knowledge brokerage", "Sistemas distintos, conexión posible",
            "Compare la aproximación de sistemas y el enfoque de redes en Martinuzzi y Sedlacko. ¿Qué problema analítico intenta resolver cada uno?",
            "La aproximación de sistemas subraya la autonomía y los códigos distintos de ciencia y política; el enfoque de redes explica cómo, pese a esa diferencia, pueden construirse conexiones parciales mediante relaciones, intermediarios y trabajo de frontera.",
            listOf("Teoría de sistemas", "Enfoque de redes", "Boundary work"),
            listOf("códigos distintos", "conectividad", "traducción parcial", "trabajo de frontera"),
            emptyList(),
            listOf("Identificar los códigos ciencia/política.", "Explicar el límite fuerte de la perspectiva sistémica.", "Mostrar qué agrega la perspectiva de redes.", "Cerrar señalando complementariedad y tensión."),
            listOf(
                "La aproximación inspirada en teoría de sistemas enfatiza que ciencia y política constituyen esferas con lógicas comunicativas diferentes. En el texto, la ciencia se organiza en torno de la verdad, mientras la política se relaciona con poder y legitimidad. Esta diferencia explica por qué no existe una traducción simple entre un resultado científico y una decisión colectiva.",
                "Llevada al extremo, esta perspectiva hace muy difícil explicar la intermediación, porque sistemas autorreferenciales no comparten un código común. Su valor es advertir que no basta con mejorar un informe o acortar un policy brief: existen diferencias estructurales en aquello que cada comunidad considera una comunicación relevante.",
                "El enfoque de redes conserva el reconocimiento de esas diferencias, pero observa procesos sociales que aumentan conectividad: relaciones de largo plazo, confianza, comunidades de práctica, co-creación, intermediarios y boundary organizations. No elimina la diferencia entre ciencia y política; crea condiciones para que puedan interactuar productivamente.",
                "Así, los dos enfoques iluminan dimensiones distintas. El primero explica la dificultad estructural de la interfaz; el segundo permite estudiar empíricamente cómo ciertos arreglos relacionales construyen puentes parciales. Una buena respuesta debe evitar presentar la red como si borrara las diferencias de racionalidad."
            ),
            listOf("Martinuzzi & Sedlacko, capítulo final"),
            listOf("Decir que la teoría de sistemas afirma simplemente que 'no se comunican bien'.", "Confundir red con transferencia lineal más eficiente.")
        ),
        q(
            103, "Knowledge brokerage", "Intermediarios y actores de frontera",
            "Explique por qué los intermediarios y actores de frontera son relevantes en el knowledge brokerage. Utilice Suelos o regulación térmica.",
            "Los intermediarios reducen fricciones de lenguaje, coordinación y temporalidad, pero su función no es transportar datos sin cambio: organizan relaciones y hacen posible que el conocimiento entre en procesos de decisión.",
            listOf("Knowledge brokerage", "Intermediario", "Boundary actor"),
            listOf("traducción", "coordinación", "construcción de confianza", "organización de procesos"),
            listOf("Ley de Suelos", "Regulación térmica"),
            listOf("Definir intermediación.", "Distinguirla de simple mensajería.", "Aplicar al rol de abogados/coordinación en Suelos o de Bustamante en térmica.", "Mostrar límites de la intermediación."),
            listOf(
                "En un enfoque de redes, el intermediario es relevante porque la distancia entre ciencia y política no es sólo informacional. Existen diferencias de lenguaje, tiempos, incentivos y criterios de éxito. Por ello, la interfaz necesita actores que conozcan más de un espacio y puedan sostener la interacción entre ellos.",
                "La intermediación incluye traducir preguntas, ordenar el proceso, conectar personas, anticipar restricciones, generar formatos comprensibles y sostener confianza. No equivale a transportar intacto un dato desde un laboratorio al Congreso; el conocimiento se vuelve utilizable mediante un proceso institucional y relacional.",
                "En Suelos, el propio caso destaca el papel del coordinador general y de abogados entendidos como brokers, dentro de una metodología de consensos con mesas y comité editor. En regulación térmica, Waldo Bustamante aparece como un actor que conecta investigación, parámetros técnicos, MINVU e industria a lo largo de décadas.",
                "El punto no es atribuir todo el resultado a individuos excepcionales. Los intermediarios operan dentro de redes y estructuras de oportunidad. Su contribución es aumentar la capacidad de coordinación y traducción, pero no pueden eliminar por sí solos los conflictos distributivos, las restricciones presupuestarias o la decisión política final."
            ),
            listOf("Martinuzzi & Sedlacko, capítulo final", "Caso Ley de Suelos", "Caso Regulación térmica"),
            listOf("Definir broker como mensajero neutral.", "Personalizar todo el proceso y omitir instituciones.")
        ),
        q(
            104, "Pielke", "Los cuatro roles del experto",
            "Presente los cuatro roles ideales de Pielke y explique qué criterio permite diferenciarlos.",
            "Los roles se distinguen por la relación del experto con una decisión y con el rango de alternativas: producir conocimiento, responder preguntas delimitadas, reducir opciones defendiendo una alternativa o ampliar/clarificar opciones.",
            listOf("Pure Scientist", "Science Arbiter", "Issue Advocate", "Honest Broker"),
            listOf("relación con la decisión", "rango de alternativas", "información", "advocacy"),
            emptyList(),
            listOf("Definir los cuatro tipos.", "Explicar el eje rango de opciones.", "Señalar que son tipos ideales.", "Distinguir información de compromiso con alternativas."),
            listOf(
                "Pielke propone cuatro tipos ideales para ordenar distintas formas de relación entre expertise y decisión. El Pure Scientist se concentra en producir conocimiento sin orientarlo a una decisión particular. El Science Arbiter responde preguntas empíricas delimitadas que surgen de un decisor, pero procura no decirle qué debería preferir.",
                "El Issue Advocate entra explícitamente en el terreno de las alternativas: utiliza su expertise para defender una opción o un conjunto estrecho de opciones, reduciendo el espacio de elección. El Honest Broker of Policy Alternatives también se compromete con una decisión concreta, pero busca ampliar o al menos clarificar el conjunto de opciones y sus consecuencias.",
                "El criterio decisivo es, por tanto, la relación con el rango de elección. Pure Scientist y Science Arbiter funcionan principalmente como recursos de información; Issue Advocate y Honest Broker se ocupan directamente de alternativas. Dentro de este segundo par, uno estrecha y el otro amplía o clarifica opciones.",
                "Las categorías no deben aplicarse como identidades personales fijas. Pielke las presenta como tipos ideales y reconoce un continuo. Un mismo investigador puede desempeñar roles distintos en momentos distintos; lo analíticamente importante es hacer visible qué relación establece con la decisión y con los valores del decisor."
            ),
            listOf("Pielke, The Honest Broker, cap. 1"),
            listOf("Definir Honest Broker como 'neutral'.", "Olvidar al Pure Scientist.", "Tratar los tipos como personalidades permanentes.")
        ),
        q(
            105, "Pielke", "Pure Scientist y Science Arbiter",
            "¿Cuál es la diferencia entre Pure Scientist y Science Arbiter? ¿Por qué no son equivalentes aunque ambos eviten recomendar una opción política?",
            "Ambos evitan prescribir una opción, pero el Science Arbiter entra en una relación directa con una decisión al responder preguntas planteadas por el decisor, mientras el Pure Scientist no organiza su trabajo en torno de esa decisión.",
            listOf("Pure Scientist", "Science Arbiter"),
            listOf("distancia de la decisión", "respuesta a preguntas factuales", "información"),
            emptyList(),
            listOf("Definir Pure Scientist.", "Definir Science Arbiter.", "Identificar la diferencia decisional.", "Mostrar una aplicación breve."),
            listOf(
                "El Pure Scientist y el Science Arbiter comparten una característica: ninguno tiene como rasgo definitorio defender una alternativa normativa específica. Sin embargo, la relación con el proceso de decisión es distinta. El Pure Scientist prioriza la producción de conocimiento y no organiza necesariamente su actividad alrededor de una pregunta concreta del decisor.",
                "El Science Arbiter, en cambio, se acerca a la decisión. Su función es responder preguntas empíricas delimitadas: qué sabemos, con qué evidencia, bajo qué supuestos o con qué incertidumbre. Su pretensión es informar sin sustituir la preferencia del decisor por la del experto.",
                "Por ejemplo, en Neuroderechos un Science Arbiter podría aclarar qué capacidades demostradas tienen determinadas neurotecnologías y qué riesgos están documentados. Un Pure Scientist podría investigar esos mismos fenómenos sin que su trabajo esté estructurado por una decisión legislativa inmediata.",
                "La distinción evita reducir toda participación experta a advocacy. Un investigador puede interactuar intensamente con autoridades y seguir desempeñando una función acotada de arbitraje científico, siempre que no use esa posición para introducir subrepticiamente una preferencia política como si fuera una conclusión empírica."
            ),
            listOf("Pielke, The Honest Broker, cap. 1", "Caso Neuroderechos"),
            listOf("Decir que el Science Arbiter no interactúa con decisores.", "Confundir no recomendar con no tener efectos políticos.")
        ),
        q(
            106, "Pielke", "Issue Advocate y Honest Broker",
            "Compare Issue Advocate y Honest Broker of Policy Alternatives. Aplique la diferencia a una controversia regulatoria del curso.",
            "Ambos se relacionan directamente con alternativas, pero el Issue Advocate busca reducir el rango de opciones defendiendo una preferencia, mientras el Honest Broker busca ampliar o clarificar alternativas para que el decisor elija conforme a sus valores.",
            listOf("Issue Advocate", "Honest Broker"),
            listOf("reducir opciones", "ampliar alternativas", "clarificar consecuencias", "valores del decisor"),
            listOf("Ley de Neuroderechos"),
            listOf("Definir ambos roles.", "Explicar el eje estrechar/ampliar opciones.", "Aplicar a Neuroderechos.", "Evitar confundir broker con neutralidad sin valores."),
            listOf(
                "El Issue Advocate y el Honest Broker comparten una orientación hacia una decisión concreta. La diferencia es qué hacen con el espacio de elección. El Issue Advocate utiliza su conocimiento para construir el caso a favor de una alternativa o de un conjunto estrecho de alternativas, por lo que procura reducir la incertidumbre decisional en una dirección preferida.",
                "El Honest Broker busca una función distinta: ampliar o clarificar el rango de opciones y describir consecuencias, costos, beneficios e incertidumbres, de modo que el decisor pueda reducir la elección de acuerdo con sus propios valores. No significa ausencia de juicio, sino transparencia sobre la relación entre evidencia y alternativas.",
                "En Neuroderechos, un Issue Advocate podría sostener que una protección constitucional específica es la respuesta correcta frente a riesgos emergentes. Un Honest Broker podría ordenar varias arquitecturas posibles —protecciones constitucionales, desarrollo legal, aplicación de derechos existentes u otras combinaciones— y explicar qué problemas intenta resolver cada una.",
                "El caso muestra por qué la distinción importa cuando ciencia, ética y derecho están entrelazados. La evidencia puede delimitar riesgos y capacidades, pero no produce por sí sola una única respuesta normativa. El rol del experto debe hacerse explícito para no confundir una preferencia regulatoria con una conclusión científica necesaria."
            ),
            listOf("Pielke, The Honest Broker, cap. 1", "Caso Neuroderechos"),
            listOf("Definir Honest Broker como alguien que nunca valora nada.", "Presentar una opción política como derivación automática de la ciencia.")
        ),
        q(
            107, "Pielke", "Stealth issue advocacy",
            "¿Qué problema intenta capturar la idea de stealth issue advocacy en Pielke y por qué es relevante para la asesoría científica?",
            "El problema aparece cuando una preferencia política se presenta como si fuera una consecuencia técnica inevitable, ocultando que la selección de preguntas, supuestos o evidencia también puede estrechar alternativas.",
            listOf("Stealth issue advocacy", "Science Arbiter", "Issue Advocate"),
            listOf("ocultar preferencias", "selección de evidencia", "estrechar opciones", "transparencia de rol"),
            emptyList(),
            listOf("Definir el riesgo.", "Mostrar cómo puede ocurrir incluso bajo apariencia informativa.", "Explicar por qué daña claridad de roles.", "Proponer una práctica preventiva."),
            listOf(
                "Pielke advierte que incluso roles que se presentan como puramente informativos pueden deslizarse hacia advocacy. El problema no consiste en que un experto tenga preferencias, sino en que utilice la autoridad de la ciencia para impulsar una opción mientras mantiene la apariencia de que sólo está comunicando hechos.",
                "Ese deslizamiento puede ocurrir por la selección de preguntas, escenarios, umbrales o conjuntos de evidencia que vuelven unas alternativas visibles y otras irrelevantes. Así, el rango de opciones puede estrecharse sin que se reconozca explícitamente que se está haciendo una intervención política.",
                "Para la asesoría científica, la consecuencia es una exigencia de transparencia. Si el experto está respondiendo una pregunta empírica, debe explicitar incertidumbres y límites. Si está defendiendo una opción, conviene reconocer el rol de Issue Advocate en lugar de presentar esa preferencia como mandato de la evidencia.",
                "La utilidad del concepto no es acusar a toda participación experta de manipulación. Es una herramienta para distinguir hechos, supuestos y preferencias, proteger la credibilidad de la interfaz ciencia-política y permitir que el desacuerdo normativo aparezca como tal."
            ),
            listOf("Pielke, The Honest Broker, cap. 1"),
            listOf("Usar el término como acusación moral sin analizar alternativas.", "Asumir que cualquier recomendación experta es encubierta.")
        ),
        q(
            108, "Policy cycle", "Las seis etapas",
            "Explique las seis etapas del policy process model de Kraft y Furlong y la utilidad analítica de distinguirlas.",
            "El modelo separa agenda, formulación, legitimación, implementación, evaluación y cambio para ordenar funciones diferentes del proceso, aunque esas funciones se solapen en la práctica.",
            listOf("Agenda setting", "Formulación", "Legitimación", "Implementación", "Evaluación", "Cambio de política"),
            listOf("definición del problema", "diseño de alternativas", "autorización", "ejecución", "retroalimentación"),
            emptyList(),
            listOf("Nombrar las seis etapas.", "Definir brevemente cada una.", "Explicar para qué sirve la separación.", "Agregar la advertencia de no linealidad."),
            listOf(
                "Kraft y Furlong proponen un modelo de seis etapas. Agenda setting refiere a cómo ciertos problemas son percibidos, definidos y logran atención política. Policy formulation comprende el diseño de objetivos y estrategias. Policy legitimation alude a la obtención de autorización y apoyo institucional suficiente para que una alternativa adquiera estatus de política.",
                "Policy implementation corresponde a la puesta en práctica mediante agencias, reglas, recursos y decisiones administrativas. Policy evaluation examina desempeño, resultados o consecuencias. Finalmente, policy change captura la modificación, reemplazo o reconsideración de políticas existentes a partir de nueva información, cambios de contexto, evaluación o conflicto político.",
                "La utilidad de la clasificación es analítica. Permite preguntar qué actores, tipos de evidencia y mecanismos dominan en distintos momentos. Por ejemplo, evidencia que ayuda a definir la magnitud de un problema puede ser central en agenda, mientras estudios de factibilidad pueden adquirir mayor relevancia durante formulación o implementación.",
                "El modelo no debe convertirse en una cronología rígida. Los propios autores señalan que las etapas pueden solaparse, invertirse u omitirse. Por ello, el ciclo funciona mejor como mapa conceptual para ordenar procesos complejos que como una ley causal universal sobre cómo se hacen las políticas."
            ),
            listOf("Kraft & Furlong, The Policy Process Model"),
            listOf("Omitir policy change.", "Presentar las etapas como secuencia obligatoria.")
        ),
        q(
            109, "Policy cycle", "El ciclo no es una línea recta",
            "¿Por qué el policy cycle debe emplearse como heurística y no como una secuencia cronológica rígida? Ilustre con Suelos.",
            "El ciclo distingue funciones analíticas, pero en procesos reales agenda, formulación y legitimación pueden superponerse y retroalimentarse; Suelos muestra esa interdependencia.",
            listOf("Policy cycle", "No linealidad", "Agenda setting", "Formulación", "Legitimación"),
            listOf("solapamiento", "retroalimentación", "redefinición del problema", "búsqueda de apoyo"),
            listOf("Ley de Suelos"),
            listOf("Explicar la advertencia de Kraft.", "Mostrar solapamientos en Suelos.", "Identificar por qué un ciclo sigue siendo útil.", "Cerrar sin forzar fechas a casilleros rígidos."),
            listOf(
                "Kraft y Furlong hablan de un policy cycle porque las políticas están sometidas a reconsideración continua, pero advierten que las etapas no son compartimentos estancos. En la práctica pueden superponerse o incluso aparecer en un orden distinto del esquema pedagógico.",
                "Suelos muestra esa no linealidad. La definición del problema no terminó antes de la formulación: durante años, eventos científicos, alianzas y trabajo conjunto siguieron refinando qué debía entenderse por protección de los suelos mientras se discutían contenidos normativos.",
                "Tampoco puede separarse completamente formulación de legitimación. Las mesas de consenso, la coordinación con senadores y el trabajo jurídico daban forma al texto al mismo tiempo que construían apoyos y condiciones para que la propuesta fuera políticamente viable.",
                "El ciclo sigue siendo útil porque permite reconocer funciones —definir, diseñar, autorizar, ejecutar, evaluar y revisar— sin exigir que cada una ocupe un período puro. La mejor lectura es heurística: sirve para formular preguntas sobre el proceso, no para obligar al caso a imitar un diagrama."
            ),
            listOf("Kraft & Furlong", "Caso Ley de Suelos"),
            listOf("Asignar cada año del caso a una sola etapa.", "Confundir no linealidad con ausencia total de estructura.")
        ),
        q(
            110, "Policy cycle", "Agenda, formulación y legitimación",
            "Distinga agenda setting, policy formulation y policy legitimation. ¿Cómo pueden interactuar en un proceso legislativo?",
            "Agenda define y prioriza problemas, formulación construye alternativas y legitimación busca autorización y apoyo; en la práctica, cada actividad puede modificar a las otras.",
            listOf("Agenda setting", "Formulación", "Legitimación"),
            listOf("definición del problema", "diseño", "apoyo político", "retroalimentación"),
            listOf("Ley de Suelos", "Ley de Humedales Urbanos"),
            listOf("Definir cada función.", "Evitar equiparar agenda con cronología inicial.", "Mostrar interacción.", "Aplicar a un caso."),
            listOf(
                "Agenda setting se refiere a la forma en que un problema adquiere definición y atención suficiente para entrar en la agenda política. Policy formulation comienza cuando se diseñan objetivos, instrumentos y alternativas. Policy legitimation se refiere a la obtención de autorización, aceptación y apoyo institucional o político para una opción.",
                "La distinción es conceptual, no necesariamente temporal. Una alternativa en formulación puede cambiar la manera en que se entiende el problema; del mismo modo, la necesidad de conseguir apoyo puede obligar a modificar el diseño. La legitimación puede comenzar mucho antes de una votación formal.",
                "En Suelos, la construcción de un diagnóstico científico de larga data convivió con la elaboración de un texto y con esfuerzos para integrar senadores, asesores y sociedad civil. En Humedales, el conocimiento sobre ecosistemas urbanos se conectó con una estrategia parlamentaria y con las negociaciones propias de la tramitación.",
                "La interacción entre las tres funciones ayuda a explicar por qué la incidencia científica no puede evaluarse sólo observando si un estudio aparece citado en la ley. El conocimiento puede contribuir a definir el problema, estructurar alternativas y sostener legitimidad técnica en distintos momentos."
            ),
            listOf("Kraft & Furlong", "Casos Suelos y Humedales"),
            listOf("Definir legitimación como 'comunicar al público'.", "Suponer que agenda termina cuando se presenta un proyecto.")
        ),
        q(
            111, "Leshner", "Confiar no es obedecer",
            "Explique la tesis de Leshner según la cual la confianza en la ciencia no es el problema central. ¿Qué distinción sostiene su argumento?",
            "La confianza general en científicos puede coexistir con rechazo de recomendaciones específicas porque las decisiones combinan evidencia con valores, intereses, experiencia y política.",
            listOf("Confianza", "Aceptación de recomendaciones", "Hechos y valores"),
            listOf("distinción confianza/seguimiento", "valores", "intereses", "experiencia"),
            emptyList(),
            listOf("Distinguir confianza de aceptación.", "Explicar múltiples inputs de decisión.", "Incluir incertidumbre sin convertirla en relativismo.", "Derivar implicancia comunicacional."),
            listOf(
                "Leshner cuestiona el diagnóstico de una caída general de confianza en la ciencia. Su punto central es conceptual: confiar en la competencia o integridad de científicos no equivale a aceptar automáticamente cada recomendación que se formula sobre un problema público.",
                "Las decisiones colectivas y personales se construyen con múltiples insumos. La evidencia científica es uno de ellos, pero también intervienen valores, intereses económicos, experiencia previa, creencias e identidades. Por eso, una discrepancia entre recomendación experta y conducta pública no demuestra por sí sola desconfianza general en la ciencia.",
                "Además, la ciencia trabaja con incertidumbre, desacuerdo y revisión de teorías. Para los científicos esas características forman parte normal del proceso; para audiencias no especializadas pueden interpretarse como señales de debilidad o falta de autoridad si no se comunican adecuadamente.",
                "La implicancia es que una estrategia de comunicación no debe comenzar suponiendo que el receptor carece de respeto por la ciencia. Conviene identificar qué valores, restricciones y preocupaciones estructuran la decisión específica y diseñar un engagement que preserve la precisión sobre lo que se sabe y lo que permanece incierto."
            ),
            listOf("Leshner, Trust in Science Is Not the Problem"),
            listOf("Generalizar datos estadounidenses como verdad universal actual.", "Concluir que los hechos no importan.")
        ),
        q(
            112, "Leshner", "La crítica al modelo de déficit",
            "¿Qué es el modelo de déficit y por qué Leshner lo considera insuficiente para explicar el desacuerdo con la ciencia?",
            "El modelo de déficit atribuye el desacuerdo a falta de conocimiento y supone que más educación corregirá la conducta; Leshner muestra que comprensión, valores, sesgos e intereses pueden coexistir y exige pasar de transmisión a engagement.",
            listOf("Modelo de déficit", "Public engagement", "Valores", "Sesgos cognitivos"),
            listOf("educación unidireccional", "diálogo", "escucha", "adaptación a la audiencia"),
            emptyList(),
            listOf("Definir el supuesto del déficit.", "Explicar por qué más información puede no cambiar preferencias.", "Introducir valores/sesgos.", "Explicar engagement como alternativa."),
            listOf(
                "El modelo de déficit parte de una explicación simple: si una persona rechaza una conclusión científica, debe ser porque no comprende suficientemente la ciencia. De allí se sigue una estrategia igualmente simple: entregar más información o educación hasta que la audiencia adopte la posición correcta.",
                "Leshner considera insuficiente ese esquema porque una persona puede entender los fundamentos de un problema y seguir rechazando una recomendación debido a valores, intereses, creencias o sesgos. La disonancia cognitiva y sesgos como confirmación, pertenencia al grupo o preferencia por el statu quo pueden afectar qué evidencia se acepta o descuenta.",
                "La alternativa es el public engagement, entendido como diálogo genuino. Supone escuchar, conocer a la audiencia, ajustar el formato, reconocer incertidumbres y buscar formas de trabajo colectivo. El científico deja de concebirse únicamente como profesor frente a un receptor ignorante.",
                "Esto no significa que toda opinión tenga el mismo estatus epistémico ni que la evidencia deba negociarse. Leshner insiste precisamente en no distorsionar los hallazgos. Lo que cambia es la teoría de la comunicación: informar sigue siendo necesario, pero no es suficiente para comprender decisiones atravesadas por valores y contexto."
            ),
            listOf("Leshner, Trust in Science Is Not the Problem"),
            listOf("Presentar engagement como marketing persuasivo.", "Confundir reconocer valores con relativizar la evidencia.")
        ),
        q(
            113, "Leshner", "Incertidumbre, sesgos y comunicación",
            "¿Cómo influyen la incertidumbre científica y los sesgos cognitivos en la relación entre evidencia y conducta según Leshner?",
            "La incertidumbre y revisión normales de la ciencia pueden ser interpretadas como debilidad, mientras sesgos y disonancia orientan la recepción de evidencia; comunicar requiere precisión, contexto y diálogo.",
            listOf("Incertidumbre", "Disonancia cognitiva", "Sesgo de confirmación", "In-group bias", "Status quo bias"),
            listOf("interpretación de incertidumbre", "selección de información", "consistencia con valores", "engagement"),
            emptyList(),
            listOf("Explicar incertidumbre y revisión científica.", "Definir al menos dos sesgos.", "Conectar con recepción de evidencia.", "Derivar reglas de comunicación."),
            listOf(
                "Leshner recuerda que la evidencia científica suele incluir incertidumbre y que las teorías pueden revisarse cuando aparece información nueva. Dentro de la ciencia, esa revisabilidad es una fortaleza del método; fuera de ella, cambios de recomendación o desacuerdo entre especialistas pueden ser interpretados como falta de competencia o autoridad.",
                "A esto se suman mecanismos de recepción selectiva. La disonancia cognitiva genera tensión cuando nueva información choca con creencias previas. El sesgo de confirmación favorece información consistente con lo ya creído; el in-group bias otorga mayor credibilidad a miembros del propio grupo; el status quo bias favorece mantener la situación existente.",
                "Estos mecanismos ayudan a explicar por qué una exposición técnicamente impecable puede no modificar una preferencia. La evidencia entra en un entorno cognitivo y social preexistente. Por eso no basta con aumentar la cantidad de datos o afirmar mayor certeza de la que realmente existe.",
                "Una comunicación responsable debe reflejar con exactitud el estado del conocimiento, contextualizar incertidumbres, evitar hipérboles, conocer los valores y capacidades de la audiencia y crear espacios de diálogo. El objetivo no es manipular sesgos, sino construir condiciones de comprensión y credibilidad."
            ),
            listOf("Leshner, Trust in Science Is Not the Problem"),
            listOf("Usar 'sesgo' para descalificar políticamente al receptor.", "Ocultar incertidumbre para persuadir.")
        ),
        q(
            114, "Ouimet", "Tres usos de la evidencia",
            "Distinga uso instrumental, conceptual y simbólico/táctico de evidencia en legislaturas según Ouimet et al.",
            "La evidencia puede facilitar una decisión directa, modificar la comprensión de un problema o servir objetivos estratégicos y políticos; reducir el uso a impacto instrumental subestima gran parte de la actividad legislativa.",
            listOf("Uso instrumental", "Uso conceptual", "Uso simbólico/táctico"),
            listOf("decisión directa", "aprendizaje", "justificación estratégica"),
            emptyList(),
            listOf("Definir los tres usos.", "Dar un ejemplo legislativo para cada uno.", "Recordar cuál fue más observado en la revisión.", "Evitar convertir frecuencia en importancia causal."),
            listOf(
                "Ouimet et al. clasifican el uso de evidencia en tres categorías recurrentes. El uso instrumental ocurre cuando la investigación facilita de manera relativamente directa una decisión o acción. El uso conceptual influye en la comprensión o reflexión sobre problemas y soluciones, incluso sin producir una decisión inmediata.",
                "El uso simbólico o táctico aparece cuando la evidencia se moviliza para alcanzar objetivos estratégicos o políticos, por ejemplo justificar una posición, fortalecer un argumento o aumentar su autoridad. En la revisión sistemática, este tipo fue el observado con mayor frecuencia entre los estudios que examinaban formas de uso.",
                "En una comisión, un informe puede ser instrumental si fundamenta una enmienda específica; conceptual si cambia cómo asesores entienden las causas de un problema; y simbólico si se cita para respaldar públicamente una posición ya adoptada. Un mismo estudio puede cumplir más de una función en distintos momentos.",
                "La implicancia metodológica es importante: medir incidencia sólo preguntando si la investigación 'cambió la ley' deja fuera aprendizaje, estructuración del debate y usos estratégicos. A la vez, la frecuencia con que una categoría aparece en estudios no debe confundirse con una medida universal de su importancia."
            ),
            listOf("Ouimet et al. 2023"),
            listOf("Definir uso simbólico como 'uso falso'.", "Afirmar que el uso más frecuente es siempre el más importante.")
        ),
        q(
            115, "Ouimet", "Usos específicamente legislativos",
            "¿Qué usos de evidencia propios del trabajo legislativo identifica la revisión de Ouimet et al. y por qué amplían la noción de incidencia?",
            "La investigación puede preparar preguntas y debates, ayudar a construir consenso, verificar información y apoyar tareas legislativas; estas funciones muestran incidencia aunque no exista adopción directa de una recomendación.",
            listOf("Usos legislativos específicos", "Construcción de consenso", "Preparación de debates", "Fact-checking"),
            listOf("estructuración del debate", "consenso", "verificación", "trabajo legislativo"),
            emptyList(),
            listOf("Nombrar funciones específicas.", "Explicar por qué no caben completamente en impacto directo.", "Relacionar con trabajo de comisión.", "Conectar con evaluación de incidencia."),
            listOf(
                "La revisión de Ouimet et al. encuentra propósitos que adquieren especial sentido en legislaturas. Entre ellos están preparar preguntas y debates, apoyar la construcción de consenso y realizar tareas de verificación o escrutinio. La investigación puede, por tanto, servir al trabajo parlamentario sin convertirse inmediatamente en una disposición legal.",
                "Esto amplía la noción de incidencia porque una legislatura no sólo 'elige políticas'. También delibera, controla, pregunta, negocia, revisa argumentos y construye acuerdos. La evidencia puede modificar la calidad o contenido de esas actividades aunque el resultado final dependa de mayorías, negociación partidaria y restricciones institucionales.",
                "Por ejemplo, un asesor puede usar un estudio para preparar preguntas a una autoridad; dos bancadas pueden compartir una base empírica que acote el desacuerdo; o una comisión puede contrastar afirmaciones realizadas durante una audiencia. Ninguna de esas acciones equivale automáticamente a adoptar la recomendación del estudio.",
                "Una evaluación más realista del intercambio ciencia-Congreso debe observar esas funciones intermedias. El impacto legislativo puede ser procesual, conceptual o estratégico, además de instrumental. Esa mirada es especialmente útil para interpretar los casos del curso, donde la evidencia suele operar dentro de relaciones y negociaciones prolongadas."
            ),
            listOf("Ouimet et al. 2023"),
            listOf("Limitar los usos legislativos a votar leyes.", "Suponer que toda cita de evidencia demuestra aprendizaje.")
        ),
        q(
            116, "Ouimet", "Barreras y facilitadores",
            "Presente las cuatro categorías de factores que pueden facilitar u obstaculizar el uso de investigación en legislaturas según Ouimet et al. y aplíquelas a un caso.",
            "El uso depende de factores institucionales/organizacionales, características de la investigación, contexto político y de política, y características individuales; los casos muestran que estas dimensiones interactúan.",
            listOf("Institución y organización", "Características de la investigación", "Contexto político", "Características individuales"),
            listOf("acceso", "relaciones y confianza", "relevancia de la evidencia", "habilidades y creencias"),
            listOf("Ley de Humedales Urbanos", "Ley de Suelos"),
            listOf("Nombrar las cuatro categorías.", "Dar ejemplos de factores.", "Aplicarlas a un caso.", "Evitar inferir importancia por número de estudios."),
            listOf(
                "Ouimet et al. agrupan facilitadores y barreras en cuatro familias. La primera corresponde a institución y organización: características de la legislatura, apoyo disponible, acceso a investigación y relaciones sociales. La segunda se refiere a características de la investigación, como forma, contenido, disponibilidad o pertinencia.",
                "La tercera categoría es el contexto político y de política: naturaleza del problema, intereses, grupos involucrados y condiciones del trabajo legislativo. La cuarta reúne características individuales, como experiencia, conocimiento, habilidades, creencias y actitudes de quienes podrían usar la evidencia.",
                "En Humedales, por ejemplo, el acceso no dependió sólo de publicar conocimiento sobre ecosistemas. La relación entre Carolina Rojas, asesores y actores senatoriales redujo barreras organizacionales y relacionales; el problema ambiental y la estrategia legislativa aportaron contexto político; la capacidad de aprender lenguajes y procedimientos afectó el uso efectivo del conocimiento.",
                "El marco funciona como una lista de dimensiones para analizar, no como ranking universal de causas. La revisión muestra qué factores fueron reportados en los estudios incluidos, pero el número de menciones no demuestra por sí mismo cuál factor es más importante en un caso concreto."
            ),
            listOf("Ouimet et al. 2023", "Caso Humedales Urbanos"),
            listOf("Convertir cuatro categorías en cuatro variables aisladas.", "Afirmar causalidad sólo por frecuencia de menciones.")
        ),
        q(
            117, "Karp", "Public scholarship como vocación",
            "¿Qué entiende Karp por public scholarship y por qué no puede reducirse a divulgar de manera simple conocimiento académico?",
            "La public scholarship exige trabajar entre esferas sociales con valores y criterios distintos, mantener fidelidad a estándares disciplinarios y reconocer a los públicos como agentes activos; no es simplificación unidireccional.",
            listOf("Public scholarship", "Pluralismo", "Público activo"),
            listOf("cruce de fronteras", "fidelidad disciplinaria", "juicio", "interacción con públicos"),
            emptyList(),
            listOf("Definir public scholarship.", "Explicar el pluralismo.", "Criticar la idea de audiencia pasiva.", "Mostrar tensión entre estándares y compromiso público."),
            listOf(
                "Karp entiende la public scholarship como una vocación que obliga al académico a operar en esferas sociales diferentes de la academia. Esos espacios contienen valores, bienes y agendas que pueden ser incompatibles, por lo que el trabajo público exige juicio y no sólo capacidad para traducir vocabulario especializado.",
                "El académico público debe conservar fidelidad a ideas, valores y estándares de su disciplina, incluso cuando el trabajo con otros actores exija compromiso, negociación o crítica de la propia disciplina. Esa tensión diferencia la public scholarship de una versión puramente promocional de la divulgación.",
                "Karp cuestiona especialmente la pregunta '¿cómo cuento mi historia a una audiencia no sofisticada?'. Los públicos no son receptores pasivos ni poseen una sola mente. Son agentes con ideas, experiencias y criterios de juicio sobre los mismos asuntos que el experto quiere discutir.",
                "Por eso, una intervención pública exitosa no consiste en simplificar hasta que el otro acepte. Consiste en construir una relación capaz de reconocer pluralidad, escuchar y sostener estándares intelectuales. La dificultad es política y ética, no meramente comunicacional."
            ),
            listOf("Karp 2012, Public scholarship as a vocation"),
            listOf("Definir public scholarship como outreach.", "Suponer que compromiso equivale a abandonar estándares.")
        ),
        q(
            118, "Karp", "Pluralismo y públicos activos",
            "¿Qué papel cumplen el pluralismo y la idea de públicos activos en la concepción de Karp?",
            "El pluralismo reconoce culturas, valores y estándares parcialmente incompatibles, mientras la idea de públicos activos impide tratar a las audiencias como objetos vacíos; juntos obligan a una interacción basada en juicio y reconocimiento mutuo.",
            listOf("Pluralismo", "Público activo", "Public scholarship"),
            listOf("incompatibilidad de valores", "agencia del público", "reconocimiento", "juicio"),
            emptyList(),
            listOf("Definir pluralismo.", "Explicar agencia del público.", "Mostrar efecto sobre práctica académica.", "Distinguir pluralismo de relativismo total."),
            listOf(
                "Para Karp, la public scholarship debe partir de una concepción pluralista de la sociedad. Los académicos trabajan entre comunidades que no comparten necesariamente los mismos bienes, valores o estándares de evaluación. Incluso dentro de una cultura existen criterios incompatibles que no pueden reducirse a una única escala.",
                "Esa pluralidad se combina con una segunda tesis: los públicos son agentes activos. Tienen opiniones, conocimientos y criterios propios sobre los asuntos que la academia estudia. Tratarlos como una audiencia homogénea y deficitaria reproduce una relación jerárquica que empobrece la interacción.",
                "La consecuencia práctica es que el académico debe aprender a escuchar, negociar significados y ejercer juicio. No puede simplemente exportar categorías académicas esperando obediencia. Al mismo tiempo, Karp no abandona la posibilidad de evaluación crítica ni reduce todo conocimiento a la perspectiva interna de una comunidad.",
                "El pluralismo, entonces, no es relativismo absoluto. Es una condición de la práctica pública: obliga a reconocer diversidad y conflicto mientras se mantienen estándares y razones que puedan ser discutidos. Esa tensión explica por qué la public scholarship es más exigente que comunicar de modo sencillo."
            ),
            listOf("Karp 2012"),
            listOf("Confundir pluralismo con 'todas las afirmaciones son igualmente verdaderas'.", "Describir al público como consumidor.")
        ),
        q(
            119, "Karp", "Compromiso y estándares disciplinarios",
            "Karp sostiene que el trabajo público implica compromiso, pero también fidelidad a estándares académicos. Explique esa tensión.",
            "La acción pública requiere negociar fines y medios en entornos plurales, pero el académico no debe convertir esa adaptación en abandono de criterios de evidencia y rigor; la vocación pública consiste precisamente en administrar esa tensión.",
            listOf("Public scholarship", "Compromiso", "Estándares disciplinarios"),
            listOf("negociación", "fidelidad intelectual", "juicio práctico", "fronteras institucionales"),
            listOf("Ley de Humedales Urbanos"),
            listOf("Explicar la tensión Weber/Karp.", "Distinguir compromiso de capitulación.", "Aplicar a salida de la academia.", "Cerrar con criterio de responsabilidad."),
            listOf(
                "Karp recupera la diferencia weberiana entre la vocación científica y la acción política. La investigación se orienta por estándares de validez y rigor, mientras la acción destinada a producir cambios opera en un mundo de compromisos, consecuencias no controladas y fines en conflicto.",
                "El académico público se sitúa precisamente en esa frontera. Debe adaptar formatos, negociar con instituciones y aceptar que sus objetivos pueden reformularse, pero no puede presentar como conocimiento lo que no está respaldado por su disciplina ni distorsionar evidencia para obtener un resultado político.",
                "Humedales Urbanos muestra esa tensión en la trayectoria de Carolina Rojas. Salir del espacio académico implicó aprender procedimientos legislativos, construir relaciones y trabajar con actores cuyos criterios de éxito no eran idénticos a los de una publicación científica. El caso también hace visibles los costos de esa salida.",
                "La fidelidad disciplinaria no exige aislamiento, y el compromiso político no exige abandonar rigor. La public scholarship es valiosa justamente porque transforma esa tensión en una práctica de juicio: decidir qué puede adaptarse y qué límites epistémicos o éticos no deben cruzarse."
            ),
            listOf("Karp 2012", "Caso Humedales Urbanos"),
            listOf("Presentar compromiso como corrupción del conocimiento.", "Idealizar la academia como espacio sin intereses.")
        ),
        q(
            120, "Casos", "Suelos: consenso, brokers y oportunidad",
            "Analice el Anteproyecto de Ley de Suelos como un caso de interacción ciencia-política. ¿Qué mecanismos explican su avance después de más de veinte años?",
            "El avance combina acumulación de conocimiento con una ventana política, coordinación, brokers jurídicos y una metodología de consenso que transformó una demanda científica de larga duración en un texto políticamente procesable.",
            listOf("Ventana de oportunidad", "Knowledge brokerage", "Metodología de consensos", "Policy cycle"),
            listOf("coordinación", "procesamiento de disensos", "intermediación jurídica", "oportunidad política"),
            listOf("Ley de Suelos"),
            listOf("Reconstruir la larga temporalidad.", "Identificar actores y brokers.", "Explicar la metodología de consensos.", "Mostrar por qué la oportunidad importa sin reemplazar la evidencia."),
            listOf(
                "El caso de Suelos comienza con una anomalía importante para una teoría lineal de incidencia: la comunidad científica acumuló por más de veinte años argumentos sobre la necesidad de regulación, pero ese conocimiento no se convirtió rápidamente en legislación. Hubo iniciativas truncas y una larga trayectoria de construcción de agenda.",
                "El avance posterior requirió una arquitectura colectiva. Más de cincuenta científicos y académicos, junto con sociedad civil, trabajaron durante alrededor de quince meses. El caso destaca la coordinación general, el papel de abogados como brokers y una metodología de consensos organizada mediante mesas de trabajo y un comité editor.",
                "Esos arreglos permitieron procesar disensos y traducir lenguaje científico en un texto susceptible de ingresar al Congreso. Al mismo tiempo, la conexión con actores políticos y una ventana de oportunidad hicieron posible que la propuesta adquiriera tracción institucional. La evidencia no desaparece: se vuelve parte de una coalición y un proceso.",
                "Por eso, el caso explica incidencia como combinación de acumulación epistémica, relaciones, diseño procesual y oportunidad. Ningún elemento por sí solo es suficiente. La ventana sin trabajo previo habría tenido poco contenido que movilizar; el conocimiento sin coordinación y acceso político podía seguir acumulándose sin transformación normativa."
            ),
            listOf("Caso Ley de Suelos", "Martinuzzi & Sedlacko", "Kraft & Furlong"),
            listOf("Explicar todo por la 'ventana de oportunidad'.", "Olvidar metodología de consensos y brokers.")
        ),
        q(
            121, "Casos", "Humedales: del conocimiento al Congreso",
            "¿Qué enseña la Ley de Humedales Urbanos sobre la trayectoria de un académico que entra al proceso legislativo? Integre Karp y Martinuzzi.",
            "El caso muestra que la incidencia surge al cruzar fronteras institucionales: la investigadora conserva expertise, pero aprende lenguajes y tiempos legislativos, construye relaciones y convierte conocimiento en un recurso dentro de una red política.",
            listOf("Public scholarship", "Knowledge brokerage", "Enfoque de redes"),
            listOf("aprendizaje institucional", "relaciones de confianza", "traducción", "costos del trabajo público"),
            listOf("Ley de Humedales Urbanos"),
            listOf("Ubicar a Carolina Rojas en la trayectoria.", "Explicar public scholarship.", "Agregar redes/brokerage.", "Mostrar costos y límites."),
            listOf(
                "Humedales Urbanos está construido precisamente como el encuentro entre dos mundos. El conocimiento sobre ecosistemas y urbanización no entra al Congreso como un paquete autosuficiente; la trayectoria de Carolina Rojas implica salir de su 'hábitat natural' académico y aprender a operar con actores parlamentarios, asesores y tiempos legislativos.",
                "Karp ayuda a interpretar esa salida como public scholarship. La académica no se limita a divulgar de manera simplificada, sino que trabaja con públicos e instituciones que poseen criterios propios. Esto exige juicio, adaptación y capacidad de sostener estándares científicos dentro de un espacio donde el compromiso y la negociación son inevitables.",
                "Martinuzzi y Sedlacko agregan la dimensión relacional. El vínculo con el senador De Urresti, asesores y equipos legislativos convierte conocimiento en un recurso conectado a estrategia, red y oportunidad. La confianza y el aprendizaje mutuo aumentan la capacidad de hacer procesable la evidencia.",
                "El caso también recuerda que ese trabajo tiene costos. Salir de la academia consume tiempo, requiere habilidades no siempre reconocidas y expone al investigador a lógicas distintas. La lección no es que todo académico deba convertirse en activista, sino que la incidencia pública necesita capacidades y relaciones que la producción científica por sí sola no suministra."
            ),
            listOf("Caso Humedales Urbanos", "Karp 2012", "Martinuzzi & Sedlacko"),
            listOf("Convertir a Carolina Rojas en un tipo ideal fijo de Pielke.", "Reducir la historia a una relación personal sin instituciones.")
        ),
        q(
            122, "Casos", "Regulación térmica: ciencia necesaria, no suficiente",
            "Explique cómo el caso de regulación térmica demuestra que la evidencia puede ser necesaria y, aun así, insuficiente para producir una decisión pública.",
            "La regulación térmica combina décadas de investigación con negociación entre Estado, industria y academia, gradualidad y ventanas políticas; los estudios iluminan opciones, pero costos, capacidad y prioridades siguen siendo decididos políticamente.",
            listOf("Knowledge brokerage", "Factibilidad", "Temporalidad", "Policy cycle"),
            listOf("gradualidad", "negociación", "traducción técnica", "persistencia"),
            listOf("Regulación térmica"),
            listOf("Reconstruir fases y larga temporalidad.", "Explicar el vínculo ciencia-MINVU-industria.", "Mostrar conflicto calidad/costo/cobertura.", "Cerrar con evidencia necesaria pero insuficiente."),
            listOf(
                "La regulación térmica de viviendas muestra una interfaz construida durante décadas. Desde mediciones iniciales y programas tempranos hasta las sucesivas etapas de reglamentación, el conocimiento técnico debió conectarse con el MINVU, las capacidades de la industria y restricciones asociadas al costo de las viviendas subsidiadas.",
                "La primera estrategia regulatoria fue gradual: comenzar por estándares que pudieran ser técnicamente defendibles y políticamente absorbidos. El caso subraya que elevar calidad térmica puede aumentar costos y afectar la cantidad de viviendas que el Estado financia, por lo que la decisión involucra un conflicto de política pública que la física de la construcción no resuelve por sí sola.",
                "Waldo Bustamante desempeña un rol sostenido de interfaz, conectando investigación con parámetros regulatorios y persistiendo frente a inercias institucionales. En la etapa iniciada en 2013, los estudios llevaron a pensar la envolvente como sistema, incorporando infiltraciones, ventilación y condensación, pero la normativa se promulgó recién una década después.",
                "La evidencia fue necesaria para definir qué estándares tenían sentido, pero insuficiente para determinar cuándo y hasta dónde avanzar. Factibilidad industrial, prioridades gubernamentales, elecciones y ventanas de oportunidad afectaron la trayectoria. El caso es, por ello, una demostración fuerte de no linealidad y temporalidades largas."
            ),
            listOf("Caso Regulación térmica", "Martinuzzi & Sedlacko", "Kraft & Furlong"),
            listOf("Tratar el caso como mera historia tecnológica.", "Suponer que demora equivale a rechazo de la ciencia.")
        ),
        q(
            123, "Casos", "Neuroderechos: gobernar bajo incertidumbre",
            "¿Qué desafíos para la relación ciencia-política aparecen cuando se intenta regular una tecnología emergente como en el caso de Neuroderechos?",
            "La regulación anticipatoria combina incertidumbre empírica, riesgos potenciales y desacuerdo normativo; exige distinguir qué puede afirmar la ciencia de qué debe decidir democráticamente el derecho y la política.",
            listOf("Incertidumbre", "Honest Broker", "Public scholarship", "Pluralismo"),
            listOf("gobernanza anticipatoria", "clarificación de opciones", "mediación ética-jurídica", "desacuerdo académico"),
            listOf("Ley de Neuroderechos"),
            listOf("Describir campo emergente y preocupación científica.", "Distinguir evidencia de opción normativa.", "Incorporar mediación interdisciplinaria.", "Mostrar desacuerdo académico."),
            listOf(
                "Neuroderechos introduce un problema distinto de los casos ambientales más maduros: la regulación intenta anticiparse a capacidades tecnológicas cuyo desarrollo y efectos todavía contienen incertidumbre. El Morningside Group transforma preocupaciones de neurocientíficos en una arquitectura de derechos, y el tema encuentra rápidamente un canal político en Chile.",
                "Pielke ayuda a separar tareas. Los expertos pueden aclarar capacidades, riesgos y grados de incertidumbre, pero elegir entre reforma constitucional, regulación legal específica o uso de garantías existentes requiere juicios normativos. Presentar una sola arquitectura como deducción inevitable de la ciencia escondería ese paso.",
                "El caso también muestra mediación interdisciplinaria. Paulina Ramos aparece como puente entre ciencia, bioética, derecho y política. La academia no actúa como bloque homogéneo: existen argumentos favorables centrados en riesgos estructurales y límites al poder, y críticas basadas en redundancia normativa y problemas de interpretación constitucional.",
                "La lección es que regular el futuro requiere prudencia en dos sentidos: no esperar certeza total antes de discutir riesgos, pero tampoco inflar la autoridad científica hasta convertirla en poder constituyente. La interfaz debe hacer visibles incertidumbres, alternativas y desacuerdos."
            ),
            listOf("Caso Neuroderechos", "Pielke", "Karp"),
            listOf("Afirmar que la tecnología ya permite todo riesgo imaginado.", "Suprimir las críticas académicas descritas por el caso.")
        ),
        q(
            124, "Comparación", "Suelos y Humedales: dos rutas de incidencia",
            "Compare Suelos y Humedales Urbanos como dos rutas mediante las cuales conocimiento académico entra al Congreso.",
            "Ambos dependen de redes y traducción, pero Suelos destaca una arquitectura colectiva de consenso y brokers durante una larga agenda, mientras Humedales enfatiza una trayectoria de conexión entre una académica y actores legislativos.",
            listOf("Knowledge brokerage", "Enfoque de redes", "Public scholarship", "Ventana de oportunidad"),
            listOf("coalición colectiva", "relación academia-Congreso", "consenso", "aprendizaje institucional"),
            listOf("Ley de Suelos", "Ley de Humedales Urbanos"),
            listOf("Establecer el patrón común.", "Distinguir arquitectura de actores.", "Comparar temporalidades y mecanismos.", "Cerrar con una teoría general limitada."),
            listOf(
                "Suelos y Humedales coinciden en un punto básico: ningún caso puede describirse como transferencia directa desde una publicación a una ley. En ambos, el conocimiento adquiere influencia cuando se inserta en relaciones, actores capaces de traducirlo y oportunidades institucionales.",
                "Suelos presenta una arquitectura especialmente colectiva. Una agenda científica de larga duración converge con más de cincuenta especialistas, sociedad civil, coordinación, abogados-brokers, mesas y comité editor. La metodología de consensos es central para convertir diversidad de posiciones en un texto común.",
                "Humedales, aunque también involucra múltiples actores, está narrado alrededor de la trayectoria de Carolina Rojas y su encuentro con el senador De Urresti y asesores. Aquí resulta especialmente visible la dimensión de public scholarship: aprender la lógica del Congreso, construir confianza y asumir los costos de atravesar fronteras institucionales.",
                "La comparación muestra que las redes son una condición común, pero pueden adoptar formas distintas. La incidencia puede descansar en una coalición organizada o en vínculos de interfaz que luego escalan. Por eso, un marco general debe identificar mecanismos compartidos sin borrar la especificidad organizativa de cada trayectoria."
            ),
            listOf("Casos Suelos y Humedales", "Martinuzzi & Sedlacko", "Karp"),
            listOf("Decir que uno es 'mejor' que el otro.", "Comparar sólo resultados legales y no mecanismos.")
        ),
        q(
            125, "Comparación", "Regulación térmica y Neuroderechos",
            "Compare regulación térmica y Neuroderechos en términos de temporalidad, incertidumbre y tipo de interfaz ciencia-política.",
            "Regulación térmica muestra acumulación y negociación incremental durante décadas; Neuroderechos muestra regulación anticipatoria de un campo emergente. Ambos requieren intermediación, pero gestionan incertidumbres y ritmos muy distintos.",
            listOf("Temporalidad", "Incertidumbre", "Knowledge brokerage", "Honest Broker"),
            listOf("incrementalismo", "anticipación", "intermediación", "clarificación de alternativas"),
            listOf("Regulación térmica", "Ley de Neuroderechos"),
            listOf("Contrastar temporalidades.", "Contrastar tipo de evidencia e incertidumbre.", "Identificar interfaz dominante.", "Extraer una lección común."),
            listOf(
                "Regulación térmica es un caso de temporalidad larga e incremental. La investigación técnica se acumula, se traduce en estándares graduales, negocia con industria y Estado y atraviesa largos períodos entre estudios, formulación y entrada en vigencia. Buena parte del problema consiste en adaptar capacidad productiva y prioridades públicas.",
                "Neuroderechos se mueve en el sentido opuesto: la preocupación regulatoria aparece cuando muchas capacidades futuras todavía son inciertas. La política intenta anticipar riesgos antes de que exista una trayectoria extensa de daño observado. Esto aumenta la importancia de separar escenarios plausibles de afirmaciones empíricas consolidadas.",
                "En ambos casos hay intermediación. Bustamante conecta investigación, MINVU e industria; en Neuroderechos, la interacción entre neurocientíficos, actores políticos y mediación bioética-jurídica permite convertir preocupaciones en lenguaje normativo. Sin embargo, el tipo de pregunta es distinto: factibilidad incremental versus gobernanza anticipatoria.",
                "La comparación muestra que no existe una única forma temporal de intercambio ciencia-política. La evidencia puede entrar lentamente en estándares maduros o rápidamente en debates preventivos. En ambos escenarios, la calidad de la interfaz depende de hacer explícitos límites, opciones y restricciones."
            ),
            listOf("Casos Regulación térmica y Neuroderechos", "Pielke", "Martinuzzi & Sedlacko"),
            listOf("Interpretar velocidad como calidad.", "Suponer que mayor incertidumbre invalida toda regulación anticipatoria.")
        ),
        q(
            126, "Comparación", "Condiciones comunes de incidencia",
            "A partir de Suelos, Humedales, regulación térmica y Neuroderechos, identifique condiciones comunes y mecanismos distintos de incidencia científica.",
            "Los cuatro casos comparten necesidad de conexión entre conocimiento e instituciones, pero difieren en temporalidad, controversia, estructura de intermediación y ventana política; una teoría útil debe combinar condiciones generales con mecanismos específicos.",
            listOf("No linealidad", "Brokerage", "Redes", "Ventana de oportunidad", "Public scholarship"),
            listOf("traducción", "confianza", "coordinación", "oportunidad", "negociación"),
            listOf("Ley de Suelos", "Ley de Humedales Urbanos", "Regulación térmica", "Ley de Neuroderechos"),
            listOf("Identificar patrones comunes.", "Distinguir mecanismos por caso.", "Comparar temporalidades.", "Evitar una receta universal."),
            listOf(
                "Los cuatro casos rechazan una explicación basada en transferencia automática. En todos aparecen actores que conectan conocimiento con instituciones, procesos de traducción entre lenguajes y algún tipo de relación sostenida que vuelve la evidencia utilizable dentro de la decisión pública.",
                "Suelos destaca coordinación colectiva, brokers jurídicos, consenso y una ventana tras décadas de agenda. Humedales enfatiza public scholarship y la relación entre academia y actores parlamentarios. Regulación térmica combina persistencia, gradualidad y negociación con capacidad productiva y estatal. Neuroderechos agrega regulación anticipatoria, interdisciplinariedad y desacuerdo normativo en un campo emergente.",
                "También varían las temporalidades. Suelos y regulación térmica muestran procesos largos; Humedales exhibe una trayectoria legislativa donde el encuentro entre redes adquiere centralidad; Neuroderechos avanza con rapidez frente a riesgos futuros. El grado y tipo de incertidumbre, por tanto, no es homogéneo.",
                "Una teoría razonable de incidencia puede formular condiciones generales —conectividad, traducción, confianza, oportunidad y capacidad institucional— sin convertirlas en receta. Los mecanismos causales cambian según problema, actores, instituciones y etapa del proceso de política."
            ),
            listOf("Cuatro casos Ciencia y Democracia", "Martinuzzi & Sedlacko", "Kraft & Furlong", "Karp", "Pielke"),
            listOf("Hacer una lista sin comparación.", "Buscar una causa única para los cuatro casos.")
        ),
        q(
            127, "Aplicación", "Audiencia parlamentaria sobre ciencia controvertida",
            "Usted debe exponer ante una comisión parlamentaria sobre un tema científicamente complejo y normativamente controvertido. Diseñe una estrategia usando Leshner y Pielke.",
            "La estrategia debe separar preguntas empíricas de elecciones normativas, explicitar el rol experto, comunicar incertidumbre sin exageración y tratar a la audiencia como interlocutora con valores y restricciones propias.",
            listOf("Public engagement", "Science Arbiter", "Honest Broker", "Incertidumbre"),
            listOf("escucha", "clarificación de preguntas", "explicitación de incertidumbre", "ampliación de opciones"),
            listOf("Ley de Neuroderechos"),
            listOf("Diagnosticar audiencia y pregunta.", "Separar hechos de opciones.", "Explicar incertidumbre.", "Diseñar diálogo y cierre con alternativas."),
            listOf(
                "La primera tarea no sería preparar más diapositivas, sino identificar qué pregunta enfrenta realmente la comisión y qué parte de ella puede responder la evidencia. Leshner sugiere conocer a la audiencia, escuchar sus preocupaciones y abandonar la expectativa de que una mayor cantidad de información resolverá por sí sola el desacuerdo.",
                "En la exposición, actuaría como Science Arbiter cuando se soliciten hechos delimitados: estado del conocimiento, magnitud de efectos, límites de datos e incertidumbre. Evitaría presentar un juicio normativo como si fuera un hallazgo. La credibilidad depende, entre otras cosas, de no exagerar la certeza.",
                "Si la comisión necesita escoger entre arquitecturas de política, un rol de Honest Broker puede ser más apropiado: ordenar alternativas, explicar consecuencias y mostrar qué supuestos valorativos hacen más atractiva una opción que otra. Si el experto desea defender una alternativa, debería transparentar que está actuando como Issue Advocate.",
                "El caso de Neuroderechos ilustra el desafío: riesgos emergentes, desacuerdo interdisciplinario y opciones regulatorias distintas. La buena asesoría no elimina esa pluralidad; ayuda a que la deliberación distinga mejor evidencia, incertidumbre y valores."
            ),
            listOf("Leshner 2021", "Pielke", "Caso Neuroderechos"),
            listOf("Usar engagement como técnica para obtener obediencia.", "Ocultar que existe una preferencia normativa.")
        ),
        q(
            128, "Aplicación", "Cuando un parlamentario pregunta '¿qué debemos hacer?'",
            "Un parlamentario le pregunta a un científico: '¿Qué debemos hacer?'. Analice al menos tres maneras de responder usando Pielke y explique sus consecuencias.",
            "La misma pregunta puede llevar a arbitraje científico, advocacy o honest brokering; la diferencia consiste en si el experto delimita hechos, defiende una alternativa o presenta opciones, y debe hacer explícito ese cambio de rol.",
            listOf("Science Arbiter", "Issue Advocate", "Honest Broker"),
            listOf("delimitar la pregunta", "defender opción", "clarificar alternativas", "transparencia de rol"),
            emptyList(),
            listOf("Reformular la pregunta factual posible.", "Mostrar respuesta de Advocate.", "Mostrar respuesta de Broker.", "Explicar por qué transparencia importa."),
            listOf(
                "La frase '¿qué debemos hacer?' mezcla una demanda de información con una demanda de juicio. Una primera respuesta compatible con Science Arbiter sería desagregar la pregunta: qué efectos tienen las opciones, qué evidencia existe, cuáles son los rangos de incertidumbre y qué preguntas siguen abiertas.",
                "Una segunda respuesta sería asumir el rol de Issue Advocate. El experto podría decir que, dadas sus evaluaciones y valores, una alternativa es preferible y argumentar a favor de ella. Ese rol es legítimo como tipo ideal, pero debe reconocerse como advocacy y no presentarse como si la ciencia hubiera eliminado la elección política.",
                "Una tercera respuesta sería actuar como Honest Broker: identificar un conjunto de opciones, explicitar consecuencias y supuestos, y permitir que el decisor reduzca el rango de elección de acuerdo con valores y responsabilidades democráticas propias.",
                "La clave es la transparencia. Pielke no exige que los expertos permanezcan siempre fuera de la política; exige distinguir qué rol están desempeñando. Cuando esa diferencia se oculta, aumenta el riesgo de stealth issue advocacy y se vuelve más difícil separar desacuerdo empírico de desacuerdo normativo."
            ),
            listOf("Pielke, The Honest Broker"),
            listOf("Afirmar que sólo un rol es siempre correcto.", "Convertir el Honest Broker en decisor final.")
        ),
        q(
            129, "Aplicación", "¿Cómo observar uso de evidencia en una comisión?",
            "Si quisiera estudiar empíricamente cómo una comisión parlamentaria usa evidencia, ¿qué observaría a partir de Ouimet et al.?",
            "El análisis debe observar múltiples formas de uso y los factores que las condicionan, no sólo citas o cambios legislativos; preguntas, debates, aprendizaje, justificación, consenso y verificación son resultados relevantes.",
            listOf("Uso instrumental", "Uso conceptual", "Uso simbólico/táctico", "Barreras y facilitadores"),
            listOf("observación de debates", "cambios en comprensión", "justificación estratégica", "contexto organizacional"),
            emptyList(),
            listOf("Definir unidad de observación.", "Construir categorías de uso.", "Registrar factores contextuales.", "Evitar inferir causalidad desde una cita."),
            listOf(
                "Empezaría evitando una medida única de 'impacto'. Una cita de un estudio en sala no demuestra que la evidencia haya causado una decisión, y la ausencia de una cita no demuestra que no hubo aprendizaje. La tipología de Ouimet permite construir observaciones más finas.",
                "Buscaría uso instrumental cuando un hallazgo se conecte con una enmienda, decisión o tarea concreta; uso conceptual cuando cambie la manera de definir un problema; y uso simbólico/táctico cuando la evidencia se emplee para justificar o reforzar una posición. También registraría preparación de preguntas, debate, construcción de consenso y fact-checking.",
                "Después incorporaría factores que pueden facilitar u obstaculizar esos usos: reglas y recursos de la comisión, acceso a asesoría, relaciones de confianza, formato y pertinencia de la investigación, características del tema y habilidades o creencias individuales.",
                "Metodológicamente, convendría triangular fuentes: debates, documentos, entrevistas y trazas de modificaciones legislativas. La revisión de Ouimet señala precisamente que el análisis de contenido de debates parlamentarios está subutilizado, lo que abre una vía para observar evidencia dentro del proceso y no sólo en resultados finales."
            ),
            listOf("Ouimet et al. 2023"),
            listOf("Contar citas como sinónimo de impacto.", "Ignorar que un uso puede ser estratégico y a la vez real.")
        ),
        q(
            130, "Aplicación", "Entrar al Congreso sin abandonar la academia",
            "Un investigador quiere colaborar con el Congreso sin perder rigor académico. ¿Qué recomendaciones se desprenden conjuntamente de Karp y Martinuzzi & Sedlacko?",
            "Debe entender la colaboración como trabajo de frontera: mantener estándares de evidencia, reconocer públicos activos, invertir en relaciones y traducción, y aceptar que la incidencia depende de procesos colectivos más que de una transmisión unilateral.",
            listOf("Public scholarship", "Knowledge brokerage", "Pluralismo", "Boundary work"),
            listOf("fidelidad disciplinaria", "escucha", "construcción de relaciones", "traducción"),
            listOf("Ley de Humedales Urbanos", "Ley de Suelos"),
            listOf("Definir tensión público-académica.", "Explicar trabajo relacional.", "Proponer prácticas concretas.", "Mostrar caso como ilustración."),
            listOf(
                "Desde Karp, la primera recomendación sería abandonar la imagen de un académico que simplemente simplifica su conocimiento para una audiencia menos sofisticada. Los parlamentarios y asesores son públicos activos, con experiencia, valores y criterios propios. Trabajar con ellos exige escucha, juicio y reconocimiento de pluralidad.",
                "Al mismo tiempo, la vocación pública no autoriza a distorsionar resultados o abandonar estándares disciplinarios. El investigador debe distinguir qué sabe, qué infiere y qué prefiere, y aceptar que la acción pública incluye compromisos que no convierten automáticamente una decisión en conclusión científica.",
                "Martinuzzi y Sedlacko agregan una dimensión organizacional: la colaboración requiere relaciones sostenidas, confianza, conocimiento de las necesidades del otro lado e intermediarios o arreglos de frontera. Un policy brief puede ayudar, pero no sustituye la conectividad social que vuelve el conocimiento utilizable.",
                "Humedales y Suelos muestran prácticas concretas: aprender procedimientos, construir vínculos con asesores, participar en procesos colectivos, trabajar con brokers y diseñar mecanismos para procesar disensos. La recomendación general es tratar la interfaz como una práctica institucional de largo plazo, no como una entrega puntual de información."
            ),
            listOf("Karp 2012", "Martinuzzi & Sedlacko", "Casos Humedales y Suelos"),
            listOf("Proponer sólo 'hacer un resumen ejecutivo'.", "Confundir adaptación de formato con adaptación de evidencia.")
        )
    )

    fun timedAnswer(question: IntensiveDevelopmentQuestion, minutes: Int): TimedModelAnswer {
        val normalizedMinutes = when {
            minutes <= 5 -> 5
            minutes <= 10 -> 10
            else -> 20
        }
        val blockCount = when (normalizedMinutes) {
            5 -> 1
            10 -> 3
            else -> question.answerBlocks.size
        }
        val target = when (normalizedMinutes) {
            5 -> "80–150 palabras"
            10 -> "160–260 palabras"
            else -> "250–380 palabras"
        }
        val strategy = when (normalizedMinutes) {
            5 -> "Tesis inmediata + una distinción central + mecanismo + ejemplo breve. No intentes cubrir todo."
            10 -> "Tesis + dos movimientos argumentales + aplicación de caso + cierre explícito. Prioriza precisión sobre enumeración."
            else -> "Respuesta completa: tesis, definiciones, mecanismo causal, contraste o segundo marco, evidencia de caso, límite y conclusión."
        }
        val selected = question.answerBlocks.take(blockCount).joinToString("\n\n")
        val extension = if (normalizedMinutes == 20) {
            val mechanismSentence = if (question.mechanisms.isNotEmpty()) "Una formulación explícita del mecanismo debe conectar ${question.mechanisms.joinToString(", ")} con el resultado que se intenta explicar." else "La respuesta debe hacer explícito el mecanismo que conecta los conceptos con el resultado observado."
            val caseSentence = if (question.cases.isNotEmpty()) "La evidencia de caso puede anclarse en ${question.cases.joinToString(" y ")}, usando un episodio concreto en lugar de una mención nominal." else "La aplicación debe mostrar cómo el marco ordena una situación concreta y qué deja fuera."
            "$mechanismSentence $caseSentence También conviene explicitar un límite del argumento: los marcos del curso ayudan a ordenar mecanismos y roles, pero no convierten procesos políticos contingentes en secuencias automáticas."
        } else ""
        val conclusion = when (normalizedMinutes) {
            5 -> "En síntesis, ${question.thesis.replaceFirstChar { it.lowercase() }}"
            10 -> "En suma, el punto central es que ${question.thesis.replaceFirstChar { it.lowercase() }}"
            else -> "En conclusión, ${question.thesis.replaceFirstChar { it.lowercase() }}"
        }
        val intro = question.thesis
        val body = if (extension.isBlank()) selected else "$selected\n\n$extension"
        return TimedModelAnswer(normalizedMinutes, target, strategy, "$intro\n\n$body\n\n$conclusion")
    }

    fun randomQuestion(excludingId: Int? = null): IntensiveDevelopmentQuestion {
        val pool = if (excludingId == null) questions else questions.filter { it.id != excludingId }
        return pool.random()
    }

    private fun q(
        id: Int,
        theme: String,
        title: String,
        prompt: String,
        thesis: String,
        keyConcepts: List<String>,
        mechanisms: List<String>,
        cases: List<String>,
        outline: List<String>,
        answerBlocks: List<String>,
        sourceBasis: List<String>,
        commonPitfalls: List<String>
    ) = IntensiveDevelopmentQuestion(id, theme, title, prompt, thesis, keyConcepts, mechanisms, cases, outline, answerBlocks, sourceBasis, commonPitfalls)
}

object ProfessorModeAnalyzer {
    fun analyze(answer: String, question: IntensiveDevelopmentQuestion): ProfessorFeedback {
        val normalized = normalize(answer)
        val words = answer.trim().split(Regex("\\s+")).filter { it.isNotBlank() }

        val detectedConcepts = question.keyConcepts.filter { matches(normalized, it) }
        val detectedMechanisms = question.mechanisms.filter { matches(normalized, it) }
        val detectedCases = question.cases.filter { matches(normalized, it) }

        val conceptCoverage = ratio(detectedConcepts.size, question.keyConcepts.size)
        val mechanismCoverage = ratio(detectedMechanisms.size, question.mechanisms.size)
        val caseCoverage = if (question.cases.isEmpty()) 100 else ratio(detectedCases.size, question.cases.size)
        val weighted = if (question.cases.isEmpty()) {
            (conceptCoverage * 55 + mechanismCoverage * 45) / 100
        } else {
            (conceptCoverage * 40 + mechanismCoverage * 35 + caseCoverage * 25) / 100
        }

        val comments = buildList {
            if (words.size < 90) add("La respuesta es muy breve para mostrar definición, mecanismo y aplicación con claridad.")
            if (detectedConcepts.isEmpty()) add("No aparecen con suficiente claridad los conceptos centrales esperados.")
            if (detectedMechanisms.size < (question.mechanisms.size.coerceAtMost(2))) add("La respuesta parece más descriptiva que explicativa: explicita cómo o por qué se produce la conexión.")
            if (question.cases.isNotEmpty() && detectedCases.isEmpty()) add("Falta anclar el argumento en al menos uno de los casos pertinentes.")
            if (weighted >= 75) add("La cobertura temática es alta; la revisión final debe concentrarse en precisión conceptual y calidad de la inferencia, no sólo en menciones.")
            add("Este detector compara vocabulario y cobertura estructural. No determina si una afirmación es correcta ni reemplaza evaluación docente.")
        }

        return ProfessorFeedback(
            wordCount = words.size,
            detectedConcepts = detectedConcepts,
            missingConcepts = question.keyConcepts - detectedConcepts.toSet(),
            detectedMechanisms = detectedMechanisms,
            missingMechanisms = question.mechanisms - detectedMechanisms.toSet(),
            detectedCases = detectedCases,
            missingCases = question.cases - detectedCases.toSet(),
            structuralCoverage = weighted.coerceIn(0, 100),
            comments = comments
        )
    }

    private fun ratio(found: Int, total: Int): Int = if (total <= 0) 100 else found * 100 / total

    private fun matches(normalizedAnswer: String, expected: String): Boolean {
        val aliases = aliases(expected)
        if (aliases.any { normalizedAnswer.contains(it) }) return true
        val tokens = normalize(expected).split(" ").filter { it.length >= 5 && it !in stopWords }
        return tokens.isNotEmpty() && tokens.count { normalizedAnswer.contains(it) } >= if (tokens.size >= 3) 2 else 1
    }

    private fun aliases(term: String): List<String> {
        val n = normalize(term)
        val extra = when {
            n.contains("knowledge brokerage") -> listOf("brokerage", "intermediacion", "intermediario")
            n.contains("enfoque de redes") -> listOf("enfoque de redes", "redes", "network")
            n.contains("modelo lineal") -> listOf("modelo lineal", "transferencia lineal")
            n.contains("pure scientist") -> listOf("pure scientist", "cientifico puro")
            n.contains("science arbiter") -> listOf("science arbiter", "arbitro cientifico")
            n.contains("issue advocate") -> listOf("issue advocate", "advocate", "defensor de una opcion")
            n.contains("honest broker") -> listOf("honest broker", "corredor honesto", "alternativas")
            n.contains("stealth") -> listOf("stealth issue advocacy", "advocacy encubierto")
            n.contains("agenda setting") -> listOf("agenda setting", "agenda", "definicion del problema")
            n == "formulacion" -> listOf("formulacion", "diseno de alternativas")
            n.contains("legitimacion") -> listOf("legitimacion", "autorizacion", "apoyo politico")
            n.contains("implementacion") -> listOf("implementacion", "ejecucion")
            n.contains("evaluacion") -> listOf("evaluacion", "resultados", "desempeno")
            n.contains("cambio de politica") -> listOf("cambio de politica", "revision de politica")
            n.contains("modelo de deficit") -> listOf("modelo de deficit", "deficit model", "falta de conocimiento")
            n.contains("public engagement") -> listOf("public engagement", "engagement", "dialogo")
            n.contains("public scholarship") -> listOf("public scholarship", "academico publico", "vocacion publica")
            n.contains("uso instrumental") -> listOf("uso instrumental", "instrumental")
            n.contains("uso conceptual") -> listOf("uso conceptual", "conceptual", "aprendizaje")
            n.contains("uso simbolico") -> listOf("simbolico", "tactico", "estrategico")
            n.contains("ley de suelos") -> listOf("ley de suelos", "suelos", "antilen")
            n.contains("humedales") -> listOf("humedales", "carolina rojas", "de urresti")
            n.contains("regulacion termica") -> listOf("regulacion termica", "bustamante", "minvu", "termica")
            n.contains("neuroderechos") -> listOf("neuroderechos", "yuste", "girardi", "morningside", "paulina ramos")
            else -> emptyList()
        }
        return (listOf(n) + extra.map(::normalize)).distinct().filter { it.length >= 4 }
    }

    private fun normalize(text: String): String = Normalizer.normalize(text.lowercase(), Normalizer.Form.NFD)
        .replace(Regex("\\p{Mn}+"), "")
        .replace(Regex("[^a-z0-9\\s]+"), " ")
        .replace(Regex("\\s+"), " ")
        .trim()

    private val stopWords = setOf("sobre", "entre", "desde", "hasta", "donde", "cuando", "estos", "estas", "puede", "deben", "tiene", "politica", "ciencia", "evidencia")
}
