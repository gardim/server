package com.example.server.controller

import com.example.server.entity.PlantEntity
import com.example.server.service.PlantService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/plants")
class PlantController(private val plantService: PlantService) {

    @GetMapping
    fun getAllPlants(): List<PlantEntity> {
        return plantService.getAllPlants()
    }

    @GetMapping("/{id}")
    fun getPlantById(@PathVariable id: Long): PlantEntity? {
        return plantService.getPlantById(id)
    }

    @PostMapping
    fun savePlant(@RequestBody plant: PlantEntity): PlantEntity {
        return plantService.savePlant(plant)
    }

    @PutMapping("/{id}")
    fun updatePlant(@PathVariable id: Long, @RequestBody updatedPlant: PlantEntity): PlantEntity? {
        return plantService.updatePlant(id, updatedPlant)
    }

    @DeleteMapping("/{id}")
    fun deletePlant(@PathVariable id: Long) {
        plantService.deletePlant(id)
    }
}