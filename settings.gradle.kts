rootProject.name = "Enesportfolio"

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include(":app:webApp")
include(":app:shared")
include(":app:ui-components")
include(":core:model")
include(":core:domain")
include(":core:datastore")
include(":core:presentation")
include(":feature:portfolio:contract")
include(":feature:portfolio:domain")
include(":feature:portfolio:data")
include(":feature:portfolio:presentation")
