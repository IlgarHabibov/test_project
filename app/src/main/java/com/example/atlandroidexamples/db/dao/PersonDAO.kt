package com.example.atlandroidexamples.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.atlandroidexamples.db.entities.PersonEntity

@Dao
interface PersonDAO {
    @Insert
    fun addPerson(person: PersonEntity)

    @Update
    suspend fun updatePerson(person: PersonEntity)

    @Upsert
    suspend fun updateOrInsertPerson(person: PersonEntity)

    @Delete
    suspend fun deletePerson(person: PersonEntity)

    @Query("SELECT * FROM PersonEntity")
    fun getAllPersons(): LiveData<List<PersonEntity>>

}