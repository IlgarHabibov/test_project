package com.example.atlandroidexamples.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StudentEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val studentId: Int = 0,
    val studentName: String? = null,
    val studentAge: Int? = null,
    val studentAddress: Int? = null
)
