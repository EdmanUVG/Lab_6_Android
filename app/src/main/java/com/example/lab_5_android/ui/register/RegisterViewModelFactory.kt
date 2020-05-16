package com.example.lab_5_android.ui.register

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab_5_android.database.GuestDatabaseDao
import java.lang.IllegalArgumentException

class RegisterViewModelFactory(
    private val dataSource: GuestDatabaseDao,
    private val application: Application): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}