package com.example.lab_5_android.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="guest_count_table")
data class Guest (
    @ColumnInfo(name="name")
    var name:String,

    @ColumnInfo(name="phone_number")
    var phone: String,

    @ColumnInfo(name="email_address")
    var email : String
): Serializable {
    @PrimaryKey(autoGenerate = true)
    var guestId: Long = 0L
}