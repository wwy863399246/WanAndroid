package com.wwy.android.ui.homepage

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.jeremyliao.liveeventbus.LiveEventBus
import com.wwy.android.R
import com.wwy.android.adapter.MyFragmentPagerAdapter
import com.wwy.android.ext.HOME_PAGE_CUT
import com.wwy.android.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*
import org.jetbrains.anko.support.v4.indeterminateProgressDialog

/**
 *@创建者wwy
 *@创建时间 2020/1/13 14:21
 *@描述
 */
class MainFragment : BaseFragment() {
    override fun setLayoutResId(): Int = R.layout.fragment_main
    override fun initData() {
        val mHomePageTabLayout =
            arrayOf(
                context?.getString(R.string.home_page),
                context?.getString(R.string.home_project)
            )
        homePagNv.setTabLayoutData(mHomePageTabLayout, homePageVp)
    }

    override fun initView() {
        LiveEventBus.get(HOME_PAGE_CUT).observe(this, Observer {
            homePageVp.setCurrentItem(0, true)
        })
        val firstPageFragment = HomePageFragment()
        val mainProjectFragment = MainProjectFragment()
        val fragments = listOf(firstPageFragment, mainProjectFragment)
        homePageVp.adapter = activity?.let { MyFragmentPagerAdapter(it, fragments) }
        homePageVp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                homePageVp.isUserInputEnabled = position == 0
            }
        })
    }

}