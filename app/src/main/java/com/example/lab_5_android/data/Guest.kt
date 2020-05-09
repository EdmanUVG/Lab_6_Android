package com.example.lab_5_android.data

data class Guest (val name: String, val phone: String, val email: String) {
    override fun toString(): String {
        return "$name - $phone - $email"
    }
}