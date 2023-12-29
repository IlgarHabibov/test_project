package com.example.atlandroidexamples.lessons.lesson35

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.atlandroidexamples.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MyWorker(
    context: Context,
    workerParams: WorkerParameters
): CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO){


            val name = inputData.getString("name") ?: ""
            val age = inputData.getInt("age", 0)

            Log.d(Constants.WORKER_TAG, "$name $age")
            Log.d(Constants.WORKER_TAG, "Image uploading started ...")
            Log.d(Constants.WORKER_TAG, "ID -> $id")
             uploadImage()
            delay(5000)
            Log.d(Constants.WORKER_TAG, "Image uploading ended")



            if (name.length > 3){
                Result.success(createData("super"))
            }else{
                Result.failure(createData("Ne pis"))

            }

        }
    }

    private fun createData(data: String):Data{
        return Data.Builder()
            .putString("result", data)
            .build()
    }

    private suspend fun uploadImage(){

    }
}