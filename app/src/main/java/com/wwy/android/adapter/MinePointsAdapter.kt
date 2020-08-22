package com.wwy.android.adapter

import android.annotation.SuppressLint
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.wwy.android.R
import com.wwy.android.data.bean.PointRecord
import com.wwy.android.ext.toDateTime
import kotlinx.android.synthetic.main.item_mine_points.view.*

/**
 */
@SuppressLint("SetTextI18n")
class MinePointsAdapter : BaseQuickAdapter<PointRecord, BaseViewHolder>(R.layout.item_mine_points),LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: PointRecord) {
        holder.itemView.apply {
            tvReason.text = item.reason
            tvTime.text = item.date.toDateTime("YYYY-MM-dd HH:mm:ss")
            tvPoint.text = "+${item.coinCount}"
        }
    }

}