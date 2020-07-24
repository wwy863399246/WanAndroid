package com.wwy.android.data.db

import androidx.room.*
import com.wwy.android.data.bean.User
import kotlinx.coroutines.flow.Flow

/**
 *@创建者wwy
 *@创建时间 2020/7/24 10:58
 *@描述
 */
@Dao
interface UserDao {
    //插入所有
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User?)

    //获取User
    @Query("SELECT * FROM User")
    fun loadUserBean(): Flow<User?>

    //获取id
    @Query("SELECT user_id FROM User")
    fun loadUid(): Int

    //获取用户公开name
    @Query("SELECT user_public_name FROM User")
    fun loadPublicName(): String

    //设置publicName
    @Query("UPDATE User SET user_public_name= :publicName")
    fun setPublicName(publicName: String): Int

    //通过id设置publicName 适合多账户
    @Query("UPDATE User SET user_public_name= :publicName WHERE user_id = :uid")
    fun setPublicNameByUid(publicName: String, uid: Int): Int

    //删除全部数据
    @Query("DELETE FROM User")
    fun deleteAll()

    //通过id删除全部数据 适合多账户
    @Query("DELETE FROM User WHERE user_id = :uid")
    fun deleteAll(uid: Int)

    //更新用户信息
    @Update
    fun updateUsers(vararg users: User?)
}