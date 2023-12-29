package com.example.atlandroidexamples.lessons.lesson34

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.activities.SecondActivity

class BroadcastActivity : AppCompatActivity() {
    private val receiver = TestReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)

//        registerReceiver(receiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))

        registerReceiver(receiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        receiver.setOnStatusChanged {status ->
            Toast.makeText(this, "Airplane Mode status -> $status", Toast.LENGTH_SHORT).show()
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}