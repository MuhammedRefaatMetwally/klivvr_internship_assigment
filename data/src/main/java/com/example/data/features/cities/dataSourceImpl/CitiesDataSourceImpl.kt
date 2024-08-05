package com.example.data.features.cities.dataSourceImpl

import android.content.Context
import com.example.data.features.cities.CityTrie
import com.example.data.features.cities.dataSourceContract.CitiesDataSource
import com.example.data.mappers.cities.products.toEntity
import com.example.data.mappers.cities.products.toModel
import com.example.data.model.City
import com.example.domain.features.cities.model.CityEntity
import kotlinx.serialization.json.Json
import java.io.IOException
import javax.inject.Inject


class CityDataSourceImpl(private val context: Context) : CitiesDataSource {
    private val cities: List<City>
    private val trie = CityTrie()

    init {
        cities = loadCitiesFromJson()
        cities.forEach { trie.insert(it.toEntity()) }
    }

    private fun loadCities(): List<City> {
        return cities
    }

    override fun searchCitiesByPrefix(prefix: String): List<City> {
        val domainCities = trie.search(prefix)
        return domainCities.map{ it.toModel() }
    }

    override fun loadCitiesFromJson(): List<City> {
        return try {
            val jsonString = context.assets.open("cities.json").bufferedReader().use { it.readText() }
            Json.decodeFromString(jsonString)
        } catch (e: IOException) {
            e.printStackTrace()
            emptyList()
        }
    }


    }


