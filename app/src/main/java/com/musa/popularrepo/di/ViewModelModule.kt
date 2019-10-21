package com.musa.popularrepo.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.musa.popularrepo.reposFragment.ReposViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory:ExampleViewModelFactory) :ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ReposViewModel::class)
    abstract fun bindViewModel(viewModel: ReposViewModel):ViewModel
}