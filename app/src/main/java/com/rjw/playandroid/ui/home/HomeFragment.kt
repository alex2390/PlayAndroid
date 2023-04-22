package com.rjw.playandroid.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.rjw.base.BaseBindingFragment
import com.rjw.base.LoadUiIntent
import com.rjw.playandroid.databinding.ActivityHomeBinding
import com.rjw.playandroid.databinding.FragmentHomeBinding
import com.rjw.playandroid.ui.adapter.HomeBannerAdapter
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Des
 *
 * Created by renjiawen on 2023/4/19 21:13.
 *
 */
class HomeFragment : BaseBindingFragment<FragmentHomeBinding>({ FragmentHomeBinding.inflate(it) }) {
    companion object {
        private const val TAG = "HomeFragment"
    }


    private lateinit var bannerAdapter: HomeBannerAdapter
    private val homeViewModel by viewModel<HomeViewModel>()
    override fun initData(savedInstanceState: Bundle?) {
    }
    override fun initView(view: View, savedInstanceState: Bundle?) {
        homeViewModel.sendUiIntent(HomeIntent.GetBanner)
        lifecycleScope.launch {


            homeViewModel.loadUiIntentFlow
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                when (it) {
                    is LoadUiIntent.Error -> toast(it.msg)
                    is LoadUiIntent.ShowMainView -> toast("show main")
                    is LoadUiIntent.Loading -> toast("show loading")
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            homeViewModel.uiStateFlow.map { it.bannerUiState }.distinctUntilChanged().collect {
                when (it) {
                    is HomeState.BannerUiState.INIT -> {}
                    is HomeState.BannerUiState.SUCCESS -> {
                        bannerAdapter = HomeBannerAdapter(it.models)
                        binding?.homeBanner?.setAdapter(bannerAdapter)
                    }
                }

            }
        }
    }
    private fun toast(str: String?) {
        Toast.makeText(requireContext(), str, Toast.LENGTH_SHORT).show()
    }
}