# Auditoría técnica — SUS3021 Study v0.5

## Alcance
La v0.5 agrega planificación adaptativa por tiempo, modo de repaso final, banco filtrable y análisis estructural heurístico de desarrollo.

## Validaciones realizadas
- Compilación con `kotlinc` de modelos y repositorios Kotlin puros, incluidos `StudySessionRepository` y `DevelopmentAnalyzer`.
- Verificación de que los planes de 15, 25 y 45 minutos suman exactamente su duración declarada.
- Verificación del plan “día antes”: 55 minutos distribuidos en cinco bloques.
- Conservación de los conteos de contenido de v0.4: 120 alternativas, 46 flashcards y 24 prompts orales.
- Prueba de ejecución del analizador estructural sobre una respuesta de muestra.
- Auditoría textual del archivo Compose para detectar errores sintácticos evidentes.

## Limitación del entorno
No se realizó ensamblado de APK/AAB porque el entorno no dispone de Android SDK/Gradle configurado. La compilación integral debe ejecutarse en Android Studio o CI con SDK 35.

## Limitación del analizador de desarrollo
`DevelopmentAnalyzer` no es un corrector semántico. Detecta patrones lingüísticos, menciones de conceptos/casos y conectores que suelen corresponder a la arquitectura esperada de una respuesta. Puede producir falsos positivos o falsos negativos. Por diseño, la app obliga a mantener la autocorrección con rúbrica y la comparación con la respuesta modelo.

## Resultados del script de auditoría
- Pielke: 23 preguntas etiquetadas.
- Karp: 20.
- Ouimet et al.: 26.
- Leshner: 13.
- Kraft & Furlong: 11.
- Martinuzzi & Sedlacko: 17.
- Casos etiquetados en el banco: Suelos 12, Humedales 8, regulación térmica 9, Neuroderechos 12.
- Respuesta de prueba mínima: cobertura estructural 0%; respuesta rica de prueba: 100%. Esto confirma sensibilidad del detector a la presencia de la estructura, no validez sustantiva.
