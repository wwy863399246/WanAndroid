package com.leshu.superbrain.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.leshu.superbrain.R
import com.leshu.superbrain.data.bean.ClassifyResponse
import com.leshu.superbrain.ext.inflate
import kotlinx.android.synthetic.main.item_system.view.*

/**
 *@创建者wwy
 *@创建时间 2020/6/28 15:37
 *@描述
 */
class SystemAdapter : BaseQuickAdapter<ClassifyResponse, BaseViewHolder>(R.layout.item_system) {
    override fun convert(holder: BaseViewHolder, item: ClassifyResponse) {
        holder.itemView.apply {
            tvSystemItemTitle.text = item.name
            item.children?.size?.let {
                for (index in 0 until it) {
                    flexBoxSystemItem?.let { flexBoxSystemItem ->
                        flexBoxSystemItem.inflate(R.layout.item_system_textview, false).apply {
                            findViewById<TextView>(R.id.tvSystemTypeText).text =
                                item.children[index].name
                            flexBoxSystemItem.addView(this)
                        }
                    }
                }
            }
        }
    }
}