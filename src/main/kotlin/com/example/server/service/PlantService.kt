package com.example.server.service

import com.example.server.entity.PlantEntity
import com.example.server.model.plant.PlantImageIdentifyRequest
import com.example.server.model.plant.PlantImageIdentifyResponse
import com.example.server.repository.PlantRepository
import io.swagger.v3.oas.models.responses.ApiResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponents
import org.springframework.web.util.UriComponentsBuilder

@Service
class PlantService(
        private val plantRepository: PlantRepository,
        private val webClient: WebClient
) {

    fun getAllPlants(): List<PlantEntity> {
        return plantRepository.findAll()
    }

    fun getPlantById(id: Long): PlantEntity? {
        return plantRepository.findById(id).orElse(null)
    }

    fun getPlantsByUserId(userId: Long): List<PlantEntity> {
        return plantRepository.findByUserId(userId)
    }

    fun identifyPlantImage(plantImageRequest: PlantImageIdentifyRequest): PlantImageIdentifyResponse? {
        val url = "http://localhost:3000/query/image"

        return webClient.post()
                .uri(url)
                .bodyValue(plantImageRequest)
                .retrieve()
                .bodyToMono(PlantImageIdentifyResponse::class.java)
                .block()
    }

    fun identifyPlantByText(keywords: String): ApiResponse? {
        val url = "http://localhost:3000/query/text"
        val uri: UriComponents = UriComponentsBuilder.fromUriString(url)
            .queryParam("q", keywords)
            .build()

        return webClient.get()
            .uri(uri.toUri())
            .retrieve()
            .bodyToMono(ApiResponse::class.java)
            .block()
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