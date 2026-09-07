package com.example.enesportfolio.feature.portfolio.presentation.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.unit.dp
import com.example.enesportfolio.core.designsystem.theme.Palette
import com.example.enesportfolio.core.model.PortfolioCopy
import com.example.enesportfolio.feature.portfolio.presentation.platform.clipEntryOf
import kotlinx.coroutines.launch

@Composable
internal fun PortfolioSelectionBar(
    selectionState: SelectionState,
    copy: PortfolioCopy,
    modifier: Modifier = Modifier,
) {
    val selectedTexts = selectionState.selectedTexts
    val selectedPlainText = selectedTexts.joinToString("\n") { it.text }
    val lastSelectedText = remember { LastSelectedText() }
    val clipboard = LocalClipboard.current
    val scope = rememberCoroutineScope()

    SideEffect {
        if (selectedPlainText.isNotEmpty()) {
            lastSelectedText.value = selectedPlainText
        }
    }

    AnimatedVisibility(
        visible = selectedPlainText.isNotEmpty(),
        modifier = modifier,
        enter = fadeIn() + slideInVertically { it / 2 },
        exit = fadeOut() + slideOutVertically { it / 2 },
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(999.dp))
                .background(Palette.BackgroundElevated)
                .border(1.dp, Palette.Line, RoundedCornerShape(999.dp))
                .padding(horizontal = 6.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SelectionBarAction(
                label = copy.copySelection,
                onClick = {
                    val text = lastSelectedText.value
                    if (text.isEmpty()) return@SelectionBarAction
                    scope.launch {
                        clipboard.setClipEntry(clipEntryOf(text))
                    }
                },
            )
            SelectionBarAction(
                label = copy.selectAll,
                onClick = selectionState::selectAll,
            )
        }
    }
}

private class LastSelectedText {
    var value: String = ""
}

@Composable
private fun SelectionBarAction(
    label: String,
    onClick: () -> Unit,
) {
    Text(
        text = label,
        modifier = Modifier
            .clip(RoundedCornerShape(999.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        style = MaterialTheme.typography.labelMedium,
        color = Palette.Ink,
    )
}
