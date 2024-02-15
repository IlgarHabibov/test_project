package com.example.atlandroidexamples.lessons.lesson36

import android.Manifest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.ActivityDownloadBinding
import com.example.atlandroidexamples.lessons.lesson36.download.DownloadManager
import com.example.atlandroidexamples.utils.Constants

class DownloadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDownloadBinding
    private val requestNotificationPermission = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){}

    private val requestStoragePermission = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ){}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDownloadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestNotificationPermission.launch(Manifest.permission.POST_NOTIFICATIONS)
        }

        requestStoragePermission.launch(arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ))


        binding.download.setOnClickListener {
            downloadFile()
        }

    }


    private fun downloadFile(){

        val url1 = "https://freetestdata.com/wp-content/uploads/2023/07/260KB.pdf"
        val url2 = "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_1MB_PDF.pdf"
        val url3 = "https://freetestdata.com/wp-content/uploads/2023/07/1.5MB.pdf"
        val url4 = "https://freetestdata.com/wp-content/uploads/2022/11/Free_Test_Data_10.5MB_PDF.pdf"
        val fileName = "book"
        val type = "PDF"

        val data: Data = Data.Builder()
            .putString(Constants.KEY_FILE_URL, url4)
            .putString(Constants.KEY_FILE_NAME, fileName)
            .putString(Constants.KEY_FILE_TYPE, type)
            .build()

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresStorageNotLow(true)
            .setRequiresBatteryNotLow(true)
            .build()

        val workerOneRequest = OneTimeWorkRequestBuilder<DownloadManager>()
            .setConstraints(constraints)
            .setInputData(data)
            .build()

        val workName = "oneFileDownloadWork_${System.currentTimeMillis()}"
        Log.d(Constants.WORKER_TAG, "WORK STARTED -> $workName")

        WorkManager.getInstance(applicationContext).enqueueUniqueWork(
            workName,
            ExistingWorkPolicy.KEEP,
            workerOneRequest
        )

    }
}