package com.example.atlandroidexamples.lessons.lesson36

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.atlandroidexamples.utils.Constants
import kotlinx.coroutines.delay

class WorkerTwo(
    context: Context,
    workerParameters: WorkerParameters
): CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        logWorkResult("WorkerTwo  started")
        delay(2000)
        logWorkResult("WorkerTwo ended")
        return Result.success()
    }

}
