package com.example.lab_5_android.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface GuestDatabaseDao {

    @Insert
    fun insert(gues:Guest)

    @Update
    fun update(guest: Guest)

    @Query ("SELECT * from guest_count_table WHERE guestId = :key")
    fun get(key:Long):Guest?

    @Query("DELETE FROM guest_count_table")
    fun clear()

    @Query("SELECT * FROM guest_count_table ORDER BY guestId DESC LIMIT 1")
    fun getCurrentGuest(): Guest?

    @Query("SELECT * FROM guest_count_table ORDER BY guestId DESC")
    fun getAllGuests(): LiveData<List<Guest>>

}