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
import androidx.activity.result.contract.ActivityResultContracts
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.ActivityPlayerBinding

class PlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayerBinding
    private var isServiceConnected = false
    private var myTestService: TestService? = null

    private val connection = object : ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, binder: IBinder?) {
            val myBinder = binder as? TestService.TestBinder
            myTestService = myBinder?.getMyService()

            val fullname = myTestService?.getMyFullName("Ilgar", "Habibov")
            binding.title.text = fullname

           isServiceConnected = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
           isServiceConnected = false
        }

    }

    private val permissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(applicationContext, TestService::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissionRequest.launch(Manifest.permission.POST_NOTIFICATIONS)
        }

        binding.play.setOnClickListener {

//            startMyPlayer(MyForegroundService.PlayerActions.PLAY.toString())

            val fullname = myTestService?.getMyFullName("Nurlan", "Veliyev")
            binding.title.text = fullname
        }

        binding.pause.setOnClickListener {
            startMyPlayer(MyForegroundService.PlayerActions.PAUSE.toString())
        }

        binding.resume.setOnClickListener {
            startMyPlayer(MyForegroundService.PlayerActions.RESUME.toString())
        }

        binding.stop.setOnClickListener {
            startMyPlayer(MyForegroundService.PlayerActions.STOP.toString())
        }

        binding.quit.setOnClickListener {
            startMyPlayer(MyForegroundService.PlayerActions.QUIT.toString())
        }


    }


    private fun startMyPlayer(action: String){
        val intent = Intent(applicationContext, MyForegroundService::class.java)
        intent.action = action
        startService(intent)
    }

    override fun onStop() {
        super.onStop()
        isServiceConnected = false
    }
}