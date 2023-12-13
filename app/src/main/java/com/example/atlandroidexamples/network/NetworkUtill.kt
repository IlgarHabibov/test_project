package com.example.atlandroidexamples.network

import com.example.atlandroidexamples.network.result.ErrorModel
import com.example.atlandroidexamples.network.result.ResultWrapper
import com.google.gson.Gson
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response

suspend fun <T> handleResult(
    apiCall: suspend () -> Response<T>?
): ResultWrapper<T?> {
    return try {
        val result = apiCall()
        if(result?.isSuccessful == true){
            ResultWrapper.Success(result.body())
        }else{
            val errorBody = result?.errorBody()?.getErrorObject<ErrorModel>()
            ResultWrapper.Error(message = "Xeta Bas verdi")
        }
    }catch (throwable:Throwable){
        ResultWrapper.Error(message = throwable.message.toString())

    }
}

inline fun <reified T> ResponseBody.getErrorObject(): T {
    val gson = Gson()
    val jsonObject = JSONObject(charStream().readText())
    return gson.fromJson(jsonObject.toString(), T::class.java)
}