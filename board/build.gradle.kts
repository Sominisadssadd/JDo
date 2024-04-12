@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("kotlin-kapt")
    kotlin("plugin.serialization")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.board"
    compileSdk = 34

    defaultConfig {
        minSdk = 29

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
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.storage)
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
    //Firebase
    implementation(platform(libs.firebase.bom))
    //Chart
    implementation(libs.pie.chart)
    implementation(libs.mpchart)
    //Serializable
    implementation(libs.sirializable)
    //lottie
    implementation(libs.lottie.animation)

    implementation(project(path = ":core"))
}