package com.example.lab_5_android.ui.roles

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab_5_android.database.GuestRole
import com.example.lab_5_android.database.GuestRoleDatabaseDao
import kotlinx.coroutines.*

class AddRolesViewModel(val database: GuestRoleDatabaseDao) : ViewModel() {

    val role = MutableLiveData<String>()

    val desctiption = MutableLiveData<String>()

    val orden = MutableLiveData<Int>()

    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun insertGuestRole() {
        uiScope.launch {
            insert()
        }
    }

    private suspend fun insert(){
        withContext(Dispatchers.IO) {
            database.insert(GuestRole(role = role.value ?: "", description = desctiption.value ?: "", order = orden.value?: 1 ))
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
