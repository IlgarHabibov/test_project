package com.example.atlandroidexamples.lessons.lesson39

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.ActivityCustomViewBinding

class CustomViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.change.setOnClickListener {
            binding.indicator.setCurrentStep(4)
        }
    }
}