pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "MyApplication"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
//include(":build-logic")
include(":core")
include(":core:common")
include(":core:network")
include(":core:model")
include(":core:database")
include(":core:data")
//include(":core:datastore")
include(":core:ui")
include(":feature")
include(":feature:actors")
include(":core:domain")
include(":feature:films")
include(":sync")
include(":sync:work")
include(":benchmark")
