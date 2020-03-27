package com.leshu.superbrain.adapter

import android.text.Html
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.leshu.superbrain.R
import com.leshu.superbrain.data.bean.Article

/**
 *@创建者wwy
 *@创建时间 2020/1/15 10:48
 *@描述
 */
class HomePageAdapter : BaseQuickAdapter<Article, BaseViewHolder>(R.layout.home_page_item) {
    override fun convert(helper: BaseViewHolder, item: Article?) {
        item?.let {
            helper.setText(R.id.item_home_author,if (it.author.isNotEmpty()) it.author else it.shareUser)
            helper.setText(R.id.item_home_content,Html.fromHtml(it.title))
            helper.setText(R.id.item_home_type2, Html.fromHtml("${it.superChapterName}·${it.chapterName}"))
            helper.setText(R.id.item_home_date, it.niceDate)
        }
    }
}