package com.wwy.wanandroid.ui.homepage

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.wwy.wanandroid.R
import com.wwy.wanandroid.bean.Article
import kotlinx.android.synthetic.main.first_page_item.view.*

/**
 *@创建者wwy
 *@创建时间 2019/10/30 11:50
 *@描述
 */
class FirstPageAdapter : PagedListAdapter<Article, FirstPageAdapter.ViewHolder>(FirstPageDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.first_page_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position) ?: return
        holder.itemView.item_home_author.text = if (data.author.isNotEmpty()) data.author else data.shareUser
        holder.itemView.item_home_content.text = Html.fromHtml(data.title)
        holder.itemView.item_home_type2.text = Html.fromHtml("${data.superChapterName}·${data.chapterName}")
        holder.itemView.item_home_date.text = data.niceDate
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

private class FirstPageDiffCallback : DiffUtil.ItemCallback<Article>() {
    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}