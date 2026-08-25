package com.example.enesportfolio.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

@Immutable
data class ProjectCardTheme(
    val surface: Color,
    val surfaceHover: Color,
    val border: Color,
    val borderHover: Color,
    val accent: Color,
    val link: Color,
    val chipBackground: Color,
    val chipBorder: Color,
    val chipText: Color,
)

@Composable
@ReadOnlyComposable
fun projectCardTheme(index: String): ProjectCardTheme {
    val scheme = MaterialTheme.colorScheme
    val accent = projectAccent(index)
    val onSurface = scheme.onSurface
    val chipText = Color(
        red = (accent.red * 0.28f + onSurface.red * 0.72f).coerceIn(0f, 1f),
        green = (accent.green * 0.28f + onSurface.green * 0.72f).coerceIn(0f, 1f),
        blue = (accent.blue * 0.28f + onSurface.blue * 0.72f).coerceIn(0f, 1f),
        alpha = 1f,
    )
    return ProjectCardTheme(
        surface = accent.copy(alpha = 0.11f),
        surfaceHover = accent.copy(alpha = 0.17f),
        border = accent.copy(alpha = 0.28f),
        borderHover = accent.copy(alpha = 0.46f),
        accent = accent,
        link = accent.copy(alpha = 0.92f),
        chipBackground = accent.copy(alpha = 0.16f),
        chipBorder = accent.copy(alpha = 0.34f),
        chipText = chipText,
    )
}

@Composable
@ReadOnlyComposable
private fun projectAccent(index: String): Color {
    val scheme = MaterialTheme.colorScheme
    val accents = PortfolioTheme.projectAccents
    return when (index) {
        "01" -> scheme.tertiary
        "02" -> accents.terracotta
        "03" -> accents.rose
        "04" -> accents.sky
        "05" -> accents.steel
        "06" -> scheme.primary
        "07" -> accents.sage
        "08" -> scheme.secondary
        else -> scheme.tertiary
    }
}
