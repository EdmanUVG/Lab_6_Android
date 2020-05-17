package com.example.lab_5_android.ui.add

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab_5_android.database.Guest
import com.example.lab_5_android.database.GuestDatabaseDao
import com.example.lab_5_android.database.GuestRole
import com.example.lab_5_android.database.GuestRoleDatabaseDao
import kotlinx.coroutines.*
import javax.sql.DataSource

class AddViewModel(val database: GuestDatabaseDao,
                   val databaseRole: GuestRoleDatabaseDao) : ViewModel() {

    val name = MutableLiveData<String>()

    val phone = MutableLiveData<String>()

    val email = MutableLiveData<String>()

    val registered = MutableLiveData<Boolean>()

    val rolesList = databaseRole.getGuestRoles()

    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun insertGuest(role: Any) {
        uiScope.launch {
            insert(role as GuestRole)
        }
    }

    private suspend fun insert(guestRole: GuestRole?) {
        withContext(Dispatchers.IO) {
            database.insert(Guest(name = name.value ?: "", phone = phone.value ?: "",
                email = email.value ?: "", registered = registered.value ?: false , role_id = guestRole?.roleId ?: 0L))
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
