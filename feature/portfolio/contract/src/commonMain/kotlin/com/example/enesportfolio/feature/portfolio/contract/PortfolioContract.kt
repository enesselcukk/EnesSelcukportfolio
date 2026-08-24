package com.example.enesportfolio.feature.portfolio.contract

import com.example.enesportfolio.core.model.AppLanguage
import com.example.enesportfolio.core.model.PortfolioContent

object PortfolioContract {

    data class UiState(
        val language: AppLanguage = AppLanguage.EN,
        val content: PortfolioContent? = null,
    )

    sealed interface Action {
        data class LanguageSelected(val language: AppLanguage) : Action
    }
}
