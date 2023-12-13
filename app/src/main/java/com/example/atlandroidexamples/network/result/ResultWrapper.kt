package com.example.atlandroidexamples.network.result

import com.google.gson.annotations.SerializedName

sealed class ResultWrapper <out T> {
    data class Success <T>(val data: T): ResultWrapper<T>()
    data class Error (val message: String): ResultWrapper<Nothing>()
}
