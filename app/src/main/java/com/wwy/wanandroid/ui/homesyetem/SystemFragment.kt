package com.wwy.wanandroid.ui.homesyetem

import androidx.fragment.app.Fragment
import com.wwy.wanandroid.BaseFragment
import com.wwy.wanandroid.R
import com.wwy.wanandroid.adapter.MyFragmentPagerAdapter
import com.wwy.wanandroid.ui.homepage.FirstPageFragment
import com.wwy.wanandroid.ui.homepage.MainProjectFragment
import kotlinx.android.synthetic.main.fragment_home_page.*

/**
 *@创建者wwy
 *@创建时间 2019/9/25 9:46
 *@描述
 */
class SyetemFragment : BaseFragment() {
    override fun getLayoutResId(): Int = R.layout.fragment_home_page


    override fun initData() {
        val mHomePageTabLayout =
            arrayOf(context!!.getString(R.string.home_system), context!!.getString(R.string.home_navigation))
        navigation_bar_view.setTabLayoutData(mHomePageTabLayout, home_page_viewpage)
    }

    override fun initView() {
        val firstPageFragment = FirstPageFragment()
        val mainProjectFragment = MainProjectFragment()
        val fragments = listOf<Fragment>(firstPageFragment, mainProjectFragment)
        home_page_viewpage.adapter = MyFragmentPagerAdapter(this, fragments)
    }


}