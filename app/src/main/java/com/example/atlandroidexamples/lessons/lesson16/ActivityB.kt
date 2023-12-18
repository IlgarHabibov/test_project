package com.example.atlandroidexamples.lessons.lesson16

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.ActivityABinding
import com.example.atlandroidexamples.databinding.ActivityBBinding
import com.example.atlandroidexamples.lessons.lesson33.TestService

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(Keys.NAME)

        val humanName = Human

        binding.textBActivity.text = Human.getHumanName()



        binding.buttonBackToA.setOnClickListener {
            val intent = Intent(applicationContext, TestService::class.java)
            intent.action = "Start"
            startService(intent)
        }





    }


    fun onSecondButtonClick(){
        val intent = Intent(applicationContext, TestService::class.java)
        intent.action = "Start New"
        startService(intent)
    }

    private fun onBackToAClick() {
        val newIntent = Intent()
        newIntent.putExtra("surname", "Habibov")
        setResult(200, newIntent)
        finish()
    }
}