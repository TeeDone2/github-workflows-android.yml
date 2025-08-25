plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.jarvisx"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jarvisx"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "0.1.0"
        vectorDrawables { useSupportLibrary = true }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.activity:activity-ktx:1.9.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Optional: ML Kit (OCR) & TTS/Speech placeholder dependencies (add real ones as needed)
    implementation("com.google.mlkit:text-recognition:16.0.1")
}