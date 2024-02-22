package com.example.atlandroidexamples.practices.practice21.notes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.atlandroidexamples.practices.practice21.utils.FirebaseConstants
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.core.OrderBy
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.installations.ktx.installations
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.options
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesMVIVM @Inject constructor(
    private val fireStore: FirebaseFirestore
) : ViewModel() {


    private val _state = MutableLiveData<UiState>(UiState.None)
    val state: LiveData<UiState> = _state


    fun obtainEvent(event: Event){
        when(event){
            is Event.GetNotes -> getNotes()
            is Event.CheckButton -> checkButton()
        }
    }

    private fun checkButton() {
        viewModelScope.launch {
            delay(2000)
            _state.value = UiState.Navigate
        }
    }


    private fun getNotes() {
        _state.value = UiState.Loading(true)
        fireStore.collection(FirebaseConstants.NOTES)
            .orderBy("date", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener {
                val items = it.toObjects(NoteModel::class.java)
                items.let { list ->
                    _state.value = UiState.Loading(false)
                    _state.value = UiState.Data(list)

                }
            }
            .addOnFailureListener {
                _state.value = UiState.Loading(false)
                _state.value = UiState.Error(it.message)

            }




    }


    sealed interface Event{
        data object GetNotes: Event
        data object CheckButton: Event
    }


    sealed class UiState {
        data object None : UiState()
        data class Loading(var isLoading: Boolean) : UiState()
        data class Data(val data: List<NoteModel>) : UiState()
        data object Navigate : UiState()
        data class Error(var error: String?) : UiState()
    }

}