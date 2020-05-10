package com.example.lab_5_android.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Guest::class], version = 3, exportSchema = false)
abstract class GuestDatabase: RoomDatabase() {

    abstract val guestDatabaseDao: GuestDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: GuestDatabase? = null

        fun getInstance(context: Context): GuestDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GuestDatabase::class.java,
                        "guest_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}