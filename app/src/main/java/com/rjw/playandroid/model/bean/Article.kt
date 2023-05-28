package com.rjw.playandroid.model.bean

/**
 * Des 文章
 *
 * Created by renjiawen on 2023/4/23 22:21.
 *
 */
data class Article(
    val niceDate: String? = null,
    val title: String? = null,
    val link: String? = null,
    val superChapterName: String? = null,
    val id: Int = 0,
    //新增区分是否是置顶文章字段
    var isTop: Boolean = false

)