package com.ananananzhuo.mvvm.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ananananzhuo.mvvm.bean.bean.ItemData
import com.ananananzhuo.mvvm.databinding.FragmentCustomAdapterBinding

/**
 * author  :mayong
 * function:支持
 * date    :2021/11/19
 **/

@Deprecated("unuse")
abstract class CustomBindingAdapterFragment : Fragment() {
    private var _binding: FragmentCustomAdapterBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCustomAdapterBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.customRecycle?.setCustomAdapter(getAdapterDatas(), showFirstItem())
    }

    abstract fun showFirstItem(): Boolean

    abstract fun getAdapterDatas(): MutableList<ItemData>

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}