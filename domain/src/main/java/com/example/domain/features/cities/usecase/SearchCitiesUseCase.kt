package com.example.domain.features.cities.usecase

import com.example.domain.features.cities.model.CityEntity
import com.example.domain.features.cities.repository.CitiesRepository

class SearchCitiesUseCase(private val cityRepository: CitiesRepository) {

    fun invoke(prefix: String): List<CityEntity> {
        return cityRepository.searchCitiesByPrefix(prefix).sortedBy { it.name }
    }

}