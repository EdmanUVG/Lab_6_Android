package com.example.lab_5_android.ui.guest

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import androidx.room.Database
import com.example.lab_5_android.database.Guest
import com.example.lab_5_android.database.GuestDatabaseDao
import com.example.lab_5_android.formatGuests
import kotlinx.coroutines.*

class GuestViewModel(val database: GuestDatabaseDao, application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    // Get all guest from database
    private val guests = database.getGuests()

    private val _guest_name = MutableLiveData<String>()
    val guest_name: LiveData<String>
    get() = _guest_name

    private val _guest_phone = MutableLiveData<String>()
    val guest_phone: LiveData<String>
        get() = _guest_phone

    private val _guest_email = MutableLiveData<String>()
    val guest_email: LiveData<String> get() = _guest_email


    // Current guest
    private var guest = MutableLiveData<Guest?>()

    init {
        initializeGuest()
    }

    private fun initializeGuest() {
        uiScope.launch {
            guest.value = getGuestFromDatabase()
        }
    }

    private suspend fun getGuestFromDatabase():Guest?{
        return withContext(Dispatchers.IO) {
            val invitado = database.getGuest()
            invitado
        }
    }

    fun onStartTracking(){
        uiScope.launch {
            val newGuest = Guest(34, "Edman", "474858", "correo electornico")

            insertGuest(newGuest)
        }
    }

    private suspend fun insertGuest(guest: Guest) {
        withContext(Dispatchers.IO) {
            database.insertOrUpdateGuest(guest)
            database.getGuests()

            // Current errro cannot assigned value inside another thread
            getInvitados()

            Log.i("@Edman", "Id: id : ${guest.guestId}")
            Log.i("@Edman", "Id: id : ${guest.name}")
            Log.i("@Edman", "Id: id : ${guest.phone}")
            Log.i("@Edman", "Id: id : ${guest.email}")
        }
    }

    private fun getInvitados() {
        _guest_name.value = (guest_name.value)
        _guest_phone.value = (guest_phone.value)
        _guest_email.value = (guest_email.value)
    }



    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}