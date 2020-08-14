package com.wwy.android.adapter

import android.text.Html
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.wwy.android.R
import com.wwy.android.data.bean.Article
import com.wwy.android.ext.htmlToSpanned

/**
 *@创建者wwy
 *@创建时间 2020/1/15 10:48
 *@描述
 */
class HomePageAdapter : BaseQuickAdapter<Article, BaseViewHolder>(R.layout.item_home_page),
    LoadMoreModule {

    override fun convert(holder: BaseViewHolder, item: Article) {
        item.let {
            holder.setText(
                R.id.tvHomePageItemAuthor,
                if (it.author!!.isNotEmpty()) it.author else it.shareUser
            )
            holder.setText(R.id.tvHomePageItemContent, it.title.htmlToSpanned())
            holder.setText(
                R.id.tvHomePageItemType,
                "${it.superChapterName}·${it.chapterName}".htmlToSpanned()
            )
            holder.setText(R.id.tvHomePageItemDate, it.niceDate)
        }
    }
}