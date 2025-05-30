plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    // Hilt
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.axoft.axmobilepedidos"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.axoft.axmobilepedidos"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "API_BASE_URL", "\"${property("API_BASE_URL_RELEASE")}\"")
            buildConfigField("String", "API_TOKEN", "\"${property("API_TOKEN_RELEASE")}\"")
            buildConfigField("int", "API_COMPANY", property("API_COMPANY_RELEASE").toString())
            buildConfigField("boolean", "LOGIN_REQUIRED", property("LOGIN_REQUIRED_RELEASE").toString())
        }
        debug {
            buildConfigField("String", "API_BASE_URL", "\"${property("API_BASE_URL_DEBUG")}\"")
            buildConfigField("String", "API_TOKEN", "\"${property("API_TOKEN_DEBUG")}\"")
            buildConfigField("int", "API_COMPANY", property("API_COMPANY_DEBUG").toString())
            buildConfigField("boolean", "LOGIN_REQUIRED", property("LOGIN_REQUIRED_DEBUG").toString())
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    //region Core & Extensions
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    //endregion

    //region Jetpack Compose & UI
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.foundation)
    //endregion

    //region Room (Database)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)
    //endregion

    //region Dependency Injection (Hilt)
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    kapt(libs.hilt.compiler)
    //endregion

    //region Network (Retrofit)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    //endregion

    //region Background & Transport
    implementation(libs.transport.runtime)
    //endregion

    //region Benchmark (if used)
    implementation(libs.androidx.benchmark.common)
    //endregion

    //region Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    //endregion

    //region Debug Tools
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    //endregion
}
