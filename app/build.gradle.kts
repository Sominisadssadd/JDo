plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.jdo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.jdo"
        minSdk = 29
        targetSdk = 34
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
        viewBinding = true
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    //GLide
    implementation(libs.image.glide)
    //Room
    //noinspection KaptUsageInsteadOfKsp
    kapt(libs.room.compiler)
    implementation(libs.room.runtime)
    //Retrofit
    implementation(libs.retrofit2.std)
    implementation(libs.retrofit2.converter)
    //Coroutines
    implementation(libs.coroutine.core)
    implementation(libs.coroutines.android)
    //GSON
    implementation(libs.gson)
    //Navigation
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    //Dagger
    implementation(libs.dagger.std)
    kapt(libs.dagger.compiler)
    implementation(libs.dagger.runtime)
    //Lifecycle
    implementation(libs.lifycycle.runtime)

    implementation(project(path = ":core"))
    implementation(project(path = ":authentication"))
    implementation(project(path = ":profile"))
    implementation(project(path = ":board"))
    implementation(project(path = ":message"))
    implementation(project(path = ":challenge"))

}