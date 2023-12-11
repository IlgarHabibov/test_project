package com.example.atlandroidexamples.lessons.lesson24

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.atlandroidexamples.db.MyDB
import com.example.atlandroidexamples.db.entities.TextEntity
import com.example.atlandroidexamples.network.NetworkManager
import com.example.atlandroidexamples.network.model.CurrentWeatherModel

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.HeaderMap
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap


class SimpleListViewModel: ViewModel() {

//    private val textDAO = MyDB.appDatabase?.getTextDAO()

    private var textEntity: TextEntity? = null

//    val data: LiveData<List<TextEntity>>? = textDAO?.getAllTexts()

    val entityData = MutableLiveData<TextEntity>()


    fun addNewText (text: String){
//        if (textEntity != null){
//            textEntity?.text = text
//            textDAO?.updateText(textEntity!!)
//            textEntity  = null
//        }else {
//            textDAO?.addText(TextEntity(text = text))
//        }
    }

    fun setTextEntityFromList(textEntity: TextEntity){
//        this.textEntity = textEntity
//        entityData.postValue(textEntity)
    }


    fun delete(data: TextEntity){
//        textDAO?.deleteText(data)

    }


}

