package com.ananananzhuo.mvvn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ananananzhuo.mvvm.bean.bean.ItemData
import com.ananananzhuo.mvvm.utils.logEE
import com.ananananzhuo.mvvm.view.recycle.CustomRecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycle = findViewById<CustomRecyclerView>(R.id.recycle_main)
        recycle.setCustomAdapter(datas)
    }

    private val datas = mutableListOf(
        ItemData("哈哈", {
            logEE("哈行aha")
        }),
        ItemData("跳转到下一个Activity", {
            logEE("哈行aha")
        },activity = ShowActivity::class.java)
    )
}