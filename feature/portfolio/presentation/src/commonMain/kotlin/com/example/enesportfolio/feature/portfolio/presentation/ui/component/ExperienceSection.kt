package com.example.enesportfolio.feature.portfolio.presentation.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.enesportfolio.core.designsystem.component.ChipRow
import com.example.enesportfolio.core.designsystem.component.OverlineText
import com.example.enesportfolio.core.designsystem.component.PortfolioCard
import com.example.enesportfolio.core.designsystem.component.SectionTitle
import com.example.enesportfolio.core.designsystem.theme.Palette
import com.example.enesportfolio.core.model.PortfolioContent
import com.example.enesportfolio.core.model.PortfolioCopy
import com.example.enesportfolio.core.model.SkillGroup

@Composable
internal fun ExperienceSection(
    content: PortfolioContent,
    languageCode: String,
    modifier: Modifier = Modifier,
) {
    val copy = content.copy
    BoxWithConstraints(modifier = modifier.fillMaxWidth()) {
        val stacked = maxWidth < PortfolioLayout.StackBreakpoint
        if (stacked) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                ExperienceTimeline(copy = copy, languageCode = languageCode)
                SideColumn(copy = copy, skillGroups = content.skillGroups, languageCode = languageCode)
            }
        } else {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                ExperienceTimeline(
                    copy = copy,
                    languageCode = languageCode,
                    modifier = Modifier.weight(1.2f),
                )
                SideColumn(
                    copy = copy,
                    skillGroups = content.skillGroups,
                    languageCode = languageCode,
                    modifier = Modifier.weight(0.85f),
                )
            }
        }
    }
}

@Composable
private fun ExperienceTimeline(
    copy: PortfolioCopy,
    languageCode: String,
    modifier: Modifier = Modifier,
) {
    PortfolioCard(modifier = modifier) {
        OverlineText(copy.expOverline, languageCode = languageCode)
        SectionTitle(copy.expTitle, modifier = Modifier.padding(top = 6.dp))
        TimelineEntry(
            whenText = copy.j1When,
            company = "Eteration Bilişim A.Ş.",
            role = copy.j1Role,
            highlights = listOf(copy.j1Team, copy.j1a, copy.j1b, copy.j1c, copy.j1d, copy.j1e, copy.j1f, copy.j1g),
        )
        TimelineEntry(
            whenText = copy.j2When,
            company = "Nuevo Softwarehouse",
            role = copy.j2Role,
            highlights = listOf(copy.j2Team, copy.j2a, copy.j2b, copy.j2c),
        )
        TimelineEntry(
            whenText = copy.j3When,
            company = copy.j3Company,
            role = copy.j3Role,
            highlights = listOf(copy.j3Team, copy.j3a, copy.j3b, copy.j3c, copy.j3d),
        )
    }
}

@Composable
private fun TimelineEntry(
    whenText: String,
    company: String,
    role: String,
    highlights: List<String>,
) {
    Column(
        modifier = Modifier
            .padding(top = 25.dp)
            .padding(start = 18.dp)
            .drawBehind {
                drawLine(
                    color = Palette.Line,
                    start = Offset(0f, 0f),
                    end = Offset(0f, size.height),
                    strokeWidth = 1.dp.toPx(),
                )
            },
    ) {
        Text(text = whenText, style = MaterialTheme.typography.labelMedium, color = Palette.Violet)
        Text(
            text = company,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 3.dp),
        )
        Text(
            text = role,
            style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.7.sp),
            modifier = Modifier.padding(top = 2.dp),
        )
        highlights.forEach { highlight ->
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
                    .padding(start = 14.dp)
                    .drawBehind {
                        drawLine(
                            color = Palette.Violet.copy(alpha = 0.45f),
                            start = Offset(0f, 0f),
                            end = Offset(0f, size.height),
                            strokeWidth = 2.dp.toPx(),
                        )
                    },
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Text(
                    text = highlight,
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.7.sp),
                    modifier = Modifier.padding(start = 10.dp),
                )
            }
        }
    }
}

@Composable
private fun SideColumn(
    copy: PortfolioCopy,
    skillGroups: List<SkillGroup>,
    languageCode: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        PortfolioCard {
            OverlineText(copy.stackOverline, languageCode = languageCode)
            SectionTitle(copy.stackTitle, modifier = Modifier.padding(top = 6.dp))
            skillGroups.forEach { group ->
                Text(
                    text = group.title.asOverline(languageCode),
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 12.sp,
                        letterSpacing = 1.44.sp,
                        color = Palette.Muted,
                    ),
                    modifier = Modifier.padding(top = 18.dp, bottom = 7.dp),
                )
                ChipRow(chips = group.skills)
            }
        }
        PortfolioCard {
            OverlineText(copy.eduOverline, languageCode = languageCode)
            Text(
                text = copy.eduUniversity,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(top = 6.dp),
            )
            Text(
                text = copy.eduDegree,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 5.dp),
            )
            Text(
                text = copy.eduWhen,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(top = 9.dp),
            )
        }
    }
}

private fun String.asOverline(languageCode: String): String =
    when (languageCode.lowercase()) {
        "tr" -> replace('i', 'İ').replace('ı', 'I').uppercase()
        else -> uppercase()
    }
