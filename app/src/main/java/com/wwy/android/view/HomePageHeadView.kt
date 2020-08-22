package com.wwy.android.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.wwy.android.R
import com.wwy.android.ui.homepage.HomePageFragment
import com.wwy.android.ui.main.DetailActivity
import kotlinx.android.synthetic.main.layout_banner.view.*
import org.jetbrains.anko.include
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.startActivity

@SuppressLint("ViewConstructor")
class HomePageHeadView @JvmOverloads constructor(
    context: Context?,
    homePageStickAdapter: HomePageFragment.HomePageStickAdapter?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    init {
        include<View>(R.layout.layout_banner)
        rvHomePageHeadView.run {
            layoutManager = LinearLayoutManager(context)
            adapter = homePageStickAdapter

        }
        homePageStickAdapter?.run {
            isAnimationFirstOnly = true
            setAnimationWithDefault(BaseQuickAdapter.AnimationType.SlideInBottom)
            setOnItemClickListener { adapter, view, position ->
                val article = data[position]
                context?.startActivity<DetailActivity>(DetailActivity.PARAM_ARTICLE to article)
            }
        }
    }
}