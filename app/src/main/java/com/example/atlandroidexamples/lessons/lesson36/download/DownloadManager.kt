package com.example.atlandroidexamples.lessons.lesson36.download

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.net.toUri
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.utils.Constants
import java.io.File
import java.io.FileOutputStream
import java.net.URL

class DownloadManager(
    context: Context,
    workerParameters: WorkerParameters
    ): CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {
        val fileUrl = inputData.getString(Constants.KEY_FILE_URL) ?: ""
        val fileName = inputData.getString(Constants.KEY_FILE_NAME) ?: ""
        val fileType = inputData.getString(Constants.KEY_FILE_TYPE) ?: ""

        if (fileName.isEmpty()
            || fileType.isEmpty()
            || fileUrl.isEmpty()
        ){
            Log.d(Constants.WORKER_TAG, "WORK doWork -> failure")
            Result.failure()
        }

        setForeground(getNotification())

        val uri = getSavedFileUri(
            fileName = fileName,
            fileType = fileType,
            fileUrl = fileUrl,
            context = applicationContext
        )

        NotificationManagerCompat.from(applicationContext).cancel(Constants.NOTIFICATION_ID)
        return if (uri != null){
            Log.d(Constants.WORKER_TAG, "WORK doWork -> success")
            Result.success(workDataOf(Constants.KEY_FILE_URI to uri.toString()))
        }else{
            Log.d(Constants.WORKER_TAG, "WORK doWork -> failure notification")
            Result.failure()
        }
    }


    private fun getNotification(): ForegroundInfo {

        val notification = NotificationCompat.Builder(
            applicationContext,
            Constants.NOTIFICATION_CHANNEL_ID
        )
            .setContentTitle("File downloading ...")
            .setSmallIcon(R.drawable.ic_player)
            .setOngoing(true)
            .setProgress(100,0,true)
            .build()

        return ForegroundInfo(Constants.NOTIFICATION_ID, notification)
    }

    private fun getSavedFileUri(
        fileName:String,
        fileType:String,
        fileUrl:String,
        context: Context): Uri?{
        val mimeType = when(fileType){
            "PDF" -> "application/pdf"
            "PNG" -> "image/png"
            "MP4" -> "video/mp4"
            else -> ""
        } // different types of files will have different mime type

        if (mimeType.isEmpty()) return null

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            val contentValues = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
                put(MediaStore.MediaColumns.MIME_TYPE, mimeType)
                put(MediaStore.MediaColumns.RELATIVE_PATH, "Download")
            }

            val resolver = context.contentResolver

            val uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues)

            return if (uri!=null){
                URL(fileUrl).openStream().use { input->
                    resolver.openOutputStream(uri).use { output->
                        input.copyTo(output!!, DEFAULT_BUFFER_SIZE)
                    }
                }
                uri
            }else{
                null
            }

        }else{

            val target = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                fileName
            )
            URL(fileUrl).openStream().use { input->
                FileOutputStream(target).use { output ->
                    input.copyTo(output)
                }
            }

            return target.toUri()
        }
    }
}