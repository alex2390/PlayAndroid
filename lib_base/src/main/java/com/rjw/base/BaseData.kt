package com.rjw.base

import com.google.gson.annotations.SerializedName

/**
 * Des
 *
 * Created by renjiawen on 2023/4/11 00:08.
 *
 */
data class BaseData<T>(
    @SerializedName("errorCode")
    var code: Int = -1,
    @SerializedName("errorMsg")
    var msg: String? = null,
    var data: T? = null,
    var state: ReqState = ReqState.Error
)
enum class ReqState {
    Success, Error
}