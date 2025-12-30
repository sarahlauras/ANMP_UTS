package com.mlbdev.anmp_miniproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class DataUkur (
    @ColumnInfo(name="age")
    var age: Int,
    @ColumnInfo(name="height")
    var height: Int,
    @ColumnInfo(name="weight")
    var weight: Int
)