package com.example.enesportfolio.feature.portfolio.presentation.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

internal object PortfolioLayout {
    val PageMaxWidth = 1120.dp
    val StackBreakpoint = 860.dp
    val CompactBreakpoint = 560.dp
}

@Composable
internal fun PageWidth(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    BoxWithConstraints(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter,
    ) {
        val horizontalPadding = if (maxWidth < PortfolioLayout.CompactBreakpoint) 22.dp else 19.dp
        Box(
            modifier = Modifier
                .widthIn(max = PortfolioLayout.PageMaxWidth)
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding),
        ) {
            content()
        }
    }
}
