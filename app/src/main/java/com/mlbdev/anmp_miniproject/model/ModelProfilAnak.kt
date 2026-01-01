package com.mlbdev.anmp_miniproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataProfilAnak (
    @ColumnInfo(name="name")
    var name: String,
    @ColumnInfo(name="dob")
    var dob: String,
    @ColumnInfo(name="gender")
    var gender: String
){
    @PrimaryKey
    var id:Int = 1
}