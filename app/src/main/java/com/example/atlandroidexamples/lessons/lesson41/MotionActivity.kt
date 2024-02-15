package com.example.atlandroidexamples.lessons.lesson41

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.ActivityMotionBinding
import com.example.atlandroidexamples.practices.practice20.MenuItem
import com.example.atlandroidexamples.practices.practice20.SideMenuAdapter

class MotionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMotionBinding
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val type = intent?.getStringExtra("type")
        Log.d("asdasdasdasdasd", "onCreate type: $type")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMotionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val type = intent.getStringExtra("type")
        Log.d("asdasdasdasdasd", "onCreate type: $type")


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) ==
                PackageManager.PERMISSION_GRANTED
            ) {
                // FCM SDK (and your app) can post notifications.
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                // TODO: display an educational UI explaining to the user the features that will be enabled
                //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
                //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
                //       If the user selects "No thanks," allow the user to continue without notifications.
            } else {
                // Directly ask for the permission
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }


        val adapter = SideMenuAdapter(
            list = createMenuList().toMutableList(),
            ::onMenuItemClick
        )


//        binding.menuList.adapter = adapter


    }


    override fun onResume() {
        Log.d("asdasdasdasdasd", "onResume")

        super.onResume()
    }


    private fun onMenuItemClick(menuItem: MenuItem){

    }

    private fun createMenuList() = listOf(
        MenuItem(0, "Home"),
        MenuItem(1, "Categories"),
        MenuItem(2, "Notifications"),
        MenuItem(3, "Settings"),
    )
}