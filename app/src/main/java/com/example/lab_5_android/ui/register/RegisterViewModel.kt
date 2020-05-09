package com.example.lab_5_android.ui.register

import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterViewModel : ViewModel() {

    // Total of guesed registered
    private val _guestRegistered = MutableLiveData<Int>()
    val guestRegistered: LiveData<Int>
    get() = _guestRegistered

    // Total of guest in our list
    private val _guestCount = MutableLiveData<Int>()
    val guestCount: LiveData<Int>
    get() = _guestCount

    // the current guest
    private val _guest = MutableLiveData<String>()
    val guest: LiveData<String>
    get() = _guest

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
    get() = _eventGameFinish


//    class Guest(val name: String, val phone: String, val email: String, val registered: Boolean )

    // List of Guests
    private lateinit var guestList: MutableList<String>

    private fun resetLists() {
        guestList = mutableListOf(
            "Andrei",
            "Edman",
            "Crisitan",
            "Marco"
        )
    }


//    private val allGuest = listOf(
//        Guest("Andrei Portales", "45674638", "andreiportales@uvg.edu.gt", false),
//        Guest("Marco Perez", "31251678", "marcoperez@uvg.edu.gt", false),
//        Guest("Hansel Lopez", "48252369", "hansellopez@uvg.edu.gt", false),
//        Guest("Christian Perez", "87648378", "christianperez@uvg.edu.gt", false),
//        Guest("Javier Hurtarte", "58302598", "javierhurtarte@uvg.edu.gt", false),
//        Guest("Oscar de Leon", "56306847", "oscardeleon@uvg.edu.gt", false),
//        Guest("Ana Castillo", "45511189", "anacastillo@uvg.edu.gt", false),
//        Guest("Edman Cota", "42595836", "edmancota@uvg.edu.gt", false)
//    )



    init {
        resetLists()
        nextGuest()

        _guestCount.value = 1
        _guest.value = guestList.removeAt(0)
        _guestRegistered.value = 0
    }

    private fun nextGuest() {
        if (guestList.isEmpty()) {
            onGameFinish()
        } else {
            // Select and remove a guest from the list
            _guest.value = guestList.removeAt(0)
        }
    }

     fun onYesGuestClicked() {
         _guestRegistered.value = (guestRegistered.value)?.plus(1)
         _guestCount.value = (guestCount.value)?.plus(1)
         nextGuest()
    }

     fun onNoGuestClicked() {
         _guestCount.value = (guestCount.value)?.plus(1)
         nextGuest()
    }

    // Method for the game completed event
    fun onGameFinish() {
        _eventGameFinish.value = true
    }

    // Method for the game completed event
    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("RegisterViewModel", "GameviewModel destroyed")
    }
}