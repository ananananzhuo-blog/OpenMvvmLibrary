package com.ananananzhuo.mvvm.callback

import android.view.View
import com.ananananzhuo.mvvm.bean.bean.ItemData

/**
 * author  :mayong
 * function:
 * date    :2021/7/28
 **/
interface Callback {
    fun callback(callData: CallData)
}

class CallData{
    lateinit var itemData:ItemData
    var onClickListener:View.OnClickListener?=null
}