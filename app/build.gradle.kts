plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.happyland_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.happyland_app"
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
        kotlinCompilerExtensionVersion = "1.5.1" // Versión del compilador Compose
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core Android libraries
    
        implementation("androidx.camera:camera-camera2:1.2.0") // O la última versión disponible
        implementation("androidx.camera:camera-lifecycle:1.2.0")
        implementation("androidx.camera:camera-view:1.2.0-alpha20") // Solo si lo necesitas


    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.9.2")

    // Compose libraries
    implementation(platform("androidx.compose:compose-bom:2024.04.01")) // Bill of Materials (BoM) para Compose
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3:1.1.0-alpha05")
    implementation(libs.androidx.espresso.core)
    implementation(libs.androidx.espresso.core)
    implementation(libs.androidx.espresso.core)

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    // Testing para Compose
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.04.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // Debug
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
