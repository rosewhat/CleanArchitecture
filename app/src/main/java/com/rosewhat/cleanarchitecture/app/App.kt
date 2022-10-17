package com.rosewhat.cleanarchitecture.app

import android.app.Application
import com.rosewhat.cleanarchitecture.di.appModule
import com.rosewhat.cleanarchitecture.di.dagger.AppComponent
import com.rosewhat.cleanarchitecture.di.dataModule
import com.rosewhat.cleanarchitecture.di.domainModule
import dagger.Component
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@HiltAndroidApp
class App : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
       /* startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }*/

            //   appComponent = DaggerAppComponent.builder().



    }

}