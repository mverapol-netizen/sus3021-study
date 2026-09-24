# Auditoría técnica v0.7 — SUS3021 Study

## Alcance

La v0.7 añade una capa de práctica intensiva de desarrollo sin modificar el banco objetivo ni los motores de repetición de versiones anteriores.

## Componentes nuevos

1. `IntensiveDevelopmentQuestion`, `TimedModelAnswer` y `ProfessorFeedback` en `Models.kt`.
2. `DevelopmentIntensiveRepository.kt` con 30 preguntas únicas.
3. Generador de respuestas modelo en tres duraciones: 5, 10 y 20 minutos.
4. `ProfessorModeAnalyzer`, detector local de cobertura temática.
5. Pantalla de banco intensivo con filtro temático/búsqueda.
6. Pantalla de detalle con cambio dinámico de extensión.
7. Modo profesor con cronómetro, entrega sin pistas y comparación posterior.

## Verificaciones ejecutadas

- Compilación con `kotlinc` de todos los repositorios/modelos Kotlin puros: correcta.
- IDs del banco intensivo: 30/30 únicos.
- Distribución temática: 3 knowledge brokerage; 4 Pielke; 3 policy cycle; 3 Leshner; 3 Ouimet; 3 Karp; 4 casos; 3 comparaciones; 4 aplicaciones.
- Generación de los tres modelos temporales: correcta.
- Prueba de `ProfessorModeAnalyzer` con una respuesta sintética sobre Neuroderechos: detectó conceptos, mecanismos y caso esperados.
- `MainActivity.kt` fue sometido a control sintáctico con el compilador Kotlin; los errores reportados corresponden a dependencias Android/Compose ausentes en el entorno y no se observaron errores de parser.

## Limitación del entorno

No hay Android SDK/Gradle instalado en el entorno de generación, por lo que no se ejecutó `assembleDebug` ni se produjo APK. La sincronización y compilación integral debe hacerse en Android Studio con JDK 17 y Android SDK 35.

## Nota metodológica

El porcentaje del modo profesor es un índice de cobertura léxica ponderada. No debe interpretarse como calificación, predicción de nota ni evaluación semántica completa.
