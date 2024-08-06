plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.example.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Kotlinx Serialization library for serializing and deserializing Kotlin objects to and from JSON
    implementation (libs.kotlinx.serialization.json )

    //Hilt Dependency Injection
    implementation(libs.hilt.android)
    // Dagger Core
    implementation (libs.dagger)
    kapt (libs.dagger.compiler)

    // Dagger Android
    api (libs.dagger.android)
    api (libs.dagger.android.support)
    kapt (libs.dagger.android.processor)

    // Dagger - Hilt
    implementation (libs.dagger.hilt.android)
    kapt (libs.hilt.android.compiler)

    implementation(project(":domain"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}