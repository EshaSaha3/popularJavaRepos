package com.musa.popularrepo.application

import android.app.Application
import com.musa.popularrepo.di.ApiServiceModule
import com.musa.popularrepo.di.LocalDataModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,ApiServiceModule::class,LocalDataModule::class])
interface ApplicationComponent {

    fun inject(application: Application)
}

