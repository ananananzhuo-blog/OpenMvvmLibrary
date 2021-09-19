package com.ananananzhuo.mvvn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ananananzhuo.mvvm.activity.SingleItemActivity
import com.ananananzhuo.mvvm.callback.CallData
import com.ananananzhuo.mvvm.utils.logEE

class SingleItemPageActivity : SingleItemActivity() {
    override var title: String="只有一条item"
    override var callback: (callData: CallData) -> Unit = {
        logEE("打印")
    }
}