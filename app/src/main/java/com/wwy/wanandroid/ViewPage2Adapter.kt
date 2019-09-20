package com.wwy.wanandroid

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * @创建者wwy
 * @创建时间 2019/9/20 16:02
 * @描述
 */
class ViewPage2Adapter(fragmentActivity: FragmentActivity, private val mFragments: List<Fragment>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getItemCount(): Int {
        return mFragments.size
    }
}
