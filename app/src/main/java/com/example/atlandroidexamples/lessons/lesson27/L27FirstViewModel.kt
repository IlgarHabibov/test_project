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
import com.example.atlandroidexamples.network.model.AlbumModel
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
   private val apiService: ApiService
): ViewModel() {


    val data = MutableLiveData<String>()


    val state = MutableStateFlow(0)

    val shared = MutableSharedFlow<Int>(
        replay = 1,
        extraBufferCapacity = 2,
        onBufferOverflow = BufferOverflow.SUSPEND
    )

    fun getName(): String{

        return ""
    }

    fun startCoroutines(){


        viewModelScope.launch {

            delay(2000)
            shared.emit(22)
            delay(2000)
            shared.tryEmit(46)
        }
//
//            val flow1 = flowOf(1,2,3,4)
//            val flow2 = flowOf(5,6,7,8,9, 10)
//
//
//            flow1.zip(flow2){element1, element2 ->
//                element1 + element2
//            }.collect{element ->
//                Log.d(TAG, " element -> $element")
//
//            }
//
//            list.asFlow()
//                .filter { element
//                    -> element >= 3
//                }
//                .map { element ->
//                    element - 1
//                }
//                .transform { element ->
//                    emit("$element start")
//                    emit("$element ${element - 1}")
//                    emit("$element ${element - 2}")
//                    emit("$element end")
//                }
//                .collect{element ->
////                    Log.d(TAG, " element -> $element")
//                }

    }


    private fun createFlow() = flow{
        emit(0)
        emit(1)
        emit(2)
        emit(3)
        emit(4)
        emit(5)
    }


    companion object{
        private const val TAG = "CoroutinesTestTag"
    }
}
