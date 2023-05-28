package com.rjw.playandroid.model.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rjw.base.BaseData
import com.rjw.base.BaseRepository
import com.rjw.playandroid.model.bean.Article
import com.rjw.playandroid.model.bean.Banner
import com.rjw.playandroid.model.http.RetrofitClient.service
import com.rjw.playandroid.model.http.api.ApiHelperImpl
import com.rjw.playandroid.model.paging.HomeArticlePagingSource
import kotlinx.coroutines.flow.Flow

/**
 * Des
 *
 * Created by renjiawen on 2023/4/13 23:22.
 *
 */
class HomeRepository: BaseRepository() {
    suspend fun requestBannerData(): BaseData<List<Banner>> {
        return executeRequest { service?.getBanner() }!!
    }
     fun getArticles(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize =10),
            pagingSourceFactory = {HomeArticlePagingSource(service!!)}
        ).flow
    }





}