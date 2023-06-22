package com.rjw.playandroid

import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import androidx.navigation.fragment.NavHostFragment
import com.rjw.base.BaseActivity
import com.rjw.libcommon.util.LogUtil
import com.rjw.playandroid.databinding.ActivityHomeBinding
import kotlinx.coroutines.*

class HomePage : BaseActivity<ActivityHomeBinding>() {

    companion object {
        private const val TAG = "HomePage"

    }

    override fun getViewBinding()=ActivityHomeBinding.inflate(layoutInflater)
    @OptIn(InternalCoroutinesApi::class)
    override fun initEvents() {

        super.initEvents()
        initToolBar()
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_container) as NavHostFragment
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.tab_home->{
                    navHostFragment.navController.navigate(R.id.homeFragment)
                    LogUtil.d(TAG,"tab_home")
                }
                R.id.tab_square
                ->{
                    navHostFragment.navController.navigate(R.id.squareFragment)
                }
                else->{
                    navHostFragment.navController.navigate(R.id.homeFragment)
                }

            }
            true
        }




    }

    private fun initToolBar() {
        binding.toolbarLayout.toolbar.run {
            updateLayoutParams<ViewGroup.LayoutParams> {
                height =0
            }
            title = getString(R.string.app_name)
            setSupportActionBar(this)
        }
    }


}

