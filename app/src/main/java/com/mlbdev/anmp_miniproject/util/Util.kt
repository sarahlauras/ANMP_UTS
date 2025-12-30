package com.mlbdev.anmp_miniproject.util

import android.content.Context
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mlbdev.anmp_miniproject.model.UkurDatabase

val DB_NAME = "ukurdb"
fun buildDB(context: Context): UkurDatabase{
    val db = UkurDatabase.buildDatabase(context)
    return db
}