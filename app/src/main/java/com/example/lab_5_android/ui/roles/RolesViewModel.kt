package com.example.lab_5_android.ui.roles

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.lab_5_android.database.GuestDatabaseDao
import com.example.lab_5_android.database.GuestRole
import com.example.lab_5_android.database.GuestRoleDatabaseDao
import com.example.lab_5_android.database.GuestWithRole
import java.lang.StringBuilder

class RolesViewModel(val database: GuestRoleDatabaseDao) : ViewModel() {

    private val roles = database.getGuestRoles()

    val rolesText = Transformations.map(roles) {
        buildGuestsText(it)
    }

    private fun buildGuestsText(roles: List<GuestRole>) : String{
        val rolesText = StringBuilder()
        for (rol in roles){
            rolesText.append("Role: ${rol.roleId}\nNombre: ${rol.role}\nDescripcion: ${rol.description}\nOrden: ${rol.order}\n\n")
        }
        return rolesText.toString()
    }

}
