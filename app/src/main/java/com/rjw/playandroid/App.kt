package com.rjw.playandroid

import android.app.Application
import com.rjw.playandroid.di.KoinModule.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Des
 *
 * Created by renjiawen on 2023/4/18 22:50.
 *
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        //开启Koin
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}