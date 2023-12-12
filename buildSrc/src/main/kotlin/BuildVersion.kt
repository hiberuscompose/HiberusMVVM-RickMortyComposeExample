import org.gradle.api.JavaVersion

object BuildVersion {
    object environment {
        private const val majorVersion = 1
        private const val minorVersion = 0
        private const val bugFixVersion = 0

        const val minSdkVersion = 24
        const val compileSdkVersion = 34
        const val applicationId = "com.hiberus.template.presentation"
        const val appVersionCode = majorVersion * 1000 + minorVersion*100 + bugFixVersion
        const val appVersionName = "$majorVersion.$minorVersion.$bugFixVersion"
        val javaVersion = JavaVersion.VERSION_17
        const val jvmTarget = "17"
        const val composeCompilerVersion = "1.5.4"
    }

    object testEnvironment {
        const val instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        const val instrumentationRunnerArgs = "de.mannodermaus.junit5.AndroidJUnit5Builder"
    }
}
