plugins {
    id("enesportfolio.library.kmp")
}

kotlin {
    android {
        namespace = "com.example.enesportfolio.core.domain"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain.dependencies {
            api(project(":core:model"))
        }
    }
}
