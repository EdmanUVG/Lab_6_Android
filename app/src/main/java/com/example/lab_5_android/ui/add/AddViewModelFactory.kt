package com.example.lab_5_android.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab_5_android.database.GuestDatabaseDao
import java.lang.IllegalArgumentException

class AddViewModelFactory(
    private val dataSource: GuestDatabaseDao): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddViewModel::class.java)) {
            return AddViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}