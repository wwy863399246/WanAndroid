package com.wwy.android.adapter

import android.annotation.SuppressLint
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.wwy.android.R
import com.wwy.android.data.bean.PointRank
import kotlinx.android.synthetic.main.item_points_rank.view.*


/**
 */
@SuppressLint("SetTextI18n")
class PointsRankAdapter : BaseQuickAdapter<PointRank, BaseViewHolder>(R.layout.item_points_rank),LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: PointRank) {
        holder.itemView.run {
            tvNo.text = "${holder.adapterPosition + 1}"
            tvName.text = item.username
            tvPoints.text = item.coinCount.toString()
        }
    }
}