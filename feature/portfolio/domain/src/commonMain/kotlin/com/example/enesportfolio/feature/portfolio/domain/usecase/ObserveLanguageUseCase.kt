package com.example.enesportfolio.feature.portfolio.domain.usecase

import com.example.enesportfolio.core.model.AppLanguage
import com.example.enesportfolio.feature.portfolio.domain.repository.PortfolioRepository
import kotlinx.coroutines.flow.Flow

class ObserveLanguageUseCase(
    private val portfolioRepository: PortfolioRepository,
) {
    operator fun invoke(): Flow<AppLanguage> = portfolioRepository.observeLanguage()
}
