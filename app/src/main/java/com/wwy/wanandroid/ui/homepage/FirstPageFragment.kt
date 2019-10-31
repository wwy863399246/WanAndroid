package com.wwy.wanandroid.ui.homepage

import android.widget.Toast
import androidx.lifecycle.Observer
import com.wwy.wanandroid.MyApplication
import com.wwy.wanandroid.R
import com.wwy.wanandroid.bean.Banner
import com.wwy.wanandroid.ui.base.BaseVMFragment
import timber.log.Timber

/**
 *@创建者wwy
 *@创建时间 2019/9/17 11:58
 *@描述
 */
class FirstPageFragment : BaseVMFragment<FirstPageViewModel>() {
    override fun providerVMClass(): Class<FirstPageViewModel>? = FirstPageViewModel::class.java
    override fun setLayoutResId(): Int = R.layout.fragment_first_page
    override fun initView() {
    }

    override fun initData() {
        mViewModel.getArticleList(page = 1)
    }

    override fun startObserve() {
        super.startObserve()
        mViewModel.apply {
            mBanner.observe(this@FirstPageFragment, Observer { it ->
                it?.let {
                   // Toast.makeText(MyApplication.CONTEXT, "haha", Toast.LENGTH_LONG).show()
                    setBanner(it)
                }
            })
            mArticleList.observe(this@FirstPageFragment, Observer {
                it?.let {
                    Timber.tag("wwy").d(it.toString())
                    Toast.makeText(MyApplication.CONTEXT, "haha", Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    private fun setBanner(bannerList: List<Banner>) {
        Timber.tag("wangwuyuan").d(bannerList[0].title)
    }
}