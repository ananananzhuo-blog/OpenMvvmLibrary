package com.ananananzhuo.mvvn

import android.widget.ImageView
import com.ananananzhuo.mvvm.activity.CustomAdapterActivity
import com.ananananzhuo.mvvm.bean.bean.ItemData
import com.ananananzhuo.mvvm.callback.CallData
import com.ananananzhuo.mvvm.callback.Callback
import com.ananananzhuo.mvvm.callback.ImageCallback

class MainActivity : CustomAdapterActivity() {

    override fun getAdapterDatas(): MutableList<ItemData> {
        return  mutableListOf(
            ItemData("哈哈", callback = object : Callback {
                override fun callback(callData: CallData) {
                    callData.itemData.content =
                        "哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥"
                    callData.itemData.notifyDataSetChange()
                }
            },ivCallback = object :ImageCallback{
                override fun showIv(iv: ImageView) {
                    iv.setImageResource(R.drawable.apple)
                }
            })
        )
    }

    override fun showFirstItem(): Boolean {
        return true
    }
}