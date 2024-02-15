package com.example.atlandroidexamples.utils

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.app.NotificationCompat
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.lessons.lesson18.HomeActivity
import com.example.atlandroidexamples.lessons.lesson33.PlayerActivity
import com.example.atlandroidexamples.lessons.lesson41.MotionActivity
import com.example.atlandroidexamples.practices.practice21.FirebaseActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyPushService: FirebaseMessagingService() {

    companion object{
        private const val TAG = "MyPushServiceTAG"
    }

    override fun onNewToken(token: String) {
        Log.d(TAG, "token: $token")
        super.onNewToken(token)
    }


    override fun onMessageReceived(message: RemoteMessage) {
        Log.d(TAG, "message: $message")
        Log.d(TAG, "notification: ${message.notification}")
        Log.d(TAG, "data: ${message.data}")
        Log.d(TAG, "title: ${message.notification?.title}")
        Log.d(TAG, "title: ${message.notification?.body}")

        val type = message.data["type"]
        val id = message.data["id"]
//
        val intent = Intent(applicationContext, FirebaseActivity::class.java).apply{
            putExtra("type", type)
            putExtra("id", id)
        }
        val pendingIntent =PendingIntent.getActivity(applicationContext, 300, intent, PendingIntent.FLAG_MUTABLE)



        var notification = NotificationCompat.Builder(this, Constants.NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_car_cargo)
            .setContentTitle(message.notification?.title)
            .setContentText(message.notification?.body)
            .setContentIntent(pendingIntent)
//            .setCustomContentView(RemoteViews())
            .build()


        val notificationManager = applicationContext.getSystemService(NotificationManager::class.java)
        notificationManager.notify(0, notification)



        super.onMessageReceived(message)
    }



    private fun getPendingIntentByType(type: String?): PendingIntent{

        return when(type){
            "Motion" -> {
                val intent = Intent(applicationContext, MotionActivity::class.java)
                PendingIntent.getActivity(applicationContext, 100, intent, PendingIntent.FLAG_MUTABLE)
            }
            "Player" -> {
                val intent = Intent(applicationContext, PlayerActivity::class.java)
                PendingIntent.getActivity(applicationContext, 100, intent, PendingIntent.FLAG_MUTABLE)
            }
            else -> {
                val intent = Intent(applicationContext, HomeActivity::class.java)
                PendingIntent.getActivity(applicationContext, 100, intent, PendingIntent.FLAG_MUTABLE)
            }
        }
    }
}