package com.ananananzhuo.mvvm.bean.bean

import android.content.Context
import android.graphics.Color
import android.view.View
import com.ananananzhuo.mvvm.R

/**
 * author  :mayong
 * function:RecycleView的适配数据
 * date    :2021/7/4
 **/
data class ItemData(
    var title: String,
    val callback: View.OnClickListener,
    var content: String = "",
    var icon: Int = R.drawable.apple,
    val itemTextColor: Int = Color.BLACK,//文字颜色
    val activity: Class<*>? = null//将要跳转的activity
)