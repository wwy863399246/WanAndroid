package com.wwy.android.ext

import androidx.appcompat.app.AppCompatDelegate
import com.tencent.mmkv.MMKV
import com.wwy.android.R

/**
 *@创建者wwy
 *@创建时间 2020/7/15 20:25
 *@描述
 */
private const val THEME = "theme"
private const val LOGIN_STATE = "login_state"
private const val KEY_NIGHT_MODE = "key_night_mode"
fun setAppTheme(theme: Int) {
    MMKV.defaultMMKV().putInt(THEME, theme)
}

fun getAppTheme(): Int {
    return MMKV.defaultMMKV().getInt(THEME, R.style.AppTheme)
}

fun setNightMode(theme: Int) {
    MMKV.defaultMMKV().putInt(KEY_NIGHT_MODE, theme)
}

fun getNightMode(): Int {
    return MMKV.defaultMMKV().getInt(KEY_NIGHT_MODE, AppCompatDelegate.MODE_NIGHT_NO)
}

fun setLoginState(isLogin: Boolean) {
    MMKV.defaultMMKV().putBoolean(LOGIN_STATE, isLogin)
}

fun getLoginState(): Boolean {
    return MMKV.defaultMMKV().getBoolean(LOGIN_STATE, false)
}