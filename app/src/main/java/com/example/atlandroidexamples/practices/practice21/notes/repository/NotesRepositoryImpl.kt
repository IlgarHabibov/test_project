package com.example.atlandroidexamples.practices.practice21.notes.repository

import com.example.atlandroidexamples.practices.practice21.notes.NoteModel
import com.example.atlandroidexamples.practices.practice21.notes.NotesVM
import com.example.atlandroidexamples.practices.practice21.notes.Result
import com.example.atlandroidexamples.practices.practice21.utils.FirebaseConstants
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import javax.inject.Inject

class NotesRepositoryImpl @Inject constructor (
    private val fireStore: FirebaseFirestore
): NotesRepository {

    override fun getNotes(onResult: (result: Result<List<NoteModel>>) -> Unit) {
        fireStore.collection(FirebaseConstants.NOTES)
            .orderBy("date", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener {
                val items = it.toObjects(NoteModel::class.java)
                onResult.invoke(Result.Success(data = items))
            }
            .addOnFailureListener {
                onResult.invoke(Result.Error(message = it.message))

            }



    }
}