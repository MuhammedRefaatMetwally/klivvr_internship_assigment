package com.example.domain.features.cities.model

data class CityEntity(
    val country: String,
    val name: String,
    val id: Int,
    val coord: CoordEntity
){
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$name$country",
            "$name $country",
            "${name.first()} ${country.first()}",
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}


data class CoordEntity(
    val lon: Double,
    val lat: Double
)