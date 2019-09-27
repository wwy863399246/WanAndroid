package com.wwy.wanandroid.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 *@创建者wwy
 *@创建时间 2019/9/20 15:04
 *@描述
 */
class MyFragmentPagerAdapter(fragment: Fragment, private val mFragments: List<Fragment>) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = mFragments.size

    override fun createFragment(position: Int): Fragment = mFragments[position]
}