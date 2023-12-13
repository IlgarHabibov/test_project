package com.example.atlandroidexamples.lessons.lesson27

import com.example.atlandroidexamples.network.ApiService
import com.example.atlandroidexamples.network.handleResult
import com.example.atlandroidexamples.network.model.AlbumModel
import com.example.atlandroidexamples.network.model.User
import com.example.atlandroidexamples.network.result.ResultWrapper
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AlbumRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getAlbums(): ResultWrapper<List<AlbumModel>?>{
        return handleResult {
             apiService.getAlbums2()
        }
    }

    suspend fun getUsers(userId: Int):  ResultWrapper<User?>{
        return handleResult {
            apiService.getUser(userId)
        }
    }


}