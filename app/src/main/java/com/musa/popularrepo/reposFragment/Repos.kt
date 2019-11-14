package com.musa.popularrepo.reposFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


import com.musa.popularrepo.R
import com.musa.popularrepo.application.MyApplication
import com.musa.popularrepo.base.BaseFragment
import com.musa.popularrepo.databinding.ReposFragmentBinding
import com.musa.popularrepo.networkUtils.LoadingStatus
import javax.inject.Inject

class Repos : BaseFragment() {

    private lateinit var viewModel: ReposViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ReposFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.repos_fragment,
            container,
            false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (context!!.applicationContext as MyApplication).applicationComponent.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ReposViewModel::class.java)
        val adapter = ReposAdapter(ReposAdapter.ReposListener { repoId ->
            viewModel.addToFavourites(repoId)
            Toast.makeText(context, "Added successfully to your favourite Repositories", Toast.LENGTH_LONG)
                .show()
        })
        binding.reposRecyclerView.adapter = adapter
        viewModel.repos.observe(this, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
        viewModel.loadingStatus.observe(this, Observer {
            when (it) {
                is LoadingStatus.Loading -> mainActivity.showLoading()
                is LoadingStatus.Error -> mainActivity.showError()
                LoadingStatus.Success -> mainActivity.dismissLoading()
            }
        })
    }


}
