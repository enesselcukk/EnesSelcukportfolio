package com.example.enesportfolio.core.navigation

import org.koin.dsl.module

val navigationModule = module {
    single<NavigationManager> { NavigationManagerImpl() }
}
