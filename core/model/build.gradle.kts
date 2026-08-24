plugins {
    id("enesportfolio.library.kmp")
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    android {
        namespace = "com.example.enesportfolio.core.model"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization.json)
        }
    }
}
