package com.example.atlandroidexamples.practices.practice21.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.atlandroidexamples.practices.practice21.notes.Result
import com.example.atlandroidexamples.practices.practice21.notes.repository.NotesRepository
import com.example.atlandroidexamples.practices.practice21.utils.FirebaseConstants
import com.google.firebase.firestore.Query
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesVM @Inject constructor(
    private val notesRepository: NotesRepository
) : ViewModel() {


    private val _state = MutableLiveData<UiState>(UiState.None)
    val state: LiveData<UiState> = _state


    fun getNotes() {
        _state.value = UiState.Loading(true)

        notesRepository.getNotes {
            when(it){
                is Result.Success ->{
                    _state.value = UiState.Loading(false)
                    _state.value = UiState.Data(it.data)
                }
                is Result.Error ->{
                    _state.value = UiState.Loading(false)
                    _state.value = UiState.Error(it.message)
                }
            }
        }

    }


    sealed class UiState {
        data object None : UiState()
        data class Loading(var isLoading: Boolean) : UiState()
        data class Data(val data: List<NoteModel>) : UiState()
        data class Error(var error: String?) : UiState()
    }


    //    private val _state = MutableLiveData<State>(State())
//    val state: LiveData<State> = _state

//    fun getNotes() {
//        _state.postValue(State(isLoading = true))
//        fireStore.collection(FirebaseConstants.NOTES)
//            .orderBy("date", Query.Direction.DESCENDING)
//            .get()
//
//            .addOnSuccessListener {
//                val items = it.toObjects(NoteModel::class.java)
//                items.let { list ->
//                    _state.postValue(
//                        State(
//                            isLoading = false,
//                            data = list
//                        )
//                    )
//                }
//            }
//            .addOnFailureListener {
//                _state.postValue(
//                    State(
//                        isLoading = false,
//                        error = it.message
//                    )
//                )
//            }
//
//    }


//    data class State(
//        var isLoading: Boolean = false,
//        var error: String? = null,
//        var data: List<NoteModel>? = null
//    )


}