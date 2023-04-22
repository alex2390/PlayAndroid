package com.rjw.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Des Activity基类
 *
 * Created by jiawen on 2022/7/8 00:59.
 *
 */
abstract class BaseActivity<T:ViewBinding>: AppCompatActivity() {


    private lateinit var mBinding: T
    protected val binding get() = mBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = getViewBinding()
        setContentView(mBinding.root)
        initViews()
        initEvents()
    }

    protected abstract fun getViewBinding(): T
    open fun initViews() {}
    open fun initEvents() {}



}