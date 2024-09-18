plugins {
    alias(libs.plugins.my.jvm.library)
    alias(libs.plugins.my.hilt)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.turbine)
}