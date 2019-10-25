package com.wwy.wanandroid.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import com.wwy.wanandroid.R
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.view.*


/**
 *@创建者wwy
 *@创建时间 2019/9/18 13:58
 *@描述
 */
@SuppressLint("NewApi")
class CustomNavigationBarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : Toolbar(context, attrs, defStyleAttr) {
    private var mLeftImg: Int = 0
    private var mLeftTextStr: String? = null
    private var mLeftTextId: Int = 0
    private var mRightImg1: Int = 0
    private var mRightImg2: Int = 0
    private var mRightImg3: Int = 0
    private var mShowLeftImg: Boolean = false
    private var mShowRightImg1: Boolean = false
    private var mShowRightImg2: Boolean = false
    private var mShowRightImg3: Boolean = false
    private var mTitleTextStr: String? = null
    private var mTitleTextId: Int = 0
    private var mTextColor: Int = 0
    private var mShowTabLayout: Boolean = false

    init {
        val obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CustomNavigationBarView)
        mLeftTextId = obtainStyledAttributes.getResourceId(R.styleable.CustomNavigationBarView_left_textId, 0)
        mLeftTextStr = obtainStyledAttributes.getString(R.styleable.CustomNavigationBarView_left_textStr)
        mLeftImg = obtainStyledAttributes.getResourceId(R.styleable.CustomNavigationBarView_left_img, 0)
        mShowLeftImg = obtainStyledAttributes.getBoolean(R.styleable.CustomNavigationBarView_isShow_left_img, false)
        mRightImg1 = obtainStyledAttributes.getResourceId(R.styleable.CustomNavigationBarView_right_img1, 0)
        mRightImg2 = obtainStyledAttributes.getResourceId(R.styleable.CustomNavigationBarView_right_img2, 0)
        mRightImg3 = obtainStyledAttributes.getResourceId(R.styleable.CustomNavigationBarView_right_img3, 0)
        mShowRightImg1 = obtainStyledAttributes.getBoolean(R.styleable.CustomNavigationBarView_isShow_right_img1, false)
        mShowRightImg2 = obtainStyledAttributes.getBoolean(R.styleable.CustomNavigationBarView_isShow_right_img2, false)
        mRightImg3 = obtainStyledAttributes.getResourceId(R.styleable.CustomNavigationBarView_right_img3, 0)
        mShowRightImg3 = obtainStyledAttributes.getBoolean(R.styleable.CustomNavigationBarView_isShow_right_img2, false)
        mTitleTextId = obtainStyledAttributes.getResourceId(R.styleable.CustomNavigationBarView_title_textId, 0)
        mTitleTextStr = obtainStyledAttributes.getString(R.styleable.CustomNavigationBarView_title_textStr)
        mTextColor = obtainStyledAttributes.getColor(R.styleable.CustomNavigationBarView_text_color, 0)
        mShowTabLayout = obtainStyledAttributes.getBoolean(R.styleable.CustomNavigationBarView_isShow_tablayout, false)
        initView()
        setContentInsetsRelative(0, 0)
        obtainStyledAttributes.recycle()
    }

    private fun initView() {
        View.inflate(context, R.layout.layout_custom_navigationbar_view, this)
        if (mLeftImg != 0) {
            iv_back_navigationbar.setImageResource(mLeftImg)
        }
        mLeftTextStr?.let {
            tv_left_title.text = mLeftTextStr
            tv_left_title.visibility = View.VISIBLE
        }
        if (mLeftTextId != 0) {
            tv_left_title.setText(mLeftTextId)
            tv_left_title.visibility = View.VISIBLE
        }
        if (mShowLeftImg) iv_back_navigationbar.visibility =
            View.VISIBLE else iv_back_navigationbar.visibility =
            View.GONE
        if (mRightImg1 != 0) {
            iv_settings_navigationbar.setImageResource(mRightImg1)
        }
        if (mShowRightImg1) iv_settings_navigationbar.visibility =
            View.VISIBLE else iv_settings_navigationbar.visibility =
            View.GONE
        if (mRightImg2 != 0) {
            iv_search_navigationbar.setImageResource(mRightImg2)
        }
        if (mShowRightImg2) iv_search_navigationbar.visibility =
            View.VISIBLE else iv_search_navigationbar.visibility =
            View.GONE
        mTitleTextStr?.let {
            tv_title_text.text = mTitleTextStr
            tv_title_text.visibility = View.VISIBLE
        }
        if (mTitleTextId != 0) {
            tv_title_text.setText(mTitleTextId)
            tv_title_text.visibility = View.VISIBLE
        }
        if (mTextColor != 0) {
            tv_title_text.setTextColor(mTextColor)
        }
        if (mShowTabLayout) tl_navigationbar.visibility =
            View.VISIBLE else tl_navigationbar.visibility =
            View.GONE
    }

    fun setTabLayoutData(tablayoutTitle: Array<String?>, viewPager2: ViewPager2) {
        //viewpage2 tablayout 联动
        TabLayoutMediator(tl_navigationbar, viewPager2) { tab, position ->
            tab.text = tablayoutTitle[position]

        }.attach()
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