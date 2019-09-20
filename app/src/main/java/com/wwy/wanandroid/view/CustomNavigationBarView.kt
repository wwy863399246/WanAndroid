package com.wwy.wanandroid.view

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.view.View.GONE
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.wwy.wanandroid.R
import kotlinx.android.synthetic.main.fragment_home_mine.view.*
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.view.*
import java.util.*


/**
 *@创建者wwy
 *@创建时间 2019/9/18 13:58
 *@描述
 */
class CustomNavigationBarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var left_img: Int = 0
    private var right_img1: Int = 0
    private var right_img2: Int = 0
    private var right_img3: Int = 0
    private var isShow_left_img: Boolean = false
    private var isShow_right_img1: Boolean = false
    private var isShow_right_img2: Boolean = false
    private var title_textStr: String? = null
    private var title_textId: Int = 0
    private var text_color: Int = 0

    init {
        val obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CustomNavigationBarView)
        left_img = obtainStyledAttributes.getResourceId(R.styleable.CustomNavigationBarView_left_img, 0)
        isShow_left_img = obtainStyledAttributes.getBoolean(R.styleable.CustomNavigationBarView_isShow_left_img, false)
        right_img1 = obtainStyledAttributes.getResourceId(R.styleable.CustomNavigationBarView_right_img1, 0)
        right_img2 = obtainStyledAttributes.getResourceId(R.styleable.CustomNavigationBarView_right_img2, 0)
        isShow_right_img1 =
            obtainStyledAttributes.getBoolean(R.styleable.CustomNavigationBarView_isShow_right_img1, false)
        isShow_right_img2 =
            obtainStyledAttributes.getBoolean(R.styleable.CustomNavigationBarView_isShow_right_img2, false)
//        right_img3 = obtainStyledAttributes.getResourceId(R.styleable.CustomNavigationBarView_right_img3, 0)
        title_textId = obtainStyledAttributes.getResourceId(R.styleable.CustomNavigationBarView_title_textId, 0)
        title_textStr = obtainStyledAttributes.getString(R.styleable.CustomNavigationBarView_title_textStr)
        text_color = obtainStyledAttributes.getColor(R.styleable.CustomNavigationBarView_text_color, 0)
        initView()
        obtainStyledAttributes.recycle()
    }

    private fun initView() {
        View.inflate(context, R.layout.layout_custom_navigationbar_view, this)
        if (left_img != 0) {
            iv_back_navigationbar.setImageResource(left_img)
        }
        if (isShow_left_img) iv_back_navigationbar.visibility = View.VISIBLE else iv_back_navigationbar.visibility =
            View.GONE
        if (right_img1 != 0) {
            iv_settings_navigationbar.setImageResource(right_img1)
        }
        if (isShow_right_img1) iv_settings_navigationbar.visibility =
            View.VISIBLE else iv_settings_navigationbar.visibility =
            View.GONE
        if (right_img2 != 0) {
            iv_search_navigationbar.setImageResource(right_img2)
        }
        if (isShow_right_img2) iv_search_navigationbar.visibility =
            View.VISIBLE else iv_search_navigationbar.visibility =
            View.GONE
        if (title_textStr != null) {
            findViewById<TextView>(R.id.tv_title_text).text = title_textStr
            tv_title_text.visibility = View.VISIBLE
        }
        if (title_textId != 0) {
            tv_title_text.setText(title_textId)
            tv_title_text.visibility = View.VISIBLE
        }
        if (text_color != 0) {
            tv_title_text.setTextColor(text_color)
        }

    }

    fun setTabLayoutData(tablayoutTitle: Array<String>,viewPager2: ViewPager2) {
        for (s in tablayoutTitle) {
            tl_navigationbar.addTab(tl_navigationbar.newTab().setText(s))
        }
        tl_navigationbar.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
            }
        })
    }

    //扩展函数
    fun Context.color(colorRes: Int) = ContextCompat.getColor(this, colorRes)

    fun View.color(colorRes: Int) = context.color(colorRes)

}