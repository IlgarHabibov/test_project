package com.example.atlandroidexamples.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.atlandroidexamples.databinding.ActivityThirdBinding
import com.example.atlandroidexamples.cache.SharedPrefs
import com.example.atlandroidexamples.utils.ErrorHandler
import com.example.atlandroidexamples.utils.ErrorHandlerImpl

class FourthActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE)
        SharedPrefs.setPrefs(sharedPreferences)


    }


}