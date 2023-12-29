package com.example.atlandroidexamples.lessons.lesson36

import android.content.Context
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.ListenableWorker
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class WorkerOne(
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            logWorkResult("WorkerOne started")
            setForeground(getNotification())
            delay(5000)
            logWorkResult("WorkerOne ended")

            Result.success()
        }

    }


    private fun getNotification(): ForegroundInfo{

        val intent = WorkManager.getInstance(applicationContext)
            .createCancelPendingIntent(id)

        val notification = NotificationCompat.Builder(
            applicationContext,
            Constants.NOTIFICATION_CHANNEL_ID
        ).setContentTitle("My Notification")
            .setContentText("Work in progress")
            .setSmallIcon(R.drawable.ic_player)
            .addAction(android.R.drawable.ic_dialog_email, "Cancel", intent)
            .build()
        return ForegroundInfo(10, notification)
    }

}

fun ListenableWorker.logWorkResult(resultText: String) {
    Log.d(Constants.WORKER_TAG, resultText)
}