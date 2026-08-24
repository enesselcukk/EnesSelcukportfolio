package com.example.enesportfolio.feature.portfolio.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PortfolioScreen(
    viewModel: PortfolioViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val content = uiState.content
    if (content != null) {
        PortfolioScreenContent(
            uiState = uiState,
            onAction = viewModel::onAction,
        )
    }
}
