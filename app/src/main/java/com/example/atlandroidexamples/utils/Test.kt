package com.example.atlandroidexamples.utils

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CompletionHandler
import kotlinx.coroutines.DisposableHandle
import kotlin.coroutines.CoroutineContext

interface Job: CoroutineContext.Element{
    val isActive: Boolean
    val isCompleted: Boolean
    val isCanceled: Boolean

    fun cancel(cause: CancellationException? = null)

    fun invokeOnCompletion(handler: CompletionHandler): DisposableHandle

    suspend fun join()

    fun start(): Boolean

    val children: Sequence<Job>
}

fun Job.ensureActive(){}

class TestJob: Job{
    override val isActive: Boolean
        get() = TODO("Not yet implemented")
    override val isCompleted: Boolean
        get() = TODO("Not yet implemented")
    override val isCanceled: Boolean
        get() = TODO("Not yet implemented")

    override fun cancel(cause: CancellationException?) {
        TODO("Not yet implemented")
    }

    override fun invokeOnCompletion(handler: CompletionHandler): DisposableHandle {
        TODO("Not yet implemented")
        ensureActive()
    }

    override suspend fun join() {
        TODO("Not yet implemented")
    }

    override fun start(): Boolean {
        TODO("Not yet implemented")
    }

    override val children: Sequence<Job>
        get() = TODO("Not yet implemented")


    override val key: CoroutineContext.Key<*>
        get() = TODO("Not yet implemented")


}