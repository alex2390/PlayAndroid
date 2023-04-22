package com.rjw.playandroid.model.bean

import android.icu.text.CaseMap.Title

/**
 * Des  banner数据类
 *
 * Created by renjiawen on 2023/4/11 23:14.
 *
 */
data class Banner(
    var desc: String,
    var imagePath: String,
    var title: String,
    var url: String
)
