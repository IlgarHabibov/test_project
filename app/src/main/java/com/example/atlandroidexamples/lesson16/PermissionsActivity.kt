package com.example.atlandroidexamples.lesson16

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.activities.MainActivity

class PermissionsActivity : AppCompatActivity() {
    val cameraPermissionRequest = registerForActivityResult(ActivityResultContracts.RequestPermission()){

    }
    val requestForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

    }

    val contentRequet = registerForActivityResult(ActivityResultContracts.GetContent()){

    }

    val takePicture = registerForActivityResult(ActivityResultContracts.TakePicture()){

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)

//        cameraPermissionRequest.launch(Manifest.permission.CAMERA)
        requestForResult.launch(Intent(this, MainActivity::class.java))
//        contentRequet.launch("image/*")
//        contentRequet.launch("application/pdf")
    }
}