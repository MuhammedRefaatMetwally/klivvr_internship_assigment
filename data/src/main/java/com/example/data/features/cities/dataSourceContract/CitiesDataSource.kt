package com.example.data.features.cities.dataSourceContract


import com.example.data.model.City
import com.example.domain.features.cities.model.CityEntity
import kotlinx.coroutines.flow.Flow

interface CitiesDataSource {
    fun searchCitiesByPrefix(prefix: String): List<City>
    fun getAllCities(): Flow<List<City>>
}