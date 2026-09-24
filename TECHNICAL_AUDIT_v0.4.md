# Auditoría técnica y pedagógica — v0.4

## Cobertura funcional

- 120 preguntas de alternativa: 20 por cada uno de los módulos prioritarios 1–6.
- 12 preguntas de desarrollo con rúbrica de autocorrección.
- 8 fichas de lectura profunda.
- 4 dossiers de casos.
- 26 conexiones en matriz concepto × autor × caso.
- 4 líneas de tiempo de casos.
- 46 flashcards de recuperación activa.
- 24 preguntas de práctica oral.
- 10 combinaciones adaptativas autor × caso.

## Lógica adaptativa

El índice de dominio no se presenta como calificación. Se calcula con tres señales del banco objetivo:

1. nivel medio de repetición espaciada (55%);
2. precisión histórica de respuestas (30%);
3. cobertura de preguntas vinculadas (15%).

La ruta autor × caso combina dominio del autor (45%), dominio del caso (30%) y desempeño en los conceptos asociados (25%). Cuando no existe práctica registrada, el sistema explicita que faltan datos y recomienda construir cobertura antes de interpretar el porcentaje.

## Generación de simulacros

Los simulacros mantienen balance por módulo. El generador compara la selección con el intento inmediatamente anterior y vuelve a barajar hasta 12 veces buscando una superposición igual o inferior a 65%. Dado que cada módulo dispone de 20 preguntas, esta restricción es alcanzable en condiciones normales.

## Auditoría de contenido

La v0.4 no incorpora nuevas afirmaciones sustantivas externas. Las flashcards, preguntas orales y rutas reutilizan contenido ya trazado en `CourseRepository.kt`, `DeepStudyRepository.kt` y `StudyToolsRepository.kt`, construidos a partir del programa y las lecturas/casos cargados del curso. Las recomendaciones de estudio son una capa pedagógica de la app, no afirmaciones atribuidas a los autores.

## Validación ejecutada

Los repositorios Kotlin puros (`Models`, `QuestionBank`, `StudyToolsRepository`, `DeepStudyRepository` y `AdaptiveStudyRepository`) fueron compilados con `kotlinc`. Se ejecutó además un test de control que verificó conteos, generación de estadísticas y baja superposición entre dos simulacros consecutivos. La compilación Android integral sigue requiriendo Android SDK/Gradle, no disponible en el entorno de generación.
