package com.rjw.playandroid.ui.home

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.rjw.base.BaseViewModel
import com.rjw.base.IUiIntent
import com.rjw.playandroid.model.bean.Article
import com.rjw.playandroid.model.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

/**
 * Des 主页viewmodel
 *
 *
 * Created by renjiawen on 2023/4/14 00:07.
 */
class HomeViewModel(private val homeRepository: HomeRepository) : BaseViewModel<HomeState, HomeIntent>() {
    override fun initUiState(): HomeState {
        return HomeState(HomeState.BannerUiState.INIT)
    }
    override fun handleIntent(intent: IUiIntent) {
        when (intent) {
            HomeIntent.GetBanner -> {
                requestDataWithFlow(true,
                    request = { homeRepository.requestBannerData() },
                    success = {
                        sendUiState {
                            copy(
                                bannerUiState = HomeState.BannerUiState.SUCCESS(
                                    it
                                )
                            )
                        }
                    },
                    failure = {}
                )
            }
        }
    }

     fun getPagingData(): Flow<PagingData<Article>> {
        return homeRepository.getArticles().cachedIn(viewModelScope)
    }



}