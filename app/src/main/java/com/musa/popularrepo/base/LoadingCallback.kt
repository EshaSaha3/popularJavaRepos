package com.musa.popularrepo.base

import androidx.annotation.StringRes

interface LoadingCallback {

    fun showLoading()

    fun showLoading(@StringRes resId: Int)

    fun showLoading(message: String)

    fun dismissLoading()

    fun showError()
}