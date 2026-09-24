# SUS3021 Study — Android v0.7

Aplicación **offline-first** para estudiar **Formación de Capacidades para el Intercambio de Conocimiento con el Congreso Nacional (SUS3021)**.

La app está pensada como herramienta de recuperación activa: no sólo resume lecturas, sino que obliga a conectar **concepto → mecanismo → autor → caso → aplicación**.

**Uso académico:** los modelos de respuesta y el modo profesor están diseñados para estudio y práctica. El programa del curso restringe el uso de IA en evaluaciones salvo autorización expresa; por ello, estas respuestas no deben copiarse como entregas evaluadas.



## Novedades v0.7

### Banco intensivo de desarrollo
- **30 preguntas de práctica plausibles** derivadas del programa, lecturas y casos cargados.
- Se presentan expresamente como banco pedagógico, **no como predicción de la prueba oficial**.
- Cobertura: knowledge brokerage, Pielke, policy cycle, Leshner, Ouimet, Karp, cuatro casos, comparaciones y escenarios aplicados.
- Cada pregunta incluye tesis, conceptos esperados, mecanismos, casos pertinentes, esqueleto y errores frecuentes.

### Respuestas modelo por tiempo
- Cada una de las 30 preguntas puede estudiarse en versión **5, 10 o 20 minutos**.
- La app cambia extensión y estrategia según el tiempo disponible: respuesta nuclear, respuesta intermedia o desarrollo completo.
- Los rangos orientativos son 80–150, 160–260 y 250–380 palabras, respectivamente.

### Modo profesor
- Entrega una pregunta sin mostrar autor, conceptos, mecanismos, casos ni modelo.
- Permite escoger 5, 10 o 20 minutos y usar un cronómetro local.
- Tras entregar la respuesta, compara cobertura de conceptos, mecanismos y casos contra la pauta de estudio.
- Reporta lo detectado y lo ausente, muestra tesis/esqueleto y recién entonces revela el modelo temporal correspondiente.
- El porcentaje de cobertura es **heurístico**: no es nota, no valida la verdad de una afirmación y no reemplaza evaluación docente.

## Novedades v0.6

### Calendario automático hasta la prueba
- Genera metas diarias desde la fecha actual hasta el 30 de septiembre de 2026.
- El foco de cada jornada se construye con los autores, conceptos y casos menos consolidados según el historial local.
- Organiza el estudio en fases: cobertura, consolidación teoría–caso, integración, cierre y día de prueba.
- Permite marcar cada jornada como completada.

### Historial y curva de simulacros
- Registra resultados de **Simulacro 30**, **Simulacro mixto** y **Examen final de práctica**.
- Conserva puntaje objetivo, tiempo, fecha/hora y autoevaluación de desarrollo cuando corresponde.
- Presenta una curva con los últimos porcentajes de acierto en alternativas y un historial detallado.

### Matriz de errores recurrentes
- Agrupa errores acumulados por **autor, concepto y caso**.
- Muestra número de errores, tasa de error, número de intentos y preguntas vinculadas.
- Sugiere una acción de repaso específica según el tipo de patrón.

### Examen final de práctica
- **60 minutos: 30 alternativas + 1 desarrollo.**
- 5 alternativas por cada uno de los seis módulos prioritarios.
- Prioriza preguntas no vistas y reduce repetición respecto del intento anterior.
- Mantiene diagnóstico estructural y rúbrica de desarrollo.
- Está rotulado expresamente como **blueprint pedagógico interno**: los materiales disponibles del curso no especifican una distribución oficial de ítems.

## Novedades v0.5

### Sesiones automáticas de 15, 25 y 45 minutos
- El inicio ofrece tres duraciones de estudio.
- Cada plan se recalcula usando la ruta adaptativa autor × caso y el historial de respuestas.
- Los bloques combinan flashcards, alternativas, explicación oral, desarrollo y cierre reflexivo.
- Incluyen cronómetro, progreso por bloques y acceso directo a cada ejercicio dentro de la misma sesión.

### Modo “día antes”
- Plan especial de 55 minutos sin incorporación de materia nueva.
- Prioriza errores y vencidas, flashcards de alto rendimiento, simulacro corto, dos esqueletos de desarrollo y cierre oral.
- La interfaz recuerda explícitamente que el objetivo es consolidar recuperación y estructura, no aumentar el volumen de lectura.

