plugins {
    id("enesportfolio.library.compose")
}

compose.resources {
    publicResClass = true
    packageOfResClass = "com.example.enesportfolio.feature.portfolio.presentation.generated.resources"
}

kotlin {
    android {
        namespace = "com.example.enesportfolio.feature.portfolio.presentation"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
        androidResources {
            enable = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":core:domain"))
            implementation(project(":feature:portfolio:contract"))
            implementation(project(":feature:portfolio:domain"))
            implementation(project(":feature:portfolio:data"))
            implementation(project(":app:ui-components"))
            implementation(libs.compose.runtime)
            implementation(libs.compose.animation)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.koin.core)
            implementation(libs.koin.core.viewmodel)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
        }
    }
}
