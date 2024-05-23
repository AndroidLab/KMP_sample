import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.devtoolsKsp)
    alias(libs.plugins.jensklingenbergKtorfit)
    alias(libs.plugins.roomGradlePlugin)
    libs.plugins.pluginSerialization.get().run {
        kotlin(pluginId) version version.displayName
    }
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_17.toString()
            }
        }
    }

    jvm("desktop")

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.kotlinxSerializationJson)
            implementation(libs.lifecycleViewmodel)

            //Пользовательские предпочтения
            implementation(libs.androidxDataStoreCore)
            //Графики
            implementation(libs.chart)
            //Сеть
            implementation(libs.ktorfitLib)
            implementation(libs.ktorSerializationKotlinxJson)
            implementation(libs.ktorClientSerialization)
            implementation(libs.ktorClientContentNegotiation)
            implementation(libs.kotlinxCoroutinesCore)
            //Внедрение зависимостей
            implementation(libs.koinCore)
            //api(libs.koinCompose)  //Что то не работает
            implementation(libs.koinCoreCoroutines)
            //#Навигация
            implementation(libs.odysseyCore)
            implementation(libs.odysseyCompose)
            //Загрузка изображений
            implementation(libs.coil)
            implementation(libs.coilComposeCore)
            implementation(libs.coilCompose)
            implementation(libs.coil)
            implementation(libs.coilNetworkKtor)
            //БД
            implementation(libs.roomRuntime)
            implementation(libs.sqliteBundled)
            implementation(libs.sqlite)
            //Остальное
            //implementation(libs.mvvmCore) // only ViewModel, EventsDispatcher, Dispatchers.UI
            //implementation(libs.mvvmCompose) // api mvvm-core, getViewModel for Compose Multiplatfrom

        }
        androidMain.dependencies {
            implementation(libs.uiToolingPreview)
            implementation(libs.activityCompose)
            implementation(libs.koinAndroid)
            api(libs.androidxStartup)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
    }
}

dependencies {
    with("de.jensklingenberg.ktorfit:ktorfit-ksp:2.0.0-beta1") {
        add("kspAndroid", this)
        add("kspIosX64", this)
        add("kspIosArm64", this)
        add("kspIosSimulatorArm64", this)
        add("kspDesktop", this)
    }
    with("androidx.room:room-compiler:2.7.0-alpha02") {
        add("kspAndroid", this)
        add("kspIosSimulatorArm64", this)
        add("kspIosX64", this)
        add("kspIosArm64", this)
        add("kspDesktop", this)
    }
}

room {
    schemaDirectory("$projectDir/schemas")
}

android {
    namespace = "org.example.project"
    compileSdk = libs.versions.androidCompileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "org.example.project"
        minSdk = libs.versions.androidMinSdk.get().toInt()
        targetSdk = libs.versions.androidTargetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    dependencies {
        debugImplementation(libs.composeUiTooling)
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        //javaHome = System.getenv("JAVA_HOME")   //Может иногда понадобиться, если не работает на windows
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.example.project"
            packageVersion = "1.0.0"
        }
    }
}