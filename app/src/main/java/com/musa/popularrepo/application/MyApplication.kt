package com.musa.popularrepo.application

import android.app.Application
import com.musa.popularrepo.BuildConfig
import com.musa.popularrepo.di.ApiServiceModule
import com.musa.popularrepo.di.LocalDataModule
import com.musa.popularrepo.di.NetworkModule
import timber.log.Timber

class MyApplication() : Application() {
     lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}