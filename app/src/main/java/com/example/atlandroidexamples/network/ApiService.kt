package com.example.atlandroidexamples.network

import com.example.atlandroidexamples.network.model.AlbumModel
import com.example.atlandroidexamples.network.model.CurrentWeatherModel
import com.example.atlandroidexamples.network.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("v1/current.json")
    fun getCurrentWeather(
        @Query("key") key: String,
        @Query("q") city: String
    ): Call<CurrentWeatherModel>


    @GET("users/{userId}")
    suspend fun getUser(
        @Path("userId") userId: Int
    ): Response<User>


    @GET("photos")
    fun getAlbums(): Call<List<AlbumModel>>


    @GET("photos")
    suspend fun getAlbums2(): Response<List<AlbumModel>?>

}