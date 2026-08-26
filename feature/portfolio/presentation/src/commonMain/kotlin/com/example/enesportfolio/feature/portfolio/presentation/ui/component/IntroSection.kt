package com.example.enesportfolio.feature.portfolio.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.enesportfolio.core.designsystem.component.OverlineText
import com.example.enesportfolio.core.designsystem.component.PortfolioCard
import com.example.enesportfolio.core.designsystem.component.SectionTitle
import com.example.enesportfolio.core.designsystem.theme.Palette
import com.example.enesportfolio.core.model.PortfolioCopy

@Composable
internal fun IntroSection(
    copy: PortfolioCopy,
    languageCode: String,
    modifier: Modifier = Modifier,
) {
    BoxWithConstraints(modifier = modifier.fillMaxWidth()) {
        val stacked = maxWidth < PortfolioLayout.StackBreakpoint
        if (stacked) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                AboutCard(copy = copy, languageCode = languageCode)
                NowCard(copy = copy, languageCode = languageCode)
            }
        } else {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                AboutCard(copy = copy, languageCode = languageCode, modifier = Modifier.weight(1.35f))
                NowCard(copy = copy, languageCode = languageCode, modifier = Modifier.weight(0.8f))
            }
        }
    }
}

@Composable
private fun AboutCard(
    copy: PortfolioCopy,
    languageCode: String,
    modifier: Modifier = Modifier,
) {
    PortfolioCard(modifier = modifier) {
        SectionTitle(copy.aboutTitle)
        Text(
            text = copy.aboutLead,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 12.dp),
        )
        LabeledFacts(
            items = listOf(
                copy.aboutArchLabel to copy.aboutArch,
                copy.aboutSecLabel to copy.aboutSec,
                copy.aboutShipLabel to copy.aboutShip,
            ),
            languageCode = languageCode,
            modifier = Modifier.padding(top = 18.dp),
        )
    }
}

@Composable
private fun LabeledFacts(
    items: List<Pair<String, String>>,
    languageCode: String,
    modifier: Modifier = Modifier,
) {
    BoxWithConstraints(modifier = modifier.fillMaxWidth()) {
        if (maxWidth < PortfolioLayout.CompactBreakpoint) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items.forEach { (label, body) ->
                    ExpertiseItem(label = label, body = body, languageCode = languageCode)
                }
            }
        } else {
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                items.forEach { (label, body) ->
                    ExpertiseItem(
                        label = label,
                        body = body,
                        languageCode = languageCode,
                        modifier = Modifier.weight(1f),
                    )
                }
            }
        }
    }
}

@Composable
private fun ExpertiseItem(
    label: String,
    body: String,
    languageCode: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        OverlineText(label, languageCode = languageCode)
        Text(
            text = body,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.88f),
            modifier = Modifier.padding(top = 6.dp),
        )
    }
}

@Composable
private fun NowCard(
    copy: PortfolioCopy,
    languageCode: String,
    modifier: Modifier = Modifier,
) {
    PortfolioCard(
        modifier = modifier,
        shape = RoundedCornerShape(32.dp),
        backgroundColor = Palette.BackgroundElevated,
    ) {
        Box {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Palette.Violet.copy(alpha = 0.08f), Color.Transparent),
                            startY = 0f,
                            endY = 280f,
                        ),
                    ),
            )
            Column {
                OverlineText(copy.nowLabel, languageCode = languageCode)
                listOf(copy.nowOne, copy.nowTwo, copy.nowThree).forEach { item ->
                    Row(
                        modifier = Modifier.padding(top = 14.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(top = 2.dp)
                                .width(2.dp)
                                .height(20.dp)
                                .background(Palette.Violet),
                        )
                        Text(
                            text = item,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Normal,
                                color = Palette.Ink,
                            ),
                        )
                    }
                }
            }
        }
    }
}
