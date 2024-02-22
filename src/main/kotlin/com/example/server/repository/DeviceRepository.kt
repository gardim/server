package com.example.server.repository

import com.example.server.entity.DeviceEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DeviceRepository : JpaRepository<DeviceEntity?, Long?> {
    fun findByUserId(userId: Long?): List<DeviceEntity?>?
}