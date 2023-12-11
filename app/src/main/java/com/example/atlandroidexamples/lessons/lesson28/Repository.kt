package com.example.atlandroidexamples.lessons.lesson28

import retrofit2.Retrofit
import javax.inject.Inject

abstract class AuthRepository{
    abstract fun login(name: String): String
    abstract fun logout(): String
}

class AuthRepositoryImpl @Inject constructor (
    retrofit: Retrofit
): AuthRepository(){

    override fun login(name: String): String {
        return "My Name is $name"
    }

    override fun logout(): String {
        return "logged out"
    }

}