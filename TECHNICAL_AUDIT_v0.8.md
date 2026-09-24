# Auditoría técnica v0.8

## Alcance
La versión 0.8 agrega exclusivamente recursos de estudio guiado: fichas de lectura y fichas conceptuales. No modifica el banco de preguntas, el modo profesor, los simulacros ni la lógica adaptativa existente.

## Verificaciones realizadas
- 8 `GuidedReadingPlan` con IDs únicos 1–8.
- 39 `ConceptStudyCard` con IDs únicos 1–39.
- Los 8 planes remiten a las 8 fichas de lectura existentes en `DeepStudyRepository`.
- Compilación correcta con `kotlinc` de `Models.kt`, `GuidedStudyRepository.kt`, `DeepStudyRepository.kt` y, posteriormente, de todos los repositorios Kotlin puros salvo `ProgressStore.kt` (depende de Android).
- `MainActivity.kt` fue sometido a una pasada del parser de Kotlin; no se detectaron errores sintácticos (`expecting`, `unexpected tokens`, llaves faltantes). Los errores restantes al compilarlo fuera de Android son referencias esperables a AndroidX/Compose.
- Se incorporó persistencia local para marcar lecturas y conceptos como estudiados.

## Límites
No se generó APK en este entorno porque no está disponible el Android SDK/Gradle completo. La compilación integral debe hacerse en Android Studio/JDK 17 como en versiones anteriores.
