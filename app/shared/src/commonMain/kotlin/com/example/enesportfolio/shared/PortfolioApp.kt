package com.example.enesportfolio.shared

import androidx.compose.runtime.Composable
import com.example.enesportfolio.core.designsystem.theme.PortfolioTheme
import com.example.enesportfolio.feature.portfolio.presentation.ui.PortfolioScreen

@Composable
fun PortfolioApp() {
    PortfolioTheme {
        PortfolioScreen()
    }
}
