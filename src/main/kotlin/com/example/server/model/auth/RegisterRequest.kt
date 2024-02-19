package com.example.server.model.auth

data class RegisterRequest(
    val googleId: String,
    val email: String,
    val username: String,
    val profilePictureUrl: String
)