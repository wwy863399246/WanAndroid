package com.wwy.android.ext

import android.app.Activity
import android.content.Context
import android.content.pm.PackageInfo
import android.content.res.Resources
import android.util.TypedValue
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.annotation.NavigationRes
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.wwy.android.app.MyApplication
import com.wwy.android.ui.member.LoginActivity
import org.jetbrains.anko.startActivity
import java.text.SimpleDateFormat
import java.util.*


/**
 *@创建者wwy
 *@创建时间 2019/11/14 10:03
 *@描述
 */
const val SET_THEME = "set_theme"
const val MY_PAGE_SET_THEME_COLOR = "my_page_set_theme_color"
const val HOME_PAGE_CUT = "home_page_cut"
const val MAIN_PLAZA_CUT = "main_plaza_cut"
const val UPDATE_COLLECT_STATE = "update_collect_state"

//获取包名
fun Context.packageInfo(): PackageInfo = this.packageManager.getPackageInfo(this.packageName, 0)

//获取颜色
fun Context.color(colorRes: Int) = ContextCompat.getColor(this, colorRes)
fun View.color(colorRes: Int) = context.color(colorRes)
//设置颜色
fun Context.text(textRes: Int) = this.resources.getString(textRes)
fun View.text(textRes: Int) = context.text(textRes)

//获取主题属性id
fun TypedValue.resourceId(resId: Int, theme: Resources.Theme): Int {
    theme.resolveAttribute(resId, this, true)
    return this.resourceId
}

//加载子布局
fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToRoot: Boolean = true): View {
    if (layoutId == -1) {
        return this
    }
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

inline fun <reified T : ViewModel> NavController.viewModel(@NavigationRes navGraphId: Int): T {
    val storeOwner = getViewModelStoreOwner(navGraphId)
    return ViewModelProvider(storeOwner)[T::class.java]
}

fun String?.htmlToSpanned() =
    if (this.isNullOrEmpty()) "" else HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY)

/***
 * 设置延迟时间的View扩展
 * @param delay Long 延迟时间，默认600毫秒
 * @return T
 */
fun <T : View> T.withTrigger(delay: Long = 600): T {
    triggerDelay = delay
    return this
}

/***
 * 点击事件的View扩展
 * @param block: (T) -> Unit 函数
 * @return Unit
 */
fun <T : View> T.click(block: (T) -> Unit) = setOnClickListener {
    block(it as T)
}

/***
 * 带延迟过滤的点击事件View扩展
 * @param delay Long 延迟时间，默认600毫秒
 * @param block: (T) -> Unit 函数
 * @return Unit
 */
fun <T : View> T.clickWithTrigger(time: Long = 600, block: (T) -> Unit) {
    triggerDelay = time
    setOnClickListener {
        if (clickEnable()) {
            block(it as T)
        }
    }
}

private var <T : View> T.triggerLastTime: Long
    get() = if (getTag(1123460103) != null) getTag(1123460103) as Long else -601
    set(value) {
        setTag(1123460103, value)
    }

private var <T : View> T.triggerDelay: Long
    get() = if (getTag(1123461123) != null) getTag(1123461123) as Long else 600
    set(value) {
        setTag(1123461123, value)
    }

private fun <T : View> T.clickEnable(): Boolean {
    var flag = false
    val currentClickTime = System.currentTimeMillis()
    if (currentClickTime - triggerLastTime >= triggerDelay) {
        flag = true
    }
    triggerLastTime = currentClickTime
    return flag
}

/***
 * 带延迟过滤的点击事件监听，见[View.OnClickListener]
 * 延迟时间根据triggerDelay获取：600毫秒，不能动态设置
 */
interface OnLazyClickListener : View.OnClickListener {

    override fun onClick(v: View?) {
        if (v?.clickEnable() == true) {
            onLazyClick(v)
        }
    }

    fun onLazyClick(v: View)
}

/**
 * 设置Activity的亮度
 * @param [brightness] 0 ~ 1
 */
fun Activity.setBrightness(brightness: Float) {
    val attributes = window.attributes
    attributes.screenBrightness = brightness
    window.attributes = attributes
}

/**
 * 弹出软键盘
 */
fun View.showSoftInput() {
    requestFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

/**
 * 隐藏软键盘
 */
fun View.hideSoftInput() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun Long.toDateTime(pattern: String): String =
    SimpleDateFormat(pattern, Locale.getDefault()).format(this)

/**
 * 是否登录，如果登录了就执行then，没有登录就直接跳转登录界面
 * @return true-已登录，false-未登录
 */
fun Context.checkLogin(then: (() -> Unit)? = null): Boolean {
    return if (isLogin()) {
        then?.invoke()
        true
    } else {
        this.startActivity<LoginActivity>()
        false
    }
}

fun isLogin(): Boolean = getLoginState() && CookieClass.hasCookie()