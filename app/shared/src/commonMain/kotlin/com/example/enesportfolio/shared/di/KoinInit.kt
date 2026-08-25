package com.example.enesportfolio.shared.di

import com.example.enesportfolio.core.datastore.DefaultLanguageSettingsRepository
import com.example.enesportfolio.core.datastore.LanguageSettingsRepository
import com.example.enesportfolio.feature.portfolio.data.di.portfolioDataModule
import com.example.enesportfolio.feature.portfolio.domain.di.portfolioDomainModule
import com.example.enesportfolio.feature.portfolio.presentation.di.portfolioPresentationModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule = module {
    single<LanguageSettingsRepository> { DefaultLanguageSettingsRepository() }
}

private val sharedModules = listOf(
    appModule,
    portfolioDataModule,
    portfolioDomainModule,
    portfolioPresentationModule,
)

fun startKoinWithModules(
    platformModules: List<Module> = emptyList(),
    appDeclaration: KoinApplication.() -> Unit = {},
) {
    startKoin {
        appDeclaration()
        modules(sharedModules + platformModules)
    }
}
