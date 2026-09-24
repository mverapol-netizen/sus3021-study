# Trazabilidad de fuentes de contenido

Esta aplicación no intenta sustituir las lecturas. Su banco de estudio deriva de los siguientes materiales del proyecto:

| Bloque | Fuente principal | Uso dentro de la app |
|---|---|---|
| Movilización de conocimiento | Garretón et al. (2020), *Diseño de Sistema Vincula: Needfinding* | Needfinding, mapa de actores, oferta/demanda, diseño de interfaz |
| Knowledge brokerage | Martinuzzi & Sedlacko, capítulo final de *Knowledge Brokerage for Sustainable Development* | Modelo lineal, sistemas, redes, boundary work, juegos de brokerage |
| Roles de expertos | Roger A. Pielke Jr. (2007), *The Honest Broker*, cap. 1 | Pure Scientist, Science Arbiter, Issue Advocate, Honest Broker |
| Ciclo de políticas | Kraft & Furlong (2018), *Public Policy*, Policy Process Model | Agenda, formulación, legitimación, implementación, evaluación, cambio; advertencia de no linealidad |
| Confianza y engagement | Alan I. Leshner (2021), *Trust in Science Is Not the Problem* | confianza vs conducta, modelo de déficit, sesgos, incertidumbre, public engagement |
| Evidencia en legislaturas | Ouimet et al. (2023), *Use of research evidence in legislatures* | usos instrumental/conceptual/simbólico, usos legislativos específicos, barreras/facilitadores |
| Rol público académico | Ivan Karp (2012), *Public scholarship as a vocation* | public scholarship, pluralismo, público activo, compromiso y fronteras institucionales |
| Caso 2 | *Tres mujeres, un destino: la creación del Anteproyecto de la Ley de Suelo* | línea de tiempo, consensos, redes, oportunidad política y brokerage |
| Caso 3 | *Dos corazones unidos por un sueño: la Ley de Humedales Urbanos* | línea de tiempo, trayectoria de Carolina Rojas, relación academia–Congreso |
| Caso 4 | *Del cielo al suelo construyendo una misión* | línea de tiempo de regulación térmica, conocimiento con propósito, MINVU, gradualidad e implementación |
| Caso 5 | *Historia de la Ley de Neuroderechos* | línea de tiempo, Morningside Group, Yuste/Girardi, bioética, reforma constitucional y controversia |
| Estructura del curso | Programa SUS3021, semestre 02-2026 | secuencia de sesiones, prioridad de prueba y módulos posteriores |

## Regla editorial aplicada

Cuando el programa exige materiales específicos que no están incorporados al repositorio —por ejemplo, infografías posteriores o roles de simulación— el módulo se mantiene visible pero bloqueado. No se completó con conocimiento general externo.


## Cobertura añadida en v0.3

| Recurso de la app | Base documental |
|---|---|
| Ficha Vincula | Garretón et al. (2020), Needfinding, mapas de actores/3C y matrices lógicas |
| Ficha Knowledge Brokerage | Martinuzzi & Sedlacko, capítulo final: tres enfoques y cuatro juegos |
| Ficha roles del científico | Pielke (2007), capítulo 1 |
| Ficha policy cycle | Kraft & Furlong, pp. 154–177 |
| Ficha confianza/engagement | Leshner (2021) |
| Ficha uso de evidencia | Ouimet et al. (2023) |
| Ficha public scholarship | Karp (2012) |
| Ficha ozono | Nature Editorial (2025), marcada como complementaria |
| Dossier Suelos | Ciencia y Democracia, caso 2 |
| Dossier Humedales | Ciencia y Democracia, caso 3 |
| Dossier regulación térmica | Ciencia y Democracia, caso 4 |
| Dossier Neuroderechos | Ciencia y Democracia, caso 5 |

El comparador y las secciones “cómo usarlo en desarrollo” son síntesis analíticas construidas a partir de esas fuentes y de los marcos teóricos del curso; no se presentan como citas textuales de los materiales.

## v0.4: capas adaptativas

`AdaptiveStudyRepository.kt` no introduce una nueva fuente académica. Sus flashcards y preguntas orales reutilizan definiciones, tesis, mecanismos y casos ya trazados en esta documentación. El índice de dominio, las reglas de etiquetado y la ruta autor × caso son funciones pedagógicas creadas para la aplicación y deben leerse como ayudas de estudio, no como resultados empíricos de las lecturas.


## v0.6 — Capa de preparación intensiva
Las funciones de calendario, historial, matriz de errores y selección de examen no agregan contenido disciplinar nuevo. Operan sobre el banco, fichas, matrices y casos ya trazados en versiones anteriores. La composición 5 preguntas × 6 módulos del examen final es una decisión de diseño pedagógico de la aplicación y se muestra explícitamente como no oficial.


## v0.7 — Banco intensivo y modo profesor

`DevelopmentIntensiveRepository.kt` reutiliza únicamente el corpus ya documentado: Martinuzzi & Sedlacko, Pielke, Kraft & Furlong, Leshner, Ouimet et al., Karp y los casos de Suelos, Humedales Urbanos, regulación térmica y Neuroderechos.

Las 30 preguntas son **ejercicios plausibles construidos por síntesis** a partir de ese corpus; no provienen de un banco oficial ni se presentan como predicciones de evaluación. Las respuestas modelo combinan definiciones y mecanismos sustentados en las fuentes con aplicaciones analíticas a los casos. Cuando se comparan autores o casos, la comparación es una síntesis pedagógica de la aplicación y no una cita textual de las lecturas.

El `ProfessorModeAnalyzer` no incorpora conocimiento externo: busca señales léxicas asociadas a los conceptos, mecanismos y casos almacenados en cada pauta. Por ello, una coincidencia no garantiza corrección conceptual y una ausencia léxica tampoco demuestra que el argumento sea incorrecto.


## v0.8 — trazabilidad de fichas guiadas
Las fichas guiadas se construyen a partir de las mismas fuentes ya documentadas en el proyecto: Garretón et al. (Vincula), Martinuzzi & Sedlacko, Pielke, Kraft & Furlong, Leshner, Ouimet et al., Karp y los casos docentes de Suelos, Humedales Urbanos, regulación térmica y Neuroderechos. El editorial de Nature se mantiene explícitamente como complementario. Las secciones “uso en respuesta”, “distinción” y “error frecuente” son ayudas pedagógicas derivadas de esas fuentes y no citas textuales.
