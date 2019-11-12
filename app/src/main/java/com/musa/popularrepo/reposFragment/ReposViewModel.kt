package com.musa.popularrepo.reposFragment


import androidx.lifecycle.viewModelScope
import com.musa.popularrepo.base.BaseViewModel
import com.musa.popularrepo.repository.RepoRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


class ReposViewModel @Inject constructor(private val repository: RepoRepository) : BaseViewModel() {
    val repos = repository.repos

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

}



