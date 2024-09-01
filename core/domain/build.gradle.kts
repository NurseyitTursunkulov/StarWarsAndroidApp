plugins {
    alias(libs.plugins.nowinandroid.android.library)
    alias(libs.plugins.nowinandroid.android.library.jacoco)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.domain"
}

dependencies {
    api(projects.core.data)
    api(projects.core.model)

    implementation(libs.javax.inject)

//    testImplementation(projects.core.testing)
}