package com.rjw.playandroid.ui.home

import com.rjw.base.IUiState
import com.rjw.playandroid.model.bean.Banner

/**
 * Des
 *
 * Created by renjiawen on 2023/4/14 00:08.
 *
 */
data class HomeState(val bannerUiState: BannerUiState):IUiState {

    sealed class BannerUiState{
        object INIT:BannerUiState()
        data class SUCCESS(val models: List<Banner>):BannerUiState()
    }
}