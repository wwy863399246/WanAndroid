package com.wwy.android.ui.main

import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import android.view.ViewGroup
import android.webkit.ConsoleMessage
import android.webkit.WebResourceRequest
import android.webkit.WebView
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.coder.zzq.smartshow.toast.SmartToast
import com.gyf.immersionbar.ktx.immersionBar
import com.jeremyliao.liveeventbus.LiveEventBus
import com.just.agentweb.*
import com.wwy.android.R
import com.wwy.android.data.bean.Article
import com.wwy.android.ext.*
import com.wwy.android.ui.base.BaseVMActivity
import com.wwy.android.ui.member.LoginActivity
import com.wwy.android.util.ActivityHelper
import com.wwy.android.view.loadpage.BasePageViewForStatus
import com.wwy.android.view.loadpage.LoadPageStatus
import com.wwy.android.view.loadpage.LoadPageViewForStatus
import com.wwy.android.view.loadpage.SimplePageViewForStatus
import com.wwy.android.vm.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.view.*
import org.jetbrains.anko.startActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel
import timber.log.Timber

/**
 *@创建者wwy
 *@创建时间 2020/8/10 0010 下午 17:48
 *@描述
 */
class DetailActivity : BaseVMActivity<DetailViewModel>() {

    companion object {
        const val PARAM_ARTICLE = "param_article"
    }

    private lateinit var article: Article
    private lateinit var rootView: LoadPageViewForStatus
    private val pageViewForStatus: BasePageViewForStatus = SimplePageViewForStatus()
    private var agentWeb: AgentWeb? = null
    override fun initVM(): DetailViewModel = getViewModel()
    override fun initImmersionBar() {
        super.initImmersionBar()
        immersionBar {
            titleBar(R.id.detailNv)
        }
    }

    override fun setLayoutId(): Int = R.layout.activity_detail

    override fun initView(savedInstanceState: Bundle?) {
        article = intent?.getParcelableExtra(PARAM_ARTICLE) ?: return
        detailNv.apply {
            tvTitleNavigationBar.text = article.title.htmlToSpanned()
            ivBackNavigationBar.clickWithTrigger {
                ActivityHelper.finish(DetailActivity::class.java)
            }
            ivRightNavigationBarOne.clickWithTrigger {
                ActionFragment.newInstance(article).show(supportFragmentManager)
            }
        }
        if (getNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setBrightness(0.08f)
        }
    }

    override fun startObserve() {
        mViewModel.run {
            collectLiveData.observe(this@DetailActivity, Observer {
                when (it) {
                    0 -> {
                        SmartSnackbar.get(this@DetailActivity).show("添加收藏失败，请重试")
                    }
                    1 -> {//成功
                        SmartSnackbar.get(this@DetailActivity).show("添加收藏成功")
                        article.collect = true
                        LiveEventBus.get(UPDATE_COLLECT_STATE).post(true)
                    }
                }
            })
            unCollectLiveData.observe(this@DetailActivity, Observer {
                when (it) {
                    0 -> {
                        SmartSnackbar.get(this@DetailActivity).show("取消收藏失败，请重试")
                    }
                    1 -> {//成功
                        SmartSnackbar.get(this@DetailActivity).show("取消收藏成功")
                        article.collect = false
                        LiveEventBus.get(UPDATE_COLLECT_STATE).post(false)
                    }
                }
            })
        }
    }

