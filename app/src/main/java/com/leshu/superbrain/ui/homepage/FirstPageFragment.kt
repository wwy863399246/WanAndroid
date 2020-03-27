package com.leshu.superbrain.ui.homepage

import androidx.lifecycle.Observer
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.leshu.superbrain.R
import com.leshu.superbrain.data.bean.BannerResponse
import com.leshu.superbrain.ui.base.BaseVMFragment
import com.leshu.superbrain.util.*
import kotlinx.android.synthetic.main.fragment_home_page.*

/**
 *@创建者wwy
 *@创建时间 2019/9/17 11:58
 *@描述
 */
class FirstPageFragment : BaseVMFragment<FirstPageViewModel>() {
    override fun providerVMClass(): Class<FirstPageViewModel>? = FirstPageViewModel::class.java
    override fun setLayoutResId(): Int = R.layout.fragment_home_page
    private var page = 0
    private val adapter = FirstPageAdapter()
    override fun initView() {
        firstPageRv.adapter = adapter
    }

    override fun initData() {
        mViewModel.getArticleList(page, true)
    }

    override fun startObserve() {
        super.startObserve()
        mViewModel.apply {
            mBannerResponse.observe(this@FirstPageFragment, Observer { it ->
                it?.let {
                    setBanner(it)
                }
            })
            pagedList.observe(this@FirstPageFragment, Observer {
                it?.let {
                    adapter.submitList(it)
                }
            })
            listStatus.observe(this@FirstPageFragment, Observer {
                when (it) {
                    ListStatus.EMPTY -> {
                        loadEmptyView()//加载空布局
                    }
                    ListStatus.END -> {
                        loadMore()
                    }
                }
            })
//            refreshStatus.observe(this@FirstPageFragment, Observer {
//                when (it) {
//                    NetworkState.LOADING -> {
//
//                    }
//                    NetworkState.FAILED -> {
//
//                    }
//                    NetworkState.LOADED -> {
//
//                    }
//                }
//            })
        }
    }

    private fun loadEmptyView() {

    }

    private fun loadMore() {
        if (isInternetAvailable()) {
            page += 1
            mViewModel.getArticleList(page, false)
        } else {//没网 并且数据库到底了 给用户提示
            SmartSnackbar.get(activity).show("已经没有更多数据了")
        }

    }

    private fun setBanner(bannerResponseList: List<BannerResponse>) {
        //Timber.tag("wangwuyuan").d(bannerResponseList[0].title)
    }
}