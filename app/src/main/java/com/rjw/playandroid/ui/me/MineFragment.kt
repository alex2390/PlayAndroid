package com.rjw.playandroid.ui.me

import android.os.Bundle
import android.view.View
import com.rjw.base.BaseBindingFragment
import com.rjw.playandroid.databinding.FragmentHomeBinding
import com.rjw.playandroid.databinding.FragmentMeBinding

/**
 * Des
 *
 * Created by renjiawen on 2023/4/19 21:13.
 *
 */
class MineFragment : BaseBindingFragment<FragmentMeBinding>({ FragmentMeBinding.inflate(it) }) {
    companion object {
        private const val TAG = "HomeFragment"
    }



    override fun initData(savedInstanceState: Bundle?) {
    }
    override fun initView(view: View, savedInstanceState: Bundle?) {

    }

}