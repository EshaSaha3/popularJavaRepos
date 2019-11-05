package com.musa.popularrepo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.musa.popularrepo.database.RepoDatabase
import com.musa.popularrepo.di.RepoService
import com.musa.popularrepo.model.DomainModel
import com.musa.popularrepo.networkUtils.Result
import com.musa.popularrepo.networkUtils.getApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class RepoRepository @Inject constructor(private val service:RepoService, private val repoDatabase: RepoDatabase){
    val repos : LiveData<List<DomainModel>> = Transformations.map(
        repoDatabase.database.getRepo()){
        it.asDomainModel()
    }


    suspend fun refreshRepo(){
        withContext(Dispatchers.IO){
            try {
                when(val repos = getApiResult(service.getTrendingReposAsync())){
                    is Result.Success -> {
                        repoDatabase.database.dropTable()
                        repoDatabase.database.insertRepo(*repos.data.items.asDatabaseModel())
                    }
                    is Result.Error -> {
                        Result.Error(repos.errorCode, repos.errorMessage)
                    }
                }
            }catch (e: Exception){
                Timber.e(e)
            }

        }
    }
}