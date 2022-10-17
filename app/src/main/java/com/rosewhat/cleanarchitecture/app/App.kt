package com.rosewhat.cleanarchitecture.app

import android.app.Application
import com.rosewhat.cleanarchitecture.di.appModule
import com.rosewhat.cleanarchitecture.di.dataModule
import com.rosewhat.cleanarchitecture.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }

}