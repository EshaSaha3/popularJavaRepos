package com.musa.popularrepo.application

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(val _application: Application) {

    private val application: Application
        get() = _application

    @Provides
    fun getgiContext(): Context {
        return application
    }

}
