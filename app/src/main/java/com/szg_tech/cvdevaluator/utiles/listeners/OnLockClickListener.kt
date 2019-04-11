package com.szg_tech.cvdevaluator.utiles.listeners

import android.view.View

class OnLockClickListener(val onViewClick: (v: View?, listener: OnLockClickListener) -> Unit) :
    View.OnClickListener {
    var isLock = false

    override fun onClick(v: View?) {
        if (!isLock) {
            lock()
            onViewClick(v, this)
        }
    }

    fun lock() {
        isLock = true
    }

    fun unlock() {
        isLock = false
    }
}