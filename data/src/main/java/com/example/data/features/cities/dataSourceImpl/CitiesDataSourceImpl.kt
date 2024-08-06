package com.example.data.features.cities.dataSourceImpl

import android.content.Context
import com.example.data.core.util.TernarySearchTree
import com.example.data.features.cities.dataSourceContract.CitiesDataSource
import com.example.data.mappers.cities.products.toEntity
import com.example.data.mappers.cities.products.toModel
import com.example.data.model.City
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json
import java.io.IOException
import javax.inject.Inject


class CitiesDataSourceImpl @Inject constructor(@ApplicationContext private val context: Context) :
    CitiesDataSource {
    private val cities: List<City>
    private val ternarySearchTree = TernarySearchTree()

    init {
        cities = loadCitiesFromJson()
        cities.forEach { ternarySearchTree.insert(it.toEntity()) }
    }

    override fun getAllCities(): Flow<List<City>> = flow {
        val citiesFlow = ternarySearchTree.getAllCities()
        citiesFlow.collect { cityChunk ->
            emit(cityChunk.map { it.toModel() })
        }
    }

    override fun searchCitiesByPrefix(prefix: String): List<City> {
        val domainCities = ternarySearchTree.search(prefix.lowercase())
        return domainCities.map { it.toModel() }
    }


    private fun loadCitiesFromJson(): List<City> {
        return try {
            val jsonString =
                context.assets.open("cities.json").bufferedReader().use { it.readText() }
            val json = Json { ignoreUnknownKeys = true }
            json.decodeFromString(jsonString)
        } catch (e: IOException) {
            e.printStackTrace()
            emptyList()
        }
    }
}



