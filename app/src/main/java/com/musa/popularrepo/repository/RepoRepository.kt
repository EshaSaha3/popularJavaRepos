package com.musa.popularrepo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.musa.popularrepo.database.RepoDatabase
import com.musa.popularrepo.di.RepoService
import com.musa.popularrepo.model.DomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class RepoRepository @Inject constructor(private val service:RepoService,private val repoDatabase: RepoDatabase,private val retrofit: Retrofit){
    val repos : LiveData<List<DomainModel>> = Transformations.map(
        repoDatabase.database.getRepo()){
        it.asDomainModel()
    }


    suspend fun refreshRepo(){
        withContext(Dispatchers.IO){
           val repos = retrofit.create(service::class.java).getTrendingRepos().await()
            repoDatabase.database.insertRepo(*repos.asDatabaseModel())
        }
    }
}