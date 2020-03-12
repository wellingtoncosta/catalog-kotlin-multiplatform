plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "io.github.wellingtoncosta.todoapp"
        minSdkVersion(16)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }

        viewBinding {
            isEnabled = true
        }
    }

    lintOptions {
        isAbortOnError = false
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            isTestCoverageEnabled = true
        }

        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            isZipAlignEnabled = true
            proguardFile(getDefaultProguardFile("proguard-android.txt"))
            proguardFile(file("proguard-rules.pro"))
        }
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
        animationsDisabled = true
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        val commonTest = "src/commonTest/java"
        getByName("androidTest").java.srcDirs(commonTest)
        getByName("test").java.srcDirs(commonTest)
    }
}

dependencies {
    implementation(project(":shared"))

    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")

    implementation("com.google.android.material:material:1.1.0")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.70")
}
