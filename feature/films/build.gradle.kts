plugins {
    alias(libs.plugins.my.android.feature)
    alias(libs.plugins.my.android.library.compose)
}

android {
    namespace = "com.example.films"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.domain)

    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
}