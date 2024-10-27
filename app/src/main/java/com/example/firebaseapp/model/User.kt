package com.example.firebaseapp.model

data class User(
    val email: String,
    val userId: String,
    val name: String,
){
    fun toMap(): Map<String, Any> {
        return mutableMapOf (
            "email" to email,
            "userId" to userId,
            "name" to name,
        )
    }
}