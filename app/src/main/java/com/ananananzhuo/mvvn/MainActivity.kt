package com.ananananzhuo.mvvn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ananananzhuo.mvvm.activity.CustomAdapterActivity
import com.ananananzhuo.mvvm.bean.bean.ItemData
import com.ananananzhuo.mvvm.callback.CallData
import com.ananananzhuo.mvvm.callback.Callback
import com.ananananzhuo.mvvm.utils.logEE
import com.ananananzhuo.mvvm.view.recycle.CustomRecyclerView

class MainActivity : CustomAdapterActivity() {

    override fun getAdapterDatas(): MutableList<ItemData> {
        return  mutableListOf(
            ItemData("哈哈", callback = object : Callback {
                override fun callback(callData: CallData) {
                    callData.itemData.content =
                        "哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥哈哈哈哈哈东扥撒扥"
                    callData.itemData.notifyDataSetChange()
                }
            }),
        )
    }

    override fun showFirstItem(): Boolean {
        return true
    }
}