package com.ananananzhuo.mvvm.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ananananzhuo.mvvm.R
import com.ananananzhuo.mvvm.bean.bean.ItemData
import com.ananananzhuo.mvvm.view.recycle.CustomRecyclerView

/**
 * 功能：基础fragment
 * Created by mayong on 2021/8/6.
 */
abstract class CustomAdapterFragment : Fragment() {
    lateinit var recycle: CustomRecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_custom_adapter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycle = view.findViewById<CustomRecyclerView>(R.id.customRecycle)
        recycle.setCustomAdapter(getAdapterDatas(), showFirstItem())

    }

    /**
     * 设置适配器
     */
    fun setAdapter(mutableList: MutableList<ItemData>, showFirstItem: Boolean) {
        recycle.setCustomAdapter(mutableList, showFirstItem)
    }


    abstract fun showFirstItem(): Boolean
    abstract fun getAdapterDatas(): MutableList<ItemData>

}