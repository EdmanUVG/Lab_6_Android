package com.example.lab_5_android.ui.guest

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab_5_android.database.GuestDatabaseDao
import java.lang.IllegalArgumentException
import javax.sql.CommonDataSource

class GuestViewModelFactory(private val database: GuestDatabaseDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GuestViewModel::class.java)) {
            return GuestViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}