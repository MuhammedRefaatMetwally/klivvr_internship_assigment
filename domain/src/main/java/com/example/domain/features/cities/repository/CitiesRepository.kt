package com.example.domain.features.cities.repository

import com.example.domain.features.cities.model.CityEntity
import kotlinx.coroutines.flow.Flow


interface CitiesRepository {
    fun getAllCities(): Flow<List<CityEntity>>
    fun searchCitiesByPrefix(prefix: String): List<CityEntity>
}