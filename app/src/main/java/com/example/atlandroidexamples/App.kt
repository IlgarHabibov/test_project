package com.example.atlandroidexamples

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import com.example.atlandroidexamples.utils.Constants
import com.example.test_lib.LibraryTest
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {


    override fun onCreate() {

        val test = LibraryTest()
        

        Log.d("ApplicationTAG", "url = ${test.name}")
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                Constants.NOTIFICATION_CHANNEL_ID,
                Constants.NOTIFICATION_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            )
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
            notificationManager?.createNotificationChannel(channel)
        }
    }
}