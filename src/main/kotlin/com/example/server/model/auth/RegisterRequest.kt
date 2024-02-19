package com.example.server.model.auth

data class RegisterRequest(
    val email: String,
    val username: String,
    val password: String
)