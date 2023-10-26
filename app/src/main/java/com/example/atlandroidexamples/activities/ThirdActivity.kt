package com.example.atlandroidexamples.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.ActivityThirdBinding
import com.example.atlandroidexamples.utils.SpaceItemDecoration
import com.example.atlandroidexamples.adapters.CoffeeAdapter
import com.example.atlandroidexamples.model.Coffee

class ThirdActivity : AppCompatActivity() {

    private var binding: ActivityThirdBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initViews()
    }

    private fun initViews() {
        val name = intent.getStringExtra("name")
        val desc = intent.getStringExtra("desc")
        val rating = intent.getStringExtra("rating")
        val price = intent.getDoubleExtra("price", 0.0)
        val iconId = intent.getIntExtra("imageId", 0)

//        binding?.image?.setImageResource(iconId)
//        binding?.name?.text = name
//        binding?.desc?.text = desc
//        binding?.rating?.text = rating
//        binding?.price?.text = price.toString()

    }







}