### Banco filtrable
- Nuevo filtro de preguntas por **autor**, **concepto** o **caso**.
- Búsqueda libre y atajos para Pielke, Karp, Ouimet, Kraft/Furlong, Martinuzzi/Sedlacko, Honest Broker, policy cycle, Humedales, Suelos, Neuroderechos y regulación térmica.
- Genera sesiones específicas de hasta 30 preguntas.

### Diagnóstico estructural de respuestas de desarrollo
- Antes de la rúbrica manual, un analizador local detecta señales de: tesis, conceptos, mecanismo, caso, integración/comparación y cierre.
- Reporta cobertura estructural y conceptos/casos reconocidos.
- **No evalúa verdad, precisión conceptual ni calidad argumentativa**: es un detector heurístico de estructura, complementario a la rúbrica y al modelo de respuesta.

## Novedades v0.4

### Flashcards adaptativas
- **46 tarjetas** construidas desde la matriz conceptual, las 8 fichas de lectura y los 4 dossiers de casos.
- Primero se exige recuperación activa; la respuesta se revela sólo después.
- Botones **Revisar / Lo sabía** actualizan una cola independiente de repetición espaciada.
- La siguiente sesión prioriza falladas, vencidas y tarjetas aún no vistas.

### Modo oral
- **24 preguntas breves**, 4 por cada módulo prioritario.
- Temporizador de 60 segundos por pregunta.
- Después de responder se muestran los puntos mínimos que debían aparecer.
- Autoevaluación **Necesito repasar / Lo expliqué**, guardada localmente.

### Dominio por autor, concepto y caso
El nuevo panel **Biblioteca de integración → Dominio** calcula un índice pedagógico de 0 a 100 a partir de:
- cobertura de preguntas vinculadas;
- precisión histórica;
- nivel medio alcanzado en repetición espaciada.

No es una nota académica ni pretende estimar una calificación: sirve exclusivamente para ordenar el estudio.

### Ruta adaptativa teoría × caso
La pantalla de inicio y el panel de dominio priorizan combinaciones como:
- Pielke × Neuroderechos;
- Ouimet × Humedales Urbanos;
- Martinuzzi & Sedlacko × Ley de Suelos;
- Karp × Humedales;
- Kraft & Furlong × regulación térmica;
- Leshner × Neuroderechos.

La ruta se recalcula a partir del desempeño registrado y propone una acción concreta: releer ficha, revisar dossier, hacer flashcards, responder oralmente o escribir una mini respuesta.

### Simulacros distintos
Los simulacros objetivos guardan la composición del intento anterior y regeneran una combinación balanceada procurando que la superposición inmediata no supere aproximadamente dos tercios del examen.


## Contenido incorporado

### 1. Plan de estudio
Seis módulos prioritarios para la prueba del 30 de septiembre:

1. Movilizar conocimiento — Vincula + Martinuzzi/Sedlacko.
2. Roles del científico — Pielke.
3. Ciclo de políticas y confianza — Kraft/Furlong + Leshner.
4. Uso de evidencia en legislaturas — Ouimet et al.
5. Public scholarship — Karp + Neuroderechos.
6. Casos integradores — Suelos, Humedales Urbanos, regulación térmica y Neuroderechos.

Cada módulo contiene lecturas, puntos clave, conceptos, casos, ejemplos y prompts de recuperación activa.

### 2. Banco de preguntas
- **120 preguntas de alternativa**.
- 20 preguntas por cada uno de los 6 módulos prioritarios.
- Dificultad básica, media y de aplicación.
- Feedback conceptual inmediato.
- Modos:
  - Quiz rápido de 15.
  - Simulacro de 30 balanceado por módulo.
  - Repaso adaptativo de 20.
  - Sólo preguntas falladas.
  - Banco completo.

### 3. Repetición espaciada local
Cada pregunta mantiene progreso en `SharedPreferences`:

- intentos;
- aciertos;
- racha;
- nivel de dominio 0–5;
- próxima fecha de repaso;
- estado de última respuesta.

Intervalos después de respuestas correctas: **1, 3, 7, 14 y 30 días**. Un error devuelve la pregunta al nivel inicial y la deja disponible para repaso inmediato.

