package com.rjw.playandroid.ui.home

import com.rjw.base.IUiIntent

/**
 * Des
 *
 * Created by renjiawen on 2023/4/14 00:08.
 *
 */
sealed class HomeIntent:IUiIntent {
    object GetBanner : HomeIntent()
}