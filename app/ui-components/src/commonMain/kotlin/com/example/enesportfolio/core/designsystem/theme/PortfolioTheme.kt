package com.example.enesportfolio.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val PortfolioColorScheme = darkColorScheme(
    background = Palette.Background,
    onBackground = Palette.Ink,
    surface = Palette.BackgroundElevated,
    onSurface = Palette.Ink,
    primary = Palette.Violet,
    onPrimary = Palette.Background,
    secondary = Palette.Mint,
    onSecondary = Palette.Background,
    tertiary = Palette.Gold,
    outline = Palette.Line,
)

@Composable
fun PortfolioTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = PortfolioColorScheme,
        typography = PortfolioTypography(),
        content = content,
    )
}
