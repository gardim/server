package com.example.server.repository

import com.example.server.entity.DeviceEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DeviceRepository : JpaRepository<DeviceEntity?, Long?>