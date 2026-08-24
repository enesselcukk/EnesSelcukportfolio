import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        outputModuleName.set("webApp")
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "webApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static(rootDirPath)
                    static(projectDirPath)
                }
            }
        }
        binaries.executable()
        useEsModules()
    }

    sourceSets {
        wasmJsMain.dependencies {
            implementation(project(":app:shared"))
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.kotlinx.browser)
        }
    }
}

val cloudflarePagesDir = layout.buildDirectory.dir("cloudflare-pages")

tasks.register<Copy>("packageCloudflarePages") {
    group = "distribution"
    description = "Packages the wasm web app for Cloudflare Pages deployment."

    dependsOn("wasmJsBrowserProductionWebpack")

    into(cloudflarePagesDir)

    from(layout.buildDirectory.dir("kotlin-webpack/wasmJs/productionExecutable")) {
        exclude("*.map")
    }

    from(layout.buildDirectory.dir("processedResources/wasmJs/main")) {
        include("index.html", "styles.css")
    }

    from(
        layout.buildDirectory.dir(
            "kotlin-multiplatform-resources/aggregated-resources/wasmJs/composeResources",
        ),
    ) {
        into("composeResources")
    }

    doLast {
        val headersFile = destinationDir.resolve("_headers")
        headersFile.writeText(
            """
            /*
              X-Content-Type-Options: nosniff

            /*.wasm
              Content-Type: application/wasm
            """.trimIndent() + "\n",
        )
    }
}
