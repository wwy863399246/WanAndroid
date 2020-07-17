//package com.wwy.android.ui.homemine
//
//import android.view.View
//import androidx.core.content.ContextCompat
//import androidx.lifecycle.Observer
//import androidx.navigation.fragment.findNavController
//import com.jeremyliao.liveeventbus.LiveEventBus
//import com.wwy.android.R
//import com.wwy.android.ext.OnLazyClickListener
//import com.wwy.android.ext.SET_THEME
//import com.wwy.android.ui.base.BaseFragment
//import com.wwy.android.view.rippleAnimation.RippleAnimation
//import kotlinx.android.synthetic.main.fragment_my_home_page.*
//import org.jetbrains.anko.image
//import org.jetbrains.anko.sdk27.coroutines.onClick
//import org.jetbrains.anko.support.v4.startActivity
//
///**
// *@创建者wwy
// *@创建时间 2020/7/8 11:46
// *@描述
// */
//class MyHomePageFragment : BaseFragment(), OnLazyClickListener {
//    override fun setLayoutResId(): Int = R.layout.fragment_home_mine
//
//    override fun initView() {
//        tvMyIntegral.setOnClickListener(this)
//        tvMyIntegralRanking.setOnClickListener(this)
//        tvMyShare.setOnClickListener(this)
//        tvMyCollect.setOnClickListener(this)
//        tvMyKuTu.setOnClickListener(this)
//        tvTheme.setOnClickListener(this)
//    }
//
//    override fun initData() {
//    }
//
//    override fun onLazyClick(v: View) {
//        when (v.id) {
//            R.id.tvMyIntegral -> {
//                findNavController().navigate(R.id.action_myHomePageFragment_to_myIntegralFragment)
//            }
//            R.id.tvMyIntegralRanking -> {
//                findNavController().navigate(R.id.action_myHomePageFragment_to_myIntegralRankingFragment)
//            }
//            R.id.tvMyShare -> {
//                findNavController().navigate(R.id.action_myHomePageFragment_to_myShareFragment)
//            }
//            R.id.tvMyCollect -> {
//                findNavController().navigate(R.id.action_myHomePageFragment_to_myCollectFragment)
//            }
//            R.id.tvMyKuTu -> {
//                findNavController().navigate(R.id.action_myHomePageFragment_to_myKuTuFragment)
//            }
//            R.id.tvMyTool -> {
//                //findNavController().navigate(R.id.action_myHomePageFragment_to_myIntegralFragment)
//            }
//            R.id.tvTheme -> {
//                startActivity<MyThemeActivity>()
//            }
//            R.id.tvNighMode -> {
//                // findNavController().navigate(R.id.action_myHomePageFragment_to_myIntegralFragment)
//            }
//            R.id.tvOpenSourceLicenses -> {
//                //  findNavController().navigate(R.id.action_myHomePageFragment_to_myIntegralFragment)
//            }
//            R.id.tvProjectHomePage -> {
//                // findNavController().navigate(R.id.action_myHomePageFragment_to_myIntegralFragment)
//            }
//        }
//    }
//}