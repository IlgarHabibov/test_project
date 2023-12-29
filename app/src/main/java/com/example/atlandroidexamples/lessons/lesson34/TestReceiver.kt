package com.example.atlandroidexamples.lessons.lesson34

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class TestReceiver: BroadcastReceiver() {

    private var onStatusChanged: ((status: Boolean) -> Unit)? = null

    fun setOnStatusChanged(onStatusChanged: (status: Boolean) -> Unit){
        this.onStatusChanged = onStatusChanged
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED){
            val status = intent.getBooleanExtra("state", false)
            onStatusChanged?.invoke(status)
            Log.d(TAG, "Air plain mode changed. status = $status")
        }else if (BluetoothAdapter.ACTION_STATE_CHANGED == intent?.action){
            Log.d(TAG, "Bluetooth mode changed")
        }
    }

    companion object{
        private const val TAG = "TestReceiverTag"
    }
}