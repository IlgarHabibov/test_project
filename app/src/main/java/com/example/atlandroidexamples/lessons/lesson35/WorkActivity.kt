package com.example.atlandroidexamples.lessons.lesson35

import android.Manifest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.LiveData
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.Operation
import androidx.work.Operation.State
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.ActivityWorkBinding
import com.example.atlandroidexamples.lessons.lesson36.WorkerFive
import com.example.atlandroidexamples.lessons.lesson36.WorkerFour
import com.example.atlandroidexamples.lessons.lesson36.WorkerOne
import com.example.atlandroidexamples.lessons.lesson36.WorkerThree
import com.example.atlandroidexamples.lessons.lesson36.WorkerTwo
import com.example.atlandroidexamples.utils.Constants
import java.util.UUID
import java.util.concurrent.TimeUnit

class WorkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWorkBinding
    private val requestPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()){}
    private var id: UUID?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermission.launch(Manifest.permission.POST_NOTIFICATIONS)
        }


        Log.d(Constants.WORKER_TAG, "Worker id -> $id")



        with(binding){
            startWork.setOnClickListener {
                Log.d(Constants.WORKER_TAG, "start workers ...!")
                startWorksWithChain()
            }

            cancelWork.setOnClickListener {
                cancelWork()
            }
        }




    }

    private fun cancelWork() {
        WorkManager
            .getInstance(applicationContext)
            .cancelAllWorkByTag("WorkerFour")

    }


    private fun startWorksWithChain(){
        val five = OneTimeWorkRequestBuilder<WorkerFive>()
            .addTag("WorkerFive")
            .build()

        val one = OneTimeWorkRequestBuilder<WorkerOne>()
            .addTag("WorkerOne")
            .build()

        val four = OneTimeWorkRequestBuilder<WorkerFour>()
            .addTag("WorkerFour")
            .build()

        val three = OneTimeWorkRequestBuilder<WorkerThree>()
            .addTag("WorkerThree")
            .build()

        val two = OneTimeWorkRequestBuilder<WorkerTwo>()
            .addTag("WorkerTwo")
            .build()


        WorkManager
            .getInstance(applicationContext)
            .enqueue(one)

        WorkManager.getInstance(applicationContext)
            .getWorkInfoByIdLiveData(one.id)
            .observe(this, ::onWorkStateChange)
    }


    private fun startWork(){
        val data = Data.Builder()
            .putString("name", "AA")
            .putInt("age", 32)
            .build()

        val request = OneTimeWorkRequestBuilder<MyWorker>()
            .addTag("MyWorker")
            .setInputData(data)
            .build()

        WorkManager
            .getInstance(applicationContext)
            .enqueue(request)

        WorkManager.getInstance(applicationContext)
            .getWorkInfoByIdLiveData(request.id)
            .observe(this, ::onWorkStateChange)


    }


    private fun onWorkStateChange(workInfo: WorkInfo){
        when(workInfo.state){
            WorkInfo.State.SUCCEEDED ->{
                val result = workInfo.outputData.getString("result")
                Log.d("MyWorkerStates", "SUCCEEDED -> $result")
            }
            WorkInfo.State.FAILED ->{
                val result = workInfo.outputData.getString("result")
                Log.d("MyWorkerStates", "FAILED -> $result")
            }
            WorkInfo.State.ENQUEUED ->{
                Log.d("MyWorkerStates", "ENQUEUED")
            }
            WorkInfo.State.BLOCKED ->{
                Log.d("MyWorkerStates", "BLOCKED")
            }

            WorkInfo.State.CANCELLED ->{
                Log.d("MyWorkerStates", "CANCELLED")
            }

            WorkInfo.State.RUNNING ->{
                Log.d("MyWorkerStates", "RUNNING")
            }
        }
    }
}