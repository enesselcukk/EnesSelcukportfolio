package com.example.enesportfolio.feature.portfolio.presentation.navigate

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.enesportfolio.core.navigation.NavEntryProvider
import com.example.enesportfolio.feature.portfolio.contract.PortfolioScreenDestination
import com.example.enesportfolio.feature.portfolio.presentation.ui.PortfolioScreen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

internal class PortfolioProvider : NavEntryProvider {
    override val navKeySerializers: SerializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(PortfolioScreenDestination::class, PortfolioScreenDestination.serializer())
        }
    }

    override fun EntryProviderScope<NavKey>.registerEntries() {
        entry<PortfolioScreenDestination> {
            PortfolioScreen()
        }
    }
}
