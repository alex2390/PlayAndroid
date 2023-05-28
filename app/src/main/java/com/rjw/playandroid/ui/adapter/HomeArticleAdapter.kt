package com.rjw.playandroid.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rjw.playandroid.R
import com.rjw.playandroid.databinding.ItemHomeListBinding
import com.rjw.playandroid.model.bean.Article

/**
 * Des  文章列表adapter
 *
 * Created by renjiawen on 2023/4/24 22:50.
 *
 */
class HomeArticleAdapter:PagingDataAdapter<Article,HomeArticleAdapter.ViewHolder>(COMPARATOR) {

    companion object{
        private val COMPARATOR =object : DiffUtil.ItemCallback<Article>(){
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return  oldItem.id ==newItem.id
            }
            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding: ItemHomeListBinding? = DataBindingUtil.bind(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = getItem(position)
        holder.binding?.tvArticleTitle?.text=itemData?.title
        holder.binding?.tvArticleTop?.visibility = if (itemData?.isTop==true) View.VISIBLE else View.GONE


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_home_list,parent,false).let {
            return ViewHolder(it)
        }

    }

}