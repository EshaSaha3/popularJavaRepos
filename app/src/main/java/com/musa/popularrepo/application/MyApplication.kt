package com.musa.popularrepo.application

import android.app.Application
import android.os.Build
import androidx.work.*
import com.musa.popularrepo.BuildConfig
import com.musa.popularrepo.di.ApiServiceModule
import com.musa.popularrepo.di.LocalDataModule
import com.musa.popularrepo.di.NetworkModule
import com.musa.popularrepo.workManager.RefreshDataWork
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.TimeUnit

class MyApplication() : Application() {
    val applicationScope = CoroutineScope(Dispatchers.Default)
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
        delayedInit()
    }

    private fun delayedInit(){
        applicationScope.launch {
            setupRecurringWork()
        }
    }

    private fun setupRecurringWork(){
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresCharging(true)
            .setRequiresBatteryNotLow(true)
            .apply {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    setRequiresDeviceIdle(true)
                }
            }.build()
        val repeatingRequest = PeriodicWorkRequestBuilder<RefreshDataWork>(1,TimeUnit.DAYS)
            .setConstraints(constraints)
            .build()


        WorkManager.getInstance().enqueueUniquePeriodicWork(
            RefreshDataWork.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            repeatingRequest
        )
    }
}