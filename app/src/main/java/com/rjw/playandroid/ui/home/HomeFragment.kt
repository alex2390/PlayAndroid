package com.rjw.playandroid.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.rjw.base.BaseBindingFragment
import com.rjw.base.LoadUiIntent
import com.rjw.libcommon.util.LogUtil
import com.rjw.playandroid.databinding.ActivityHomeBinding
import com.rjw.playandroid.databinding.FragmentHomeBinding
import com.rjw.playandroid.ui.adapter.BannerAdapter
import com.rjw.playandroid.ui.adapter.HomeArticleAdapter
import com.rjw.playandroid.ui.adapter.HomeBannerAdapter
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Des   首页
 *
 * Created by renjiawen on 2023/4/19 21:13.
 *
 */
class HomeFragment : BaseBindingFragment<FragmentHomeBinding>({ FragmentHomeBinding.inflate(it) }) {
    companion object {
        private const val TAG = "HomeFragment"
    }

    private val homeViewModel by viewModel<HomeViewModel>()

    //首页文章
    private val homeArticleAdapter = HomeArticleAdapter()

    //首页Banner
    private var homeBannerAdapter = BannerAdapter()
    private lateinit var homeAdapter: ConcatAdapter

    override fun initData(savedInstanceState: Bundle?) {
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        homeAdapter = ConcatAdapter(homeBannerAdapter, homeArticleAdapter)
        homeViewModel.sendUiIntent(HomeIntent.GetBanner)
        lifecycleScope.launch {
            homeViewModel.loadUiIntentFlow
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    when (it) {
                        is LoadUiIntent.Error -> toast(it.msg)
                        is LoadUiIntent.Loading -> toast("show loading")
                        else -> {}
                    }
                }
        }
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.uiStateFlow.map { it.bannerUiState }.distinctUntilChanged().collect {
                    when (it) {
                        is HomeState.BannerUiState.INIT -> {}
                        is HomeState.BannerUiState.SUCCESS -> {
                            homeBannerAdapter.setData(it.models)
                        }
                    }
                }
            }
        }
        initBanner()
        initArticle()
    }
    private fun initBanner() {
    }

    private fun initArticle() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            homeArticleAdapter.refresh()
        }
        homeArticleAdapter.addLoadStateListener {
            binding.swipeRefreshLayout.isRefreshing = it.refresh is LoadState.Loading
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter
        }
        lifecycleScope.launchWhenStarted {
            homeViewModel.getPagingData().collect {
                homeArticleAdapter.submitData(it)
                LogUtil.d(TAG, "collect article")
            }
        }
    }

    private fun toast(str: String?) {
        Toast.makeText(requireContext(), str, Toast.LENGTH_SHORT).show()
    }
}