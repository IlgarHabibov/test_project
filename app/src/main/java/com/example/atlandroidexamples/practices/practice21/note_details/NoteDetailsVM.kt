package com.example.atlandroidexamples.practices.practice21.note_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.atlandroidexamples.practices.practice21.notes.NoteModel
import com.example.atlandroidexamples.practices.practice21.utils.FirebaseConstants
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteDetailsVM @Inject constructor(
    private val fireStore: FirebaseFirestore
) : ViewModel() {

    private val _state = MutableLiveData<NoteModel>()
    val state: LiveData<NoteModel> get() = _state

    private var noteId = ""

    fun setNoteId(id: String?) {
        id?.let {
            noteId = it
        }
    }


    fun getNoteDetails() {
        fireStore.collection(FirebaseConstants.NOTES)
            .document(noteId)
            .get()
            .addOnSuccessListener {
                val note = it.toObject(NoteModel::class.java)
                note?.let {n ->
                    _state.postValue(n)
                }

            }
    }


}