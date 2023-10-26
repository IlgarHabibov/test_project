package com.example.atlandroidexamples.utils

import android.content.SharedPreferences

object SharedPrefs {

    private var prefs: SharedPreferences? = null

    fun setPrefs(sharedPreferences: SharedPreferences){
        prefs = sharedPreferences
    }


    fun getInt(key: String):Int?{
        return prefs?.getInt(key, 0)
    }

    fun getString(key: String):String?{
        return prefs?.getString(key, null)
    }

    fun getBool(key: String):Boolean?{
        return prefs?.getBoolean(key, false)
    }

    fun putInt(key: String, value: Int){
        prefs?.edit()?.putInt(key, value)?.apply()
    }

    fun putBool(key: String, value: Boolean){
        prefs?.edit()?.putBoolean(key, value)?.apply()
    }


    fun remove(key: String){
        prefs?.edit()?.remove(key)?.apply()
    }



    const val IS_WELCOME_DONE = "IS_WELCOME_DONE"
    const val FIRST_GRAPH_DONE = "FIRST_GRAPH_DONE"
    const val SECOND_GRAPH_DONE = "SECOND_GRAPH_DONE"
}