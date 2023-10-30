package com.example.atlandroidexamples.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.atlandroidexamples.db.entities.StudentEntity

@Dao
interface StudentDAO {

    @Insert
    fun addNewStudent(student: StudentEntity)

    @Update
    fun updateStudent(student: StudentEntity)

    @Delete
    fun deleteStudent(student: StudentEntity)

    @Upsert
    fun addOrUpdateStudent(student: StudentEntity)

    @Query("SELECT studentName FROM StudentEntity")
    fun getStudentNames(): LiveData<List<String>>

    @Query("SELECT * FROM StudentEntity")
    fun getStudents(): LiveData<List<StudentEntity>>

}