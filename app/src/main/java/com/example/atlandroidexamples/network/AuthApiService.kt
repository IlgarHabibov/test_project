package com.example.atlandroidexamples.network

import com.example.atlandroidexamples.network.model.CurrentWeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApiService {

    @POST("login")
    fun login(
    ): Call<String>

    @POST("logout")
    fun logout(
    ): Call<String>


}