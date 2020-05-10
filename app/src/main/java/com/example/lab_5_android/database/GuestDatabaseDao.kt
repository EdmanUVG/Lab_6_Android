package com.example.lab_5_android.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GuestDatabaseDao {

    @Query ("SELECT * from guest_count_table WHERE guestId = :key")
    fun getGuestById(key:Long):Guest?

    @Delete
    fun deleteGuest(guest:Guest)

    @Query("SELECT * FROM guest_count_table ORDER BY guestId DESC LIMIT 1")
    fun getGuest(): Guest?

    @Query("SELECT * FROM guest_count_table")
    fun getGuests(): LiveData<List<Guest>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateGuest(guest: Guest): Long

}