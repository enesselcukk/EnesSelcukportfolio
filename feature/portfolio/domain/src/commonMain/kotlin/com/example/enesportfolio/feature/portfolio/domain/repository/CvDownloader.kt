package com.example.enesportfolio.feature.portfolio.domain.repository

import com.example.enesportfolio.core.model.PortfolioContent

interface CvDownloader {
    suspend fun download(content: PortfolioContent)
}
