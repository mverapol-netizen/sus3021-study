package cl.uc.sus3021study.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val StudyColors = lightColorScheme(
    primary = Color(0xFF173B57),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFD8E9F5),
    onPrimaryContainer = Color(0xFF0B283B),
    secondary = Color(0xFF6B4D7A),
    secondaryContainer = Color(0xFFEEDDF3),
    tertiary = Color(0xFF6A5B2B),
    background = Color(0xFFF7F8FA),
    surface = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFFE9EDF1),
    outline = Color(0xFF7B8790)
)

@Composable
fun SUS3021Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = StudyColors,
        content = content
    )
}
