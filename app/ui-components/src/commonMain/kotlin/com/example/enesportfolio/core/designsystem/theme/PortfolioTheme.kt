package com.example.enesportfolio.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class PortfolioProjectAccents(
    val terracotta: Color,
    val rose: Color,
    val sky: Color,
    val steel: Color,
    val sage: Color,
)

private val LocalPortfolioProjectAccents = staticCompositionLocalOf {
    PortfolioProjectAccents(
        terracotta = Palette.Terracotta,
        rose = Palette.Rose,
        sky = Palette.Sky,
        steel = Palette.Steel,
        sage = Palette.Sage,
    )
}

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
    onTertiary = Palette.Background,
    outline = Palette.Line,
)

@Composable
fun PortfolioTheme(content: @Composable () -> Unit) {
    val projectAccents = PortfolioProjectAccents(
        terracotta = Palette.Terracotta,
        rose = Palette.Rose,
        sky = Palette.Sky,
        steel = Palette.Steel,
        sage = Palette.Sage,
    )
    CompositionLocalProvider(LocalPortfolioProjectAccents provides projectAccents) {
        MaterialTheme(
            colorScheme = PortfolioColorScheme,
            typography = PortfolioTypography(),
            content = content,
        )
    }
}

object PortfolioTheme {
    val projectAccents: PortfolioProjectAccents
        @Composable
        @ReadOnlyComposable
        get() = LocalPortfolioProjectAccents.current
}
