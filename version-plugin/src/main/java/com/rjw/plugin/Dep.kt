package com.rjw.plugin

/**
 * Des
 *
 * Created by renjiawen on 2022/4/27 22:29.
 *
 */

object Dep {
    object Version {


        // Kotlin----------------------------------------------------------------
        const val Kotlin = "1.4.32"
        const val Coroutines = "1.4.3"                      // 协程

        // JetPack---------------------------------------------------------------
        const val LifecycleViewModel = "2.2.0"
        const val LifecycleRuntimeKtx = "2.2.0"
        const val LifecycleViewModelKtx = "2.2.0"
        const val Lifecycle = "2.4.0"                       // Lifecycle相关（ViewModel & LiveData & Lifecycle）
        const val Arch = "2.1.0"
        const val Room = "2.3.0"                            // 官方推荐数据库框架
        const val Hilt = "2.40.5"                           // DI框架-Hilt
        const val HiltAndroidx = "1.0.0"
        const val WorkVersion = "2.7.1"

        const val navVersion = "2.5.3"

    }


    //Kotlin相关依赖
    object Kotlin {
        const val Kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Version.Kotlin}"
        const val CoroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.Coroutines}"
        const val CoroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.Coroutines}"
        const val Coil ="io.coil-kt:coil:1.1.1"
    }
    object Google{
        //gson
        const val GoogleGson = "com.google.code.gson:gson:2.10"

    }

    object OkHttp{
        const val Retrofit ="com.squareup.retrofit2:retrofit:2.9.0"
        const val RetrofitConverter ="com.squareup.retrofit2:converter-gson:2.9.0"
        const val Core = "com.squareup.okhttp3:okhttp:4.10.0"
        const val Logging = "com.squareup.okhttp3:logging-interceptor:4.10.0"


    }



    //JetPack相关依赖
    object JetPack {

        // ViewModel
        const val LifecycleViewModel =
            "androidx.lifecycle:lifecycle-viewmodel:${Version.LifecycleViewModel}"
        const val LifecycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Version.LifecycleRuntimeKtx}"
        const val LifecycleViewModelKtx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.Lifecycle}"
        const val lifecycleViewmodelCompose =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.Lifecycle}"

        //Saved state module for ViewModel
        const val LifecycleViewModelSavedState =
            "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.Lifecycle}"

        // LiveData
        const val LifecycleLiveData =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Version.Lifecycle}"

        //Lifecycles only (without ViewModel or LiveData)
        const val LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.Lifecycle}"

        //Annotation processor
        const val LifecycleApt = "androidx.lifecycle:lifecycle-compiler:${Version.Lifecycle}"

        const val LifecycleExtensions =
            "androidx.lifecycle:lifecycle-extensions:${Version.Lifecycle}"

        //alternately - if using Java8, use the following instead of lifecycle-compiler
        const val lifecycleCommonJava8 =
            "androidx.lifecycle:lifecycle-common-java8:${Version.Lifecycle}"

        // optional - helpers for implementing LifecycleOwner in a Service
        const val LifecycleService = "androidx.lifecycle:lifecycle-service:${Version.Lifecycle}"

        // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
        const val LifecycleProcess = "androidx.lifecycle:lifecycle-process:${Version.Lifecycle}"

        // optional - ReactiveStreams support for LiveData
        const val LifecycleReactivestreamsKtx =
            "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Version.Lifecycle}"

        // optional - Test helpers for LiveData
        const val CoreTestingtest = "androidx.arch.core:core-testing:${Version.Arch}"

        //koin

//        implementation

        const val ActivityKtx ="androidx.activity:activity-ktx:1.7.0"
        const val FragmentKtx ="androidx.fragment:fragment-ktx:1.5.6"

        const val KoinAndroid ="io.insert-koin:koin-android:3.3.3"

        const val NavigationFragment = "androidx.navigation:navigation-fragment-ktx:${Version.navVersion}"
        const val NavigationUi = "androidx.navigation:navigation-ui-ktx:${Version.navVersion}"






//    const val Room = "androidx.room:room-runtime:${Version.Room}"
//    const val RoomCompiler = "androidx.room:room-compiler:${Version.Room}"
//    const val RoomKtx = "androidx.room:room-ktx:${Version.Room}"
//
//
//    const val HiltCore = "com.google.dagger:hilt-android:${Version.Hilt}"
//    const val HiltApt = "com.google.dagger:hilt-compiler:${Version.Hilt}"
//    const val HiltAndroidx = "androidx.hilt:hilt-compiler:${Version.HiltAndroidx}"
//
//
//    const val WorkRuntimeKtx = "androidx.work:work-runtime-ktx:${Version.WorkVersion}"


        // ViewModel utilities for Compose
    }

    object ThirdPart{
        const val Banner ="io.github.youth5201314:banner:2.2.2"

    }
}

