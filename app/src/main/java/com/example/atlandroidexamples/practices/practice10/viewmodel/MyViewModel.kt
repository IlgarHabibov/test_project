package com.example.atlandroidexamples.practices.practice10.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.savedstate.SavedStateRegistryOwner

class MyViewModel(private val data: String): ViewModel(){


//    private val _data =  MutableLiveData<Int>(1)
//    val myLiveData: LiveData<Int> get() = _data
//
//    fun changeData(){
//        _data.postValue(0)
//    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                MyViewModel(
                    ""
                )
            }
        }
    }
}


class MyViewModelFactory(private val data: String) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            return MyViewModel(data) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}