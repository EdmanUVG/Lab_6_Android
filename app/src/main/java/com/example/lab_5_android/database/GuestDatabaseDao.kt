package com.example.lab_5_android.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GuestDatabaseDao {

    @Insert
    fun insert(guest: Guest)

    @Update
    fun update(guest: Guest)

    @Query("SELECT * FROM guest_table WHERE id = :key")
    fun getGuest(key: Long): Guest?

    @Query("SELECT * FROM guest_table ORDER BY id DESC")
    fun getGuests(): LiveData<List<Guest>>

    @Query("SELECT COUNT(*) FROM guest_table")
    fun getGuestCount(): LiveData<Int>

    @Query("SELECT g.*, r.role FROM guest_table g LEFT JOIN guest_role_table r ON g.role_id = r.id")
    fun getGuestsWithRole(): LiveData<List<GuestWithRole>>


//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun addGuest(guest:Guest)

//    @Query ("SELECT * from guest_count_table WHERE guestId = :key")
//    fun getGuestById(key:Long):Guest?

//    @Query("SELECT * FROM guest_count_table ORDER BY guestId DESC LIMIT 1")
//    fun getGuest(): Guest?

//    @Query("SELECT * FROM guest_count_table ORDER BY guestId DESC")
//    fun getGuests(): LiveData<List<Guest>>

//    @Query("SELECT COUNT(guestId) FROM guest_count_table")
//    fun getNumberOfRows(): Int?
//
//    @Query("DELETE FROM guest_count_table")
//    fun deleteAll()

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertOrUpdateGuest(guest: Guest): Long
}