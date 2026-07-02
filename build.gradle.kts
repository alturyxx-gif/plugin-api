plugins {
    id("com.android.library")
}

android {
    namespace = "com.zstream.plugin.api"
    compileSdk = 36
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        jvmToolchain(11)
    }
}

dependencies {
    // Kotlin stdlib only — this module has no other dependencies by design.
    // The plugin repo depends on the produced .aar as compileOnly.
}
