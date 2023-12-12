pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Hiberus Template"
include(":presentation:ui")
include(":presentation:viewmodels")
include(":domain:usecases")
include(":domain:models")
include(":domain:repository")
include(":data:repository")
include(":data:models")
include(":data:datasources")
include(":data:datasources-core")
include(":core:common")
include(":core:ui")
include(":core:di")
