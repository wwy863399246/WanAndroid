package com.wwy.android.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.wwy.android.R
import com.wwy.android.data.bean.MeiZi
import com.wwy.android.ext.ImageOptions
import com.wwy.android.ext.loadImage
import kotlinx.android.synthetic.main.item_ku_tu_adapter.view.*
import org.jetbrains.anko.dip

/**
 *@创建者wwy
 *@创建时间 2020/8/19 0019 下午 22:44
 *@描述
 */
class KuTuAdapter : BaseQuickAdapter<MeiZi, BaseViewHolder>(R.layout.item_ku_tu_adapter),LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: MeiZi) {
        holder.run {
            itemView.apply {
                ivKuTu.loadImage(
                    url = item.images?.get(0),
                    imageOptions = ImageOptions().apply {
                        cornersRadius = dip(4)
                    }
                )
            }
        }
    }
}