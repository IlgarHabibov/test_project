package com.example.atlandroidexamples.lessons.lesson33

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.atlandroidexamples.R

class MyService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            Actions.SHOW.toString() -> show()
            Actions.CLOSE.toString() -> close()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun close() {
        stopSelf()
    }

    private fun show() {
        showNotification()
    }

    fun getMyName(): String{
        return "Ilgar"
    }

    private fun showNotification() {
        val notification = NotificationCompat.Builder(applicationContext, MY_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_chat)
            .setContentTitle("Ilgar")
            .setContentText("Habibov")
            .build()
        startForeground(ID, notification)
    }

    companion object {
        const val MY_CHANNEL_ID = "my_test_channel_id"
        const val MY_CHANNEL_NAME = "my Test Channel"
        const val ID = 10
    }

    enum class Actions {
        SHOW, CLOSE
    }

}