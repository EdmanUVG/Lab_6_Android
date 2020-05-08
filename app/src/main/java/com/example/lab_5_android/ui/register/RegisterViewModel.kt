package com.example.lab_5_android.ui.register

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterViewModel : ViewModel() {

    // Total of guesed registered
    var guestRegistered = 0

    // The current guest we are evaluating
    var currentGuest = 0

    // Total of guest in our list
    var guestCount = 1;

    class Guest(val name: String, val phone: String, val email: String, val registered: Boolean )

    // List of Guests
    private lateinit var guestList: MutableList<String>

    guestList = mutableListOf(
        "Andrei",
        "Edman",
        "Crisitan"
    )


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
//        showCurrentGuest()
    }

    private fun nextGuest() {
//        if()
    }

    private fun onYesGuestClicked() {

        guestRegistered++
        guestCount++
        nextGuest()

    }

    private fun onNoGuestClicked() {
        currentGuest++
        guestCount++
        nextGuest()
    }

//    @SuppressLint("SetTextI18n")
//    private fun onYesGuestClicked() {
//
//        guestRegistered++
//        currentGuest++
//        guestCount++
//
//        if(guestCount == 9) {
//            nextFragment()
//        } else {
//            showCurrentGuest(currentGuest)
//            text_total.text = guestCount.toString() + " /8"
//        }
//
//    }
//
//    private fun onNoGuestClicked() {
//
//        currentGuest++
//        guestCount++
//
//        if(guestCount == 9) {
//            nextFragment()
//        } else {
//            showCurrentGuest(currentGuest)
//            text_total.text = guestCount.toString() + " /8"
//        }
//    }

//    private fun showCurrentGuest(i : Int) {
//
//        text_name.text = allGuest[i].name
//        text_phone.text = allGuest[i].phone
//        text_email.text = allGuest[i].email
//    }
//
//    private fun nextFragment() {
//        val total_guest = currentGuest
//        val guest_registered = guestRegistered
//        val action = RegisterFragmentDirections.registerToResult(total_guest, guest_registered)
//        findNavController().navigate(action)
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        Log.i("RegisterViewModel", "GameviewModel destroyed")
//    }
}