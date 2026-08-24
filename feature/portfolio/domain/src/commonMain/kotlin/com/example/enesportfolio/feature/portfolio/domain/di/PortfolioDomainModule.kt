package com.example.enesportfolio.feature.portfolio.domain.di

import com.example.enesportfolio.feature.portfolio.domain.usecase.GetPortfolioCopyUseCase
import com.example.enesportfolio.feature.portfolio.domain.usecase.ObserveLanguageUseCase
import com.example.enesportfolio.feature.portfolio.domain.usecase.SetLanguageUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val portfolioDomainModule = module {
    factoryOf(::ObserveLanguageUseCase)
    factoryOf(::SetLanguageUseCase)
    factoryOf(::GetPortfolioCopyUseCase)
}
