package com.example.data.features.cities.dataSourceContract

import com.example.data.model.City
import com.example.domain.features.cities.model.CityEntity

interface CitiesDataSource {
    fun searchCitiesByPrefix(prefix: String): List<City>
    fun loadCitiesFromJson(): List<City>
}