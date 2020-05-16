package com.example.lab_5_android.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab_5_android.database.*
import kotlinx.coroutines.*

class RegisterViewModel(val database: GuestDatabaseDao) : ViewModel() {

    val guests = database.getGuestsWithRole()

    private val _registeredComplete = MutableLiveData<Boolean>()
    val registeredComplete: LiveData<Boolean>
    get() = _registeredComplete

    var guestCount = 1
        private set

    var totalCount = 0
        private set

    val currentGuest = MutableLiveData<GuestWithRole>()

    // viewModelJob allows us to cancel all coroutines started by the ViewModel
    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun initialize(guests: List<GuestWithRole>) {
        totalCount = guests.size
        if (guests.isEmpty()) {
            _registeredComplete.value = true
        } else {
            currentGuest.value = guests[0]
        }
    }

    fun updateCurrentGuest() {
        val guestWithRole = currentGuest.value
        guestCount++
        if (totalCount >= guestCount) {
            currentGuest.value = guests.value?.get(guestCount -1)
        } else {
            _registeredComplete.value = true
        }
        uiScope.launch {
            update(guestWithRole?.let {
                Guest(guestId = it.guest.guestId,
                    name = it.guest.name,
                    phone = it.guest.phone,
                    email = it.guest.email,
                    registered = it.guest.registered,
                    role_id = it.guest.role_id)
            })
        }
    }

    private suspend fun update(guest: Guest?) {
        withContext(Dispatchers.IO) {
            guest ?.let {
                database.update(it)
            }
        }
    }

    fun finishRegister() {
        _registeredComplete.value = false
        guestCount = 1
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}