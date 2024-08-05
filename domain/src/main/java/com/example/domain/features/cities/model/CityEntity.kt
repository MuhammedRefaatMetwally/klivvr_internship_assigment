package com.example.domain.features.cities.model

data class CityEntity(
    val country: String,
    val name: String,
    val id: Int,
    val coord: CoordEntity
)


data class CoordEntity(
    val lon: Double,
    val lat: Double
)