package com.example.lab_5_android.ui.result

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.lab_5_android.ui.register.RegisterViewModel

class ResultViewModel(finalGuest: Int) : ViewModel() {

    // All guest in the list
    var guest = finalGuest

    init {
        Log.i("ResultViewModel", "Final score is $finalGuest")
    }
}
