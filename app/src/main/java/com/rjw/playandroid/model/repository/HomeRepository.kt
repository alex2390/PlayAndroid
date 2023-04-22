package com.rjw.playandroid.model.repository

import com.rjw.base.BaseData
import com.rjw.base.BaseRepository
import com.rjw.playandroid.model.bean.Banner
import com.rjw.playandroid.model.http.RetrofitClient
import com.rjw.playandroid.model.http.api.PlayApi

/**
 * Des
 *
 * Created by renjiawen on 2023/4/13 23:22.
 *
 */
class HomeRepository: BaseRepository() {
    private val service = RetrofitClient.getService(PlayApi::class.java)
    suspend fun requestBannerData(): BaseData<List<Banner>> {
        return executeRequest { service?.getBanner() }!!
    }
}