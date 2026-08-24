plugins {
    id("enesportfolio.library.kmp")
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    android {
        namespace = "com.example.enesportfolio.feature.portfolio.contract"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain.dependencies {
            api(project(":core:model"))
            api(project(":core:navigation"))
            implementation(libs.kotlinx.serialization.json)
        }
    }
}
