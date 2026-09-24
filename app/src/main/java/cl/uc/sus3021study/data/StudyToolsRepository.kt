package cl.uc.sus3021study.data

import cl.uc.sus3021study.model.CaseTimeline
import cl.uc.sus3021study.model.MatrixEntry
import cl.uc.sus3021study.model.TimelineEvent
import cl.uc.sus3021study.model.RubricCriterion

object StudyToolsRepository {
    val matrixEntries = listOf(
        MatrixEntry("Modelo lineal", "Martinuzzi & Sedlacko", "La brecha ciencia–política se interpreta principalmente como un problema de transferencia: si la información correcta llega de forma accesible, relevante y oportuna, debería producir mejores decisiones.", listOf("Contraste transversal con Suelos y Humedales"), "Úsalo como punto de partida que los casos complejizan: evidencia de calidad no implica uso automático."),
        MatrixEntry("Enfoque de sistemas", "Martinuzzi & Sedlacko", "Ciencia y política operan con lógicas comunicativas distintas. La verdad es central para la ciencia; poder y legitimidad son centrales para la política.", listOf("Neuroderechos", "Regulación térmica"), "Sirve para explicar fricciones estructurales que no se resuelven sólo simplificando un paper."),
        MatrixEntry("Enfoque de redes", "Martinuzzi & Sedlacko", "La conectividad se construye mediante interacciones sostenidas, confianza, aprendizaje mutuo, intermediarios y comprensión de las racionalidades del otro.", listOf("Ley de Suelos", "Humedales Urbanos", "Regulación térmica"), "Es uno de los marcos más útiles para explicar incidencia no lineal."),
        MatrixEntry("Knowledge brokerage", "Martinuzzi & Sedlacko", "Intermediación en la interfaz ciencia–política para conectar preguntas, conocimientos, actores, formatos y procesos de decisión.", listOf("Ley de Suelos", "Regulación térmica"), "Distingue brokerage de mera difusión: hay interacción, traducción y coordinación."),
        MatrixEntry("Boundary work", "Martinuzzi & Sedlacko / literatura de interfaz", "Trabajo realizado en fronteras institucionales y epistémicas donde se negocian significados, responsabilidades y formas de conocimiento utilizables.", listOf("Neuroderechos", "Humedales Urbanos"), "Úsalo para describir qué hacen actores que operan entre academia, Congreso, derecho, bioética o administración."),
        MatrixEntry("Needfinding", "Garretón et al. / Vincula", "Fase de descubrimiento y definición del problema que busca comprender actores, necesidades, fricciones y trayectorias antes de diseñar una solución.", listOf("Sistema Vincula"), "Conecta el diseño de servicios con la pregunta por qué necesita realmente la oferta académica y la demanda parlamentaria."),
        MatrixEntry("Pure Scientist", "Pielke", "Produce conocimiento sin involucrarse directamente en la decisión; deja el uso de los resultados al decisor.", listOf("Contraste con los cuatro casos"), "Identifica cuándo el experto se mantiene fuera del proceso de elección."),
        MatrixEntry("Science Arbiter", "Pielke", "Responde preguntas empíricas específicas planteadas por decisores, procurando limitarse a cuestiones susceptibles de resolución científica.", listOf("Neuroderechos", "Regulación térmica"), "Diferéncialo del Honest Broker: responde preguntas delimitadas, no necesariamente expande alternativas."),
        MatrixEntry("Issue Advocate", "Pielke", "Usa expertise para defender una opción o reducir el abanico de alternativas que el decisor debería considerar.", listOf("Neuroderechos", "Humedales Urbanos"), "En desarrollo, evita tratar advocacy como sinónimo de mala ciencia: la clave es la relación del experto con las opciones."),
        MatrixEntry("Honest Broker", "Pielke", "Aclara o expande alternativas de política, sus consecuencias e incertidumbres, sin reemplazar la elección democrática del decisor.", listOf("Neuroderechos", "Regulación térmica"), "Es especialmente útil para preguntas sobre cómo informar una decisión con valores en disputa."),
        MatrixEntry("Policy cycle", "Kraft & Furlong", "Mapa analítico de seis etapas: agenda, formulación, legitimación, implementación, evaluación y cambio. No describe una secuencia mecánica.", listOf("Ley de Suelos", "Humedales Urbanos"), "Siempre agrega la advertencia: las etapas se superponen, retroalimentan o pueden omitirse."),
        MatrixEntry("Agenda setting", "Kraft & Furlong", "Proceso por el cual un problema es definido, adquiere atención y entra en la agenda política.", listOf("Ley de Suelos", "Neuroderechos"), "Pregunta por qué un problema conocido durante años adquiere relevancia política en un momento específico."),
        MatrixEntry("Formulación", "Kraft & Furlong", "Diseño y redacción de metas, instrumentos y estrategias de política.", listOf("Ley de Suelos", "Neuroderechos"), "Relaciona evidencia con el paso desde diagnóstico a opciones institucionales concretas."),
        MatrixEntry("Legitimación", "Kraft & Furlong", "Otorgamiento de fuerza y justificación política/legal a una propuesta mediante autoridades, debate y aceptación institucional.", listOf("Humedales Urbanos", "Ley de Suelos"), "No la reduzcas al voto: también importa el proceso de justificación y construcción de apoyo."),
        MatrixEntry("Confianza ≠ obediencia", "Leshner", "Confiar en ciencia o científicos no implica aceptar cada recomendación: las decisiones incorporan valores, intereses, experiencias y política.", listOf("Aplicación transversal"), "Es la tesis central para evitar diagnosticar todo desacuerdo como desconfianza."),
        MatrixEntry("Modelo de déficit", "Leshner", "Supone que el desacuerdo se debe principalmente a falta de comprensión y que entregar más información resolverá el problema.", listOf("Comunicación parlamentaria"), "La respuesta correcta suele requerir explicar por qué informar más puede ser necesario pero insuficiente."),
        MatrixEntry("Public engagement", "Leshner", "Estrategia de diálogo genuino que escucha perspectivas, adapta la comunicación a la audiencia y representa con honestidad evidencia e incertidumbre.", listOf("Audiencias parlamentarias", "Humedales Urbanos"), "Contrástalo con una conferencia unidireccional o con ocultar incertidumbre."),
        MatrixEntry("Uso instrumental", "Ouimet et al.", "La investigación informa de forma relativamente directa una decisión, enmienda, pregunta o tarea legislativa.", listOf("Humedales Urbanos", "Ley de Suelos"), "No lo trates como el único indicador de impacto de investigación."),
        MatrixEntry("Uso conceptual", "Ouimet et al.", "La investigación cambia gradualmente marcos de comprensión, lenguaje o interpretación de un problema.", listOf("Humedales Urbanos", "Neuroderechos"), "Busca cambios en cómo se entiende el problema, incluso sin una decisión inmediata."),
        MatrixEntry("Uso simbólico/táctico", "Ouimet et al.", "La evidencia se moviliza para justificar, persuadir, legitimar o fortalecer una posición dentro de la competencia política.", listOf("Aplicación transversal"), "La revisión lo encuentra con alta frecuencia; no lo confundas automáticamente con falsificación de evidencia."),
        MatrixEntry("Barreras y facilitadores", "Ouimet et al.", "Cuatro familias: institución/organización; características de la investigación; contexto político/de política; características individuales.", listOf("Humedales Urbanos", "Ley de Suelos"), "Úsalas como checklist diagnóstico para explicar por qué una misma evidencia puede circular de manera distinta."),
        MatrixEntry("Public scholarship", "Karp", "Trabajo de producción y circulación de conocimiento que cruza fronteras entre academia y públicos diversos, sin reducirse a simplificar lenguaje.", listOf("Carolina Rojas / Humedales", "Neuroderechos"), "Conecta vocación pública, fidelidad disciplinaria y juicio práctico."),
        MatrixEntry("Pluralismo", "Karp", "La vida pública contiene bienes, valores y culturas diferentes, a veces incompatibles; el académico público debe trabajar dentro de esa pluralidad.", listOf("Neuroderechos"), "Sirve para explicar por qué la evidencia no elimina desacuerdos normativos razonables."),
        MatrixEntry("Público activo", "Karp", "Los públicos poseen conocimientos, criterios, experiencias y opiniones; no son receptores vacíos de una comunicación experta.", listOf("Humedales Urbanos", "Comunicación parlamentaria"), "Conecta Karp con la crítica de Leshner al modelo de déficit."),
        MatrixEntry("Broker / intermediario", "Síntesis del curso", "Actor que traduce lenguajes, conecta redes, organiza intercambios y ayuda a hacer utilizable el conocimiento entre instituciones distintas.", listOf("Ley de Suelos", "Regulación térmica", "Neuroderechos"), "En un caso, identifica qué conecta, entre quiénes y mediante qué mecanismo."),
        MatrixEntry("Ventana de oportunidad", "Aplicación a casos", "Momento en que problema, actores y condiciones políticas permiten avanzar una propuesta que podía llevar años acumulando evidencia.", listOf("Ley de Suelos", "Humedales Urbanos"), "Úsala para explicar temporalidad: la evidencia puede existir mucho antes de que se abra una oportunidad política.")
    )


