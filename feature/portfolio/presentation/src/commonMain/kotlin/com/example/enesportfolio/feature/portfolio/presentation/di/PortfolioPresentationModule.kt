package com.example.enesportfolio.feature.portfolio.presentation.di

import com.example.enesportfolio.feature.portfolio.presentation.cv.PortfolioCvDownloader
import com.example.enesportfolio.feature.portfolio.presentation.ui.PortfolioViewModel
import com.example.enesportfolio.feature.portfolio.domain.repository.CvDownloader
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val portfolioPresentationModule = module {
    singleOf(::PortfolioCvDownloader) bind CvDownloader::class
    viewModelOf(::PortfolioViewModel)
}
