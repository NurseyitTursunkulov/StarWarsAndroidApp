plugins {
    alias(libs.plugins.my.android.library)
    alias(libs.plugins.my.hilt)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.domain"
}

dependencies {
    api(projects.core.data)
    api(projects.core.model)
    implementation(projects.core.common)
    implementation(libs.javax.inject)

//    testImplementation(projects.core.testing)
}