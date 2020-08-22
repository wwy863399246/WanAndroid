package com.wwy.android.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.wwy.android.R
import com.wwy.android.data.bean.Navigation
import com.wwy.android.ext.inflate
import kotlinx.android.synthetic.main.item_system.view.*
import kotlinx.android.synthetic.main.item_system_textview.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 *@创建者wwy
 *@创建时间 2020/7/8 9:13
 *@描述
 */
class NavigationAdapter : BaseQuickAdapter<Navigation, BaseViewHolder>(R.layout.item_system) {
    private lateinit var mListener: ListenerBuilder
    override fun convert(holder: BaseViewHolder, item: Navigation) {
        holder.itemView.apply {
            flexBoxSystemItem.removeAllViews()
            tvSystemItemTitle.text = item.name
            item.articles.size.let {
                for (index in 0 until it) {
                    flexBoxSystemItem?.run {
                        inflate(R.layout.item_system_textview, false).apply {
                            tvSystemTypeText.text = item.articles[index].title
                            tvSystemTypeText.tag = index
                            tvSystemTypeText.onClick {
                                if (::mListener.isInitialized) {
                                    mListener.typeTextClick?.invoke(
                                        tvSystemTypeText.tag as Int,
                                        holder.layoutPosition
                                    )
                                }
                            }
                            addView(this)
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