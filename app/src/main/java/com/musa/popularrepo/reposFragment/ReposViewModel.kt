package com.musa.popularrepo.reposFragment


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.musa.popularrepo.base.BaseViewModel
import com.musa.popularrepo.repository.RepoRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


class ReposViewModel @Inject constructor(private val repository: RepoRepository) : BaseViewModel() {

    val repos = repository.repos

    init {
        viewModelScope.launch {
            repository.refreshRepo()
        }
    }

}



