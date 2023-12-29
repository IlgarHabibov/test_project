package com.example.atlandroidexamples.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.atlandroidexamples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.nextButton?.setOnClickListener {
            onButtonClick()
        }

        binding?.finishButton?.setOnClickListener {
            finish()
        }

        Log.d("ActivityLifeCycle", "onCreate..")
    }


    private fun  onButtonClick(){
        val intent = Intent( this,
            SecondActivity::class.java)
        intent.putExtra("name", "Ilkin")
        intent.putExtra("surname", "Memmedov")
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifeCycle", "onStart..")

    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifeCycle", "onResume..")

        startActivity(Intent(
            this,
            SecondActivity::class.java
        ).also {
        })

    }

    override fun onPause() {
        super.onPause()
        Log.d("ActivityLifeCycle", "onPause..")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ActivityLifeCycle", "onStop..")
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        Log.d("ActivityLifeCycle", "onDestroy..")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ActivityLifeCycle", "onRestart..")
    }
}