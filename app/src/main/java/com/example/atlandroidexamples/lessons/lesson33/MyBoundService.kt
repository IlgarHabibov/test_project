package com.example.atlandroidexamples.lessons.lesson33

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.atlandroidexamples.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MyBoundService: Service() {

    private val binder = MyBinder()
    private var counterJob: Job? = null
    private var count = 0

    inner class MyBinder: Binder(){
        fun getService(): MyBoundService{
            return this@MyBoundService
        }
    }

    val data = MutableLiveData<Int>()

    override fun onBind(p0: Intent?): IBinder? {
        startCounter()
        return binder
    }


    private fun showNotification(count: Int) {
        val notification = NotificationCompat.Builder(applicationContext, MyService.MY_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_chat)
            .setContentTitle("Ilgar")
            .setContentText(count.toString())
            .build()
        startForeground(MyService.ID, notification)
    }


    private fun startCounter(){

        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

        counterJob = scope.launch {
            repeat(1000){
                delay(1000)
                count++
                data.postValue(count)
                showNotification(count)
            }
        }
    }


    fun getMyName(): String{
        return "Ilgar"
    }

    override fun onUnbind(intent: Intent?): Boolean {
        counterJob?.cancel()
        return super.onUnbind(intent)
    }



}