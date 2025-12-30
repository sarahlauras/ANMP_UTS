package com.mlbdev.anmp_miniproject.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UkurDao {
    @Query("SELECT * FROM dataukur")
    fun SelectAll(): List<DataUkur>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun InsertAll(vararg dataUkur: DataUkur)

}