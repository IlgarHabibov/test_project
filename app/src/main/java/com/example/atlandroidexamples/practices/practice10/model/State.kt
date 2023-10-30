package com.example.atlandroidexamples.practices.practice10.model

sealed class State(){
    data class Success(val data: Int): State()
    data class Error(val message: String): State()
    object Loading: State()
    object None: State()
}
