plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.kotlin.android)
	kotlin("plugin.serialization") version "2.0.21"
	id("kotlin-kapt")
	id("com.google.dagger.hilt.android")
	alias(libs.plugins.compose.compiler)
}

android {
	namespace = "com.rushi.pharmahub"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.rushi.pharmahub"
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
		kotlinCompilerExtensionVersion = "1.5.1"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.tooling.preview)
	implementation(libs.androidx.material3)
	implementation(libs.material)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)

	// Jetpack Compose integration
	implementation("androidx.navigation:navigation-compose:2.8.3")

	// Serialization
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

	// Dagger Hilt
	implementation("com.google.dagger:hilt-android:2.51.1")
	kapt("com.google.dagger:hilt-android-compiler:2.51.1")

	// Hilt Navigation Compose
	implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

	// Api For RetroFit
	implementation("com.squareup.retrofit2:retrofit:2.11.0")
	implementation("com.squareup.retrofit2:converter-gson:2.11.0")

	// Image Loading Coil
	implementation("io.coil-kt:coil-compose:2.5.0")

	implementation("com.google.accompanist:accompanist-pager:0.36.0")
	implementation("com.google.accompanist:accompanist-pager-indicators:0.36.0")

	// For controlling system UI (status bar, navigation bar)
	implementation("com.google.accompanist:accompanist-systemuicontroller:0.36.0")
	implementation(kotlin("script-runtime"))

	//lottie
	implementation("com.airbnb.android:lottie-compose:6.0.0")

}