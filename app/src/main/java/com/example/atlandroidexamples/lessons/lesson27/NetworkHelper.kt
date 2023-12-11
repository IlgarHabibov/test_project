package com.example.atlandroidexamples.lessons.lesson27

import retrofit2.Retrofit
import javax.inject.Inject

class NetworkHelper @Inject constructor() {

    private val name = "Ilgar Habibov"

    fun getFullName() = name
}