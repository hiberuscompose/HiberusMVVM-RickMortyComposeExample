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
        applicationId = BuildVersion.environment.applicationId
        minSdk = BuildVersion.environment.minSdkVersion
        targetSdk = BuildVersion.environment.compileSdkVersion
        versionCode = BuildVersion.environment.appVersionCode
        versionName = BuildVersion.environment.appVersionName

        testInstrumentationRunner = BuildVersion.testEnvironment.instrumentationRunner
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
        animationsDisabled = true
        unitTests.isReturnDefaultValues = true
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
    tasks.withType<Test> {
        jvmArgs("-XX:+AllowRedefinitionToAddDeleteMethods")
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
    testImplementation("junit:junit:4.13.2")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.10.0")
    testImplementation("androidx.compose.ui:ui-test-junit4:1.5.4")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.4")
    testImplementation(libs.bundles.testing.unit)
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.4")
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.4")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.4")

}