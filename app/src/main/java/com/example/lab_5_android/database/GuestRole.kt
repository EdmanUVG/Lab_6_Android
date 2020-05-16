package com.example.lab_5_android.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guest_role_table")
data class GuestRole(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var roleId: Long = 0L,

    @NonNull
    val  role: String
) {
    override fun toString(): String {
        return role
    }
}