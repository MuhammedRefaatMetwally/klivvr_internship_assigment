package com.example.data.model

import com.google.gson.annotations.SerializedName

data class City(
    @field:SerializedName("country")
    val country: String,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("_id")
    val id: Int,
    @field:SerializedName("coord")
    val coord: Coord
)


data class Coord(
    @field:SerializedName("lon")
    val lon: Double,
    @field:SerializedName("lat")
    val lat: Double
)