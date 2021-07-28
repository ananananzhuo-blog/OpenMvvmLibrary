package com.ananananzhuo.mvvm.view.recycle

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ananananzhuo.mvvm.R
import com.ananananzhuo.mvvm.bean.bean.ItemData
import com.ananananzhuo.mvvm.view.ItemView

/**
 * author  :mayong
 * function:
 * date    :2021/7/4
 **/
class CustomAdapter(private val context: Context, private val datas: MutableList<ItemData>) :
    RecyclerView.Adapter<CustomHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val itemView =
            LayoutInflater.from(context).inflate(R.layout.item_custom_layout, parent, false)
        return CustomHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        holder.bindData(datas[position])
    }

    override fun getItemCount(): Int {
        return datas.size
    }
}

class CustomHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val iv = itemView.findViewById<ImageView>(R.id.iv_recycle_item)
    private val tvTitle = itemView.findViewById<TextView>(R.id.tv_recycle_item_title)
    private val tvContent = itemView.findViewById<TextView>(R.id.tv_reyccle_item_content)

    fun bindData(itemData: ItemData) {
        if (itemData.showIcon) {
            iv.setImageResource(itemData.icon)
            iv.visibility = View.VISIBLE
        } else {
            iv.visibility = View.GONE
        }

        tvTitle.text = itemData.title
        tvTitle.setTextColor(itemData.itemTextColor)
        if (itemData.content.isEmpty()) {
            tvContent.visibility = View.GONE
        } else {
            tvContent.visibility = View.VISIBLE
            tvContent.text = itemData.content
        }
        itemView.setOnClickListener {
            itemData.let {
                itemData.callback?.callback(itemData.callData)
            }
        }
    }
}


