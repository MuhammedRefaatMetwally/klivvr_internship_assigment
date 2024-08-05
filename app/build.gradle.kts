plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.klivvr_cities_assigment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.klivvr_cities_assigment"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Core Jetpack Compose UI library for building composable UIs
    implementation (libs.ui)

    // Jetpack Compose Material Design library for UI components
    implementation (libs.androidx.material)

    // Tooling support for Compose to preview UI components
    implementation (libs.ui.tooling.preview)

    // Kotlin extensions for lifecycle-aware components (ViewModel, LiveData, etc.)
    implementation (libs.androidx.lifecycle.runtime.ktx.v240)

    // Jetpack Compose integration with Activity component
    implementation (libs.androidx.activity.compose.v140)

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

    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}