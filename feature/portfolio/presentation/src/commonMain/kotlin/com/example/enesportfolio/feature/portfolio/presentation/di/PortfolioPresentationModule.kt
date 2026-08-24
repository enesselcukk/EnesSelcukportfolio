package com.example.enesportfolio.feature.portfolio.presentation.di

import com.example.enesportfolio.core.navigation.NavEntryProvider
import com.example.enesportfolio.feature.portfolio.presentation.navigate.PortfolioProvider
import com.example.enesportfolio.feature.portfolio.presentation.ui.PortfolioViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val portfolioPresentationModule = module {
    single<NavEntryProvider>(named("PortfolioProvider")) {
        PortfolioProvider()
    }

    viewModelOf(::PortfolioViewModel)
}
