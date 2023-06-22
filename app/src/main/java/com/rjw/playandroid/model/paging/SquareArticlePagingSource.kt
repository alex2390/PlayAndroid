package com.rjw.playandroid.model.paging

import android.annotation.SuppressLint
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rjw.playandroid.model.bean.Article
import com.rjw.playandroid.model.http.api.ApiService

/**
 * Des 广场文章分页
 *
 * Created by renjiawen on 2023/4/23 22:13.
 *
 */
class SquareArticlePagingSource(private val service: ApiService) : PagingSource<Int, Article>() {
    companion object {
        private const val TAG = "SquareArticlePagingSource"
        //页码从0开始
        private const val PAGE_NUMBER_START = 0
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return PAGE_NUMBER_START
    }

    @SuppressLint("SuspiciousIndentation")
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page = params.key ?: 1
            val nextPageNumber = params.key ?: 0
            var data: List<Article>?

            data = service.getUserArticles(nextPageNumber).data?.datas ?: emptyList()

            Log.d(TAG, "data size:${data?.size}")

            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (data?.isNotEmpty() == true) page + 1 else null
            LoadResult.Page(
                data = data?.toList() ?: emptyList(),
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}