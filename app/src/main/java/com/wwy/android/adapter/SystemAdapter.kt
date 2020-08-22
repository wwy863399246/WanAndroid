package com.wwy.android.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.wwy.android.R
import com.wwy.android.data.bean.ClassifyResponse
import com.wwy.android.ext.inflate
import kotlinx.android.synthetic.main.item_system.view.*
import kotlinx.android.synthetic.main.item_system_textview.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 *@创建者wwy
 *@创建时间 2020/6/28 15:37
 *@描述
 */
class SystemAdapter : BaseQuickAdapter<ClassifyResponse, BaseViewHolder>(R.layout.item_system) {
    private lateinit var mListener: ListenerBuilder
    override fun convert(holder: BaseViewHolder, item: ClassifyResponse) {
        holder.itemView.apply {
            flexBoxSystemItem.removeAllViews()
            tvSystemItemTitle.text = item.name
            item.children?.size?.let {
                for (index in 0 until it) {
                    flexBoxSystemItem?.let { flexBoxSystemItem ->
                        flexBoxSystemItem.inflate(R.layout.item_system_textview, false).apply {
                            tvSystemTypeText.text = item.children[index].name
                            tvSystemTypeText.tag = index
                            tvSystemTypeText.onClick {
                                if (::mListener.isInitialized) {
                                    mListener.typeTextClick?.invoke(
                                        tvSystemTypeText.tag as Int,
                                        holder.layoutPosition
                                    )
                                }
                            }
                            flexBoxSystemItem.addView(this)
                        }
                    }
                }
            }
        }
    }

    fun registerListener(listenerBuilder: ListenerBuilder.() -> Unit) {
        mListener = ListenerBuilder().also(listenerBuilder)
    }

    inner class ListenerBuilder {
        internal var typeTextClick: ((tag: Int, position: Int) -> Unit)? = null
        fun onTypeTextClick(action: (tag: Int, position: Int) -> Unit) {
            typeTextClick = action
        }
    }
}