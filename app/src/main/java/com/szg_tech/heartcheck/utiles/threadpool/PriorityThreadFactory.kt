package com.firestak.lib.utils.threadpool

import android.os.Process
import java.util.concurrent.ThreadFactory

class PriorityThreadFactory(val threadPriority: Int) : ThreadFactory {

    override fun newThread(r: Runnable?): Thread {
        val wrapperRunnable = Runnable {
            try {
                Process.setThreadPriority(threadPriority)
            } catch (t: Throwable) {
            }
            r?.run()
        }
        return Thread(wrapperRunnable)
    }
}