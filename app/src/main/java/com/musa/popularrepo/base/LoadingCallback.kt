package com.musa.popularrepo.base

import androidx.annotation.StringRes

interface LoadingCallback {

    fun showLoading()

    fun showLoading(@StringRes resId:Int)

    fun dismissLoading()

    fun showError(message:String)
}