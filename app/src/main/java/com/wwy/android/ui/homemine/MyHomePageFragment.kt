package com.wwy.android.ui.homemine

import android.app.UiModeManager
import android.content.Context
import android.content.DialogInterface
import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gyf.immersionbar.ktx.immersionBar
import com.jeremyliao.liveeventbus.LiveEventBus
import com.wwy.android.R
import com.wwy.android.adapter.ReadHistoryAdapter
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.MyFunction
import com.wwy.android.ext.*
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.ui.homemine.activity.*
import com.wwy.android.ui.main.DetailActivity
import com.wwy.android.ui.main.MainActivity
import com.wwy.android.ui.member.LoginActivity
import com.wwy.android.util.clearCache
import com.wwy.android.util.getCacheSize
import com.wwy.android.view.rippleAnimation.RippleAnimation
import com.wwy.android.vm.MyHomePageViewModel
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.fragment_my_home_page.*
import kotlinx.android.synthetic.main.fragment_my_home_page.tvLoginImmediately
import kotlinx.android.synthetic.main.item_my_function.view.*
import kotlinx.android.synthetic.main.item_theme.view.*
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.Appcompat
import org.jetbrains.anko.support.v4.alert
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
    private var readHistoryAdapter = ReadHistoryAdapter()
    override fun setLayoutResId(): Int = R.layout.fragment_my_home_page
    override fun initVM(): MyHomePageViewModel = getViewModel()

    override fun startObserve() {
        mViewModel.run {
            userLiveData.observe(viewLifecycleOwner, Observer {
                it?.let { user ->
                    tvUserName.text = user.publicName
                    activity?.let { activity ->
                        tvUserId.text = String.format(activity.text(R.string.user_id), user.id)
                    }
                }
                tvUserId.isVisible = it != null
                tvUserName.isVisible = it != null
                tvLoginImmediately.isVisible = it == null
            })
            readHistory.observe(viewLifecycleOwner, Observer {
                it?.let {
                    readHistoryAdapter.setList(if (it.size >= 5) it.subList(0, 5) else it)
                }
                readHistoryRv.isVisible = !it.isNullOrEmpty()
                tvNoBrowsingHistory.isVisible = it.isNullOrEmpty()
                ivMoreReadHistory.isVisible = !it.isNullOrEmpty()
            })
        }
    }


    override fun initView() {
        ivMoreReadHistory.clickWithTrigger {
            startActivity<ReadHistoryActivity>()
        }
        rvMyFunction.apply {
            adapter = functionAdapter
        }
        readHistoryRv.apply {
            adapter = readHistoryAdapter.apply {
                setOnItemClickListener { _, _, position ->
                    startActivity<DetailActivity>(DetailActivity.PARAM_ARTICLE to data[position])
                }
            }
        }
        LiveEventBus.get(MY_PAGE_SET_THEME_COLOR).observe(this, Observer {
            val colorRes = it as Int
            immersionBar { statusBarColor(colorRes) }
            myHomePageNv.setNavigationBarBackgroundColor(colorRes)
            activity?.let { activity ->
                rlUser.backgroundColor = activity.color(colorRes)
            }
        })
        myHomePageNv.ivRightNavigationBarOne.clickWithTrigger {
            startActivity<SettingActivity>()
        }
        tvLoginImmediately.setOnClickListener(this)
        tvMyIntegral.setOnClickListener(this)
        tvMyIntegralRanking.setOnClickListener(this)
        functionAdapter.setOnItemClickListener { _, view, position ->
            when (position) {
                0 -> {//我的分享
                    activity?.checkLogin {
                        startActivity<MyShareListActivity>()
                    }
                }
                1 -> {//我的收藏
                    activity?.checkLogin {
                        startActivity<MyCollectListActivity>()
                    }
                }
                2 -> {//我的酷图
                    startActivity<MyKuTuActivity>()
                }
                3 -> {//我的工具
                    startActivity<DetailActivity>(
                        DetailActivity.PARAM_ARTICLE to Article(
                            title = (view as TextView).text.toString(),
                            link = "https://www.wanandroid.com/tools"
                        )
                    )
                }

                4 -> {//主题
                    startActivity<MyThemeActivity>()
                }
                5 -> {//夜间模式
                    when (getNightMode()) {
                        UiModeManager.MODE_NIGHT_YES -> {//夜间模式
                            setNightMode(UiModeManager.MODE_NIGHT_NO)
                            saveLastNightMode(UiModeManager.MODE_NIGHT_NO)
                            (activity?.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager).nightMode =
                                UiModeManager.MODE_NIGHT_NO
                            LiveEventBus.get(SET_THEME).post("")
                        }
                        UiModeManager.MODE_NIGHT_NO -> {
                            setNightMode(UiModeManager.MODE_NIGHT_YES)
                            saveLastNightMode(UiModeManager.MODE_NIGHT_YES)
                            (activity?.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager).nightMode =
                                UiModeManager.MODE_NIGHT_YES
                            LiveEventBus.get(SET_THEME).post("")
                        }
                        UiModeManager.MODE_NIGHT_AUTO -> {
                            activity?.let {
                                val dialog = AlertDialog.Builder(it)
                                    .setMessage(R.string.confirm_night_mode_form_system)
                                    .setPositiveButton(R.string.confirm) { _, _ ->
                                        when (getLastNightMode()) {
                                            UiModeManager.MODE_NIGHT_YES -> {//夜间模式
                                                setNightMode(UiModeManager.MODE_NIGHT_NO)
                                                saveLastNightMode(UiModeManager.MODE_NIGHT_NO)
                                                (activity?.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager).nightMode =
                                                    UiModeManager.MODE_NIGHT_NO
                                            }
                                            UiModeManager.MODE_NIGHT_NO -> {
                                                setNightMode(UiModeManager.MODE_NIGHT_YES)
                                                saveLastNightMode(UiModeManager.MODE_NIGHT_YES)
                                                (activity?.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager).nightMode =
                                                    UiModeManager.MODE_NIGHT_YES
                                            }
                                        }
                                        LiveEventBus.get(SET_THEME).post("")
                                    }
                                    .setNegativeButton(R.string.cancel) { _, _ -> }
                                    .show()
                                dialog.getButton(AlertDialog.BUTTON_POSITIVE).textColor = it.color(
                                    TypedValue().resourceId(R.attr.colorAccent, it.theme)
                                )
                                dialog.getButton(DialogInterface.BUTTON_NEGATIVE).textColor =
                                    it.color(
                                        TypedValue().resourceId(R.attr.colorAccent, it.theme)
                                    )
                            }
//                            alert(R.string.confirm_night_mode_form_system) {
//                                yesButton {
//
//                                }
//                                noButton {}
//                            }.show()
                        }
                    }

                }
                6 -> {//开源协议
                    startActivity<DetailActivity>(
                        DetailActivity.PARAM_ARTICLE to Article(
                            title = (view as TextView).text.toString(),
                            link = "https://github.com/wwy863399246/WanAndroid/blob/master/LICENSE"
                        )
                    )

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

    override fun onResume() {
        super.onResume()
        if (isCheck()) {
            LiveEventBus.get(SET_THEME).post("")
            setIsCheck(false)
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
                    if (getLastNightMode() == UiModeManager.MODE_NIGHT_NO) R.drawable.ic_night_model else R.drawable.ic_outline_wb_sunny_24,
                    it.text(if (getLastNightMode() == UiModeManager.MODE_NIGHT_NO) R.string.nigh_mode else R.string.light_mode)
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
                activity?.checkLogin {
                    startActivity<MyPointActivity>()
                }
            }
            R.id.tvMyIntegralRanking -> {
                activity?.checkLogin {
                    startActivity<PointRankingActivity>()
                }
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