package com.musa.popularrepo.reposFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.musa.popularrepo.R
import com.musa.popularrepo.application.ApplicationComponent
import com.musa.popularrepo.application.MyApplication
import com.musa.popularrepo.databinding.ReposFragmentBinding
import timber.log.Timber
import javax.inject.Inject

class Repos : Fragment() {

    private lateinit var viewModel: ReposViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ReposFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<ReposFragmentBinding>(inflater,R.layout.repos_fragment,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (context!!.applicationContext as MyApplication).applicationComponent.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ReposViewModel::class.java)
        val adapter = ReposAdapter()
        binding.reposRecyclerView.adapter = adapter
        viewModel.repos.observe(this, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
    }

}
