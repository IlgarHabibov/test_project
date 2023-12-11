package com.example.atlandroidexamples

import android.app.Application
import androidx.room.Room
import com.example.atlandroidexamples.db.AppDatabase
import com.example.atlandroidexamples.db.MyDB
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {


    override fun onCreate() {
        super.onCreate()

//        val appDatabase = Room.databaseBuilder(
//            applicationContext,
//            AppDatabase::class.java,
//            "app-database"
//        ).allowMainThreadQueries()
//            .build()
//
//        MyDB.appDatabase = appDatabase
    }
}