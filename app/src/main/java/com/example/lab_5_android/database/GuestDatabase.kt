package com.example.lab_5_android.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Guest::class], version = 8, exportSchema = false)
public abstract class GuestDatabase: RoomDatabase() {

    abstract val guestDatabaseDao: GuestDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: GuestDatabase? = null

        fun getInstance(context: Context): GuestDatabase {

            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder (
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