plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "io.antmedia.rtmp_client"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        externalNativeBuild {
            cmake {
                cppFlags("-frtti -fexceptions")
                arguments("-DANDROID_PLATFORM=android-15")
                abiFilters(
                    "x86",
                    "x86_64",
                    "armeabi-v7a",
                    "arm64-v8a"
                ) //, 'armeabi', 'mips', 'mips64'
            }
        }
    }

    lintOptions {
        isAbortOnError = false
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

    externalNativeBuild {
        cmake {
            path("CMakeLists.txt")
        }
    }
}

dependencies {

}