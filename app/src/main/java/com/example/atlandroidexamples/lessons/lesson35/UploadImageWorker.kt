package com.example.atlandroidexamples.lessons.lesson35

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadImageWorker(
    context: Context,
    workerParameters: WorkerParameters
): Worker(context, workerParameters) {

    override fun doWork(): Result {
       uploadImage()
        return Result.success()

    }

    private fun uploadImage(){
        // Code for uploading image
    }

}