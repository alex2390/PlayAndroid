package com.rjw.playandroid.model.http.api

import com.rjw.playandroid.model.bean.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Des
 *
 * Created by renjiawen on 2023/5/23 00:11.
 *
 */
class ApiHelperImpl(private val apiService: ApiService):ApiHelper {
    override fun getArticles()= flow { emit(apiService.getArticles(0)?.data?.datas) }

    override fun getTopArticles()= flow { emit(apiService.topArticles().data) }
}