package com.wwy.android.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 *@创建者wwy
 *@创建时间 2019/9/20 15:04
 *@描述
 */
class MyFragmentPagerAdapter( fragmentActivity: FragmentActivity,private val mFragments: List<Fragment>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = mFragments.size

    override fun createFragment(position: Int): Fragment = mFragments[position]
}