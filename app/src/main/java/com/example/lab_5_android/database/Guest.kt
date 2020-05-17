package com.example.lab_5_android.database

import androidx.annotation.NonNull
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

    @NonNull
    var name:String,

    var phone: String,

    var email : String,

    var registered : Boolean,

    var role_id: Long = 0L

)