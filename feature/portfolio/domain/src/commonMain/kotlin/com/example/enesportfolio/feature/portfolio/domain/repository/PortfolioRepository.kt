package com.example.enesportfolio.feature.portfolio.domain.repository

import com.example.enesportfolio.core.model.AppLanguage
import com.example.enesportfolio.core.model.PortfolioContent
import kotlinx.coroutines.flow.Flow

interface PortfolioRepository {
    fun observeLanguage(): Flow<AppLanguage>

    suspend fun setLanguage(language: AppLanguage)

    fun getPortfolioContent(language: AppLanguage): PortfolioContent
}
