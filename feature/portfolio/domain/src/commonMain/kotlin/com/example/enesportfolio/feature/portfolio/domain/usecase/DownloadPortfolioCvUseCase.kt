package com.example.enesportfolio.feature.portfolio.domain.usecase

import com.example.enesportfolio.core.model.PortfolioContent
import com.example.enesportfolio.feature.portfolio.domain.repository.CvDownloader

class DownloadPortfolioCvUseCase(
    private val cvDownloader: CvDownloader,
) {
    suspend operator fun invoke(content: PortfolioContent) {
        cvDownloader.download(content)
    }
}
