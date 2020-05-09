package com.example.lab_5_android.ui.result

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab_5_android.ui.register.RegisterViewModel

class ResultViewModel(finalRegistered: Int) : ViewModel() {

    // All guest in the list
    private val _guest = MutableLiveData<Int>()
    val guests: LiveData<Int>
    get() = _guest

    // Al registered guests
    private val _registered = MutableLiveData<Int>()
    val registered: LiveData<Int>
    get() = _registered

    // Event for play again button
    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
    get() = _eventPlayAgain

    // Event for see guests button
    private val _eventSeeGuests = MutableLiveData<Boolean>()
    val eventSeeGuests: LiveData<Boolean>
    get() = _eventSeeGuests


    init {
//        _guest.value = finalGuests
        _registered.value = finalRegistered
    }

    fun onPlayAgain() {
        _eventPlayAgain.value = true
    }

    fun onPlayAgainComplete() {
        _eventPlayAgain.value = false
    }

    fun onSeeGuests() {
        _eventSeeGuests.value = true
    }

    fun onSeeGuestsComplete() {
        _eventSeeGuests.value = false
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ResultViewModel", "GameviewModel destroyed")
    }
}
