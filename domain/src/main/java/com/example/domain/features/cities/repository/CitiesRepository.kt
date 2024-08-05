package com.example.domain.features.cities.repository

import com.example.domain.features.cities.model.CityEntity


interface CitiesRepository {
    fun searchCitiesByPrefix(prefix: String): List<CityEntity>
    fun loadCitiesFromJson(): List<CityEntity>
}