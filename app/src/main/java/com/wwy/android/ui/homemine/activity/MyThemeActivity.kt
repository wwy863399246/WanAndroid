package com.wwy.android.ui.homemine.activity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.SimpleItemAnimator
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gyf.immersionbar.ktx.immersionBar
import com.jeremyliao.liveeventbus.LiveEventBus
import com.wwy.android.R
import com.wwy.android.data.bean.Theme
import com.wwy.android.ext.*
import com.wwy.android.ui.base.BaseActivity
import com.wwy.android.view.rippleAnimation.RippleAnimation
import kotlinx.android.synthetic.main.activity_my_theme.*
import kotlinx.android.synthetic.main.item_theme.view.*
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.*
import org.jetbrains.anko.textColor

/**
 *@创建者wwy
 *@创建时间 2020/7/8 11:46
 *@描述
 */
class MyThemeActivity : BaseActivity() {
    private var themes = ArrayList<Theme>()
    private var themeAdapter =
        ThemeAdapter()
    private var mPosition: Int = 0
    private var isClick: Boolean = false
    private lateinit var mThemeBean: Theme
    override fun setLayoutId(): Int = R.layout.activity_my_theme
    override fun initImmersionBar() {
        super.initImmersionBar()
        immersionBar {
            titleBar(R.id.themeNv)
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        themeNv.apply {
            ivBackNavigationBar.clickWithTrigger {
                finish()
            }
        }
        themeRv.apply {
            (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            adapter = themeAdapter
        }
        themeAdapter.setOnItemClickListener { adapter, view, position ->
            if (mPosition != position) {
                view.apply {
                    RippleAnimation.create(tvUserTheme).setDuration(1000).start()
                }
                mThemeBean = themeAdapter.data[position]
                mThemeBean.isChoose = 1
                themeAdapter.setData(position, mThemeBean)
                immersionBar {
                    statusBarColor(mThemeBean.color)
                }
                themeNv.setNavigationBarBackgroundColor(mThemeBean.color)
                isClick = true
                if (mPosition != -1) {
                    val themeBean = themeAdapter.data[mPosition]
                    themeBean.isChoose = 0
                    themeAdapter.setData(mPosition, themeBean)
                }
                mPosition = position
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        if (isClick) {
            LiveEventBus.get(SET_THEME).post("")
            if (getAppTheme() != mThemeBean.theme) {
                setAppTheme(mThemeBean.theme)
            }
        }
    }

    override fun initData() {
        themes.add(Theme(R.color.accent_red, R.style.AppTheme_Red, text(R.string.theme_red), 0))
        themes.add(Theme(R.color.accent_pink, R.style.AppTheme_Pink, text(R.string.theme_pink), 0))
        themes.add(
            Theme(
                R.color.accent_orange,
                R.style.AppTheme_Orange,
                text(R.string.theme_orange),
                0
            )
        )
        themes.add(
            Theme(
                R.color.accent_pale_blue,
                R.style.AppTheme_PaleBlue,
                text(R.string.theme_blue),
                0
            )
        )
        themes.add(Theme(R.color.accent_green, R.style.AppTheme, text(R.string.theme_green), 0))
        themes.add(Theme(R.color.accent_cyan, R.style.AppTheme_Cyan, text(R.string.theme_cyan), 0))
        themes.add(
            Theme(
                R.color.accent_dark_blue,
                R.style.AppTheme_DarkBlue,
                text(R.string.theme_blue),
                0
            )
        )
        themes.add(
            Theme(
                R.color.accent_purple,
                R.style.AppTheme_Purple,
                text(R.string.theme_purple),
                0
            )
        )
        themes.add(
            Theme(
                R.color.accent_brown,
                R.style.AppTheme_Brown,
                text(R.string.theme_brown),
                0
            )
        )
        for (index in 0 until themes.size) {
            if (getAppTheme() == themes[index].theme) {
                themes[index].isChoose = 1
                mPosition = index
            }
        }
        themeAdapter.setList(themes)
    }

    class ThemeAdapter : BaseQuickAdapter<Theme, BaseViewHolder>(R.layout.item_theme) {
        override fun convert(holder: BaseViewHolder, item: Theme) {
            holder.apply {
                addChildClickViewIds(R.id.tvUserTheme)
                itemView.apply {
                    flThemeColor.delegate.backgroundColor = color(item.color)
                    ivChooseTheme.visibility = if (item.isChoose == 0) View.GONE else View.VISIBLE
                    tvUserTheme.text =
                        if (item.isChoose == 0) text(R.string.theme_user) else text(R.string.theme_user_ing)
                    tvUserTheme.delegate.strokeColor =
                        color(if (item.isChoose == 0) R.color.color_8A000000 else item.color)
                    tvUserTheme.textColor =
                        color(if (item.isChoose == 0) R.color.color_8A000000 else item.color)
                    tvThemeColor.text = item.colorName
                    tvThemeColor.textColor = color(item.color)
                }
            }
        }

    }

}