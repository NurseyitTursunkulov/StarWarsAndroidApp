plugins {
    alias(libs.plugins.my.android.library)
    alias(libs.plugins.my.hilt)
}

android {
    namespace = "com.example.work"
    defaultConfig {
        testInstrumentationRunner = "com.google.samples.apps.nowinandroid.core.testing.NiaTestRunner"
    }
}

dependencies {
    ksp(libs.hilt.ext.compiler)

    implementation(libs.androidx.tracing.ktx)
    implementation(libs.androidx.work.ktx)
    implementation(libs.hilt.ext.work)
    implementation(projects.core.data)


    androidTestImplementation(libs.androidx.work.testing)
    androidTestImplementation(libs.hilt.android.testing)
    androidTestImplementation(libs.kotlinx.coroutines.guava)
}