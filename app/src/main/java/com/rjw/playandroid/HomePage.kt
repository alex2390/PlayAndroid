package com.rjw.playandroid

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationView
import com.rjw.base.BaseActivity
import com.rjw.base.LoadUiIntent
import com.rjw.libwidget.behavior.BottomNavigationBehavior
import com.rjw.playandroid.databinding.ActivityHomeBinding
import com.rjw.playandroid.ui.adapter.HomeBannerAdapter
import com.rjw.playandroid.ui.home.HomeIntent
import com.rjw.playandroid.ui.home.HomeState
import com.rjw.playandroid.ui.home.HomeViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomePage : BaseActivity<ActivityHomeBinding>() {



    companion object {
        private const val TAG = "MainActivity"
    }

    override fun getViewBinding()=ActivityHomeBinding.inflate(layoutInflater)
    @OptIn(InternalCoroutinesApi::class)
    override fun initEvents() {
        super.initEvents()
        initToolBar()
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_container) as NavHostFragment
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
//                R.id.tab_home->{
//                    navHostFragment.navController.navigate(R.id.homeFragment)
//                }
//                R.id.tab_2->{
//                    navHostFragment.navController.navigate(R.id.mineFragment)
//                }
//                else->{
//                    navHostFragment.navController.navigate(R.id.homeFragment)
//
//                }

            }



            Log.d(TAG,it.title.toString())
            true
        }




    }

    private fun initToolBar() {
        binding.toolbarLayout.toolbar.run {
            title = getString(R.string.app_name)
            setSupportActionBar(this)
        }
    }


}

