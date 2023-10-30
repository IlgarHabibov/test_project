package com.example.atlandroidexamples.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TextEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    var text: String? = null
)