package com.example.enesportfolio.feature.portfolio.presentation.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.enesportfolio.core.designsystem.component.OverlineText
import com.example.enesportfolio.core.designsystem.component.SectionTitle
import com.example.enesportfolio.core.model.PortfolioContent
import com.example.enesportfolio.core.model.ProjectItem
import com.example.enesportfolio.feature.portfolio.presentation.ui.PersonalProjectCard

@Composable
internal fun WorkSection(
    content: PortfolioContent,
    languageCode: String,
    onOpenLink: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        OverlineText(content.copy.prodOverline, languageCode = languageCode)
        SectionTitle(content.copy.prodTitle, modifier = Modifier.padding(top = 5.dp, bottom = 16.dp))
        ProjectGrid(projects = content.productionProjects, onOpenLink = onOpenLink)
        OverlineText(
            content.copy.persOverline,
            languageCode = languageCode,
            modifier = Modifier.padding(top = 32.dp),
        )
        SectionTitle(content.copy.persTitle, modifier = Modifier.padding(top = 5.dp, bottom = 16.dp))
        ProjectGrid(projects = content.personalProjects, onOpenLink = onOpenLink, columns = 2)
    }
}

@Composable
private fun ProjectGrid(
    projects: List<ProjectItem>,
    onOpenLink: (String) -> Unit,
    columns: Int = 3,
    modifier: Modifier = Modifier,
) {
    BoxWithConstraints(modifier = modifier.fillMaxWidth()) {
        val stacked = maxWidth < PortfolioLayout.StackBreakpoint
        val columnCount = if (stacked) 1 else columns
        val rows = projects.chunked(columnCount)
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            rows.forEach { rowProjects ->
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    rowProjects.forEach { project ->
                        PersonalProjectCard(
                            project = project,
                            onClick = { onOpenLink(project.url) },
                            modifier = Modifier.weight(1f),
                        )
                    }
                    repeat(columnCount - rowProjects.size) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}
