package com.example.lab_5_android.ui.add

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab_5_android.database.Guest
import com.example.lab_5_android.database.GuestDatabaseDao
import kotlinx.coroutines.*
import javax.sql.DataSource

class AddViewModel(dataSource: GuestDatabaseDao) : ViewModel() {

    val database = dataSource

    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun onInsertGuest(name: String, phone: String, email: String) {
//        uiScope.launch {
//            withContext(Dispatchers.IO) {
//                val guest = Guest(name, phone, email, false)
//                database.addGuest(guest)
//            }
//        }
    }
}
