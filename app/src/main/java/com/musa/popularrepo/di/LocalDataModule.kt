package com.musa.popularrepo.di

import android.content.Context
import androidx.room.Room
import com.musa.popularrepo.database.RepoDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Provides
    @Singleton
    fun provideRepoDatabase(application:Context):RepoDatabase = Room.databaseBuilder(
        application,RepoDatabase::class.java,"repos-database.db").build()
}