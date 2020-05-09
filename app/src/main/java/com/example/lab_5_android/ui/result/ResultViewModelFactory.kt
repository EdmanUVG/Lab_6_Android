package com.example.lab_5_android.ui.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ResultViewModelFactory(private val finalGuests: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultViewModel::class.java)) {
            return ResultViewModel(finalGuests) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class") as Throwable
    }
}