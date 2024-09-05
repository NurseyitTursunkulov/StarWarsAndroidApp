plugins {
    alias(libs.plugins.nowinandroid.android.library)
    alias(libs.plugins.nowinandroid.android.library.jacoco)
    alias(libs.plugins.nowinandroid.hilt)
    alias(libs.plugins.protobuf)
}

android {
    defaultConfig {
        consumerProguardFiles("consumer-proguard-rules.pro")
    }
    namespace = "com.example.datastore"
    testOptions {
        unitTests {
            isReturnDefaultValues = true
        }
    }

    sourceSets {
        getByName("debug") {val buildDir = layout.buildDirectory.get().asFile
            java.srcDir(buildDir.resolve("generated/source/proto/java"))
            kotlin.srcDir(buildDir.resolve("generated/source/proto/kotlin"))
        }
    }
}

//// Setup protobuf configuration, generating lite Java and Kotlin classes
protobuf {
    protoc {
        artifact = libs.protobuf.protoc.get().toString()
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                register("java") {
                    option("lite")
                }
                register("kotlin") {
                    option("lite")
                }
            }
        }
    }
}


dependencies {
    api(libs.androidx.dataStore)
    api(projects.core.model)

    api(libs.protobuf.kotlin.lite)

    implementation(projects.core.common)

//    testImplementation(projects.core.datastoreTest)
    testImplementation(libs.kotlinx.coroutines.test)
}