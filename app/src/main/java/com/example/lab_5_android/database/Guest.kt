package com.example.lab_5_android.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="guest_count_table")
data class Guest (
    @PrimaryKey
    var guestId: Long,

    @ColumnInfo(name="name")
    var name:String,

    @ColumnInfo(name="phone_number")
    var phone: String,

    @ColumnInfo(name="email_address")
    var email : String
)