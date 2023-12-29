package com.example.atlandroidexamples.lessons.lesson27

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.PrimaryKey
import com.example.atlandroidexamples.db.AppDatabase
import com.example.atlandroidexamples.lessons.lesson26.AlbumsState
import com.example.atlandroidexamples.lessons.lesson28.AuthRepository
import com.example.atlandroidexamples.network.ApiService
import com.example.atlandroidexamples.network.AuthApiService
import com.example.atlandroidexamples.network.NetworkManager
import com.example.atlandroidexamples.network.handleResult
import com.example.atlandroidexamples.network.model.AlbumModel
import com.example.atlandroidexamples.network.result.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class L27FirstViewModel @Inject constructor(
   private val apiService: ApiService
) : ViewModel() {

    val data = MutableLiveData<List<AlbumModel>>()

    fun getData() {
        apiService.getAlbums().enqueue(object : Callback<List<AlbumModel>>{

            override fun onResponse(
                call: Call<List<AlbumModel>>,
                response: Response<List<AlbumModel>>
            ) {
                if (response.isSuccessful){
                    data.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<AlbumModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getName() = "Ilgar"

    companion object {
        private const val TAG = "CoroutinesTestTag"
    }
}
