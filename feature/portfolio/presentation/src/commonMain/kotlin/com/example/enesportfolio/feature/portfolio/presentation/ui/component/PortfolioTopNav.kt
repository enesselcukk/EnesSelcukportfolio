package com.example.enesportfolio.feature.portfolio.presentation.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.enesportfolio.core.designsystem.component.LanguageToggle
import com.example.enesportfolio.core.designsystem.theme.Palette
import com.example.enesportfolio.core.model.PortfolioCopy
import com.example.enesportfolio.feature.portfolio.presentation.ui.PortfolioSection

@Composable
internal fun PortfolioTopNav(
    copy: PortfolioCopy,
    selectedLanguage: String,
    onLanguageSelected: (String) -> Unit,
    onNavigate: (PortfolioSection) -> Unit,
    modifier: Modifier = Modifier,
) {
    BoxWithConstraints(modifier = modifier.fillMaxWidth()) {
        val stacked = maxWidth < PortfolioLayout.StackBreakpoint
        if (stacked) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {
                    LanguageToggle(
                        selected = selectedLanguage,
                        onLanguageSelected = onLanguageSelected,
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp),
                    horizontalArrangement = Arrangement.spacedBy(18.dp),
                ) {
                    NavLinks(copy = copy, onNavigate = onNavigate)
                }
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                    NavLinks(copy = copy, onNavigate = onNavigate)
                }
                Spacer(modifier = Modifier.weight(1f))
                LanguageToggle(
                    selected = selectedLanguage,
                    onLanguageSelected = onLanguageSelected,
                )
            }
        }
    }
}

@Composable
private fun NavLinks(
    copy: PortfolioCopy,
    onNavigate: (PortfolioSection) -> Unit,
) {
    NavLink(copy.navExperience) { onNavigate(PortfolioSection.Experience) }
    NavLink(copy.navWork) { onNavigate(PortfolioSection.Work) }
    NavLink(copy.navNotes) { onNavigate(PortfolioSection.Notes) }
}

@Composable
private fun NavLink(
    label: String,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    Text(
        text = label,
        modifier = Modifier
            .hoverable(interactionSource)
            .clickable(onClick = onClick),
        style = MaterialTheme.typography.bodySmall,
        color = if (hovered) Palette.Ink else Palette.Muted,
    )
}
