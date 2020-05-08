package com.example.lab_5_android.ui.guest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuestViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is guest Fragment"
    }
    val text: LiveData<String> = _text
}