package com.example.enesportfolio.feature.portfolio.presentation.cv

import com.example.enesportfolio.core.model.PortfolioContent
import com.example.enesportfolio.feature.portfolio.domain.repository.CvDownloader
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.Res
import com.example.enesportfolio.feature.portfolio.presentation.platform.savePortfolioPdf

private const val CvResourcePath = "files/enes_selcuk_cv.pdf"
private const val CvFileName = "Enes Selcuk CV.pdf"

class PortfolioCvDownloader : CvDownloader {
    override suspend fun download(content: PortfolioContent) {
        val pdfBytes = Res.readBytes(CvResourcePath)
        savePortfolioPdf(pdfBytes, CvFileName)
    }
}
