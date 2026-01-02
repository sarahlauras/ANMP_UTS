package com.mlbdev.anmp_miniproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataUkur (
    @ColumnInfo(name="age")
    var age: String,
    @ColumnInfo(name="height")
    var height: String,
    @ColumnInfo(name="weight")
    var weight: String
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}