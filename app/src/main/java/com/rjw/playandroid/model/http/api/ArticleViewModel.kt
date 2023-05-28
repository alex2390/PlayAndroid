package com.rjw.playandroid.model.http.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rjw.playandroid.model.bean.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch

/**
 * Des
 *
 * Created by renjiawen on 2023/5/25 23:55.
 *
 */
class ArticleViewModel(private val apiHelperImpl: ApiHelperImpl):ViewModel() {

    init {
        getArticlesAndTop()
    }

    private fun getArticlesAndTop() {

        viewModelScope.launch(Dispatchers.IO){
            apiHelperImpl.getArticles().zip(apiHelperImpl.getTopArticles()){  articles, toparticles ->
                val  data = mutableListOf<Article>()
                data.addAll(articles?: emptyList())
                data.addAll(toparticles?: emptyList())

            }
        }
    }
}