package com.wwy.android.ui.homemine

import android.content.res.Resources
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gyf.immersionbar.ktx.immersionBar
import com.jeremyliao.liveeventbus.LiveEventBus
import com.wwy.android.R
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.MyFunction
import com.wwy.android.ext.*
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.ui.homemine.activity.MyThemeActivity
import com.wwy.android.ui.main.DetailActivity
import com.wwy.android.ui.main.MainActivity
import com.wwy.android.ui.member.LoginActivity
import com.wwy.android.view.rippleAnimation.RippleAnimation
import com.wwy.android.vm.MyHomePageViewModel
import kotlinx.android.synthetic.main.fragment_my_home_page.*
import kotlinx.android.synthetic.main.fragment_my_home_page.tvLoginImmediately
import kotlinx.android.synthetic.main.item_my_function.view.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.support.v4.startActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel


/**
 *@创建者wwy
 *@创建时间 2020/7/8 11:46
 *@描述
 */
class MyHomePageFragment : BaseVMFragment<MyHomePageViewModel>(), OnLazyClickListener {
    private var functions = ArrayList<MyFunction>()
    private var functionAdapter = FunctionAdapter()
    override fun setLayoutResId(): Int = R.layout.fragment_my_home_page
    override fun initVM(): MyHomePageViewModel = getViewModel()

    override fun startObserve() {
        mViewModel.run {
            userLiveData.observe(viewLifecycleOwner, Observer {
                it?.let { user ->
                    tvLoginImmediately.text = user.publicName
                    activity?.let { activity ->
                        tvUserId.text = String.format(activity.text(R.string.user_id), user.id)
                    }
                }
                tvUserId.visibility = if (it == null) View.GONE else View.VISIBLE
            })
        }
    }


    override fun initView() {
        rvMyFunction.apply {
            adapter = functionAdapter
        }
        LiveEventBus.get(MY_PAGE_SET_THEME_COLOR).observe(this, Observer {
            val colorRes = it as Int
            immersionBar { statusBarColor(colorRes) }
            myHomePageNv.setNavigationBarBackgroundColor(colorRes)
            activity?.let { activity ->
                rlUser.backgroundColor = activity.color(colorRes)
            }
        })
        tvLoginImmediately.setOnClickListener(this)
        functionAdapter.setOnItemClickListener { _, view, position ->
            when (position) {
                0 -> {//我的分享
                }
                1 -> {//我的收藏
                }
                2 -> {//我的酷图
                }
                3 -> {//我的工具
                }
                4 -> {//主题
                    startActivity<MyThemeActivity>()
                }
                5 -> {//夜间模式
                    when (getNightMode()) {
                        AppCompatDelegate.MODE_NIGHT_YES -> {//夜间模式
                            setNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            (activity as MainActivity).delegate.localNightMode =
                                AppCompatDelegate.MODE_NIGHT_NO
                        }
                        AppCompatDelegate.MODE_NIGHT_NO -> {
                            setNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            (activity as MainActivity).delegate.localNightMode =
                                AppCompatDelegate.MODE_NIGHT_YES
                        }
                    }
                }
                6 -> {//开源协议
                }
                7 -> {//项目主页
                    startActivity<DetailActivity>(
                        DetailActivity.PARAM_ARTICLE to Article(
                            title = (view as TextView).text.toString(),
                            link = "https://github.com/wwy863399246/WanAndroid"
                        )
                    )
                }
            }
        }
    }

    override fun initData() {
        activity?.let {
            functions.add(MyFunction(R.drawable.ic_outline_share, it.text(R.string.my_share)))
            functions.add(MyFunction(R.drawable.ic_my_collect, it.text(R.string.my_collect)))
            functions.add(MyFunction(R.drawable.ic_ku_tu, it.text(R.string.my_ku_tu)))
            functions.add(MyFunction(R.drawable.ic_my_tool, it.text(R.string.my_tool)))
            functions.add(MyFunction(R.drawable.ic_theme, it.text(R.string.theme)))
            functions.add(
                MyFunction(
                    R.drawable.ic_night_model,
                    it.text(if (getNightMode() == AppCompatDelegate.MODE_NIGHT_NO) R.string.nigh_mode else R.string.light_mode)
                )
            )
            functions.add(
                MyFunction(
                    R.drawable.ic_open_source_licenses,
                    it.text(R.string.open_source_licenses)
                )
            )
            functions.add(
                MyFunction(
                    R.drawable.ic_project_home_page,
                    it.text(R.string.project_home_page)
                )
            )
            functionAdapter.setList(functions)
        }

    }

    override fun onLazyClick(v: View) {
        when (v.id) {
            R.id.tvLoginImmediately -> {
                startActivity<LoginActivity>()
            }
            R.id.tvMyIntegral -> {
            }
            R.id.tvMyIntegralRanking -> {
            }
        }
    }

    class FunctionAdapter :
        BaseQuickAdapter<MyFunction, BaseViewHolder>(R.layout.item_my_function) {
        override fun convert(holder: BaseViewHolder, item: MyFunction) {
            holder.apply {
                itemView.apply {
                    tvItemFunction.setCompoundDrawablesWithIntrinsicBounds(0, item.drawable, 0, 0)
                    tvItemFunction.text = item.functionName
                }
            }
        }

    }


}