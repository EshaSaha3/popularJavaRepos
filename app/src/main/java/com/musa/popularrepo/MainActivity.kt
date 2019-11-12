package com.musa.popularrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.musa.popularrepo.base.LoadingCallback
import com.musa.popularrepo.databinding.ActivityMainBinding
import com.musa.popularrepo.extensions.*
import kotlinx.android.synthetic.main.loading_indicator.view.*


class MainActivity : AppCompatActivity(), LoadingCallback {
    override fun showLoading(message: String) {
        binding.loadingLayoutContainer.progressMessage.text = message
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun showLoading() {
        disableTouch()
        hideKeyboard()
        showLoading(R.string.default_loading_message)
    }

    override fun showLoading(resId: Int) {
        binding.loadingLayoutContainer.loadingLayout.showWithChildren()
        binding.loadingLayoutContainer.progressMessage.text = getString(resId)

    }

    override fun dismissLoading() {
        binding.loadingLayoutContainer.loadingLayout.dissmissWithChildren()
        enableTouch()
    }

    override fun showError() {
        binding.loadingLayoutContainer.progressBar.setBackgroundResource(R.drawable.ic_connection_error)
        dismissLoading()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        navController = findNavController(R.id.fragment)
        binding.bottomNavigationView.setupWithNavController(navController)
        appBarConfiguration = AppBarConfiguration(navController.graph)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}
