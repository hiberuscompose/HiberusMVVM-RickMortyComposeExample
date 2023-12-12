@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {
    namespace = "com.hiberus.template.mvvmtemplate.core.di"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    }
    kotlinOptions {
        jvmTarget = BuildVersion.environment.jvmTarget
    }
}

dependencies {

    implementation(libs.androidx.core.core.ktx)
    implementation(project(mapOf("path" to ":presentation:viewmodels")))
    implementation(project(mapOf("path" to ":domain:usecases")))
    implementation(project(mapOf("path" to ":data:repository")))
    implementation(project(mapOf("path" to ":data:datasources-core")))
}