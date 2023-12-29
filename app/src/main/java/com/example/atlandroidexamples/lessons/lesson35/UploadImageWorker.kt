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
        val imageURI = "file://downloads/test.jpg"

        val image = getImageFromGallery(imageURI)
        Log.d("UploadImageWorkerTAG", "$image uploading ...!")

        return Result.success()

    }


    private fun getImageFromGallery(path: String): String{
        return "image"
    }

}