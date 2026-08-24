package com.example.enesportfolio.feature.portfolio.presentation.platform

import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlinx.browser.document
import org.w3c.dom.HTMLAnchorElement

@OptIn(ExperimentalEncodingApi::class)
actual fun savePortfolioPdf(bytes: ByteArray, fileName: String) {
    val base64 = Base64.encode(bytes)
    val anchor = document.createElement("a") as HTMLAnchorElement
    anchor.href = "data:application/pdf;base64,$base64"
    anchor.download = fileName
    document.body?.appendChild(anchor)
    anchor.click()
    document.body?.removeChild(anchor)
}
