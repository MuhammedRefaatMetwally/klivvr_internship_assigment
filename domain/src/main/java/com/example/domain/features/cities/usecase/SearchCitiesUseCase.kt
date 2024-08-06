package com.example.domain.features.cities.usecase

import com.example.domain.features.cities.model.CityEntity
import com.example.domain.features.cities.repository.CitiesRepository
import javax.inject.Inject

class SearchCitiesUseCase @Inject constructor(
    private val citiesRepository: CitiesRepository) {

    fun invoke(prefix: String): List<CityEntity> {
        return citiesRepository.searchCitiesByPrefix(prefix).sortedBy { it.name }
    }

}