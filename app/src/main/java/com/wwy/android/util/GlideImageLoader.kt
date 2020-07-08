package com.wwy.android.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.wwy.android.R
import com.wwy.android.app.GlideApp

/**
 *@创建者wwy
 *@创建时间 2019/10/16 14:23
 *@描述
 */
class GlideImageLoader {
    //加载图片
    fun displayImage(
        context: Context,
        path: Any,
        imageView: ImageView,
        placeholder: Int = R.drawable.ic_img_code,
        error: Int = R.drawable.ic_img_code
    ) {
        GlideApp.with(context).load(path).centerCrop().placeholder(placeholder).error(error)
            .into(imageView)
    }

    fun displayImage(
        context: Context,
        path: Any,
        imageView: ImageView
    ) {
        GlideApp.with(context).load(path).centerCrop().placeholder(R.drawable.ic_img_code)
            .error(R.drawable.ic_img_code)
            .into(imageView)
    }

    //加载圆形图片
    fun displayCircleImage(
        context: Context,
        path: Any,
        imageView: ImageView,
        placeholder: Int = R.drawable.ic_img_code,
        error: Int = R.drawable.ic_img_code
    ) {
        GlideApp.with(context).load(path).centerCrop().placeholder(placeholder).error(error)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(imageView)
    }

    //加载圆角图片
    fun displayRoundedImage(
        context: Context,
        path: Any,
        imageView: ImageView,
        placeholder: Int = R.drawable.ic_img_code,
        error: Int = R.drawable.ic_img_code,
        roundingRadius: Int = 8
    ) {
        GlideApp.with(context).load(path).placeholder(placeholder).error(error)
            .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(roundingRadius)))
            .into(imageView)
    }
}