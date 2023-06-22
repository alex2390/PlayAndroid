package com.rjw.playandroid.model.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rjw.base.BaseRepository
import com.rjw.playandroid.model.bean.Article
import com.rjw.playandroid.model.http.RetrofitClient.service
import com.rjw.playandroid.model.paging.SquareArticlePagingSource
import kotlinx.coroutines.flow.Flow

/**
 * Des 广场
 *
 * Created by renjiawen on 2023/4/13 23:22.
 *
 */
class SquareRepository: BaseRepository() {

     fun getArticles(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize =10),
            pagingSourceFactory = {SquareArticlePagingSource(service!!)}
        ).flow
    }





}