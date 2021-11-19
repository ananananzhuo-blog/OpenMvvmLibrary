package com.ananananzhuo.mvvm.activity

import com.ananananzhuo.mvvm.bean.bean.ItemData
import com.ananananzhuo.mvvm.callback.CallData

/**
 * author  :mayong
 * function:只包含一条item的activity
 * date    :2021/9/19
 **/
abstract class SingleItemActivity : CustomAdapterActivity() {
    abstract var title: String
    abstract var callback: (callData: CallData) -> Unit

    override fun getAdapterDatas(): MutableList<ItemData> = mutableListOf(
        ItemData(title = title,lamCallback = callback)
    )

    override fun showFirstItem(): Boolean = false
}