package com.example.atlandroidexamples.lessons.lesson45

import com.example.atlandroidexamples.practices.practice21.notes.NoteModel

interface NotesContractor {

    interface Presenter{
        fun getNotes()
        fun onDestroy()
    }

    interface View{
        fun showLoading(isLoading: Boolean)
        fun onSuccess(notes: List<NoteModel>)
        fun onFail(errorMessage: String?)
    }

}