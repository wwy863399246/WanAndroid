package com.wwy.wanandroid.ui.homesyetem

import androidx.fragment.app.Fragment
import com.wwy.wanandroid.R
import com.wwy.wanandroid.adapter.MyFragmentPagerAdapter
import com.wwy.wanandroid.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home_system.*

/**
 *@创建者wwy
 *@创建时间 2019/9/17 11:58
 *@描述
 */
class HomeSystemFragment : BaseFragment() {
    override fun setLayoutResId(): Int = R.layout.fragment_home_system

    override fun initData() {
        val mHomePageTabLayout =
            arrayOf(context?.getString(R.string.home_system), context?.getString(R.string.home_navigation))
        navigation_bar_view.setTabLayoutData(mHomePageTabLayout, home_syetem_viewpage)
    }

    override fun initView() {
        val systemFragment = SystemFragment()
        val navigationFragment = NavigationFragment()
        val fragments = listOf<Fragment>(systemFragment, navigationFragment)
        home_syetem_viewpage.adapter = MyFragmentPagerAdapter(this, fragments)
    }


}