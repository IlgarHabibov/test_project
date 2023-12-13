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
    private val repository: AlbumRepository,
    private val apiService: ApiService
) : ViewModel() {

    private var _state = MutableStateFlow(listOf<AlbumModel>())
    val state = _state.asStateFlow()

    fun getData() {
        viewModelScope.launch {
            val result = repository.getAlbums()
            result.collect {
                when (it) {
                    is ResultWrapper.Success -> {
                        it.data?.forEach {
                            Log.d(TAG, " Element -> $it")
                        }
                    }
                    is ResultWrapper.Error -> {
                        Log.d(TAG, "error -> $result")
                    }
                }
            }


//            val result = handleResult {
//                apiService.getAlbums2()
//            }
//
//            when(result){
//                is ResultWrapper.Success -> {
//                    result.data?.forEach {
//                        Log.d(TAG, " Element -> $it")
//                    }
//                    _state.value = result.data ?: listOf()
//                }
//                is ResultWrapper.Error -> {
//                    Log.d(TAG, "error -> $result")
//                }
//            }

        }
    }

    fun getUser(id: Int) {
        viewModelScope.launch {
            when (val result = repository.getUsers(id)) {
                is ResultWrapper.Success -> {

                }

                is ResultWrapper.Error -> {
                    Log.d(TAG, "error -> $result")
                }
            }
        }
    }


    fun getName(): String {

        return ""
    }


    companion object {
        private const val TAG = "CoroutinesTestTag"
    }
}
