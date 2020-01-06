package com.leshu.superbrain.ui.main

import androidx.fragment.app.Fragment
import com.leshu.superbrain.R
import com.leshu.superbrain.ui.base.BaseActivity
import com.leshu.superbrain.ui.homemine.HomeMineFragment
import com.leshu.superbrain.ui.homepage.HomePageFragment
import com.leshu.superbrain.ui.homesyetem.HomeSystemFragment
import com.leshu.superbrain.ui.officialaccount.OfficialAccountFragment
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import com.coder.zzq.smartshow.toast.SmartToast


class MainActivity : BaseActivity() {
    private val fragments = arrayListOf<Fragment>()
    private var lastPosition: Int = 0
    private var currentFragment: Fragment? = null//要显示的Fragment
    private var hideFragment: Fragment? = null//要隐藏的Fragment
    override fun setLayoutId(): Int = R.layout.activity_main

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("last_position", lastPosition)//activity重建时保存页面的位置
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        lastPosition = savedInstanceState.getInt("last_position")//获取重建时的fragment的位置
        setSelectedFragment(lastPosition)//恢复销毁前显示的fragment
        bottom_nav_view.selectedItemId = bottom_nav_view.menu.getItem(lastPosition).itemId
    }

    override fun initView(savedInstanceState: Bundle?) {
        fragments.apply {
            add(HomePageFragment())
            add(HomeSystemFragment())
            add(OfficialAccountFragment())
            add(HomeMineFragment())
        }
        if (savedInstanceState == null) {
            //根据传入的Bundle对象判断是正常启动还是重建 true表示正常启动，false表示重建
            setSelectedFragment(0)
        }
        //BottomNavigationView 点击事件监听
        bottom_nav_view.setOnNavigationItemSelectedListener { menuItem ->
            // 跳转指定页面：Fragment
            when (menuItem.itemId) {
                R.id.home_page -> setSelectedFragment(0)
                R.id.home_system -> setSelectedFragment(1)
                R.id.wechat_official_account -> setSelectedFragment(2)
                R.id.home_mine -> setSelectedFragment(3)
            }

            true
        }
    }

    override fun initData() {
        SmartToast.show("热更新测试")
    }


    /**
     * 根据位置选择Fragment
     * @param position 要选中的fragment的位置
     */
    private fun setSelectedFragment(position: Int) {
        bottom_nav_view.menu.getItem(position).isChecked = true
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        currentFragment = fragmentManager.findFragmentByTag("fragment$position")//要显示的fragment(解决了activity重建时新建实例的问题)
        hideFragment = fragmentManager.findFragmentByTag("fragment$lastPosition")//要隐藏的fragment(解决了activity重建时新建实例的问题)
        if (position != lastPosition) {//如果位置不同
            if (hideFragment != null) {//如果要隐藏的fragment存在，则隐藏
                hideFragment?.let { transaction.hide(it) }
            }
            if (currentFragment == null) {//如果要显示的fragment不存在，则新加并提交事务
                currentFragment = fragments[position]
                currentFragment?.let { transaction.add(R.id.fl_container, it, "fragment$position") }
            } else {//如果要显示的存在则直接显示
                currentFragment?.let { transaction.show(it) }
            }
        }

        if (position == lastPosition) {//如果位置相同
            if (currentFragment == null) {//如果fragment不存在(第一次启动应用的时候)
                currentFragment = fragments[position]
                currentFragment?.let { transaction.add(R.id.fl_container, it, "fragment$position") }
            }//如果位置相同，且fragment存在，则不作任何操作
        }
        transaction.commit()//提交事务
        lastPosition = position//更新要隐藏的fragment的位置
    }
}
