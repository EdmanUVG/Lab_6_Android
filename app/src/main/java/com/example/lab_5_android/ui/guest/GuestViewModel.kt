package com.example.lab_5_android.ui.guest

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import androidx.room.Database
import com.example.lab_5_android.database.Guest
import com.example.lab_5_android.database.GuestDatabase
import com.example.lab_5_android.database.GuestDatabaseDao
import com.example.lab_5_android.database.GuestRepository
import kotlinx.coroutines.*

class GuestViewModel(dataSource: GuestDatabaseDao, application: Application) : AndroidViewModel(application) {

    private val repository: GuestRepository

    val allGuests: LiveData<List<Guest>>

    // viewModelJob allows us to cancel all coroutines started by the ViewModel
    private var viewModelJob = Job()


    init {
        val guestsDao = GuestDatabase.getInstance(application).guestDatabaseDao
        repository = GuestRepository(guestsDao)
        allGuests = repository.allGuests
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}