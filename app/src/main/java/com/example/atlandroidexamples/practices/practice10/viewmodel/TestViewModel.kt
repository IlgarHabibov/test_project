package com.example.atlandroidexamples.practices.practice10.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.atlandroidexamples.practices.practice10.model.Person

class TestViewModel(private val title: String): ViewModel() {

    val name = "Ilgar Habibov"


    val testList = listOf(
        Person("Ilgar"),
        Person("Nurlan")
    )


    fun getData() = title



    fun filterList(list: List<String>) : List<String>{

        return listOf()
    }



    companion object{
        fun factory(name: String): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                TestViewModel(name)
            }
        }
    }
}

class TestViewModelFactory(val title: String): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TestViewModel(title) as T
    }
}