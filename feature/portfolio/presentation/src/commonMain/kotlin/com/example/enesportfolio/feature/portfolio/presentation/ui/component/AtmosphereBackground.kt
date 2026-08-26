package com.example.enesportfolio.feature.portfolio.presentation.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.enesportfolio.core.designsystem.theme.Palette

@Composable
internal fun AtmosphereBackground(
    modifier: Modifier = Modifier,
) {
    Canvas(modifier = modifier) {
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Palette.Violet.copy(alpha = 0.28f), Color.Transparent),
                center = Offset(size.width * 0.06f, size.height * -0.12f),
                radius = size.width * 0.8f,
            ),
            radius = size.width * 0.8f,
            center = Offset(size.width * 0.06f, size.height * -0.12f),
        )
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Palette.Gold.copy(alpha = 0.14f), Color.Transparent),
                center = Offset(size.width, size.height * 0.08f),
                radius = size.width * 0.52f,
            ),
            radius = size.width * 0.52f,
            center = Offset(size.width, size.height * 0.08f),
        )
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Palette.Mint.copy(alpha = 0.12f), Color.Transparent),
                center = Offset(size.width * 0.72f, size.height * 1.08f),
                radius = size.width * 0.56f,
            ),
            radius = size.width * 0.56f,
            center = Offset(size.width * 0.72f, size.height * 1.08f),
        )
    }
}
