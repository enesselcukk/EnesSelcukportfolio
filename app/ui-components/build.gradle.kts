plugins {
    id("enesportfolio.library.compose")
}

compose.resources {
    publicResClass = false
    packageOfResClass = "com.example.enesportfolio.core.designsystem.generated.resources"
}

kotlin {
    android {
        namespace = "com.example.enesportfolio.core.designsystem"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.uiToolingPreview)
        }
        androidMain.dependencies {
            implementation(libs.compose.uiTooling)
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}
