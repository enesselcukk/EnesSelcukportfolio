package com.example.enesportfolio.feature.portfolio.domain.usecase

import com.example.enesportfolio.core.model.AppLanguage
import com.example.enesportfolio.feature.portfolio.domain.repository.PortfolioRepository

class SetLanguageUseCase(
    private val portfolioRepository: PortfolioRepository,
) {
    suspend operator fun invoke(language: AppLanguage) {
        portfolioRepository.setLanguage(language)
    }
}
