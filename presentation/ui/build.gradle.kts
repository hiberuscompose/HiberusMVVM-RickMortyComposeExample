import org.jetbrains.kotlin.storage.CacheResetOnProcessCanceled.enabled

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.com.google.devtools.ksp)
    alias(libs.plugins.com.google.dagger.hilt.android)
    alias(libs.plugins.de.mannodermaus.android.junit5)
    alias(libs.plugins.io.gitlab.arturbosch.detekt)
    alias(libs.plugins.app.cash.paparazzi)
    jacoco
}

android {
    namespace = BuildVersion.environment.applicationId
    compileSdk = BuildVersion.environment.compileSdkVersion

    defaultConfig {
        testInstrumentationRunnerArguments += mapOf()
        applicationId = BuildVersion.environment.applicationId
        minSdk = BuildVersion.environment.minSdkVersion
        targetSdk = BuildVersion.environment.compileSdkVersion
        versionCode = BuildVersion.environment.appVersionCode
        versionName = BuildVersion.environment.appVersionName

        testInstrumentationRunner = BuildVersion.testEnvironment.instrumentationRunner
        testInstrumentationRunnerArguments["runnerBuilder"] = BuildVersion.testEnvironment.instrumentationRunnerArgs
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    viewBinding {
        enable = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = BuildVersion.environment.javaVersion
        targetCompatibility = BuildVersion.environment.javaVersion
    }
    kotlinOptions {
        jvmTarget = BuildVersion.environment.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = BuildVersion.environment.composeCompilerVersion
    }
    packaging {
        resources {
            excludes.addAll(
                arrayOf(
                    "/META-INF/{AL2.0,LGPL2.1}",
                    "/META-INF/com.google.dagger_dagger.version",
                    "/META-INF/LICENSE.md"
                )
            )
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    testOptions {
        animationsDisabled=true
        reportDir = "$rootDir/instrumentedTestsResults/reports/$project.name"
        resultsDir = "$rootDir/instrumentedTestsResults/results/$project.name"
        unitTests{
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
            all { test ->
                test.useJUnitPlatform()
            }
        }
    }
}

dependencies {
    implementation(libs.bundles.layer.ui)
    implementation(platform(libs.compose.bom))
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(platform(libs.compose.bom))
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    coreLibraryDesugaring(libs.com.android.tools.desugar.jdk.libs)
    implementation(project(mapOf("path" to ":core:di")))
    implementation(project(mapOf( "path" to ":presentation:viewmodels")))
    implementation(project(mapOf( "path" to ":domain:models")))
    implementation(project(mapOf( "path" to ":core:common")))
    implementation(project(mapOf( "path" to ":core:ui")))
    debugImplementation(libs.ui.test.manifest)

    ksp(libs.bundles.compilers.ksp.generic)

    // Testing implementation
    testImplementation(libs.bundles.testing.unit)
    testRuntimeOnly(libs.bundles.testing.unit.runtime)
    androidTestImplementation(libs.bundles.testing.android)
    androidTestRuntimeOnly(libs.bundles.testing.android.runtime)


}