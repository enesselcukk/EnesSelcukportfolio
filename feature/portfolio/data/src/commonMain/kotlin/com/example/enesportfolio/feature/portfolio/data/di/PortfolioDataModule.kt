package com.example.enesportfolio.feature.portfolio.data.di

import com.example.enesportfolio.feature.portfolio.data.repository.PortfolioRepositoryImpl
import com.example.enesportfolio.feature.portfolio.domain.repository.PortfolioRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val portfolioDataModule = module {
    singleOf(::PortfolioRepositoryImpl) bind PortfolioRepository::class
}
