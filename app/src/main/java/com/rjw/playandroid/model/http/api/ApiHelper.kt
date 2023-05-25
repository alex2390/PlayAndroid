package com.rjw.playandroid.model.http.api

import com.rjw.playandroid.model.bean.Article
import kotlinx.coroutines.flow.Flow

/**
 * Des
 *
 * Created by renjiawen on 2023/5/23 00:11.
 *
 */
interface ApiHelper {
    fun getArticles(): Flow<List<Article>?>

    fun getTopArticles(): Flow<List<Article>?>

}