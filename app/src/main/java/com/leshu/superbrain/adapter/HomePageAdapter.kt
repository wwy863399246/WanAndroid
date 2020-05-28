package com.leshu.superbrain.adapter

import android.text.Html
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.leshu.superbrain.R
import com.leshu.superbrain.data.bean.Article

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
                if (it.author.isNotEmpty()) it.author else it.shareUser
            )
            holder.setText(R.id.tvHomePageItemContent, Html.fromHtml(it.title))
            holder.setText(
                R.id.tvHomePageItemType,
                Html.fromHtml("${it.superChapterName}·${it.chapterName}")
            )
            holder.setText(R.id.tvHomePageItemDate, it.niceDate)
        }
    }
}