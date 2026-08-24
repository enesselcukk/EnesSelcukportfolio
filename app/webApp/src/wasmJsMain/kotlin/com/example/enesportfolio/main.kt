package com.example.enesportfolio

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.window.ComposeViewport
import com.example.enesportfolio.shared.PortfolioApp
import com.example.enesportfolio.shared.di.initAppKoin
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLAnchorElement

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initAppKoin()
    ComposeViewport(viewportContainerId = "webApp") {
        CompositionLocalProvider(
            LocalUriHandler provides portfolioUriHandler(),
        ) {
            PortfolioApp()
        }
    }
    document.title = "Enes Selçuk — Android Developer"
}

private fun portfolioUriHandler(): UriHandler =
    object : UriHandler {
        override fun openUri(uri: String) {
            if (shouldDownload(uri)) {
                downloadAsset(uri)
            } else {
                window.open(uri, "_blank")
            }
        }
    }

private fun shouldDownload(uri: String): Boolean =
    uri.endsWith(".pdf", ignoreCase = true) && !uri.startsWith("http")

private fun downloadAsset(relativePath: String) {
    val fileName = relativePath.substringAfterLast('/')
    val anchor = document.createElement("a") as HTMLAnchorElement
    anchor.href = relativePath
    anchor.download = fileName
    document.body?.appendChild(anchor)
    anchor.click()
    document.body?.removeChild(anchor)
}
