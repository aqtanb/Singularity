plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler) apply false
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.google.ksp)
}

android {
    namespace = "kz.singularity.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation (libs.retrofit)
    implementation (libs.gson)
    implementation (libs.converter.gson)
    implementation (libs.logging.interceptor)

    implementation(libs.hilt.android)
    ksp (libs.hilt.android.compiler)

    implementation(libs.androidx.room.runtime)
    ksp (libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    implementation(project(":domain"))
}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}
