package com.ananananzhuo.mvvm.utils

import android.accessibilityservice.AccessibilityServiceInfo
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.provider.Settings
import android.view.accessibility.AccessibilityManager

/**
 * author  :mayong
 * function:辅助服务相关类
 * date    :2022/3/26
 **/
class AccessibilityUtils {

    /**
     * 判断辅助服务是否开启
     * @param service 辅助服务对应的Service
     */
    fun isAccessibilityServiceEnabled(
        context: Context,
        service: Class<*>,
        ): Boolean {
        val am = context.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
        val enabledServices =
            am.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_ALL_MASK)
        for (enabledService in enabledServices) {
            val enabledServiceInfo: ServiceInfo = enabledService.resolveInfo.serviceInfo
            if (enabledServiceInfo.packageName.equals(context.packageName) && enabledServiceInfo.name.equals(service.name)) return true
        }
        return false
    }

    /**
     * 申请辅助服务权限
     */
    fun applyAccessibilityPermission(context: Context){
        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        context.startActivity(intent)
    }
}