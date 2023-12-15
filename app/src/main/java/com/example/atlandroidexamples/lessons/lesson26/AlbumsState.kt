package com.example.atlandroidexamples.lessons.lesson26

import com.example.atlandroidexamples.network.model.AlbumModel
import com.example.atlandroidexamples.network.result.ResultWrapper

sealed class AlbumsState{
    data class Success(var albumsList: List<AlbumModel>?): AlbumsState()
    data class Error(var message: String?): AlbumsState()
    object Loading: AlbumsState()

//    companion object{
//        fun <T: List<AlbumModel>?> fromAPI (result: ResultWrapper<T>?): AlbumsState {
//            return when(result){
//                is ResultWrapper.Success -> AlbumsState.Success(result.data)
//                is ResultWrapper.Error -> AlbumsState.Error(result.message)
//                else -> AlbumsState.Error("")
//            }
//        }
//    }
}



