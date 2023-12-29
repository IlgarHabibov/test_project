package com.example.atlandroidexamples.lessons.lesson36

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.atlandroidexamples.utils.Constants
import kotlinx.coroutines.delay

class WorkerFive(
    context: Context,
    workerParameters: WorkerParameters
): CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        logWorkResult("WorkerFive started")
        delay(5000)
        logWorkResult("WorkerFive ended")

        return Result.success()
    }

}
