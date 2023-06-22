package com.rjw.playandroid.di

import com.rjw.playandroid.model.repository.HomeRepository
import com.rjw.playandroid.model.repository.SquareRepository
import com.rjw.playandroid.ui.home.HomeViewModel
import com.rjw.playandroid.ui.square.SquareViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Des koin 容器
 *
 * Created by renjiawen on 2023/4/18 22:46.
 *
 */
object KoinModule {
    private val homeViewModelModule = module {
        viewModel { HomeViewModel(get()) }
        single { HomeRepository() }
    }
    private val squareViewModelModule = module {
        viewModel { SquareViewModel(get()) }
        single { SquareRepository() }
    }

    val appModule = listOf(
        homeViewModelModule,
        squareViewModelModule
    )

}

