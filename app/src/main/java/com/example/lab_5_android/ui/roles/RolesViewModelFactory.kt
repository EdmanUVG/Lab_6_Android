package com.example.lab_5_android.ui.roles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab_5_android.database.GuestDatabaseDao
import com.example.lab_5_android.database.GuestRoleDatabaseDao

class RolesViewModelFactory(private val database: GuestRoleDatabaseDao): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RolesViewModel::class.java)) {
            return RolesViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}