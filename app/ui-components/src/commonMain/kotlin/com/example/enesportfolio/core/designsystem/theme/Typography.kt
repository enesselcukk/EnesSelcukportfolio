package com.example.enesportfolio.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun PortfolioTypography(): Typography {
    val sans = PortfolioFonts.sansFamily
    val serif = PortfolioFonts.serifFamily
    val mono = PortfolioFonts.monoFamily

    return Typography(
        displayLarge = TextStyle(
            fontFamily = serif,
            fontWeight = FontWeight.Medium,
            fontSize = 64.sp,
            lineHeight = 59.sp,
            letterSpacing = (-2.9).sp,
            color = Palette.Ink,
        ),
        headlineLarge = TextStyle(
            fontFamily = serif,
            fontWeight = FontWeight.Medium,
            fontSize = 32.sp,
            lineHeight = 36.sp,
            letterSpacing = (-0.96).sp,
            color = Palette.Ink,
        ),
        headlineMedium = TextStyle(
            fontFamily = serif,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            lineHeight = 22.sp,
            letterSpacing = (-0.54).sp,
            color = Palette.Ink,
        ),
        titleLarge = TextStyle(
            fontFamily = sans,
            fontWeight = FontWeight.Medium,
            fontSize = 17.sp,
            lineHeight = 22.sp,
            color = Palette.Ink,
        ),
        titleMedium = TextStyle(
            fontFamily = sans,
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            lineHeight = 20.sp,
            color = Palette.Ink,
        ),
        bodyLarge = TextStyle(
            fontFamily = sans,
            fontWeight = FontWeight.Light,
            fontSize = 17.sp,
            lineHeight = 26.sp,
            letterSpacing = 0.17.sp,
            color = Palette.Muted,
        ),
        bodyMedium = TextStyle(
            fontFamily = sans,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            lineHeight = 25.sp,
            letterSpacing = 0.16.sp,
            color = Palette.Muted,
        ),
        bodySmall = TextStyle(
            fontFamily = sans,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 22.sp,
            letterSpacing = 0.14.sp,
            color = Palette.Muted,
        ),
        labelLarge = TextStyle(
            fontFamily = sans,
            fontWeight = FontWeight.Medium,
            fontSize = 12.5.sp,
            lineHeight = 16.sp,
            letterSpacing = 2.sp,
            color = Palette.Gold,
        ),
        labelMedium = TextStyle(
            fontFamily = sans,
            fontWeight = FontWeight.Medium,
            fontSize = 12.5.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp,
            color = Palette.Violet,
        ),
        labelSmall = TextStyle(
            fontFamily = mono,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.13.sp,
            color = Palette.Muted,
        ),
    )
}
