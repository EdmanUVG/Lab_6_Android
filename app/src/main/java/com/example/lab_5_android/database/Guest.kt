package com.example.lab_5_android.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.SET_DEFAULT
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="guest_table",
    foreignKeys = [
    ForeignKey(entity = GuestRole::class,
        parentColumns = ["id"],
        childColumns = ["role_id"],
        onDelete = SET_DEFAULT)
    ])
data class Guest (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var guestId: Long = 0L,

    @ColumnInfo(name="name")
    var name:String,

    @ColumnInfo(name="phone_number")
    var phone: String,

    @ColumnInfo(name="email_address")
    var email : String,

    @ColumnInfo(name="is_registered")
    var registered : Boolean,

    var role_id: Long = 0L

)