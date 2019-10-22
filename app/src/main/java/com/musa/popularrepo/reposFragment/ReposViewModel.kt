package com.musa.popularrepo.reposFragment


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.musa.popularrepo.database.RepoDatabase
import com.musa.popularrepo.repository.RepoRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


class ReposViewModel @Inject constructor(private val repository:RepoRepository) : ViewModel() {

    val repos = repository.repos

    init {
        viewModelScope.launch {
            repository.refreshRepo()
        }
    }

}



