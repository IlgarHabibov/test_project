package com.example.atlandroidexamples.lessons.lesson39

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.ActivityCustomViewBinding

class CustomViewActivity : AppCompatActivity() {

    private var count = 0

    private lateinit var binding: ActivityCustomViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.change.setOnClickListener {
            count ++
            if (count > 5) count = 0
            binding.indicator.setCurrentStep(count)
        }




    }
}