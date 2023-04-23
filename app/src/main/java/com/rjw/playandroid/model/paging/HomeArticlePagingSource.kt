package com.rjw.playandroid.model.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rjw.playandroid.model.bean.Article
import com.rjw.playandroid.model.http.api.ApiService

/**
 * Des 首页文章分页
 *
 * Created by renjiawen on 2023/4/23 22:13.
 *
 */
class HomeArticlePagingSource(private val service: ApiService):  PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return null
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page = params.key ?: 1
            val nextPageNumber = params.key ?: 0
            val response = service.getArticles(nextPageNumber)

            val data = response.data?: emptyList()
            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (data.isNotEmpty()) page + 1 else null

                LoadResult.Page(
                    data =data,
                    prevKey = prevKey,
                    nextKey = nextKey
                )
        }catch (e:Exception){
            LoadResult.Error(e)
        }

    }
}