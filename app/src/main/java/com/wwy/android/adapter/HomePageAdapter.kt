package com.wwy.android.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.wwy.android.R
import com.wwy.android.data.bean.Article
import com.wwy.android.ext.htmlToSpanned
import com.wwy.android.ext.text
import kotlinx.android.synthetic.main.item_home_page.view.*

/**
 *@创建者wwy
 *@创建时间 2020/1/15 10:48
 *@描述
 */
class HomePageAdapter : BaseQuickAdapter<Article, BaseViewHolder>(R.layout.item_home_page),
    LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: Article) {
        holder.apply {
            itemView.apply {
                tvHomePageItemAuthor.text = when {
                    !item.author.isNullOrEmpty() -> {
                        item.author
                    }
                    !item.shareUser.isNullOrEmpty() -> {
                        item.shareUser
                    }
                    else -> text(R.string.anonymous)
                }
                tvHomePageItemContent.text = item.title.htmlToSpanned()
                tvHomePageItemType.text = when {
                    !item.superChapterName.isNullOrEmpty() && !item.chapterName.isNullOrEmpty() ->
                        "${item.superChapterName.htmlToSpanned()}·${item.chapterName.htmlToSpanned()}"
                    item.superChapterName.isNullOrEmpty() && !item.chapterName.isNullOrEmpty() ->
                        item.chapterName.htmlToSpanned()
                    !item.superChapterName.isNullOrEmpty() && item.chapterName.isNullOrEmpty() ->
                        item.superChapterName.htmlToSpanned()
                    else -> ""
                }
                tvHomePageItemDate.text= item.niceDate
            }
        }
    }
}