### 4. Desarrollo
- 12 desarrollos canónicos con tesis, estructura y respuesta modelo, más un banco intensivo adicional de 30 preguntas con modelos de 5/10/20 minutos.
- Modo de práctica: primero se redacta la respuesta y sólo después se habilitan:
  - rúbrica de 15 puntos;
  - tesis esperada;
  - estructura sugerida;
  - respuesta modelo.
- La puntuación es **autoevaluación guiada**, no calificación automática del texto.

### 5. Mapa de integración
Dos herramientas:

- **Matriz conceptual**: 26 conexiones entre concepto, autor, idea central, casos y uso esperado en prueba.
- **Líneas de tiempo**: Ley de Suelos, Humedales Urbanos, regulación térmica y Neuroderechos.

## Trazabilidad académica

El contenido se construyó exclusivamente a partir del programa y los materiales disponibles en el proyecto para el bloque evaluable. Los módulos posteriores mantienen su estructura, pero no se rellenan artificialmente cuando faltan las infografías o lecturas específicas del curso.

## Arquitectura

- Kotlin
- Jetpack Compose
- Material 3
- minSdk 26
- targetSdk 35
- Sin backend
- Datos de estudio locales

Archivos principales:

- `CourseRepository.kt`: módulos y 12 desarrollos canónicos.
- `QuestionBank.kt`: banco de 120 preguntas.
- `StudyToolsRepository.kt`: matriz conceptual, rúbrica y líneas de tiempo.
- `ProgressStore.kt`: progreso y repetición espaciada.
- `StudySessionRepository.kt`: planificación temporal adaptativa y analizador estructural de desarrollo.
- `IntensivePrepRepository.kt`: calendario hasta la prueba, matriz de errores y selección fresca del examen final de práctica.
- `DevelopmentIntensiveRepository.kt`: banco de 30 preguntas, modelos temporales y analizador del modo profesor.
- `MainActivity.kt`: navegación y pantallas Compose.

## Abrir en Android Studio

1. Abra la carpeta `SUS3021Study`.
2. Use JDK 17.
3. Sincronice Gradle.
4. Ejecute en emulador o dispositivo Android API 26+.

El entorno de generación no dispone del Android SDK, por lo que no se incluye un APK precompilado. Sí se realizó compilación de control con `kotlinc` sobre los componentes Kotlin puros del repositorio de contenido.

## Pendiente para una versión posterior

- Importar materiales de sesiones 10–17 cuando estén disponibles.
- Fichas de lectura extensas con localización de página.
- Buscador global transversal que conecte alternativas, flashcards, lecturas y desarrollos.
- Exportación del progreso de estudio.
- Posible motor de evaluación semántica de respuestas de desarrollo, si se decide incorporar conectividad o un modelo local/remoto.
- Exportación/importación del historial de simulacros entre dispositivos.


## Novedades v0.3

- 8 fichas extensas de lectura: pregunta central, tesis, mapa argumental, conceptos, tensiones, conexiones con casos y posibles preguntas de prueba.
- 4 dossiers de casos (Suelos, Humedales Urbanos, regulación térmica y Neuroderechos) con actores, base de conocimiento, mecanismos, barreras, facilitadores y usos analíticos.
- Comparador móvil de casos por problema, temporalidad, puente, mecanismo, barrera, conceptos y errores a evitar.
- Simulacro mixto cronometrado de 50 minutos: 20 alternativas balanceadas + 1 desarrollo, sin feedback inmediato durante la parte objetiva y con rúbrica al final.
- Se mantiene el banco de 120 alternativas, 12 desarrollos, repetición espaciada, matriz conceptual y líneas de tiempo.

Las nuevas fichas están construidas a partir de los PDFs cargados para SUS3021. Cuando una conexión es una aplicación analítica del curso y no una afirmación textual del autor/caso, la app la presenta como conexión o uso para examen, separada del resumen de fuente.


## Estudio guiado v0.8
La versión 0.8 cierra la expansión funcional y concentra el trabajo en dos recursos de repaso: fichas de lectura y fichas conceptuales. En Biblioteca → Guiado hay 8 rutas de lectura y 39 conceptos. Cada lectura se trabaja en cinco movimientos: orientación, reconstrucción del argumento, recuperación sin mirar, pauta/síntesis y conexión con casos. Cada concepto obliga primero a recuperar la definición antes de revelar distinción, mecanismo, ejemplo y error frecuente. El progreso queda almacenado localmente.
