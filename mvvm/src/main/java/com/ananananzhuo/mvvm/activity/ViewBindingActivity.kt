package com.ananananzhuo.mvvm.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * author  :mayong
 * function:
 * date    :2022/3/27
 **/
abstract class ViewBindingActivity<Binging : ViewBinding> : AppCompatActivity() {
    lateinit var mBinding: Binging
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = initBinding()
        setContentView(mBinding.root)
    }

    abstract fun initBinding(): Binging
}