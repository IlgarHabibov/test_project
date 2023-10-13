package com.example.atlandroidexamples.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.atlandroidexamples.databinding.ActivityThirdBinding

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val adapter = TestAdapter()
//        binding.recycler.adapter = adapter
//        binding.recycler.layoutManager = LinearLayoutManager(this)
//        adapter.addData(createList())
    }


    private fun createList() = mutableListOf(
        "Apple",
        "Grapefruit",
        "Kiwi",
        "Lime",
        "Mango",
        "Orange",
        "Lemon",
    )
}