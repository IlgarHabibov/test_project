package com.example.atlandroidexamples.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.atlandroidexamples.db.entities.TextEntity

@Dao
interface TextDAO {

    @Insert
    fun addText(text: TextEntity)

    @Upsert
    fun updateText(text: TextEntity)

    @Delete
    fun deleteText(text: TextEntity)

    @Query("SELECT * FROM TextEntity")
    fun getAllTexts(): LiveData<List<TextEntity>>

}