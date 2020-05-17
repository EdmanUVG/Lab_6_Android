package com.example.lab_5_android.ui.guest

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import androidx.room.Database
import com.example.lab_5_android.database.*
import kotlinx.coroutines.*
import java.lang.StringBuilder

class GuestViewModel(val database: GuestDatabaseDao) : ViewModel() {

    private val guests = database.getGuestsWithRole()

    val guestsText = Transformations.map(guests) {
        buildGuestsText(it)
    }

    private fun buildGuestsText(guestsWithRole: List<GuestWithRole>) : String {
        val guestsText = StringBuilder()
        for (qwt in guestsWithRole) {
            guestsText.append("Invitado: ${qwt.guest.guestId}\n" +
            "Nombre: ${qwt.guest.name}\n" +
            "Telefono: ${qwt.guest.phone}\n" +
            "Correo: ${qwt.guest.email}\n" +
            "Rol: ${qwt.role}\n\n")
        }
        return guestsText.toString()
    }

}