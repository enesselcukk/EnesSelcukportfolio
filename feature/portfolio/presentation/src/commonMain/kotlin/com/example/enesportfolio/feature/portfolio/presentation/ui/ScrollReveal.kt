package com.example.enesportfolio.feature.portfolio.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

private const val MinScale = 0.92f

@Composable
fun ScrollRevealItem(
    listState: LazyListState,
    itemIndex: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val progressState = rememberScrollRevealProgress(listState, itemIndex)

    Box(
        modifier = modifier.graphicsLayer {
            val progress = progressState.value
            val scale = lerp(MinScale, 1f, progress)
            scaleX = scale
            scaleY = scale
            transformOrigin = TransformOrigin(0.5f, 0.5f)
        },
    ) {
        content()
    }
}

@Composable
private fun rememberScrollRevealProgress(
    listState: LazyListState,
    itemIndex: Int,
): State<Float> {
    val density = LocalDensity.current
    val revealDistancePx = with(density) { 180.dp.toPx() }

    return remember(listState, itemIndex, revealDistancePx) {
        derivedStateOf {
            listState.firstVisibleItemIndex
            listState.firstVisibleItemScrollOffset
            scrollRevealProgress(
                listState = listState,
                itemIndex = itemIndex,
                revealDistancePx = revealDistancePx,
            )
        }
    }
}

private fun scrollRevealProgress(
    listState: LazyListState,
    itemIndex: Int,
    revealDistancePx: Float,
): Float {
    val layoutInfo = listState.layoutInfo
    if (layoutInfo.totalItemsCount == 0) return 1f

    val visibleItem = layoutInfo.visibleItemsInfo.find { it.index == itemIndex } ?: return 0f

    val viewportStart = layoutInfo.viewportStartOffset.toFloat()
    val viewportEnd = layoutInfo.viewportEndOffset.toFloat()
    val itemTop = visibleItem.offset.toFloat()
    val itemBottom = itemTop + visibleItem.size

    val progressFromBottom = ((viewportEnd - itemTop) / revealDistancePx).coerceIn(0f, 1f)
    val progressFromTop = ((itemBottom - viewportStart) / revealDistancePx).coerceIn(0f, 1f)

    return smoothStep(minOf(progressFromBottom, progressFromTop))
}

private fun lerp(start: Float, stop: Float, fraction: Float): Float =
    start + (stop - start) * fraction

private fun smoothStep(value: Float): Float {
    val clamped = value.coerceIn(0f, 1f)
    return clamped * clamped * (3f - 2f * clamped)
}
