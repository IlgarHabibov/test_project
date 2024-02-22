package com.example.atlandroidexamples.practices.practice21.notes.repository

import com.example.atlandroidexamples.practices.practice21.notes.NoteModel
import com.example.atlandroidexamples.practices.practice21.notes.Result

interface NotesRepository {

    fun getNotes(onResult: (result: Result<List<NoteModel>>) -> Unit)
}