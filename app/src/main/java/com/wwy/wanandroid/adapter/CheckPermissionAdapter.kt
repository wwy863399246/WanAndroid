package com.wwy.wanandroid.adapter

import android.app.AlertDialog
import android.content.DialogInterface
import com.qw.soul.permission.SoulPermission
import com.qw.soul.permission.bean.Permission
import com.qw.soul.permission.callbcak.CheckRequestPermissionListener
import java.util.*

/**
 *@创建者wwy
 *@创建时间 2019/10/10 11:36
 *@描述 权限
 */
abstract class CheckPermissionAdapter : CheckRequestPermissionListener {

    override fun onPermissionDenied(permission: Permission?) {
        val activity = SoulPermission.getInstance().topActivity
        activity?.let {
            val permissionNameDesc = permission?.permissionNameDesc
            val alertDialog = AlertDialog.Builder(activity).setTitle("提示").setMessage(permissionNameDesc)
                .setPositiveButton(
                    "设置"
                ) { _, _ -> SoulPermission.getInstance().goApplicationSettings() }
            alertDialog.create().show()

        }
    }
}