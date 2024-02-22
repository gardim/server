package com.example.server.repository

import com.example.server.entity.PlantEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PlantRepository : JpaRepository<PlantEntity, Long> {
    fun findByUserId(userId: Long): List<PlantEntity>
}