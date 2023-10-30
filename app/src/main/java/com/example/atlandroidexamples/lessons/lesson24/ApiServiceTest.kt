package com.example.atlandroidexamples.lessons.lesson24

import com.example.atlandroidexamples.practices.practice10.model.Person
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceTest {

    @POST("user")
    fun createNewUser(
        @Body person: Person
    ): Call<List<String>>

}