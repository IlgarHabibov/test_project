package com.example.atlandroidexamples.lessons.lesson33

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.atlandroidexamples.R

class MyForegroundService: Service() {

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when(intent?.action){
            PlayerActions.PLAY.toString() -> showNotification("Start Playing")
            PlayerActions.STOP.toString()  -> showNotification("Stop Playing")
            PlayerActions.PAUSE.toString()  -> showNotification("Pause Playing")
            PlayerActions.RESUME.toString()  -> showNotification("Resume Playing")
            PlayerActions.QUIT.toString()  -> stopSelf()
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun showNotification(message: String) {
        val notification = NotificationCompat.Builder(
            applicationContext,
            "my_music_player_channel_id")
            .setSmallIcon(R.drawable.ic_player)
            .setContentTitle("My Music Player")
            .setContentText(message)
            .build()
        startForeground(11, notification)
    }

    enum class PlayerActions{
        PLAY, RESUME, STOP, PAUSE, QUIT
    }
}