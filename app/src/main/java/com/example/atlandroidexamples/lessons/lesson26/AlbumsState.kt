package com.example.atlandroidexamples.lessons.lesson26

import com.example.atlandroidexamples.network.model.AlbumModel

sealed class AlbumsState{
    data class Success(var albumsList: List<AlbumModel>?): AlbumsState()
    data class Error(var message: String?): AlbumsState()
    object Loading: AlbumsState()
}
