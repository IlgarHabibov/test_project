package com.example.atlandroidexamples.lessons.lesson26

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.atlandroidexamples.network.NetworkManager
import com.example.atlandroidexamples.network.model.AlbumModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumsViewModel: ViewModel() {

    private var _data = MutableLiveData<AlbumsState>()
    val data: LiveData<AlbumsState> get() = _data

    fun getAlbums(){
        _data.postValue(AlbumsState.Loading)
         val call = NetworkManager.apiService?.getAlbums()
        call?.enqueue(object : Callback<List<AlbumModel>>{
            override fun onResponse(
                call: Call<List<AlbumModel>>,
                response: Response<List<AlbumModel>>
            ) {
                if (response.isSuccessful){
                    _data.postValue(AlbumsState.Success(response.body()))
                }else{
                    _data.postValue(AlbumsState.Error(" melumatlar yuklenmedi"))
                }

            }

            override fun onFailure(call: Call<List<AlbumModel>>, t: Throwable) {
                _data.postValue(AlbumsState.Error(" melumatlar yuklenmedi"))
            }

        })

    }
}