package com.mlbdev.anmp_miniproject.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mlbdev.anmp_miniproject.util.DB_UKUR_NAME

@Database(entities = [DataUkur::class], version = 2)
abstract class UkurDatabase:RoomDatabase() {
    abstract fun ukurDao(): UkurDao

    companion object{
        @Volatile private var instance: UkurDatabase ?= null
        private val LOCK = Any()

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                UkurDatabase::class.java,
                DB_UKUR_NAME
            )
                .fallbackToDestructiveMigration()
                .build()


        operator fun invoke(context: Context){
            if(instance == null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }
    }
}