package com.example.atlandroidexamples.db.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class PersonEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    var firstName: String? = null,

    var lastName: String? = null,

    var address: String? = null,

    @Ignore val age: Int? = null,
)