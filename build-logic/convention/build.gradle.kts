plugins {
    `kotlin-dsl`
}

group = "com.example.enesportfolio.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    jvmToolchain(11)
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.composeCompiler.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("kmpLibrary") {
            id = "enesportfolio.library.kmp"
            implementationClass = "KmpLibraryConventionPlugin"
        }
        register("kmpCompose") {
            id = "enesportfolio.library.compose"
            implementationClass = "KmpComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "enesportfolio.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }
}
