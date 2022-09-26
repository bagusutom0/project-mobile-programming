package com.latihan.project_mobile_programming.di

import android.app.Application
import com.latihan.project_mobile_programming.core.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@MyApp)
            modules(appModule)
            modules(repositoryModule)
        }
    }
}