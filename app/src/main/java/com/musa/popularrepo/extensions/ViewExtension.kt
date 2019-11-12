package com.musa.popularrepo.extensions

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.view.children

fun View.show(){
    visibility = VISIBLE
}

fun View.hideView(){
    visibility = GONE
}

fun ViewGroup.showWithChildren(){
    show()
    for (view in children){
        view.show()
    }
}

fun ViewGroup.dissmissWithChildren(){
    hideView()
    for (view in children){
        view.hideView()
    }
}