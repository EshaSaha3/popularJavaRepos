package com.musa.popularrepo.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.musa.popularrepo.networkUtils.LoadingStatus

abstract class BaseViewModel : ViewModel() {

    private val _loadingStatus = MutableLiveData<LoadingStatus>()

    val loadingStatus: LiveData<LoadingStatus>
        get() = _loadingStatus

    fun isLoading(message : String){
        _loadingStatus.value = LoadingStatus.Loading(message)
    }

    fun isError(errorCode: String?, errorMessage:String?){
        _loadingStatus.value = LoadingStatus.Error(errorCode,errorMessage)
    }

    fun isSuccess(){
        _loadingStatus.value = LoadingStatus.Success
    }

}