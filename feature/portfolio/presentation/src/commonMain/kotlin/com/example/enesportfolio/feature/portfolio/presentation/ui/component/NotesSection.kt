package com.example.enesportfolio.feature.portfolio.presentation.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.example.enesportfolio.core.designsystem.component.OverlineText
import com.example.enesportfolio.core.designsystem.component.PortfolioCard
import com.example.enesportfolio.core.designsystem.component.SectionTitle
import com.example.enesportfolio.core.designsystem.theme.Palette
import com.example.enesportfolio.core.model.NoteItem
import com.example.enesportfolio.core.model.PortfolioCopy

@Composable
internal fun NotesSection(
    copy: PortfolioCopy,
    notes: List<NoteItem>,
    languageCode: String,
    onOpenLink: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        PortfolioCard(
            contentPadding = PaddingValues(horizontal = 22.dp, vertical = 24.dp),
        ) {
            OverlineText(copy.notesOverline, languageCode = languageCode)
            SectionTitle(copy.notesTitle, modifier = Modifier.padding(top = 5.dp, bottom = 8.dp))
            notes.forEachIndexed { index, note ->
                NoteRow(
                    note = note,
                    showBottomBorder = index < notes.lastIndex,
                    onClick = { onOpenLink(note.url) },
                )
            }
        }
    }
}

@Composable
private fun NoteRow(
    note: NoteItem,
    showBottomBorder: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .hoverable(interactionSource)
            .clickable(onClick = onClick)
            .drawBehind {
                if (showBottomBorder) {
                    drawLine(
                        color = Palette.Line,
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = 1.dp.toPx(),
                    )
                }
            }
            .padding(vertical = 15.dp, horizontal = 3.dp),
    ) {
        val narrow = maxWidth < PortfolioLayout.CompactBreakpoint
        if (narrow) {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = note.whenLabel,
                    style = MaterialTheme.typography.labelMedium,
                    color = Palette.Violet,
                )
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = if (hovered) Palette.Violet else Palette.Ink,
                    ),
                )
            }
        } else {
            Row(horizontalArrangement = Arrangement.spacedBy(13.dp)) {
                Text(
                    text = note.whenLabel,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.width(72.dp),
                    color = Palette.Violet,
                )
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = if (hovered) Palette.Violet else Palette.Ink,
                    ),
                )
            }
        }
    }
}
