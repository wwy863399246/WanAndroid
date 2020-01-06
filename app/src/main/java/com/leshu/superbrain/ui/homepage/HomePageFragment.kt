package com.leshu.superbrain.ui.homepage

import com.leshu.superbrain.adapter.MyFragmentPagerAdapter
import com.leshu.superbrain.R
import com.leshu.superbrain.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home_page.*

/**
 *@创建者wwy
 *@创建时间 2019/9/17 11:58
 *@描述
 */
class HomePageFragment : BaseFragment() {
    override fun setLayoutResId(): Int = R.layout.fragment_home_page


    override fun initData() {
        val mHomePageTabLayout =
            arrayOf(context?.getString(R.string.home_page), context?.getString(R.string.home_project))
        navigation_bar_view.setTabLayoutData(mHomePageTabLayout, home_page_viewpage)
    }

    override fun initView() {
        val firstPageFragment = FirstPageFragment()
        val mainProjectFragment = MainProjectFragment()
        val fragments = listOf(firstPageFragment, mainProjectFragment)
        home_page_viewpage.adapter = activity?.let { MyFragmentPagerAdapter(it, fragments) }
    }




}