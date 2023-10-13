package com.example.atlandroidexamples.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.atlandroidexamples.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val name = intent.getStringExtra("name")
        val surname = intent.getStringExtra("surname")

        val textView = findViewById<TextView>(R.id.nameText)
        textView.text = "$name $surname"

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
//            onBackPressed()
            finish()
        }
    }
}