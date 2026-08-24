plugins {
    id("enesportfolio.library.kmp")
}

kotlin {
    android {
        namespace = "com.example.enesportfolio.feature.portfolio.data"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":core:datastore"))
            implementation(project(":core:domain"))
            implementation(project(":core:model"))
            implementation(project(":feature:portfolio:domain"))
            implementation(libs.kotlinx.coroutines.core)
            api(libs.koin.core)
        }
    }
}
