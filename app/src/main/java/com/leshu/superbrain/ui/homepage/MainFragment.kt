package com.leshu.superbrain.ui.homepage

import com.leshu.superbrain.R
import com.leshu.superbrain.adapter.MyFragmentPagerAdapter
import com.leshu.superbrain.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*

/**
 *@创建者wwy
 *@创建时间 2020/1/13 14:21
 *@描述
 */
class MainFragment: BaseFragment() {
    override fun setLayoutResId(): Int = R.layout.fragment_main


    override fun initData() {
        val mHomePageTabLayout =
            arrayOf(context?.getString(R.string.home_page), context?.getString(R.string.home_project))
        navigation_bar_view.setTabLayoutData(mHomePageTabLayout, home_page_vp)
    }

    override fun initView() {
        val firstPageFragment = HomePageFragment()
        val mainProjectFragment = MainProjectFragment()
        val fragments = listOf(firstPageFragment, mainProjectFragment)
        home_page_vp.adapter = activity?.let { MyFragmentPagerAdapter(it, fragments) }
    }
}