package com.example.enesportfolio.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.enesportfolio.core.designsystem.generated.resources.Res
import com.example.enesportfolio.core.designsystem.generated.resources.fraunces_variable
import com.example.enesportfolio.core.designsystem.generated.resources.ibm_plex_mono_regular
import com.example.enesportfolio.core.designsystem.generated.resources.outfit_light
import com.example.enesportfolio.core.designsystem.generated.resources.outfit_medium
import com.example.enesportfolio.core.designsystem.generated.resources.outfit_regular
import com.example.enesportfolio.core.designsystem.generated.resources.outfit_semibold
import org.jetbrains.compose.resources.Font

object PortfolioFonts {
    val sansFamily: FontFamily
        @Composable get() = FontFamily(
            Font(Res.font.outfit_light, FontWeight.Light),
            Font(Res.font.outfit_regular, FontWeight.Normal),
            Font(Res.font.outfit_medium, FontWeight.Medium),
            Font(Res.font.outfit_semibold, FontWeight.SemiBold),
        )

    val serifFamily: FontFamily
        @Composable get() = FontFamily(
            Font(Res.font.fraunces_variable, FontWeight.Medium),
        )

    val monoFamily: FontFamily
        @Composable get() = FontFamily(
            Font(Res.font.ibm_plex_mono_regular, FontWeight.Normal),
        )
}
