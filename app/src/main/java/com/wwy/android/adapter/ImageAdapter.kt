package com.wwy.android.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.wwy.android.data.bean.Banner
import com.wwy.android.util.GlideImageLoader
import com.youth.banner.adapter.BannerAdapter

/**
 * 自定义布局，图片
 */
class ImageAdapter //设置数据，也可以调用banner提供的方法,或者自己在adapter中实现
    (
    mDatas: List<Banner?>?,
    var mContext: Context
) : BannerAdapter<Banner?, ImageAdapter.ImageHolder>(
    mDatas
) {

    //更新数据
    fun updateData(data: List<Banner?>?) {
        //这里的代码自己发挥，比如如下的写法等等
        mDatas.clear()
        mDatas.addAll(data!!)
        notifyDataSetChanged()
    }

    //创建ViewHolder，可以用viewType这个字段来区分不同的ViewHolder
    override fun onCreateHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageHolder {
        val imageView = ImageView(parent.context)
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        val params = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        imageView.layoutParams = params
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return ImageHolder(imageView)
    }

    override fun onBindView(holder: ImageHolder?, data: Banner?, position: Int, size: Int) {
        GlideImageLoader().displayImage(mContext, data!!.imagePath, holder!!.imageView)
    }

    class ImageHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        var imageView: ImageView = view as ImageView

    }


}