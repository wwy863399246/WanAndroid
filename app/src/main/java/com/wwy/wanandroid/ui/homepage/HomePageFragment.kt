package com.wwy.wanandroid

import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home_page.*

/**
 *@创建者wwy
 *@创建时间 2019/9/17 11:58
 *@描述
 */
class HomePageFragment : BaseFragment() {
    override fun getLayoutResId(): Int = R.layout.fragment_home_page


    override fun initData() {
        val mHomePageTabLayout =
            arrayOf(context!!.getString(R.string.home_page), context!!.getString(R.string.home_project))
        navigation_bar_view.setTabLayoutData(mHomePageTabLayout, home_page_viewpage)
    }

    override fun initView() {
        val firstPageFragment = FirstPageFragment()
        val mainProjectFragment = MainProjectFragment()
        val fragments = listOf<Fragment>(firstPageFragment, mainProjectFragment)
        home_page_viewpage.adapter = MyFragmentPagerAdapter(this, fragments)
    }


}