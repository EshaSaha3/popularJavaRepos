package com.musa.popularrepo.di

import android.app.Application
import androidx.room.Room
import com.musa.popularrepo.database.RepoDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Provides
    @Singleton
    fun provideRepoDatabase(app:Application):RepoDatabase = Room.databaseBuilder(
        app,RepoDatabase::class.java,"repos-database.db").build()
}