package com.example.atlandroidexamples.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {
    override fun intercept(
        chain: Interceptor.Chain
    ): Response {
        val request = chain.request()
        val modifiedRequest = request.newBuilder()
            .addHeader("Authorization", "token")
            .build()
        return chain.proceed(modifiedRequest)
    }
}