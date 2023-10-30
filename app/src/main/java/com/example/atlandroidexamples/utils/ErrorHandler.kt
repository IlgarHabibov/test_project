package com.example.atlandroidexamples.utils

interface ErrorHandler {

    fun onError(message: String)
}

class ErrorHandlerImpl(): ErrorHandler{
    override fun onError(message: String) {

    }

}