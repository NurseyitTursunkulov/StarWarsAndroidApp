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
include(":core:datastore")
include(":core:datastor-proto")
include(":core:datastore-proto")
include(":core:notifications")
include(":core:ui")
include(":lib")
include(":feature")
include(":feature:bookmarks")
include(":feature:foryou")
include(":core:domain")
