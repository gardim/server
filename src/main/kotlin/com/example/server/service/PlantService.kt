package com.example.server.service

import com.example.server.entity.PlantEntity
import com.example.server.repository.PlantRepository
import org.springframework.stereotype.Service

@Service
class PlantService(private val plantRepository: PlantRepository) {

    fun getAllPlants(): List<PlantEntity> {
        return plantRepository.findAll()
    }

    fun getPlantById(id: Long): PlantEntity? {
        return plantRepository.findById(id).orElse(null)
    }

    fun savePlant(plant: PlantEntity): PlantEntity {
        return plantRepository.save(plant)
    }

    fun updatePlant(id: Long, updatedPlant: PlantEntity): PlantEntity? {
        if (plantRepository.existsById(id)) {
            updatedPlant.id = id
            return plantRepository.save(updatedPlant)
        }
        return null
    }

    fun deletePlant(id: Long) {
        plantRepository.deleteById(id)
    }
}