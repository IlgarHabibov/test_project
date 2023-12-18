package com.example.atlandroidexamples.lessons.lesson33

import android.Manifest
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.ActivityL33Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class L33Activity : AppCompatActivity() {
    private lateinit var binding: ActivityL33Binding
    private val requestPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()){}

    private var boundService: MyBoundService? = null
    private var isBound = false

    private val boundConnection = object : ServiceConnection{

        override fun onServiceConnected(className: ComponentName?, service: IBinder?) {

            val binder = service as? MyBoundService.MyBinder
            boundService = binder?.getService()

            boundService?.data?.observe(this@L33Activity){
                binding.title.text = it.toString()
            }

//            binding.title.text = boundService?.getMyName()

            isBound = true
        }

        override fun onServiceDisconnected(className: ComponentName?) {
            isBound = false
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityL33Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermission.launch(Manifest.permission.POST_NOTIFICATIONS)
        }

        binding.buttonShow.setOnClickListener {
            startMyService(MyService.Actions.SHOW.toString())
        }

        binding.buttonClose.setOnClickListener {
            startMyService(MyService.Actions.CLOSE.toString())
//            stopService(Intent(applicationContext, MyService::class.java))
        }

        binding.buttonBound.setOnClickListener {
            bindMyService()
        }




        binding.buttonUnBound.setOnClickListener {
            if (isBound) {
                unbindService(boundConnection)
                isBound = false
            }
        }
    }

    private fun startMyService(action: String){
        val intent = Intent(applicationContext, MyService::class.java)
        intent.action = action
        startService(intent)
    }

    private fun bindMyService(){
        val intent = Intent(applicationContext, MyBoundService::class.java)
        bindService(intent, boundConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onStop() {
        super.onStop()
        unbindService(boundConnection)
        isBound = false
    }
}