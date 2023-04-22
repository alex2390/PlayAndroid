package com.rjw.playandroid.ui.adapter

import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rjw.playandroid.model.bean.Banner
import com.youth.banner.adapter.BannerAdapter


/**
 * Des
 *
 * Created by renjiawen on 2023/4/15 00:11.
 *
 */
class HomeBannerAdapter(mDatas:List<Banner>): BannerAdapter<Banner, HomeBannerAdapter.BannerViewHolder>(mDatas) {

    class BannerViewHolder(@NonNull view: ImageView) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView

        init {
            imageView = view
        }
    }

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): BannerViewHolder {

        val imageView = ImageView(parent?.context)
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return BannerViewHolder(imageView)
    }

    override fun onBindView(holder: BannerViewHolder?, data: Banner?, position: Int, size: Int) {
        Log.d(TAG,"imagePath:${data?.imagePath}")
        holder?.imageView?.load(data?.imagePath)
    }

    companion object{
        private const val TAG = "HomeBannerAdapter"
    }
}