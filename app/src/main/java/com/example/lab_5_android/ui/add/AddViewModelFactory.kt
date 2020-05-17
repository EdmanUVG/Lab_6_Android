package com.example.lab_5_android.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab_5_android.database.GuestDatabaseDao
import com.example.lab_5_android.database.GuestRoleDatabaseDao
import java.lang.IllegalArgumentException

class AddViewModelFactory(private val database: GuestDatabaseDao,
                          private val databaseRole: GuestRoleDatabaseDao): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddViewModel::class.java)) {
            return AddViewModel(database, databaseRole) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}