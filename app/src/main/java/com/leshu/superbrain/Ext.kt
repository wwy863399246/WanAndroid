package com.leshu.superbrain

import android.provider.ContactsContract
import android.content.Intent
import com.leshu.superbrain.adapter.CheckPermissionAdapter
import android.Manifest.permission
import com.qw.soul.permission.SoulPermission
import android.app.Activity
import android.content.Context
import android.content.pm.PackageInfo
import android.view.View
import androidx.core.content.ContextCompat
import com.qw.soul.permission.bean.Permission


/**
 *@创建者wwy
 *@创建时间 2019/11/14 10:03
 *@描述
 */
const val SOPHIX_APP_KEY = "28257014"
const val SOPHIX_APP_SECRET = "6926d6a9d07815626a8affa25f9954de"
const val SOPHIX_RSA_SECRET ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDWxCpSu1QXDOVX+jN9OeeeZAzGziynIfwTvRSwBpA3xJVlIzmOEzD0PnoxKrKgoYLRgBUH7YdRaqs9iJTf+ImYD3JLgLbzj1Fio2i2iefxgTyIrS5IL5bHiWaXozUAToTz9Twk1fWwqlXMgdxPvM4yineamKe4ZDkaUTj6SUGyEjRTcgZ+e+uJ3cWsAD7TvDDbjEcHph0LChFsVBsNuUCX1973uaB/y3hxR7Lub7VyJFZx+NtxlZmD1LE8PpQvuybefFOr+GKhviXBJzK8nRefyxRx752Non8es/iCiZlGcrzbIq2SwExyCEU2fRjJ3ukHwDe2STIEPvQ4yDfOybRfAgMBAAECggEATKf380+p1BBmS+CiQDBK294aMVul1IHs157Fo460KzOfn1nTUULIVmV2d9Ylq+/6IYz19L5zbjwEoxH9EXREqGHbCdgHdSfShMKOvZi7kRfv41jtDBbwWohQdg9q+5ELI4iEzyEPcN9bgINZf5yEfMWvqx6Rvt8HAr26+JrtOAFf/meenIOeWgLjbf9Y+n1f53sUM/kxVIEAfOU7kDxJUZBC4+PSlNTmy18zA1Nv3SxMj6Grupf3dabk6FKM2+shLKPOsb0QlYtR46dUdlyMO+g+dKdT0V6Ipc7RtMiKxLQJ+G3q1quHOZZlrpeA5ahFhmZ0eGYRFkOmlNvfSUpHAQKBgQDvvfe7vd+BZ22SUY+9EoRSWkiLAuAVkYL7dSwXj3DIucJmyXALraYzaQBVvtkyHb4BPX9f2rOeelHEYpLNfzf50xO8xEaFGKhX/uN388YYRlv1RQ3eIqsC4SGH/Tm4i4mbCJnjR4wp/nBw2wJ+Ki2tCKLbgT+mS97N6Q9jqJsM4wKBgQDlVJs+czD1MSIiAihJyhQ1pyRDYiG5lEr4kjwO0Kull8NML0O7bIESP+VTAJcA3x98H051U5pXV6ANQLmNcp0fegTVAXs1O7wR4o7Cg6nK5rFfS/ye7b4d/OCgz0StGuFEWzQBOcx/My5s/gFDdCqiGIxubi42qRb9xQONWehvVQKBgGG0ZQMhdbZSRYiNLuxaYI0DeG8W4+ZGYEBE14xejBNyCTVEwSIxSfvHvjgzyGaxUl9FBeU1x2A975b+qV+QimqJSJD02NyjWPBL075uHfyEqDOESguOy20n/TdjzyNT0ufZEIZdAVWX+ZE04IY0gFr1mxGkUiFe6FW4tunhrBcLAoGBANgULepbswdz8gtFKRzNsNkU0VBESC6JkVJAxyHWb8SpCDTiW9le1QaS+cqJRb5mfU4AWXam/UfKol2aXLrwASfFWoQwzxxLWlsnsweH8xXg48M835wHuhibSjN61+Sa7SHxJUD6arp3SQkdE6ew7vKoWrk6S4TpMWaOmVg4HI+5AoGBANnu060lP7J5sD2+M70MXHhYiSdZDjB3P5U+wHryW6D8KAliqWbL0zQOb3AxITGUuKUwmn3g15BqGkWH+XAzyo9Jddee7Fd2tZC4oPSTiMOdUJNRyHn+/xzwFeN2SxWc+3oMA237E0L6MG6me2NXB3Exbjgs6Uw+wBjPTbnanNz9"
const val NEED_RESTART = "need_restart"//需要重启
const val NO_PATCH = "no_patch"//没有补丁
const val DOWN_PATCH = "down_patch"//补丁下载中
fun chooseContact(activity: Activity, requestCode: Int) {
    SoulPermission.getInstance().checkAndRequestPermission(
        permission.READ_PHONE_STATE,
        object : CheckPermissionAdapter() {
            override fun onPermissionOk(permission: Permission) {
                activity.startActivityForResult(Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI), requestCode)
            }
        })
}
fun Context.packageInfo(): PackageInfo = this.packageManager.getPackageInfo(this.packageName, 0)
//扩展函数
fun Context.color(colorRes: Int) = ContextCompat.getColor(this, colorRes)

fun View.color(colorRes: Int) = context.color(colorRes)