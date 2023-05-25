package com.rjw.playandroid.model.paging

import android.annotation.SuppressLint
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rjw.base.BaseData
import com.rjw.playandroid.model.bean.Article
import com.rjw.playandroid.model.bean.ArticleData
import com.rjw.playandroid.model.http.api.ApiHelper
import com.rjw.playandroid.model.http.api.ApiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch

/**
 * Des 首页文章分页
 *
 * Created by renjiawen on 2023/4/23 22:13.
 *
 */
class HomeArticlePagingSource(private val service: ApiService) : PagingSource<Int, Article>() {
    companion object{

        private const val TAG = "HomeArticlePagingSource"
        //页码从0开始
        private const val PAGE_NUMBER_START =0
    }
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return PAGE_NUMBER_START
    }

    @SuppressLint("SuspiciousIndentation")
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {


        return try {
            val page = params.key ?: 1
            val nextPageNumber = params.key ?: 0
            var data:List<Article>?
            if (nextPageNumber == 0) {
                //组合置顶文章数据和第一页文章数据
                 data = service.topArticles().data?.toMutableList()
                val articles = service.getArticles(nextPageNumber).data?.datas?: emptyList()
                data?.addAll(articles)
            } else {
                data = service.getArticles(nextPageNumber).data?.datas?: emptyList()
            }
            Log.d(TAG,"data size:${data?.size}")

            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (data?.isNotEmpty()==true) page + 1 else null
            LoadResult.Page(
                data = data?.toList()?: emptyList(),
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}