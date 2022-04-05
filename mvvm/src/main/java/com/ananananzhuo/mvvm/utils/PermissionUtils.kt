package com.broaddeep.flow.utils

import android.app.Activity
import android.content.pm.PackageManager

object PermissionUtils {
    /**
     * 是否有多项权限
     */
    fun hasPermissions(activity:Activity,permissions:Array<String>): Boolean {
        val pm: PackageManager = activity.packageManager
        var hasPermission = true
        permissions.forEach {
            if (PackageManager.PERMISSION_GRANTED != pm.checkPermission(it, activity.packageName)){
                hasPermission = false
            }
        }
        return hasPermission
    }
}