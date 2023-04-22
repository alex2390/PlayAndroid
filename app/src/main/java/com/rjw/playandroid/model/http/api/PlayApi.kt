package com.rjw.playandroid.model.http.api

import com.rjw.base.BaseData
import com.rjw.playandroid.model.bean.Banner
import retrofit2.http.GET

/**
 * Des api
 *
 * Created by renjiawen on 2023/4/11 23:12.
 *
 */
interface PlayApi {

    @GET("banner/json")
    suspend fun getBanner():BaseData<List<Banner>>



}