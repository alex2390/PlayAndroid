package com.rjw.playandroid.ui.square

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.rjw.base.BaseBindingFragment
import com.rjw.libcommon.util.LogUtil
import com.rjw.playandroid.databinding.FragmentHomeBinding
import com.rjw.playandroid.ui.adapter.HomeArticleAdapter
import com.rjw.playandroid.ui.home.HomeFragment
import com.rjw.playandroid.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Des  广场
 *
 * Created by renjiawen on 2023/5/28 23:40.
 *
 */
class SquareFragment: BaseBindingFragment<FragmentHomeBinding>({ FragmentHomeBinding.inflate(it) }) {
    companion object{
        private const val TAG = "SquareFragment"
    }
    //文章列表
    private val squareArticleAdapter = HomeArticleAdapter()

    //viewModel

    private val squareViewModel by viewModel<SquareViewModel>()
    override fun initData(savedInstanceState: Bundle?) {


    }
    override fun initView(view: View, savedInstanceState: Bundle?) {
        initArticle()


    }

    private fun initArticle() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            squareArticleAdapter.refresh()
        }
        squareArticleAdapter.addLoadStateListener {
            binding.swipeRefreshLayout.isRefreshing = it.refresh is LoadState.Loading
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = squareArticleAdapter
        }
        lifecycleScope.launchWhenStarted {
            squareViewModel.getPagingData().collect {
                squareArticleAdapter.submitData(it)
                LogUtil.d(TAG, "collect article")
            }
        }
    }
}