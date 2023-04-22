package com.rjw.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*

/**
 * Des  viewModel基类
 *
 * Created by renJiaWen on 2022/4/28 00:59.
 *
 */
abstract class BaseViewModel<UiState : IUiState, UiIntent : IUiIntent> : ViewModel() {
    private val _uiStateFlow = MutableStateFlow(initUiState())
    val uiStateFlow: StateFlow<UiState> = _uiStateFlow

    protected abstract fun initUiState(): UiState

    protected fun sendUiState(copy: UiState.() -> UiState) {
        viewModelScope.launch {
            _uiStateFlow.emit(copy(_uiStateFlow.value))
        }
    }

    private val _uiIntentFlow: Channel<UiIntent> = Channel()
    val uiIntentFlow: Flow<UiIntent> = _uiIntentFlow.receiveAsFlow()

    private val _loadUiIntentFlow: Channel<LoadUiIntent> = Channel()
    val loadUiIntentFlow: Flow<LoadUiIntent> = _loadUiIntentFlow.receiveAsFlow()

    fun sendUiIntent(uiIntent: UiIntent) {
        viewModelScope.launch {
            _uiIntentFlow.send(uiIntent)
        }
    }

    init {
        viewModelScope.launch {
            uiIntentFlow.collect {
                handleIntent(it)
            }

        }
    }


    protected abstract fun handleIntent(intent: IUiIntent)

    /**
     * 发送当前加载状态：Loading、Error、Normal
     */
    private fun sendLoadUiIntent(loadUiIntent: LoadUiIntent) {
        viewModelScope.launch {
            _loadUiIntentFlow.send(loadUiIntent)
        }
    }

    protected fun <T : Any> requestDataWithFlow(
        showLoading: Boolean = true,
        request: suspend () -> BaseData<T>,
        success: (T) -> Unit,
        failure: suspend (String) -> Unit = { errorMsg ->
            sendLoadUiIntent(LoadUiIntent.Error(errorMsg))

        }
    ) {
        viewModelScope.launch {

            if (showLoading) {
                sendLoadUiIntent(LoadUiIntent.Loading(true))
            }
            val baseData: BaseData<T>
            try {
                baseData = request()
                when (baseData.state) {
                    ReqState.Success -> {
                        sendLoadUiIntent(LoadUiIntent.ShowMainView)
                        baseData.data?.let { success(it) }

                    }
                    ReqState.Error -> {
                        baseData.msg?.let {
                            Error(it)
                        }

                    }

                }
            } catch (e: Exception) {

                e.message?.let {
                    failure(it)
                }
            } finally {
                sendLoadUiIntent(LoadUiIntent.Loading(false))

            } }

    }



}