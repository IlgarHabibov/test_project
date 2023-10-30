package com.example.atlandroidexamples.db

object MyDB{

    var appDatabase: AppDatabase? = null

    fun setDataBase(appDatabase: AppDatabase){
        MyDB.appDatabase = appDatabase
    }

}