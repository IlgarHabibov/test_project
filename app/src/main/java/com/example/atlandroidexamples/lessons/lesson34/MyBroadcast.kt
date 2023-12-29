package com.example.atlandroidexamples.lessons.lesson34

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


class MyBroadcast: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED){
            val status = intent.getBooleanExtra("state", false)
            Log.d(TAG,"status -> airplain mode is enabled -> $status")
        }
    }

    companion object{
        private const val TAG = "MyBroadcastTag"
    }
}