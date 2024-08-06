package com.example.domain.features.cities.usecase

import com.example.domain.features.cities.model.CityEntity
import com.example.domain.features.cities.repository.CitiesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadCitiesUseCase @Inject constructor(
    private val citiesRepository: CitiesRepository) {

    fun invoke(): Flow<List<CityEntity>> {
        return citiesRepository.getAllCities()
    }

}