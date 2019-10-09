package com.wwy.wanandroid.ui.main

import android.content.res.Resources
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wwy.wanandroid.R
import com.wwy.wanandroid.ui.base.BaseActivity
import com.wwy.wanandroid.ui.base.BaseVMActivity
import com.wwy.wanandroid.ui.homepage.FirstPageViewModel

class MainActivity : BaseActivity() {
    override fun setLayoutId(): Int = R.layout.activity_main
    override fun initData() {
    }

    override fun initView() {
        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment?
                ?: return //NavHostFragment? 加?可以为空  ?: Elvis运算符（null合并运算符）如果?:左边的值不为空返回左边的值，如果为空返回右边
        val navController = host.navController
        setupBottomNavMenu(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val dest: String = try {
                resources.getResourceName(destination.id)
            } catch (e: Resources.NotFoundException) {
                destination.id.toString()
            }
        }

    }

    private fun setupBottomNavMenu(navController: NavController) {
        // TODO STEP 9.3 - Use NavigationUI to set up Bottom Nav
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNav?.setupWithNavController(navController)
        // TODO END STEP 9.3
    }

}
