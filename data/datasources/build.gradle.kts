@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.com.google.devtools.ksp)
    alias(libs.plugins.com.google.dagger.hilt.android)
    alias(libs.plugins.de.mannodermaus.android.junit5)
    alias(libs.plugins.io.gitlab.arturbosch.detekt)
    jacoco
}

android {
    namespace = "${BuildVersion.environment.applicationId}.data.datasources"
    compileSdk = BuildVersion.environment.compileSdkVersion

    defaultConfig {
        minSdk = BuildVersion.environment.minSdkVersion

        testInstrumentationRunner = BuildVersion.testEnvironment.instrumentationRunner
        testInstrumentationRunnerArguments["runnerBuilder"] = BuildVersion.testEnvironment.instrumentationRunnerArgs

        consumerProguardFiles("consumer-rules.pro")
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
        isCoreLibraryDesugaringEnabled = true
    }
    kotlinOptions {
        jvmTarget = BuildVersion.environment.jvmTarget
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
        }
    }
    // Needed for testing usage
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

    implementation(libs.bundles.layer.data)
    coreLibraryDesugaring(libs.com.android.tools.desugar.jdk.libs)

    implementation(project(mapOf( "path" to ":data:models")))
    implementation(project(mapOf( "path" to ":core:common")))

    ksp(libs.bundles.compilers.ksp.data)

    // Testing implementation
    testImplementation(libs.bundles.testing.unit)
    testRuntimeOnly(libs.bundles.testing.unit.runtime)
    androidTestImplementation(libs.bundles.testing.android)
    androidTestRuntimeOnly(libs.bundles.testing.android.runtime)
}