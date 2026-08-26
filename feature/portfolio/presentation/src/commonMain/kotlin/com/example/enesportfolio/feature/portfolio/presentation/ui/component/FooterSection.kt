package com.example.enesportfolio.feature.portfolio.presentation.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.enesportfolio.core.designsystem.theme.Palette
import com.example.enesportfolio.core.model.Links
import com.example.enesportfolio.core.model.PortfolioCopy

@Composable
internal fun FooterSection(
    copy: PortfolioCopy,
    onOpenLink: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp),
    ) {
        Text(
            text = copy.footerFocus,
            style = MaterialTheme.typography.bodyMedium,
            color = Palette.Muted,
        )
        Text(
            text = "© Copyright 2026. Made by enesselcukk",
            style = MaterialTheme.typography.labelSmall,
        )
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            FooterLink("GitHub") { onOpenLink(Links.GitHub) }
            FooterLink("LinkedIn") { onOpenLink(Links.LinkedIn) }
        }
    }
}

@Composable
private fun FooterLink(
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
        style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.7.sp),
        color = if (hovered) Palette.Ink else Palette.Mint,
    )
}
