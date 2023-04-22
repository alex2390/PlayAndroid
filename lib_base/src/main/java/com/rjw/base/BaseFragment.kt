package com.rjw.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

/**
 * Des fragment基类
 *
 * Created by renjiawen on 2023/4/10 23:57.
 *
 */
abstract class BaseFragment :Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view,savedInstanceState)
        initData(savedInstanceState)
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun initData(savedInstanceState: Bundle?)
    abstract fun initView(view: View, savedInstanceState: Bundle?)


}