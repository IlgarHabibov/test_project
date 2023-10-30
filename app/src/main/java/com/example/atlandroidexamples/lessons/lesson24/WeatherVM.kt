package com.example.atlandroidexamples.lessons.lesson24

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.atlandroidexamples.network.NetworkManager
import com.example.atlandroidexamples.network.model.CurrentWeatherModel
import com.example.atlandroidexamples.network.model.User
import com.example.atlandroidexamples.practices.practice10.model.Person
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherVM: ViewModel() {


    val weatherData = MutableLiveData<User?>()
    private var count = 0

    fun getWeather(){
//        val city = "London"
        count++
        val userId = 4

        NetworkManager.apiService
            .getUser(  count)
            .enqueue(object: Callback<User?>{
                override fun onResponse(call: Call<User?>, response: Response<User?>) {
                    weatherData.postValue(response.body())
                }

                override fun onFailure(call: Call<User?>, t: Throwable) {

                }

            })

//        NetworkManager.getCurrentWeather(
//            city,
//            onSuccess = {
//
//            },
//            onError = {
//
//            }
//        )
    }

}