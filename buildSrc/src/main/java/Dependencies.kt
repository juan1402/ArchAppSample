@file:Suppress("unused")

object ApplicationId {
    const val id = "com.hurtado.codechallange"
}

object Modules {
    const val app = ":app"
    const val navigation = ":navigation"
    const val features = ":features"
    const val dataSrc = ":datasource"
    const val common = ":common"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val kotlin = "1.3.50"
    const val gradle = "3.3.2"
    const val compileSdk = 28
    const val minSdk = 26
    const val targetSdk = 28
    const val appCompat = "1.1.0-alpha04"
    const val coreKtx = "1.1.0-alpha04"
    const val constraintLayout = "1.1.3"
    const val junit = "4.12"
    const val androidTestRunner = "1.1.2-alpha02"
    const val espressoCore = "3.2.0-alpha02"
    const val retrofit = "2.5.0"
    const val retrofitCoroutines = "0.9.2"
    const val retrofitGson = "2.4.0"
    const val gson = "2.8.5"
    const val okHttp = "3.12.1"
    const val coroutines = "1.1.1"
    const val koin = "1.0.2"
    const val timber = "4.7.1"
    const val lifecycle = "2.1.0-alpha04"
    const val nav = "2.1.0"
    const val room = "2.1.0-alpha06"
    const val recyclerview = "1.0.0"
    const val safeArgs = "2.1.0-alpha01"
    const val glide = "4.9.0"
    const val mockwebserver = "2.7.5"
    const val archCoreTest = "2.0.0"
    const val androidJunit = "1.1.0"
    const val mockk = "1.9.2"
    const val fragmentTest = "1.1.0-alpha06"
    const val databinding = "3.3.2"
}

object Libraries {
    // KOIN
    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"

    // ROOM
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomRunTime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    // RETROFIT
    const val retrofitCoroutineAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    const val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    // GLIDE
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
}

object KotlinLibraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object AndroidLibraries {
    // KOTLIN
    const val kotlinCoroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // ANDROID
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    const val navigationFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
}

object TestLibraries {
    // ANDROID TEST
    const val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espressoCore}"
    const val archCoreTest = "androidx.arch.core:core-testing:${Versions.archCoreTest}"
    const val junit = "androidx.test.ext:junit:${Versions.androidJunit}"
    const val fragmentNav = "androidx.fragment:fragment-testing:${Versions.fragmentTest}"

    // KOIN
    const val koin = "org.koin:koin-test:${Versions.koin}"

    // MOCK WEB SERVER
    const val mockWebServer = "com.squareup.okhttp:mockwebserver:${Versions.mockwebserver}"

    // MOCK
    const val mockkAndroid = "io.mockk:mockk-android:${Versions.mockk}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"

    // CO ROUTINE
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"

    // DATA BINDING
    const val databinding = "androidx.databinding:databinding-compiler:${Versions.databinding}"
}