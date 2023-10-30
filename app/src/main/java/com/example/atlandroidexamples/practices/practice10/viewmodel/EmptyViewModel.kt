package com.example.atlandroidexamples.practices.practice10.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.atlandroidexamples.practices.practice10.model.State
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EmptyViewModel: ViewModel() {

    private var count = 0
    private val _liveData = MutableLiveData<State>(State.None)
    val liveData: LiveData<State> get() = _liveData



    fun increase(){
        viewModelScope.launch {
            _liveData.postValue(State.Loading)
            if (count < 10){
                delay(1000)
                count++
                _liveData.postValue(State.Success(count))
            } else {
                _liveData.postValue(State.Error("10 den boyuk ola bilmez"))
            }


        }

    }
}