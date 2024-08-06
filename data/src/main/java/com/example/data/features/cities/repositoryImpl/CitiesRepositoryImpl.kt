package com.example.data.features.cities.repositoryImpl

import com.example.data.features.cities.dataSourceContract.CitiesDataSource
import com.example.data.mappers.cities.products.toEntity

import com.example.domain.features.cities.model.CityEntity
import com.example.domain.features.cities.repository.CitiesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class CitiesRepositoryImpl @Inject constructor(private val dataSource: CitiesDataSource) :
    CitiesRepository {
    override fun getAllCities(): Flow<List<CityEntity>> {
            return dataSource.getAllCities().map { cityList ->
                cityList.sortedBy { it.name }.map { it.toEntity() }
            }

    }

    override fun searchCitiesByPrefix(prefix: String): List<CityEntity> {
        return dataSource.searchCitiesByPrefix(prefix).map { it.toEntity() }
    }


}