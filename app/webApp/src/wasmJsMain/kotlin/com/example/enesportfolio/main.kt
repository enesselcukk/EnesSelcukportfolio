package com.example.enesportfolio

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.example.enesportfolio.shared.PortfolioApp
import com.example.enesportfolio.shared.di.initAppKoin
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initAppKoin()
    ComposeViewport(viewportContainerId = "webApp") {
        PortfolioApp()
    }
    document.title = "Enes Selçuk — Android Developer"
}
