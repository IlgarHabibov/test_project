package com.example.atlandroidexamples.practices.practice21.create_notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.atlandroidexamples.practices.practice21.notes.NoteModel
import com.example.atlandroidexamples.practices.practice21.utils.FirebaseConstants
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateNoteVM @Inject constructor(
    private val fireStore: FirebaseFirestore,
    private val storage: FirebaseStorage,
) : ViewModel() {

    private val _state = MutableLiveData<Boolean>()
    val state: LiveData<Boolean> get() = _state


    fun createNewNote(title: String, noteText: String) {
        val id = Firebase.firestore.collection(FirebaseConstants.NOTES).document().id
        fireStore.collection(FirebaseConstants.NOTES)
            .document(id)
            .set(
                NoteModel(
                    id = id,
                    title = title,
                    description = noteText
                )
            ).addOnSuccessListener {
                _state.postValue(true)
            }
    }


//    fun createNewNote(title: String, noteText: String){
//        val id = fireStore.collection(FirebaseConstants.NOTES).document().id
//        val note = NoteModel(
//            id = id,
//            title = title,
//            description = noteText,
//        )
//        fireStore.collection(FirebaseConstants.NOTES)
//            .document(id)
//            .set(note)
//            .addOnSuccessListener {
//                viewModelScope.launch{
//                    _state.emit(true)
//                }
//            }
//    }


//    fun sendNote(title: String, noteText: String, imageURI: String? = null) {
//        if (imageURI == null){
//            createNewNote(title, noteText, null)
//        }else {
//            uploadImage(title, noteText, imageURI)
//        }
//    }

//    private fun uploadImage(title: String, note: String, imageURI: String) {
//        val fileName = "image_${System.currentTimeMillis()}.jpg"
//        val storageRef = storage.reference.child("images").child(fileName)
//        val baos = ByteArrayOutputStream()
//    }


}