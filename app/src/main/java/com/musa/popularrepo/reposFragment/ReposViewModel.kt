package com.musa.popularrepo.reposFragment


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.musa.popularrepo.base.BaseViewModel
import com.musa.popularrepo.repository.RepoRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


class ReposViewModel @Inject constructor(private val repository: RepoRepository) : BaseViewModel() {
    val repos = repository.repos
    private var _favourite = MutableLiveData<Int?>()
    val favourite get() = _favourite

    init {
        super.isLoading("Fetching Repos Please Wait")
        viewModelScope.launch {
            try {
                repository.refreshRepo()
                super.isSuccess()
            } catch (e: Exception) {
                super.isError(e.localizedMessage, e.localizedMessage)
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



