package com.ananananzhuo.mvvn

import android.content.Intent
import android.widget.ImageView
import com.ananananzhuo.mvvm.activity.CustomAdapterActivity
import com.ananananzhuo.mvvm.bean.bean.ItemData
import com.ananananzhuo.mvvm.callback.CallData
import com.ananananzhuo.mvvm.callback.Callback
import com.ananananzhuo.mvvm.callback.ImageCallback
import com.ananananzhuo.mvvm.utils.logEE

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
            }){
                logEE(it.itemData.title)
            },
            ItemData("单条item的activity"){
                startActivity(Intent(this,SingleItemPageActivity::class.java))
            }

        )
    }

    override fun showFirstItem(): Boolean {
        return true
    }
}