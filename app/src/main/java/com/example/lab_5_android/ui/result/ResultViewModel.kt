package com.example.lab_5_android.ui.result

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab_5_android.ui.register.RegisterViewModel

class ResultViewModel(finalGuests: Int, finalRegistered: Int) : ViewModel() {

    // All guest in the list
    private val _guest = MutableLiveData<Int>()
    val guests: LiveData<Int>
    get() = _guest

    // Al registered guests
    private val _registered = MutableLiveData<Int>()
    val registered: LiveData<Int>
    get() = _registered

    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
    get() = _eventPlayAgain

    init {
        _guest.value = finalGuests
        _registered.value = finalRegistered
    }

    fun onPlayAgain() {
        _eventPlayAgain.value = true
    }

    fun onPlayAgainComplete() {
        _eventPlayAgain.value = false
    }
}
