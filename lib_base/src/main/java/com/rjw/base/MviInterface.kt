package com.rjw.base

import androidx.annotation.Keep

/**
 * Des
 *
 * Created by renjiawen on 2023/4/11 00:32.
 *
 */
@Keep
interface IUiIntent //event
@Keep
interface IUiState

class MviInterface {
}

sealed class LoadUiIntent{
    data class Loading(var isShow: Boolean) : LoadUiIntent()
    object ShowMainView : LoadUiIntent()
    data class Error(val msg: String) : LoadUiIntent()

}

