package com.wwy.android.ui.homemine

import android.view.View
import androidx.lifecycle.Observer
import com.jeremyliao.liveeventbus.LiveEventBus
import com.wwy.android.R
import com.wwy.android.ext.OnLazyClickListener
import com.wwy.android.ext.SET_THEME
import com.wwy.android.ui.base.BaseFragment
import com.wwy.android.ui.homemine.activity.MyThemeActivity
import com.wwy.android.ui.member.LoginActivity
import com.wwy.android.view.rippleAnimation.RippleAnimation
import kotlinx.android.synthetic.main.fragment_home_mine.*
import org.jetbrains.anko.support.v4.startActivity


/**
 *@创建者wwy
 *@创建时间 2019/9/17 11:58
 *@描述
 */
class HomeMineFragment : BaseFragment(), OnLazyClickListener {
    override fun setLayoutResId(): Int = R.layout.fragment_home_mine

    override fun initView() {
        LiveEventBus.get(SET_THEME).observe(viewLifecycleOwner, Observer {
            RippleAnimation.create(tvTheme).setDuration(1000).start()
        })
        tvMyIntegral.setOnClickListener(this)
        tvMyIntegralRanking.setOnClickListener(this)
        tvMyShare.setOnClickListener(this)
        tvMyCollect.setOnClickListener(this)
        tvMyKuTu.setOnClickListener(this)
        tvTheme.setOnClickListener(this)
        tvNighMode.setOnClickListener(this)
        tvLoginImmediately.setOnClickListener(this)
    }

    override fun initData() {
    }

    override fun onLazyClick(v: View) {
        when (v.id) {
            R.id.tvLoginImmediately -> {
                startActivity<LoginActivity>()
            }
            R.id.tvMyIntegral -> {
            }
            R.id.tvMyIntegralRanking -> {
            }
            R.id.tvMyShare -> {
            }
            R.id.tvMyCollect -> {
            }
            R.id.tvMyKuTu -> {
            }
            R.id.tvMyTool -> {
            }
            R.id.tvTheme -> {
                startActivity<MyThemeActivity>()
            }
            R.id.tvNighMode -> {
                RippleAnimation.create(tvNighMode).setDuration(1000).start()
            }
            R.id.tvOpenSourceLicenses -> {
            }
            R.id.tvProjectHomePage -> {
            }
        }
    }
}

