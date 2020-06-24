package com.leshu.superbrain.ui.homeplaza

import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.jeremyliao.liveeventbus.LiveEventBus
import com.leshu.superbrain.R
import com.leshu.superbrain.adapter.MyFragmentPagerAdapter
import com.leshu.superbrain.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_plaza.*

/**
 *@创建者wwy
 *@创建时间 2019/9/17 11:58
 *@描述 广场主页
 */
class MainPlazaFragment : BaseFragment() {
    override fun setLayoutResId(): Int = R.layout.fragment_plaza


    override fun initView() {
        LiveEventBus.get("MAIN_PLAZA_CUT").observe(this, Observer {
            homePlazaVp.setCurrentItem(0, true)
        })
        val fragments = listOf(HomePlazaFragment(), MainWeChatNumFragment())
        homePlazaVp.adapter = activity?.let { MyFragmentPagerAdapter(it, fragments) }
        val mHomePlazaTabLayout =
            arrayOf(
                context?.getString(R.string.home_plaza),
                context?.getString(R.string.official_account)
            )
        homePlazaNv.setTabLayoutData(mHomePlazaTabLayout, homePlazaVp)

    }
    override fun initData() {
        homePlazaVp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                homePlazaVp.isUserInputEnabled = position == 0
            }
        })
    }

}