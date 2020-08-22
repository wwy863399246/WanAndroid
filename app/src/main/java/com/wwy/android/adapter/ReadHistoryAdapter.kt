package com.wwy.android.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.wwy.android.R
import com.wwy.android.data.bean.Article
import com.wwy.android.ext.htmlToSpanned
import com.wwy.android.ext.text
import kotlinx.android.synthetic.main.item_read_history.view.*

/**
 *@创建者wwy
 *@创建时间 2020/1/15 10:48
 *@描述
 */
class ReadHistoryAdapter : BaseQuickAdapter<Article, BaseViewHolder>(R.layout.item_read_history),
    LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: Article) {
        holder.apply {
            itemView.apply {
                tvReadHistoryItemAuthor.text = when {
                    !item.author.isNullOrEmpty() -> {
                        item.author
                    }
                    !item.shareUser.isNullOrEmpty() -> {
                        item.shareUser
                    }
                    else -> text(R.string.anonymous)
                }
                tvReadHistoryItemContent.text = item.title.htmlToSpanned()
                tvReadHistoryItemDate.text = item.niceDate
            }
        }
    }
}