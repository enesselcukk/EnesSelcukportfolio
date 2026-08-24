plugins {
    id("enesportfolio.library.kmp")
}

kotlin {
    android {
        namespace = "com.example.enesportfolio.feature.portfolio.domain"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":core:domain"))
            implementation(project(":core:datastore"))
            api(project(":core:model"))
            implementation(libs.kotlinx.coroutines.core)
            api(libs.koin.core)
        }
    }
}
