package com.mlbdev.anmp_miniproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataProfilAnak (
    @ColumnInfo(name="name")
    var name: Int,
    @ColumnInfo(name="dob")
    var dob: Int,
    @ColumnInfo(name="gender")
    var gender: Int
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}