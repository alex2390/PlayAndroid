package com.rjw.base

/**
 * Des
 *
 * Created by renjiawen on 2023/4/11 00:08.
 *
 */
open class BaseRepository {

    //block: suspend () -> BaseData<T>
    //指block是suspend方法，返回值类型是BaseData<T>
    suspend fun <T : Any> executeRequest(block: suspend () -> BaseData<T>?): BaseData<T>? {
        val baseData = block.invoke()
        if (baseData?.code == 0) {
            baseData?.state = ReqState.Success
        } else {
            baseData?.state = ReqState.Error
        }
        return baseData
    }



}