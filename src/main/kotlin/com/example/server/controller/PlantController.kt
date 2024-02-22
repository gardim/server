package com.example.server.controller

import com.example.server.entity.PlantEntity
import com.example.server.model.plant.PlantImageIdentifyRequest
import com.example.server.model.plant.PlantImageIdentifyResponse
import com.example.server.service.PlantService
import io.swagger.v3.oas.models.responses.ApiResponse
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

    @GetMapping("/user/{userId}")
    fun getPlantsByUserId(@PathVariable userId: Long): List<PlantEntity> {
        return plantService.getPlantsByUserId(userId)
    }

    @PostMapping("/query/image")
    fun identifyPlantImage(@RequestBody plantImageRequest: PlantImageIdentifyRequest): PlantImageIdentifyResponse? {
        return plantService.identifyPlantImage(plantImageRequest)
    }

    @PostMapping("/query/text")
    fun identifyPlantByText(@RequestBody keywords: String): ApiResponse? {
        return plantService.identifyPlantByText(keywords)
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