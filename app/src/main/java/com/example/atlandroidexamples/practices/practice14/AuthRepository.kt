package com.example.atlandroidexamples.practices.practice14

import com.example.atlandroidexamples.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface AuthRepository {
    fun login(userName: String, password: String): Result?
    fun logout(): Result?
}

class AuthRepositoryImpl(
    private val apiService: ApiService
): AuthRepository {

    override fun login(userName: String, password: String): Result? {
        return callApi(apiService.getAlbums())
    }

    override fun logout(): Result? {
       return callApi(apiService.getAlbums())
    }

}



fun <T>callApi(call: Call<T>): Result?{
    var result: Result? = null

    call.enqueue(object : Callback<T>{
        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.isSuccessful){
                result = Result.Success(response.body())
            }else{
                result = Result.Error("")
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            result = Result.Error(t.localizedMessage)
        }

    })
    return  result
}

sealed class Result{
    data class Success<out T>(val data: T?): Result()
    data class Error(val message: String?): Result()
}
