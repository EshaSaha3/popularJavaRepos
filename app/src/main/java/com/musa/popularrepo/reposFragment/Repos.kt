package com.musa.popularrepo.reposFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.musa.popularrepo.R
import com.musa.popularrepo.application.ApplicationComponent
import com.musa.popularrepo.application.MyApplication
import timber.log.Timber
import javax.inject.Inject

class Repos : Fragment() {

    private lateinit var viewModel: ReposViewModel
    @Inject lateinit var viewModelFactory:ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.repos_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (context!!.applicationContext as MyApplication).applicationComponent.inject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(ReposViewModel::class.java)
      viewModel.repos.observe(this, Observer {
          Timber.i("the size of repo is ${it.size}")
      })
    }

}
