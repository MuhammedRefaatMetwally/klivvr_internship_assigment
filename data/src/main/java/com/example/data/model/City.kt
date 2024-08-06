package com.example.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class City(
    @SerialName("country")
    val country: String,
    @SerialName("name")
    val name: String,
    @SerialName("_id")
    val id: Int,
    @SerialName("coord")
    val coord: Coord
)

@Serializable
data class Coord(
    @SerialName("lon")
    val lon: Double,
    @SerialName("lat")
    val lat: Double
)