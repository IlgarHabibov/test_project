package com.example.atlandroidexamples.practices.practice21.notes

import com.google.firebase.Timestamp
import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class NoteModel(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    @ServerTimestamp
    val date: Date? = null,
    val imageUrl: String? = null,
)
