plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt)
    kotlin("kapt")
}

android {
    namespace = "com.example.codewarsinfo"
    compileSdk = 34

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }

    defaultConfig {
        applicationId = "com.example.codewarsinfo"
        minSdk = 27
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":presentation"))
    implementation(project(":data"))
    implementation(project(":domain"))
    val composeBom = platform("androidx.compose:compose-bom:2024.05.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.ui.graphics)
    androidTestImplementation(libs.androidx.ui.test.junit4)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui)

    // Android Studio Preview support
    implementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)
    // Optional - Integration with activities
    implementation(libs.androidx.activity.compose)
    // Optional - Integration with ViewModels
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Navigation Compose
    implementation(libs.androidx.navigation.compose)

    implementation(libs.androidx.core.splashscreen)

    // DI
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
}