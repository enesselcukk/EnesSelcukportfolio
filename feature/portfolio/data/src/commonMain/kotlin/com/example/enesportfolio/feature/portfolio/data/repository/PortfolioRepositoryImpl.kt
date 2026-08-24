package com.example.enesportfolio.feature.portfolio.data.repository

import com.example.enesportfolio.core.datastore.LanguageSettingsRepository
import com.example.enesportfolio.core.model.AppLanguage
import com.example.enesportfolio.core.model.PortfolioContent
import com.example.enesportfolio.feature.portfolio.data.PortfolioCopyData
import com.example.enesportfolio.feature.portfolio.domain.repository.PortfolioRepository
import kotlinx.coroutines.flow.Flow

class PortfolioRepositoryImpl(
    private val languageSettingsRepository: LanguageSettingsRepository,
) : PortfolioRepository {
    override fun observeLanguage(): Flow<AppLanguage> = languageSettingsRepository.language

    override suspend fun setLanguage(language: AppLanguage) {
        languageSettingsRepository.setLanguage(language)
    }

    override fun getPortfolioContent(language: AppLanguage): PortfolioContent =
        PortfolioCopyData.contentFor(language)
}
