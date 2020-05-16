package com.example.lab_5_android.ui.register

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lab_5_android.database.Guest
import com.example.lab_5_android.database.GuestDatabase
import com.example.lab_5_android.database.GuestDatabaseDao
import com.example.lab_5_android.database.GuestRepository
import kotlinx.coroutines.*

class RegisterViewModel(dataSource: GuestDatabaseDao, application: Application) : AndroidViewModel(application) {

    val database = dataSource

    // viewModelJob allows us to cancel all coroutines started by the ViewModel
    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val data = listOf<Guest>().size

//    private val _guest_name = MutableLiveData<String>()
//    val guest_name: LiveData<String>
//    get() = _guest_name
//
//    private val _guest_phone = MutableLiveData<String>()
//    val guest_phone: LiveData<String>
//        get() = _guest_phone
//
//    private val _guest_email = MutableLiveData<String>()
//    val guest_email: LiveData<String>
//        get() = _guest_email

    var guest_name = MutableLiveData<String>()

    var guest_phone = MutableLiveData<String>()

    var guest_email = MutableLiveData<String>()

    var currentGuest: Long

    private val _guestCount = MutableLiveData<Int>()
    val guestCount: LiveData<Int>
    get() = _guestCount

    init {
        currentGuest = 1
        getOneGuest(currentGuest)
        _guestCount.value = data
    }

    fun getOneGuest(guestId:Long) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                var guest = Guest("", "", "", false)
                guest = database.getGuestById(guestId)!!

                guest_name.value = guest.name
                guest_phone.value = guest.phone
                guest_email.value = guest.email
                Log.i("@Edman", "NameU: ${guest_name}")
                Log.i("@Edman", "PhoneU: ${guest_phone }")
                Log.i("@Edman", "EmailU: ${guest_email}")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

//    private val repository: GuestRepository
//
//    // Total of guesed registered
//    private val _guestRegistered = MutableLiveData<Int>()
//    val guestRegistered: LiveData<Int>
//    get() = _guestRegistered
//
//    // Total of guest in our database
//    private val _allGuestCount = MutableLiveData<Int>()
//    val allGuestCount: LiveData<Int>
//        get() = _guestCount
//
//    // Total of guest in our list
//    private val _guestCount = MutableLiveData<Int>()
//    val guestCount: LiveData<Int>
//    get() = _guestCount
//
//    // the current guest
//    private val _guest = MutableLiveData<String>()
//    val guest: LiveData<String>
//    get() = _guest
//
//    private val _eventGameFinish = MutableLiveData<Boolean>()
//    val eventGameFinish: LiveData<Boolean>
//    get() = _eventGameFinish


    // List of Guests
//    private lateinit var guestList: MutableList<String>
//


//
//    init {
//        val guestDao = GuestDatabase.getInstance(application).guestDatabaseDao
//        repository = GuestRepository(guestDao)
////        _allGuestCount.value = repository.guestCount
//
//        resetLists()
//        nextGuest()
//
//        _guestCount.value = 1
//        _guest.value = guestList.removeAt(0)
//        _guestRegistered.value = 0
//    }

//    private fun nextGuest() {
//        if (guestList.isEmpty()) {
//            onGameFinish()
//        } else {
//            // Select and remove a guest from the list
//            _guest.value = guestList.removeAt(0)
//        }
//    }
//
//     fun onYesGuestClicked() {
//         _guestRegistered.value = (guestRegistered.value)?.plus(1)
//         _guestCount.value = (guestCount.value)?.plus(1)
//         nextGuest()
//    }
//
//     fun onNoGuestClicked() {
//         _guestCount.value = (guestCount.value)?.plus(1)
//         nextGuest()
//    }

//    // Method for the game completed event
//    fun onGameFinish() {
//        _eventGameFinish.value = true
//    }
//
//    // Method for the game completed event
//    fun onGameFinishComplete() {
//        _eventGameFinish.value = false
//    }

//    override fun onCleared() {
//        super.onCleared()
//        Log.i("RegisterViewModel", "GameviewModel destroyed")
//    }
}