package com.musa.popularrepo.di

import com.musa.popularrepo.repository.NetworkRepo
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Named

@Module
class NetworkModule {
    @Provides
    @Named("baseUrl")
    fun provideBaseUrl():String= "https://api.github.com/"
}

interface RepoService{

    @GET("search/repositories")
    suspend fun getTrendingReposAsync(@Query("language") language:String , @Query("order") order:String ,@Query("sort") sort:String): Deferred<List<NetworkRepo>>
}