    override fun initData() {
        if (article.id != 0) {
            mViewModel.saveReadHistory(article)
        }
        rootView = pageViewForStatus.getRootView(this) as LoadPageViewForStatus
        rootView.apply {
            pageViewForStatus.convert(this, LoadPageStatus.NoNet)
        }
        agentWeb = AgentWeb.with(this)
            .setAgentWebParent(webContainer, ViewGroup.LayoutParams(-1, -1))
            .useDefaultIndicator(color(R.color.color_on_surface_60), 2)
            .interceptUnkownUrl()
            .setMainFrameErrorView(rootView)
            .setAgentWebWebSettings(AgentWebSettingsImpl.getInstance())
            .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
            .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.DISALLOW)
//            .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)//打开其他应用时，弹窗咨询用户是否前往其他应用
            .setWebChromeClient(object : WebChromeClient() {
                override fun onReceivedTitle(view: WebView?, title: String?) {
                    setTitle(title)
                    super.onReceivedTitle(view, title)
                }

                override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
                    Timber.tag("WanAandroidWebView").d("${consoleMessage?.message()}")
                    return super.onConsoleMessage(consoleMessage)
                }
            })
            .setWebViewClient(object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    return super.shouldOverrideUrlLoading(view, request)
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    view?.loadUrl(customJs(url))
                }
            })
            .createAgentWeb()
            .ready()
            .get()

        agentWeb?.webCreator?.webView?.run {
            overScrollMode = WebView.OVER_SCROLL_NEVER
            settings.run {
                javaScriptCanOpenWindowsAutomatically = false
                loadsImagesAutomatically = true
                useWideViewPort = true
                loadWithOverviewMode = true
//                textZoom = SettingsStore.getWebTextZoom()
            }
        }
        agentWeb?.urlLoader?.loadUrl(article.link)
    }

    /**
     * 加载js，去掉掘金、简书、CSDN等H5页面的Title、底部操作栏，以及部分广告
     */
    private fun customJs(url: String? = article.link): String {
        val js = StringBuilder()
        js.append("javascript:(function(){")
        when (Uri.parse(url).host) {
            "juejin.im" -> {
                js.append("var headerList = document.getElementsByClassName('main-header-box');")
                js.append("if(headerList&&headerList.length){headerList[0].parentNode.removeChild(headerList[0])}")
                js.append("var openAppList = document.getElementsByClassName('open-in-app');")
                js.append("if(openAppList&&openAppList.length){openAppList[0].parentNode.removeChild(openAppList[0])}")
                js.append("var actionBox = document.getElementsByClassName('action-box');")
                js.append("if(actionBox&&actionBox.length){actionBox[0].parentNode.removeChild(actionBox[0])}")
                js.append("var actionBarList = document.getElementsByClassName('action-bar');")
                js.append("if(actionBarList&&actionBarList.length){actionBarList[0].parentNode.removeChild(actionBarList[0])}")
                js.append("var columnViewList = document.getElementsByClassName('column-view');")
                js.append("if(columnViewList&&columnViewList.length){columnViewList[0].style.margin = '0px'}")
            }
            "www.jianshu.com" -> {
                js.append("var jianshuHeader = document.getElementById('jianshu-header');")
                js.append("if(jianshuHeader){jianshuHeader.parentNode.removeChild(jianshuHeader)}")
                js.append("var headerShimList = document.getElementsByClassName('header-shim');")
                js.append("if(headerShimList&&headerShimList.length){headerShimList[0].parentNode.removeChild(headerShimList[0])}")
                js.append("var fubiaoList = document.getElementsByClassName('fubiao-dialog');")
                js.append("if(fubiaoList&&fubiaoList.length){fubiaoList[0].parentNode.removeChild(fubiaoList[0])}")
                js.append("var ads = document.getElementsByClassName('note-comment-above-ad-wrap');")
                js.append("if(ads&&ads.length){ads[0].parentNode.removeChild(ads[0])}")
                js.append("var lazyShimList = document.getElementsByClassName('v-lazy-shim');")
                js.append("if(lazyShimList&&lazyShimList.length&&lazyShimList[0]){lazyShimList[0].parentNode.removeChild(lazyShimList[0])}")
                js.append("if(lazyShimList&&lazyShimList.length&&lazyShimList[1]){lazyShimList[1].parentNode.removeChild(lazyShimList[1])}")
            }
            "blog.csdn.net" -> {
                js.append("var csdnToolBar = document.getElementById('csdn-toolbar');")
                js.append("if(csdnToolBar){csdnToolBar.parentNode.removeChild(csdnToolBar)}")
                js.append("var csdnMain = document.getElementById('main');")
                js.append("if(csdnMain){csdnMain.style.margin='0px'}")
                js.append("var operate = document.getElementById('operate');")
                js.append("if(operate){operate.parentNode.removeChild(operate)}")
            }
        }
        js.append("})()")
        return js.toString()
    }

    private fun setTitle(title: String?) {
        detailNv.tvTitleNavigationBar.text = title
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (agentWeb?.handleKeyEvent(keyCode, event) == true) {
            return true
        } else {
            super.onKeyDown(keyCode, event)
        }
    }

    override fun onPause() {
        agentWeb?.webLifeCycle?.onPause()
        super.onPause()

    }

    override fun onResume() {
        agentWeb?.webLifeCycle?.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        agentWeb?.webLifeCycle?.onDestroy()
        super.onDestroy()
    }


    fun refreshPage() {
        agentWeb?.urlLoader?.reload()
    }

    fun checkLogin(): Boolean {
        if (!mViewModel.isLogin()) {
            startActivity<LoginActivity>()
        }
        return mViewModel.isLogin()
    }

    fun changeCollect() {
        if (article.collect) {
            mViewModel.unCollect(article.id)
        } else {
            mViewModel.collect(article.id)
        }

    }
}