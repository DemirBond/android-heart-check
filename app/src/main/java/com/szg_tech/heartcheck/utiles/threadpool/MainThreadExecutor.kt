package com.firestak.lib.utils.threadpool

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

class MainThreadExecutor : Executor {
    private var handler = Handler(Looper.getMainLooper())

    override fun execute(command: Runnable?) {
//        renewLooper()
        handler.post(command)
    }

    fun executeDelay(command: Runnable?, delay: Long) {
//        renewLooper()
        handler.postDelayed(command, delay)
    }

    fun run(executor: () -> Unit) {
        val command = Runnable { executor() }
        execute(command)
    }

    fun run(executor: () -> Unit, delay: Long = 0) {
        val command = Runnable { executor() }
        executeDelay(command, delay)
    }

    private fun renewLooper() {
        if (handler.looper == null) {
            handler = Handler(Looper.getMainLooper())
        }
    }
}