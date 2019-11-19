package com.musa.popularrepo.reposFragment


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.musa.popularrepo.base.BaseViewModel
import com.musa.popularrepo.networkUtils.LoadingStatus
import com.musa.popularrepo.repository.RepoRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


class ReposViewModel @Inject constructor(private val repository: RepoRepository) : BaseViewModel() {
    val repos = repository.repos
    private var _favourite = MutableLiveData<Int?>()
    val favourite get() = _favourite

    private fun isLoading(message : String){
        _loadingStatus.value = LoadingStatus.Loading(message)
    }

    private fun isError(errorCode: String?, errorMessage:String?){
        _loadingStatus.value = LoadingStatus.Error(errorCode,errorMessage)
    }

    private fun isSuccess(){
        _loadingStatus.value = LoadingStatus.Success
    }

    init {
        isLoading("Fetching Repos Please Wait")
        viewModelScope.launch {
            try {
                repository.refreshRepo()
                isSuccess()
            } catch (e: Exception) {
                isError(e.localizedMessage, e.localizedMessage)
                Timber.e(e)
            }

        }
    }

    fun addToFavourites(repoId: Int) {
        _favourite.value = repoId
    }

    fun doneAddingToFavourite() {
        _favourite.value = null
    }

}



