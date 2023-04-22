package com.rjw.playandroid.ui.home

import com.rjw.base.BaseViewModel
import com.rjw.base.IUiIntent
import com.rjw.playandroid.model.repository.HomeRepository

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
}