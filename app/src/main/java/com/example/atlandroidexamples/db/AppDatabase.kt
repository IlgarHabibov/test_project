package com.example.atlandroidexamples.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.atlandroidexamples.db.dao.PersonDAO
import com.example.atlandroidexamples.db.entities.PersonEntity
import com.example.atlandroidexamples.db.entities.StudentEntity
import com.example.atlandroidexamples.db.dao.StudentDAO
import com.example.atlandroidexamples.db.dao.TextDAO
import com.example.atlandroidexamples.db.entities.TextEntity


@Database(
    entities = [PersonEntity::class, StudentEntity::class, TextEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getPersonDAO(): PersonDAO

    abstract fun getStudentDAO(): StudentDAO
    abstract fun getTextDAO(): TextDAO

}