    val developmentRubric = listOf(
        RubricCriterion("Tesis y respuesta directa", "Formula desde el inicio una respuesta defendible a la pregunta y vuelve a ella en la conclusión.", 2),
        RubricCriterion("Precisión conceptual", "Define correctamente los conceptos y distingue autores o tipologías sin mezclar categorías.", 3),
        RubricCriterion("Mecanismo explicativo", "No se limita a nombrar conceptos: explica cómo y por qué operan en el problema analizado.", 3),
        RubricCriterion("Aplicación al caso", "Usa hechos pertinentes del caso para demostrar el argumento, no como narración separada.", 3),
        RubricCriterion("Integración y comparación", "Relaciona al menos dos marcos cuando ello agrega capacidad explicativa y explicita sus diferencias.", 2),
        RubricCriterion("Cierre analítico", "Concluye sintetizando qué permite comprender el marco y cuáles son sus límites.", 2)
    )

    val timelines = listOf(
        CaseTimeline(
            "Ley de Suelos",
            "De una agenda científica de larga duración a una propuesta legislativa coordinada",
            listOf(
                TimelineEvent("2000", "Problema científico con historia", "La Sociedad Chilena de la Ciencia del Suelo organiza un simposio sobre un proyecto de ley de protección de suelos, antecedente de una agenda de más de dos décadas.", listOf("agenda setting")),
                TimelineEvent("2014–2015", "Sociedad civil y primer puente parlamentario", "La ONG Suelo Sustentable se organiza, se registra como gestor de interés y logra reuniones de trabajo en el Senado en torno a una propuesta de ley.", listOf("brokerage", "redes")),
                TimelineEvent("2018–2019", "Nuevas alianzas", "La renovación de la Sociedad Chilena de la Ciencia del Suelo y el vínculo con la senadora Carmen Gloria Aravena amplían la coalición; en junio de 2019 se realiza el seminario Ley General de Suelos.", listOf("actores", "ventana de oportunidad")),
                TimelineEvent("2020–2021", "Metodología de consensos", "Comités científico-técnicos y mesas de trabajo articulan a especialistas, sociedad civil, asesores y actores políticos para transformar conocimiento disperso en un texto compartido.", listOf("co-creación", "intermediación", "formulación")),
                TimelineEvent("12 enero 2022", "Idea de legislar", "La Sala del Senado aprueba por unanimidad de los presentes la idea de legislar sobre la calidad de los suelos.", listOf("legitimación")),
                TimelineEvent("2022", "La formulación continúa", "El caso muestra que el avance legislativo no cierra el proceso: siguen ajustes, plazos y negociación del articulado.", listOf("policy cycle", "no linealidad"))
            )
        ),
        CaseTimeline(
            "Humedales Urbanos",
            "Investigación, vínculo parlamentario y aprendizaje político",
            listOf(
                TimelineEvent("2009–2010", "Del conocimiento del riesgo a un problema público", "Investigaciones de Carolina Rojas sobre expansión urbana y humedales adquieren visibilidad pública antes del terremoto de 2010, que refuerza la relevancia social del problema.", listOf("definición del problema")),
                TimelineEvent("2016", "Difusión y construcción de redes", "Seminarios y actividades sobre urbanización en humedales acercan la investigación a actores fuera de la academia.", listOf("engagement", "redes")),
                TimelineEvent("6 junio 2017", "Ingreso de la moción", "Una moción transversal para proteger humedales urbanos ingresa al Senado.", listOf("agenda", "formulación")),
                TimelineEvent("5 junio 2018", "La académica entra a la comisión", "Carolina Rojas expone ante la Comisión de Medio Ambiente, traduciendo evidencia a una audiencia legislativa concreta.", listOf("public scholarship", "Science Arbiter / broker")),
                TimelineEvent("2018", "Negociación legislativa", "El proyecto avanza en el Senado y luego llega a la Cámara de Diputadas y Diputados; la evidencia se inserta en una dinámica de votos, indicaciones y estrategia.", listOf("legitimación", "uso de evidencia")),
                TimelineEvent("octubre–noviembre 2019", "Cierre político", "Tras observaciones y negociación con el Ejecutivo, el proyecto queda listo y el 13 de noviembre obtiene una aprobación amplia en la Cámara.", listOf("coaliciones", "arte de lo posible")),
                TimelineEvent("2019–2020", "Ley 21.202", "El proceso culmina en la Ley de Humedales Urbanos, mostrando que el resultado legal es producto de una trayectoria relacional y no de transferencia automática de evidencia.", listOf("resultado", "brokerage"))
            )
        ),
        CaseTimeline(
            "Regulación térmica",
            "Tres décadas de conocimiento con propósito, negociación técnica e implementación",
            listOf(
                TimelineEvent("1985–1990", "Vocación pública y problema habitacional", "Waldo Bustamante inicia trabajo en soluciones energéticas y vincula desempeño térmico de la vivienda con bienestar social, no sólo con ingeniería.", listOf("public scholarship")),
                TimelineEvent("1991–1993", "Puente local–MINVU", "Experiencias locales y una primera comisión de reglamentación crean un espacio donde normas técnicas comienzan a conectarse con instrumentos públicos.", listOf("boundary work", "intermediación")),
                TimelineEvent("1994–2000", "Primera fase: techos", "La estrategia prioriza una exigencia técnicamente defendible y políticamente viable; el D.S. 115, vigente desde marzo de 2000, incorpora exigencias térmicas en la OGUC.", listOf("formulación", "factibilidad")),
                TimelineEvent("2001–2007", "Ampliar la envolvente", "La segunda fase intenta extender la regulación a muros, ventanas y pisos, elevando el conflicto técnico y económico; el D.S. 192 entra en vigencia en enero de 2007.", listOf("negociación", "intereses")),
                TimelineEvent("2013–2014", "Nueva actualización basada en estudios", "Bustamante y equipos técnicos desarrollan estudios para actualizar el estándar, incorporando desempeño de toda la envolvente y nuevas exigencias.", listOf("conocimiento con propósito", "broker")),
                TimelineEvent("2024–2025", "Promulgación e implementación diferida", "La actualización se publica en 2024 y entra en vigencia en noviembre de 2025, ilustrando la distancia temporal entre producción de evidencia, decisión normativa e implementación.", listOf("implementación", "temporalidad"))
            )
        ),
        CaseTimeline(
            "Neuroderechos",
            "De una advertencia científica global a una innovación constitucional chilena",
            listOf(
                TimelineEvent("2017", "Morningside Group", "La discusión científica y ética sobre neurotecnologías se articula internacionalmente y propone prioridades para proteger autonomía, identidad y datos cerebrales.", listOf("anticipación", "ética")),
                TimelineEvent("18 enero 2019", "Encuentro Yuste–Girardi", "Rafael Yuste presenta la idea de neuroderechos en Congreso Futuro y comienza una colaboración con el senador Guido Girardi.", listOf("ventana", "emprendimiento político")),
                TimelineEvent("mayo–octubre 2019", "Red interdisciplinaria", "La UC, especialistas en bioética, abogados y científicos participan en la discusión; en octubre se anuncia una reforma constitucional para proteger neuroderechos.", listOf("boundary work", "pluralismo")),
                TimelineEvent("7 octubre 2020", "Dos proyectos ingresan al Senado", "Se presentan una reforma constitucional y un proyecto legal sobre neuroprotección, traduciendo una controversia emergente a arquitectura normativa.", listOf("formulación", "Honest Broker / advocacy")),
                TimelineEvent("2021", "Ley 21.383", "La reforma constitucional es aprobada, incorporando una protección vinculada a la actividad cerebral y a la información proveniente de ella.", listOf("legitimación", "innovación institucional")),
                TimelineEvent("Después de 2021", "Dos trayectorias distintas", "La reforma constitucional avanza más rápido que el proyecto legal, mientras persisten desacuerdos académicos sobre necesidad, alcance y diseño regulatorio.", listOf("incertidumbre", "pluralismo", "no linealidad"))
            )
        )
    )
}
