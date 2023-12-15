package com.example.atlandroidexamples.lessons.lesson26

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.atlandroidexamples.network.ApiService
import com.example.atlandroidexamples.network.NetworkManager
import com.example.atlandroidexamples.network.handleResult
import com.example.atlandroidexamples.network.model.AlbumModel
import com.example.atlandroidexamples.network.result.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    private var _data = MutableLiveData<AlbumsState>()
    val data: LiveData<AlbumsState> get() = _data

    fun getAlbums(){

        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(AlbumsState.Loading)

//            val result = handleResult {
//                apiService.getAlbums2()
//            }
//            _data.postValue(AlbumsState.fromAPI(result))
//            when(result){
//                is ResultWrapper.Success -> {
//                    _data.postValue(AlbumsState.Success(result.data))
//                }
//                is ResultWrapper.Error ->{
//                    _data.postValue(AlbumsState.Error(result.message))
//                }
//            }

            try {
                val result = apiService.getAlbums1()
                if (result.isSuccessful){
                    _data.postValue(AlbumsState.Success(result.body()))
                }else{
                    _data.postValue(AlbumsState.Error(result.errorBody().toString()))
                }
            }catch (e: Exception){
                _data.postValue(AlbumsState.Error(""))
            }






        }

    }
}
