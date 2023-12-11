package com.example.atlandroidexamples.network

import com.example.atlandroidexamples.network.interceptors.AuthInterceptor
import com.example.atlandroidexamples.network.model.CurrentWeatherModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {

    var apiService: ApiService? = null
    private const val BASE_URL = "https://api.weatherapi.com/"
//    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    const val API_KEY = "5f045bd5a7c5423d8d370713233010"

    init {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        apiService = retrofit.create(ApiService::class.java)

    }



    fun getCurrentWeather(
        city: String,
        onSuccess: ((CurrentWeatherModel?)-> Unit)?= null,
        onError: ((String?)-> Unit)?= null,
        ){

//        apiService.getCurrentWeather(API_KEY, city)
//            .enqueue(object : Callback<CurrentWeatherModel>{
//            override fun onResponse(
//                call: Call<CurrentWeatherModel>,
//                response: Response<CurrentWeatherModel>
//            ) {
//                onSuccess?.invoke(response.body())
//            }
//
//            override fun onFailure(call: Call<CurrentWeatherModel>, t: Throwable) {
//                onError?.invoke(t.localizedMessage)
//            }
//
//        })


    }



}