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
            window.open(uri, "_blank")
        }
    }
