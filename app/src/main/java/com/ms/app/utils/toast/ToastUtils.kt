package com.ms.app.utils.toast

import android.widget.Toast
import com.ms.app.app.App

import com.ms.app.utils.thread.ThreadPoolUtils


object ToastUtils {
    private var toast: Toast? = null
    fun show(text: String?) {
        if (ThreadPoolUtils.isMainThread()) {
            if (toast == null) {
                toast = Toast.makeText(App.INSTANCE, text, Toast.LENGTH_LONG)
            } else {
                toast!!.setText(text)
            }
            toast!!.show()
        } else {
            ThreadPoolUtils.runOnMainThread(Runnable {
                run {
                    if (toast == null) {
                        toast = Toast.makeText(App.INSTANCE, text, Toast.LENGTH_LONG)
                    } else {
                        toast!!.setText(text)
                    }
                    toast!!.show()
                }
            })
        }
    }
}