package com.example.enesportfolio.feature.portfolio.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.example.enesportfolio.core.designsystem.theme.Palette
import com.example.enesportfolio.core.model.AppLanguage
import com.example.enesportfolio.feature.portfolio.contract.PortfolioContract
import com.example.enesportfolio.feature.portfolio.presentation.ui.component.AtmosphereBackground
import com.example.enesportfolio.feature.portfolio.presentation.ui.component.ExperienceSection
import com.example.enesportfolio.feature.portfolio.presentation.ui.component.FooterSection
import com.example.enesportfolio.feature.portfolio.presentation.ui.component.HeroSection
import com.example.enesportfolio.feature.portfolio.presentation.ui.component.IntroSection
import com.example.enesportfolio.feature.portfolio.presentation.ui.component.NotesSection
import com.example.enesportfolio.feature.portfolio.presentation.ui.component.PageWidth
import com.example.enesportfolio.feature.portfolio.presentation.ui.component.PortfolioTopNav
import com.example.enesportfolio.feature.portfolio.presentation.ui.component.WorkSection
import kotlinx.coroutines.launch

private val SectionIndices = mapOf(
    PortfolioSection.Experience to 3,
    PortfolioSection.Work to 4,
    PortfolioSection.Notes to 5,
)

@Composable
internal fun PortfolioScreenContent(
    uiState: PortfolioContract.UiState,
    onAction: (PortfolioContract.Action) -> Unit,
) {
    val content = uiState.content ?: return
    val copy = content.copy
    val languageCode = uiState.language.code
    val uriHandler = LocalUriHandler.current
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val sectionIndices = remember { SectionIndices }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Palette.Background),
    ) {
        AtmosphereBackground(modifier = Modifier.fillMaxSize())

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 64.dp),
        ) {
            item(key = "nav") {
                PageWidth {
                    PortfolioTopNav(
                        copy = copy,
                        selectedLanguage = languageCode,
                        onLanguageSelected = { code ->
                            onAction(PortfolioContract.Action.LanguageSelected(AppLanguage.fromCode(code)))
                        },
                        onNavigate = { section ->
                            sectionIndices[section]?.let { index ->
                                scope.launch { listState.animateScrollToItem(index) }
                            }
                        },
                        modifier = Modifier.padding(top = 22.dp, bottom = 6.dp),
                    )
                }
            }
            revealedItem(listState = listState, key = "hero", itemIndex = 1) {
                HeroSection(
                    copy = copy,
                    languageCode = languageCode,
                    onOpenLink = uriHandler::openUri,
                    onDownloadCv = { onAction(PortfolioContract.Action.DownloadCv) },
                    modifier = Modifier.padding(top = 35.dp, bottom = 32.dp),
                )
            }
            revealedItem(listState = listState, key = "intro", itemIndex = 2) {
                IntroSection(copy = copy, languageCode = languageCode)
            }
            revealedItem(listState = listState, key = "experience", itemIndex = 3) {
                ExperienceSection(
                    content = content,
                    languageCode = languageCode,
                    modifier = Modifier.padding(top = 16.dp),
                )
            }
            revealedItem(listState = listState, key = "work", itemIndex = 4) {
                WorkSection(
                    content = content,
                    languageCode = languageCode,
                    onOpenLink = uriHandler::openUri,
                    modifier = Modifier.padding(top = 38.dp),
                )
            }
            revealedItem(listState = listState, key = "notes", itemIndex = 5) {
                NotesSection(
                    copy = copy,
                    notes = content.notes,
                    languageCode = languageCode,
                    onOpenLink = uriHandler::openUri,
                    modifier = Modifier.padding(top = 38.dp),
                )
            }
            revealedItem(listState = listState, key = "footer", itemIndex = 6) {
                FooterSection(
                    copy = copy,
                    onOpenLink = uriHandler::openUri,
                    modifier = Modifier.padding(top = 56.dp, bottom = 64.dp),
                )
            }
        }
    }
}

private fun LazyListScope.revealedItem(
    listState: LazyListState,
    key: String,
    itemIndex: Int,
    content: @Composable () -> Unit,
) {
    item(key = key) {
        ScrollRevealItem(listState = listState, itemIndex = itemIndex) {
            PageWidth(content = content)
        }
    }
}
