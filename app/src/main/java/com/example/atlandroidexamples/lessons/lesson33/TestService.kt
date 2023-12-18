package com.example.atlandroidexamples.lessons.lesson33

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class TestService: Service() {

    private val binder = TestBinder()

    override fun onBind(p0: Intent?): IBinder? {
        return binder
    }

    inner class TestBinder: Binder(){
        fun getMyService() = this@TestService
    }

    fun getMyFullName(name: String, surname: String):String{
        return "$name $surname"
    }
}