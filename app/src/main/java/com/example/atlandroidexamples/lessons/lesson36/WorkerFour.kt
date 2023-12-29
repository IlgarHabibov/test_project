package com.example.atlandroidexamples.lessons.lesson36

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.atlandroidexamples.utils.Constants
import kotlinx.coroutines.delay

class WorkerFour(
    context: Context,
    workerParameters: WorkerParameters
): CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        logWorkResult("WorkerFour started")
        delay(4000)
        logWorkResult("WorkerFour ended")
        return Result.success()
    }

}
