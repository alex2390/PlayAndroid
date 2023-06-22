package com.rjw.playandroid.ui.square

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.rjw.base.BaseViewModel
import com.rjw.playandroid.model.bean.Article
import com.rjw.playandroid.model.repository.HomeRepository
import com.rjw.playandroid.model.repository.SquareRepository
import kotlinx.coroutines.flow.Flow

/**
 * Des
 *
 * Created by renjiawen on 2023/6/4 23:41.
 *
 */
class SquareViewModel(private val squareRepository: SquareRepository):ViewModel() {


    fun getPagingData(): Flow<PagingData<Article>> {
        return squareRepository.getArticles().cachedIn(viewModelScope)
    }

}