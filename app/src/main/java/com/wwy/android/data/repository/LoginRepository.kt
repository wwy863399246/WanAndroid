package com.wwy.android.data.repository

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.User
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.db.AppDatabase
import com.wwy.android.data.repository.datasource.RemoteDataSource
import com.wwy.android.ext.setLoginState
import com.wwy.android.util.ListModel

/**
 *@创建者wwy
 *@创建时间 2019/10/25 10:43
 *@描述
 */
class LoginRepository(private val remoteDataSource: RemoteDataSource) {
    private val userDao = AppDatabase.getInstance().userDao()
    suspend fun login(
        username: String,
        password: String,
        listModel: MutableLiveData<ListModel<Int>>?
    ) {
        listModel?.postValue(ListModel(showLoading = true))
        val result = remoteDataSource.login(username, password)
        if (result is ResultData.Success) {
            setLoggedInUser(result.data)
            listModel?.postValue(ListModel(showLoading = false, showEnd = true))
        } else if (result is ResultData.ErrorMessage) {
            listModel?.postValue(ListModel(showLoading = false, showError = result.message))
        }
    }

    private suspend fun setLoggedInUser(loggedInUser: User?) {
        userDao.deleteAll()
        userDao.insert(loggedInUser)
        setLoginState(true)
    }

    suspend fun register(
        username: String,
        password: String,
        repassword: String,
        listModel: MutableLiveData<ListModel<Int>>?
    ) {
        listModel?.postValue(ListModel(showLoading = true))
        val result = remoteDataSource.register(username, password, repassword)
        if (result is ResultData.Success) {
            setLoggedInUser(result.data)
            listModel?.postValue(ListModel(showLoading = false, showEnd = true))
        } else if (result is ResultData.ErrorMessage) {
            listModel?.postValue(ListModel(showLoading = false, showError = result.message))
        }
    }
}