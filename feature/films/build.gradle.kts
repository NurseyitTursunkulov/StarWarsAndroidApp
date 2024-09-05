plugins {
    alias(libs.plugins.nowinandroid.android.feature)
    alias(libs.plugins.nowinandroid.android.library.compose)
    alias(libs.plugins.nowinandroid.android.library.jacoco)
}

android {
    namespace = "com.example.films"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.domain)

    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
}