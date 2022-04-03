package com.ananananzhuo.mvvn

import android.content.Intent
import android.widget.ImageView
import android.widget.Toast
import com.ananananzhuo.mvvm.activity.CustomAdapterActivity
import com.ananananzhuo.mvvm.bean.bean.ItemData
import com.ananananzhuo.mvvm.callback.CallData
import com.ananananzhuo.mvvm.callback.Callback
import com.ananananzhuo.mvvm.callback.ImageCallback
import com.ananananzhuo.mvvm.utils.NetCheckUtils
import com.ananananzhuo.mvvm.utils.logEE

class MainActivity : CustomAdapterActivity() {

    override fun getAdapterDatas(): MutableList<ItemData> {
        return mutableListOf(
            ItemData(title = "判断网络是否通畅", callback = {
                val isConnected = NetCheckUtils.checkNet(this)
                Toast.makeText(this,"${if (isConnected) "网络通畅" else "网络不通"}",Toast.LENGTH_LONG).show()
            }),
            ItemData("哈哈", ivCallback = object : ImageCallback {
                override fun showIv(iv: ImageView) {
                    iv.setImageResource(R.drawable.apple)
                }
            }, lamCallback = {
                logEE(it.itemData.title)
            }) { callData ->
                callData.itemData.content =
                    "哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥"
                callData.itemData.notifyDataSetChange()
            },
            ItemData("单条item的activity") {
                startActivity(Intent(this, SingleItemPageActivity::class.java))
            }

        )
    }

    override fun showFirstItem(): Boolean {
        return true
    }
}