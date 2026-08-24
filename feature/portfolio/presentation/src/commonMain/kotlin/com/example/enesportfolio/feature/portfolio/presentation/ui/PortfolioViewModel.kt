package com.example.enesportfolio.feature.portfolio.presentation.ui

import androidx.lifecycle.viewModelScope
import com.example.enesportfolio.core.model.AppLanguage
import com.example.enesportfolio.core.presentation.CoreViewModel
import com.example.enesportfolio.feature.portfolio.contract.PortfolioContract
import com.example.enesportfolio.feature.portfolio.domain.usecase.DownloadPortfolioCvUseCase
import com.example.enesportfolio.feature.portfolio.domain.usecase.GetPortfolioCopyUseCase
import com.example.enesportfolio.feature.portfolio.domain.usecase.ObserveLanguageUseCase
import com.example.enesportfolio.feature.portfolio.domain.usecase.SetLanguageUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PortfolioViewModel(
    observeLanguageUseCase: ObserveLanguageUseCase,
    private val setLanguageUseCase: SetLanguageUseCase,
    private val getPortfolioCopyUseCase: GetPortfolioCopyUseCase,
    private val downloadPortfolioCvUseCase: DownloadPortfolioCvUseCase,
) : CoreViewModel() {
    private val _uiState = MutableStateFlow(PortfolioContract.UiState())
    val uiState: StateFlow<PortfolioContract.UiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            observeLanguageUseCase().collect { language ->
                _uiState.update {
                    it.copy(
                        language = language,
                        content = getPortfolioCopyUseCase(language),
                    )
                }
            }
        }
    }

    fun onAction(action: PortfolioContract.Action) {
        when (action) {
            is PortfolioContract.Action.LanguageSelected -> {
                viewModelScope.launch {
                    setLanguageUseCase(action.language)
                }
            }

            PortfolioContract.Action.DownloadCv -> {
                viewModelScope.launch {
                    val content = _uiState.value.content ?: return@launch
                    downloadPortfolioCvUseCase(content)
                }
            }
        }
    }
}
