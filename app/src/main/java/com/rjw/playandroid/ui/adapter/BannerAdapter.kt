package com.rjw.playandroid.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rjw.playandroid.R
import com.rjw.playandroid.databinding.ItemBannerBinding
import com.rjw.playandroid.model.bean.Banner
import org.koin.core.KoinApplication.Companion.init

/**
 * Des  banner外层adapter
 *
 * Created by renjiawen on 2023/4/27 00:02.
 *
 */
class BannerAdapter : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    private var dataList: List<Banner> = emptyList()

   fun setData(list: List<Banner>){
       dataList =list
       notifyItemChanged(0)
   }


    inner class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ItemBannerBinding? = DataBindingUtil.bind(itemView)

    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.binding?.homeBanner?.setAdapter( HomeBannerAdapter(dataList))


    }

    override fun getItemCount(): Int = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false).let {
            return BannerViewHolder(it)
        }


    }

}