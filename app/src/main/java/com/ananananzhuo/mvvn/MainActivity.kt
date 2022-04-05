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
import com.broaddeep.flow.utils.Gps
import kotlin.math.log

class MainActivity : CustomAdapterActivity() {

    override fun getAdapterDatas(): MutableList<ItemData> {
        return mutableListOf(
            ItemData(
                title = "android原生定位方法封装",
                content = "安卓原生的定位方法封装，会首先获取上一次的定位结果，如果获取失败则重新定位获取当前定位结果，使用requestLocationUpdates定位的时候很慢，超过两分钟是正常的",
            ) { callData ->
                Gps(this).startLocation {
                    logEE(it.toString())
                    callData.itemData.content = "经度：${it?.longitude}纬度：${it?.latitude}"
                    callData.itemData.notifyDataSetChange()
                }
            },
            ItemData(title = "判断网络是否通畅", callback = {
                val isConnected = NetCheckUtils.checkNet(this)
                Toast.makeText(this, "${if (isConnected) "网络通畅" else "网络不通"}", Toast.LENGTH_LONG)
                    .show()
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