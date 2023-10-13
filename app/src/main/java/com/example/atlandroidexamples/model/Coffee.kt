package com.example.atlandroidexamples.model

data class Coffee(
    val name:String,
    val desc:String,
    val price: Double,
    val rating: String,
    val iconId: Int = 0
)