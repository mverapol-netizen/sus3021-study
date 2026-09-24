# Auditoría técnica v0.6 — SUS3021 Study

Fecha de versión: 2026-09-24

## Alcance
La v0.6 agrega una capa de preparación intensiva sin introducir nuevos contenidos académicos externos al corpus del curso. Los nuevos componentes reorganizan el banco existente, el historial de práctica y las etiquetas autor/concepto/caso.

## Funciones incorporadas

1. **Calendario adaptativo hasta la prueba**
   - Fecha de prueba configurada: 30-09-2026, según el programa cargado.
   - Genera una meta por día desde `LocalDate.now()` hasta la fecha de prueba.
   - Fases: cobertura y precisión; consolidación teoría–caso; integración y examen; consolidación final; día de prueba.
   - Cada día recibe un foco derivado de la ruta adaptativa y de los autores/casos con menor dominio registrado.
   - El usuario puede marcar cumplimiento diario en `SharedPreferences`.

2. **Historial de simulacros**
   - Registra Simulacro 30, Simulacro mixto y Examen final de práctica.
   - Conserva fecha/hora, puntaje objetivo, puntaje de desarrollo cuando existe, tiempo utilizado e IDs de preguntas.
   - Se visualizan los últimos intentos y una curva de porcentaje de aciertos objetivos.

3. **Matriz de errores recurrentes**
   - Agrega errores históricos por autor, concepto y caso.
   - Usa las mismas etiquetas del motor adaptativo de v0.4/v0.5.
   - Informa intentos, errores, tasa de error y sugerencia de repaso.
   - No interpreta automáticamente un error como ausencia de conocimiento; sólo describe concentración de errores registrados.

4. **Examen final de práctica**
   - 60 minutos.
   - 30 alternativas: 5 por cada uno de los seis módulos prioritarios.
   - 1 pregunta de desarrollo con rúbrica y diagnóstico estructural.
   - La selección prioriza preguntas aún no vistas y, en segundo término, preguntas no usadas en el intento final anterior.
   - El formato está rotulado en la interfaz como **blueprint pedagógico interno**, porque los materiales disponibles no especifican la estructura oficial de la prueba.

## Validaciones realizadas

### Compilación de lógica Kotlin pura
Compilan correctamente con `kotlinc`:
- `Models.kt`
- `QuestionBank.kt`
- `CourseRepository.kt`
- `StudyToolsRepository.kt`
- `DeepStudyRepository.kt`
- `AdaptiveStudyRepository.kt`
- `StudySessionRepository.kt`
- `IntensivePrepRepository.kt`

Resultado: `content.jar` generado sin errores. Única advertencia: constructor `Locale(String, String)` marcado como deprecated por Java; no afecta funcionalidad.

### Coherencia de selección final
- Banco: 120 preguntas.
- Módulos prioritarios: 6.
- Blueprint final: 5 preguntas por módulo = 30 preguntas.
- Cada módulo contiene 20 preguntas, por lo que existe holgura suficiente para priorizar preguntas nuevas y reducir repetición.

### Persistencia
`ProgressStore` conserva:
- progreso de preguntas;
- progreso de flashcards;
- progreso oral;
- último conjunto de IDs por tipo de examen;
- historial de intentos de examen;
- cumplimiento del calendario diario.

## Limitaciones técnicas
- No hay Android SDK en el entorno de generación, por lo que no se generó APK ni se ejecutó compilación integral del módulo Compose.
- La curva de rendimiento muestra precisión objetiva de alternativas. El puntaje de desarrollo es autoevaluado y se presenta separadamente.
- El analizador de desarrollo sigue siendo heurístico: detecta estructura, no verdad ni calidad argumentativa.
- El calendario se basa en el dominio observado al momento de abrirlo; se recalcula al actualizar la pantalla, no predice aprendizaje futuro.
