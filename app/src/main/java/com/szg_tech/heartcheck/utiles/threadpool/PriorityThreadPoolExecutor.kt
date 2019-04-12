package com.firestak.lib.utils.threadpool

import java.util.concurrent.*

class PriorityThreadPoolExecutor(
    corePoolSize: Int,
    maximumPoolSize: Int,
    keepAliveTime: Long,
    unit: TimeUnit,
    blockingQueue: BlockingQueue<Runnable>,
    threadFactory: ThreadFactory
) : ThreadPoolExecutor(
    corePoolSize,
    maximumPoolSize,
    keepAliveTime,
    unit,
    blockingQueue,
    threadFactory
) {

    override fun submit(task: Runnable?): Future<*> {
        val futureTask =
            PriorityFutureTask(task as PriorityRunnable)
        execute(futureTask)
        return futureTask
    }

    fun run(executor: () -> Unit) {
        val task = object : PriorityRunnable() {
            override fun run() {
                super.run()
                executor()
            }
        }
        submit(task)
    }

    override fun execute(task: Runnable?) {
        if (task is PriorityFutureTask) {
            super.execute(task)
        } else {
            val futureTask =
                PriorityFutureTask(task as PriorityRunnable)
            super.execute(futureTask)
        }
    }

    private class PriorityFutureTask(val priorityRunnable: PriorityRunnable) :
        FutureTask<PriorityRunnable>(priorityRunnable, null), Comparable<PriorityFutureTask> {
        override fun compareTo(other: PriorityFutureTask): Int {
            val p1 = priorityRunnable.priority
            val p2 = other.priorityRunnable.priority
            return p2.ordinal - p1.ordinal
        }
    }

}