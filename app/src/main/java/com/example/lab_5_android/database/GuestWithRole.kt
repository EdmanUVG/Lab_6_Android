package com.example.lab_5_android.database

import androidx.room.Embedded

data class GuestWithRole (
    @Embedded
    val guest: Guest,

    val role: String
)