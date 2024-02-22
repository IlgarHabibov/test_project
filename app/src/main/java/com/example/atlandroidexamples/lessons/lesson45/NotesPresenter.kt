package com.example.atlandroidexamples.lessons.lesson45

import android.util.Log
import com.example.atlandroidexamples.practices.practice21.notes.NoteModel
import com.example.atlandroidexamples.practices.practice21.utils.FirebaseConstants
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class NotesPresenter(private var view: NotesContractor.View?): NotesContractor.Presenter {

    override fun getNotes() {
        view?.showLoading(true)
        Firebase.firestore.collection("FirebaseConstants.NOTES")
            .orderBy("date", Query.Direction.DESCENDING)
            .get()

            .addOnSuccessListener {
                val items = it.toObjects(NoteModel::class.java)
                items?.let {list ->
                    view?.showLoading(false)
                    view?.onSuccess(list)
                }
            }
            .addOnFailureListener {
                view?.showLoading(false)
                view?.onFail(it.message)
            }
    }

    override fun onDestroy() {
        view = null
    }

}