package com.musa.popularrepo


import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.musa.popularrepo.networkUtils.LoadingStatus


@BindingAdapter("showProgress")
fun ImageView.showProgress(loadingStatus: LoadingStatus){
    when(loadingStatus){
        is LoadingStatus.Loading -> setBackgroundResource(R.drawable.loading_animation)
        is LoadingStatus.Error -> setBackgroundResource(R.drawable.ic_connection_error)
        is LoadingStatus.Success -> visibility = View.GONE
    }
}