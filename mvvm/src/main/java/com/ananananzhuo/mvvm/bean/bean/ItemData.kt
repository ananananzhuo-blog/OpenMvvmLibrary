package com.ananananzhuo.mvvm.bean.bean

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import com.ananananzhuo.mvvm.R
import com.ananananzhuo.mvvm.callback.CallData
import com.ananananzhuo.mvvm.callback.Callback
import com.ananananzhuo.mvvm.callback.ImageCallback
import com.ananananzhuo.mvvm.view.recycle.CustomAdapter
import kotlin.jvm.functions.FunctionN

/**
 * author  :mayong
 * function:RecycleView的适配数据
 * date    :2021/7/4
 **/
data class ItemData(
    var title: String,
    var icon: Int = R.drawable.apple,
    val itemTextColor: Int = Color.BLACK,//文字颜色
    val activity: Class<*>? = null,//将要跳转的activity
    val callback: Callback?=null,//点击回调
    val callData: CallData=CallData(),
    var adapter: CustomAdapter?=null,//适配器
    var showIcon:Boolean =true,//是否展示第一条的Imageview图片
    var content: String = "",//不为空就展示Textview
    val ivCallback:ImageCallback?=null//有回调就展示Imageview
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

