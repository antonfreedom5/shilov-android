package com.example.shilov.model

data class CustomOrder (
    val id: Long,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val note: String
        ) {
    override fun toString(): String {
        return "$firstName, $lastName, $phone, $note"
    }
}