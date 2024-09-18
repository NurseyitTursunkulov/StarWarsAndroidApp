plugins {
    alias(libs.plugins.my.android.library)
    alias(libs.plugins.my.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.example.data"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    api(projects.core.common)
    api(projects.core.database)
    api(projects.core.network)

    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.kotlinx.serialization.json)
}