package com.rjw.playandroid.model.http.api

import androidx.paging.PagingData
import com.rjw.base.BaseData
import com.rjw.playandroid.model.bean.Article
import com.rjw.playandroid.model.bean.ArticleData
import com.rjw.playandroid.model.bean.Banner
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Des service
 *
 * Created by renjiawen on 2023/4/11 23:12.
 *
 */
interface ApiService {

    /**
     * 首页banner
     * https://www.wanandroid.com/banner/json
     */
    @GET("banner/json")
    suspend fun getBanner():BaseData<List<Banner>>

    /**
     * 首页文章列表
     * https://www.wanandroid.com/article/list/0/json
     * @param pageNum :页码
     */
    @GET("article/list/{pageNum}/json")
    suspend fun getArticles(@Path("pageNum") pageNum: Int): BaseData<ArticleData>



}