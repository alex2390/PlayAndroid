package com.rjw.playandroid.di

import com.rjw.playandroid.model.repository.HomeRepository
import com.rjw.playandroid.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Des koin 容器
 *
 * Created by renjiawen on 2023/4/18 22:46.
 *
 */
object KoinModule {

    private val viewModelModule = module {
        viewModel { HomeViewModel(get()) }
    }

    private val repositoryModule = module {
        single { HomeRepository() }
    }
    val appModule= listOf(viewModelModule, repositoryModule)

}

