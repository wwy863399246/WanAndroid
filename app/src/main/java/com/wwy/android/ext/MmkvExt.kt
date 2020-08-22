package com.wwy.android.ext

import androidx.appcompat.app.AppCompatDelegate
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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
private const val SAVE_NIGHT_MODE = "save_night_mode"
private const val IS_CHECK = "is_check"
private const val KEY_SEARCH_HISTORY = "searchHistory"
private val mGson by lazy { Gson() }
fun setAppTheme(theme: Int) {
    MMKV.defaultMMKV().putInt(THEME, theme)
}

fun getAppTheme(): Int {
    return MMKV.defaultMMKV().getInt(THEME, R.style.AppTheme)
}

fun setIsCheck(isChect: Boolean) {
    MMKV.defaultMMKV().putBoolean(IS_CHECK, isChect)
}

fun isCheck(): Boolean {
    return MMKV.defaultMMKV().getBoolean(IS_CHECK, false)
}

fun setNightMode(theme: Int) {
    MMKV.defaultMMKV().putInt(KEY_NIGHT_MODE, theme)
}

fun getNightMode(): Int {
    return MMKV.defaultMMKV().getInt(KEY_NIGHT_MODE, AppCompatDelegate.MODE_NIGHT_NO)
}

fun saveLastNightMode(theme: Int) {
    MMKV.defaultMMKV().putInt(SAVE_NIGHT_MODE, theme)
}

fun getLastNightMode(): Int {
    return MMKV.defaultMMKV().getInt(SAVE_NIGHT_MODE, AppCompatDelegate.MODE_NIGHT_NO)
}

fun setLoginState(isLogin: Boolean) {
    MMKV.defaultMMKV().putBoolean(LOGIN_STATE, isLogin)
}

fun getLoginState(): Boolean {
    return MMKV.defaultMMKV().getBoolean(LOGIN_STATE, false)
}

fun saveSearchHistoryData(words: String) {
    val history = getSearchHistoryData()
    if (history.contains(words)) {
        history.remove(words)
    }
    history.add(0, words)
    val listStr = mGson.toJson(history)
    MMKV.defaultMMKV().putString(KEY_SEARCH_HISTORY, listStr)
}

fun getSearchHistoryData(): MutableList<String> {
    val listStr = MMKV.defaultMMKV().getString(KEY_SEARCH_HISTORY, "")
    return if (listStr.isNullOrEmpty()) {
        mutableListOf()
    } else {
        mGson.fromJson<MutableList<String>>(
            listStr,
            object : TypeToken<MutableList<String>>() {}.type
        )
    }
}

fun deleteSearchHistoryData(words: String) {
    val history = getSearchHistoryData()
    history.remove(words)
    val listStr = mGson.toJson(history)
    MMKV.defaultMMKV().putString(KEY_SEARCH_HISTORY, listStr)
}