package com.wwy.android.ext

import com.tencent.mmkv.MMKV
import com.wwy.android.R

/**
 *@创建者wwy
 *@创建时间 2020/7/15 20:25
 *@描述
 */
const val THEME = "theme"
fun setAppTheme(theme: Int) {
    MMKV.defaultMMKV().putInt(THEME, theme)
}

fun getAppTheme(): Int {
    return MMKV.defaultMMKV().getInt(THEME, R.style.AppTheme)
}