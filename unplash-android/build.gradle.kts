plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("kotlin-android")
    id("com.google.devtools.ksp") version "1.7.0-1.0.6"
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.uwaisalqadri.unplash_mobile.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    applicationVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/$name/kotlin")
            }
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("androidx.navigation:navigation-fragment-ktx:2.4.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.2")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")

    implementation("androidx.compose.ui:ui:1.1.1")
    implementation("androidx.compose.material:material:1.1.1")
    implementation("androidx.compose.ui:ui-tooling:1.1.1")
    implementation("androidx.compose.foundation:foundation:1.1.1")
    implementation("androidx.compose.foundation:foundation-layout:1.1.1")
    implementation("androidx.compose.ui:ui-graphics:1.1.1")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.compose.material:material-icons-extended:1.1.1")
    implementation("androidx.compose.ui:ui-util:1.1.1")
    implementation("com.valentinilk.shimmer:compose-shimmer:1.0.2")
    implementation("androidx.compose.runtime:runtime-livedata:1.1.1")

    implementation("io.insert-koin:koin-android:3.1.6")
    implementation("io.insert-koin:koin-androidx-compose:3.1.6")

    implementation("com.google.accompanist:accompanist-coil:1.0.0")

    implementation("io.github.raamcosta.compose-destinations:core:1.0.0")
    implementation("io.github.raamcosta.compose-destinations:animations-core:1.0.0")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.0.0")
}