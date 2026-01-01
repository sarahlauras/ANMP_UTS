package com.mlbdev.anmp_miniproject.util

import android.content.Context
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mlbdev.anmp_miniproject.model.ProfilAnakDatabase
import com.mlbdev.anmp_miniproject.model.UkurDatabase

//val DB_NAME = "ukurdb"
//fun buildDB(context: Context): UkurDatabase{
//    val db = UkurDatabase.buildDatabase(context)
//    return db
//}

const val DB_PROFIL_NAME = "profil_db"
const val DB_UKUR_NAME = "ukur_db"

fun buildProfilDB(context: Context): ProfilAnakDatabase {
    return ProfilAnakDatabase.buildDatabase(context)
}

fun buildUkurDB(context: Context): UkurDatabase {
    return UkurDatabase.buildDatabase(context)
}