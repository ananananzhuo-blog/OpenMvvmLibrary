package com.ananananzhuo.mvvm.bean.bean

import android.content.Context
import android.graphics.Color
import android.view.View
import com.ananananzhuo.mvvm.R
import com.ananananzhuo.mvvm.callback.CallData
import com.ananananzhuo.mvvm.callback.Callback
import com.ananananzhuo.mvvm.view.recycle.CustomAdapter

/**
 * author  :mayong
 * function:RecycleView的适配数据
 * date    :2021/7/4
 **/
data class ItemData(
    var title: String,
    var content: String = "",
    var icon: Int = R.drawable.apple,
    val itemTextColor: Int = Color.BLACK,//文字颜色
    val activity: Class<*>? = null,//将要跳转的activity
    val callback: Callback?=null,
    val callData: CallData=CallData(),
    var adapter: CustomAdapter?=null,
    var showIcon:Boolean =true
){
    init {
        callData.itemData=this
    }

    /**
     * 刷新适配器
     */
    fun notifyDataSetChange(){
        adapter?.notifyDataSetChanged()
    }
}

