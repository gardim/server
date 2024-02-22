package com.example.server.model.plant

data class PlantImageIdentifyRequest(
        val images: List<Image>,
        val latitude: Double,
        val longitude: Double,
        val similarImages: Boolean
)
