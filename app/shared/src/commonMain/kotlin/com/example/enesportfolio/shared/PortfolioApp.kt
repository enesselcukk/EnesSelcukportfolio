package com.example.enesportfolio.shared

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.enesportfolio.core.designsystem.theme.PortfolioTheme
import com.example.enesportfolio.core.navigation.NavEntryProvider
import com.example.enesportfolio.core.navigation.NavigationManager
import com.example.enesportfolio.core.navigation.PortfolioNavHost
import com.example.enesportfolio.feature.portfolio.contract.PortfolioScreenDestination
import org.koin.mp.KoinPlatform.getKoin

@Composable
fun PortfolioApp() {
    val features: List<NavEntryProvider> = remember { getKoin().getAll() }
    val navigationManager = remember { getKoin().get<NavigationManager>() }

    PortfolioTheme {
        PortfolioNavHost(
            modifier = Modifier.fillMaxSize(),
            startDestination = PortfolioScreenDestination,
            features = features,
            navigationManager = navigationManager,
        )
    }
}
