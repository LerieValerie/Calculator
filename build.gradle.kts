import Presentation_android_common_gradle.FlavorsConfiguratorPlugin.configureFlavors

plugins {
    id(Libs.Android.libraryPlugin)
    id(Libs.Kotlin.androidPlugin)
    id(Libs.AndroidX.Navigation.safeArgsPlugin)
}

configureFlavors()

android {
    compileSdk = Tools.Android.compileSdkVersion
    namespace = "com.google.android.apps.calculator"

    defaultConfig {
        minSdk = Tools.Android.minSdkVersion
        consumerProguardFiles("proguard-rules.pro")
    }


    sourceSets["main"].apply {
        manifest.srcFile("AndroidManifest.xml")
        java.srcDirs("src")
        res.srcDirs("res")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(files("arity-2.1.2.jar"))

    implementation(Libs.AndroidX.core)
    implementation(Libs.AndroidX.viewpager)

    implementation(Libs.AndroidX.Navigation.ui)

    implementation(project(Modules.Core.domain))
    implementation(project(Modules.Core.presentationAndroid))
    implementation(project(Modules.Feature.CalcMask.domain))
    implementation(project(Modules.Feature.CalcMask.presentationMp))
}