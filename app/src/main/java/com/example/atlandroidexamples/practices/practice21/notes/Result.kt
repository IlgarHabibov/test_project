package com.example.atlandroidexamples.practices.practice21.notes


sealed class Result <out T> {
    data class Success <T>(val data: T): Result<T>()
    data class Error (val message: String?): Result<Nothing>()
}