package com.wwy.android.ext

import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.wwy.android.app.MyApplication

/**
 *@创建者wwy
 *@创建时间 2020/8/12 0012 上午 11:15
 *@描述
 */
object CookieClass {
    /**Cookie*/
    val cookiePersistor = SharedPrefsCookiePersistor(MyApplication.CONTEXT)
    val cookieJar = PersistentCookieJar(SetCookieCache(), cookiePersistor)
    /**清除Cookie*/
    fun clearCookie() = cookieJar.clear()

    /**是否有Cookie*/
    fun hasCookie() = cookiePersistor.loadAll().isNotEmpty()
}