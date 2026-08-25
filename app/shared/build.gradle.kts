plugins {
    id("enesportfolio.library.compose")
}

kotlin {
    android {
        namespace = "com.example.enesportfolio.shared"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
        androidResources {
            enable = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":app:ui-components"))
            implementation(project(":core:model"))
            implementation(project(":core:domain"))
            implementation(project(":core:datastore"))
            implementation(project(":feature:portfolio:data"))
            implementation(project(":feature:portfolio:domain"))
            implementation(project(":feature:portfolio:presentation"))
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
        }
    }
}
