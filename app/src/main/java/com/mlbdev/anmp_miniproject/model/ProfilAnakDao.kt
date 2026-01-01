package com.mlbdev.anmp_miniproject.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProfilAnakDao {
    @Query("SELECT * FROM dataprofilanak WHERE id = 1 LIMIT 1")
    fun getProfilAnak(): DataProfilAnak?

    @Insert
    fun insertProfil(data: DataProfilAnak)

    @Update
    fun updateProfilAnak(dataProfilAnak: DataProfilAnak)
}