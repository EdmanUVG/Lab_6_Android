package com.example.lab_5_android.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="guest_count_table")
data class Guest (
    @PrimaryKey(autoGenerate=true)
    var guestId: Long = 0L,

    @ColumnInfo(name="name")
    var name:String = "Edman Cota",

    @ColumnInfo(name="phone_number")
    var phone: String = "23764567",

    @ColumnInfo(name="email_address")
    var email : String = "edmancota@gmail.com"
)