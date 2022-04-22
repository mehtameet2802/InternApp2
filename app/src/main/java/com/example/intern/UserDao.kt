package com.example.intern

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    suspend fun addData(data:TheProject)

    @Query("SELECT * FROM yes_thats_me ORDER BY id ASC")
    fun readData() : LiveData<List<TheProject>>

//    @Query("SELECT COUNT(*) FROM yes_thats_me")
//    fun length(): Int
}