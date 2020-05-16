package com.example.lab_5_android.database

import androidx.lifecycle.LiveData

class GuestRepository(private val getDatabaseDao: GuestDatabaseDao) {

    val allGuests: LiveData<List<Guest>> = getDatabaseDao.getGuests()

    suspend fun addGuest(guest: Guest) {
        getDatabaseDao.addGuest(guest)
    }
}