// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `version-catalog`
    `jacoco`
    `jacoco-report-aggregation`
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.com.android.library) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.com.google.devtools.ksp) apply false
    alias(libs.plugins.de.mannodermaus.android.junit5) apply false
    alias(libs.plugins.org.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.com.google.dagger.hilt.android) apply false
    alias(libs.plugins.com.github.ben.manes.versions)
    alias(libs.plugins.nl.littlerobots.version.catalog.update)
    alias(libs.plugins.io.gitlab.arturbosch.detekt)
}

allprojects {
    this.tasks.forEach { task ->
        if (task.name.contains("testDebugUnitTest")) {
            task.finalizedBy("jacocoTestReport")
        }
    }
}

true // Needed to make the Suppress annotation work for the plugins block