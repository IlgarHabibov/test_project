plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.atlandroidexamples"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.atlandroidexamples"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

//    signingConfigs {
//        getByName("test"){
//            keyAlias = "ATL_project"
//            keyPassword = "ATL123"
//            storePassword = "ATL123"
//            storeFile = file("")
//        }
//
//        getByName("prod"){
//            keyAlias = ""
//            keyPassword = ""
//            storePassword = ""
//            storeFile = file("")
//        }
//    }



    buildTypes {
        release {
            isMinifyEnabled = true
//            signingConfig = signingConfigs.getByName("prod")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            isMinifyEnabled = false
            versionNameSuffix = "-debug"
//            signingConfig = signingConfigs.getByName("test")
        }
    }

    flavorDimensions += "environment"

    productFlavors {
        create("prod"){
            dimension = "environment"

        }

        create("dev"){
            dimension = "environment"
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

kapt {
    correctErrorTypes = true
}

dependencies {


    implementation(project(":teachers"))
    implementation(project(":students"))

    // Core ktx
    implementation("androidx.core:core-ktx:1.12.0")

    // Appcompat
    implementation("androidx.appcompat:appcompat:1.6.1")

    // Material
    implementation("com.google.android.material:material:1.11.0")

    // ConstraintLayout
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Navigation
    val navVersion = "2.7.4"
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    // Lifecycle
    val lifecycleVersion = "2.7.0"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")


    // Room
    val roomVersion = "2.6.0"
    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")

    // Retrofit
    val retrofitVersion = "2.9.0"
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    //Okhttp
    val okhttpVersion = "4.11.0"
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")

    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.46.1")
    kapt("com.google.dagger:hilt-android-compiler:2.46.1")

    // Coroutines
    val coroutiesVersion = "1.7.1"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutiesVersion")

    //Coil
    implementation("io.coil-kt:coil:2.4.0")

    //Picasso
    implementation("com.squareup.picasso:picasso:2.8")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // WorkManager
    val workVersion = "2.9.0"
    implementation("androidx.work:work-runtime-ktx:$workVersion")


    implementation(project(":my-library"))
//    implementation(project(":test-lib"))

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}