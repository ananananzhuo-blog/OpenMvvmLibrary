package com.ananananzhuo.mvvm.view.recycle

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ananananzhuo.mvvm.bean.bean.ItemData
import java.lang.IllegalArgumentException

/**
 * author  :mayong
 * function:自定义的item适配器
 * date    :2021/7/4
 **/
class CustomRecyclerView(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs) {

    override fun setAdapter(adapter: Adapter<*>?) {
        throw IllegalArgumentException("禁用此adapter")
    }

    fun setCustomAdapter(datas: MutableList<ItemData>) {
        datas.add(0, ItemData("本栏目由\"安安安安卓\"独家开发，禁转载", {},itemTextColor = Color.RED))
        val adapter = CustomAdapter(context, datas)
        layoutManager = LinearLayoutManager(context)
        super.setAdapter(adapter)
    }
}