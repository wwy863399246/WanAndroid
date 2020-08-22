package com.wwy.android.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.jeremyliao.liveeventbus.LiveEventBus
import com.wwy.android.R
import com.wwy.android.ext.SET_THEME
import com.wwy.android.ui.base.BaseActivity
import com.wwy.android.ui.homemine.MyHomePageFragment
import com.wwy.android.ui.homepage.MainFragment
import com.wwy.android.ui.homeplaza.MainPlazaFragment
import com.wwy.android.ui.homesyetem.HomeSystemFragment
import kotlinx.android.synthetic.main.activity_main.*


open class MainActivity : BaseActivity() {
    private val fragments = arrayListOf<Fragment>()
    private var lastPosition: Int = 0
    private var mPosition: Int = 0
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
        setSelectedFragment(lastPosition)
        bottom_nav_view.selectedItemId = bottom_nav_view.menu.getItem(lastPosition).itemId
    }

    override fun initView(savedInstanceState: Bundle?) {
        LiveEventBus.get(SET_THEME).observe(this, Observer {
            recreate()
        })

        fragments.apply {
            add(MainFragment())
            add(HomeSystemFragment())
            add(MainPlazaFragment())
            // add(HomeMineFragment())
            add(MyHomePageFragment())
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
                R.id.home_plaza -> setSelectedFragment(2)
                R.id.home_mine -> setSelectedFragment(3)
            }

            true
        }
    }

    override fun initData() {
    }


    /**
     * 根据位置选择Fragment
     * @param position 要选中的fragment的位置
     */
    private fun setSelectedFragment(position: Int) {
        bottom_nav_view.menu.getItem(position).isChecked = true
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        currentFragment =
            fragmentManager.findFragmentByTag("fragment$position")//要显示的fragment(解决了activity重建时新建实例的问题)
        hideFragment =
            fragmentManager.findFragmentByTag("fragment$lastPosition")//要隐藏的fragment(解决了activity重建时新建实例的问题)
        if (position != lastPosition) {//如果位置不同
            //如果要隐藏的fragment存在，则隐藏
            hideFragment?.let { transaction.hide(it) }
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
        mPosition = position
    }


    override fun recreate() {
        val beginTransaction = supportFragmentManager.beginTransaction()
        for (index in 0..2) {
            supportFragmentManager.findFragmentByTag("fragment$index")?.let {
                beginTransaction.remove(it)
            }
        }
        beginTransaction.commitAllowingStateLoss();
        super.recreate()
    }
    private var previousTimeMillis = 0L
    override fun onBackPressed() {
        val currentTimMillis = System.currentTimeMillis()
        if (currentTimMillis - previousTimeMillis < 2000) {
            super.onBackPressed()
        } else {
            SmartSnackbar.get(this).show(R.string.press_again_to_exit)
            previousTimeMillis = currentTimMillis
        }
    }
}
