package com.example.server.repository

import com.example.server.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Int> {
    fun findByUsername(username: String): UserEntity?

    fun findByUsernameOrEmail(username: String, email: String): UserEntity?
}