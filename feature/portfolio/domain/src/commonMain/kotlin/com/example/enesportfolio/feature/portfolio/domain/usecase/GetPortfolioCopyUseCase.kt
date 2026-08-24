package com.example.enesportfolio.feature.portfolio.domain.usecase

import com.example.enesportfolio.core.model.AppLanguage
import com.example.enesportfolio.core.model.PortfolioContent
import com.example.enesportfolio.feature.portfolio.domain.repository.PortfolioRepository

class GetPortfolioCopyUseCase(
    private val portfolioRepository: PortfolioRepository,
) {
    operator fun invoke(language: AppLanguage): PortfolioContent =
        portfolioRepository.getPortfolioContent(language)
}
