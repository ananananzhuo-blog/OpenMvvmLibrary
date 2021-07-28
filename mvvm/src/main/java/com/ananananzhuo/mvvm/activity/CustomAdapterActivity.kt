package com.ananananzhuo.mvvm.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ananananzhuo.mvvm.R
import com.ananananzhuo.mvvm.bean.bean.ItemData
import com.ananananzhuo.mvvm.view.recycle.CustomRecyclerView

/**
 * author  :mayong
 * function:
 * date    :2021/7/28
 **/
abstract class CustomAdapterActivity : AppCompatActivity() {
    val recycle: CustomRecyclerView by lazy {
        findViewById(R.id.customRecycle)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_custom_adapter)
        setAdapter(getAdapterDatas(), showFirstItem())
    }

    /**
     * 设置适配器
     */
    fun setAdapter(mutableList: MutableList<ItemData>, showFirstItem: Boolean) {
        recycle.setCustomAdapter(mutableList, showFirstItem)
    }


    abstract fun getAdapterDatas(): MutableList<ItemData>
    abstract fun showFirstItem(): Boolean
}