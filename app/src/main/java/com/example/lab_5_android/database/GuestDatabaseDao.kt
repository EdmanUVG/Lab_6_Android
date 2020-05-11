package com.example.lab_5_android.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GuestDatabaseDao {

    @Insert
    suspend fun addGuest(guest:Guest)

    @Query ("SELECT * from guest_count_table WHERE guestId = :key")
    suspend fun getGuestById(key:Long):Guest?

    @Delete
    suspend fun deleteGuest(guest:Guest)

    @Query("SELECT * FROM guest_count_table ORDER BY guestId DESC LIMIT 1")
    suspend fun getGuest(): Guest?

    @Query("SELECT * FROM guest_count_table")
    suspend fun getGuests(): List<Guest>

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertOrUpdateGuest(guest: Guest): Long
}