package com.example.data.features.cities

import com.example.domain.features.cities.model.CityEntity

class CityTrie {
    private val root = TrieNode()

    fun insert(city: CityEntity) {
        var current = root
        city.name.lowercase().forEach { char ->
            current = current.children.computeIfAbsent(char) { TrieNode() }
        }
        current.cities.add(city)
    }

    fun search(prefix: String): List<CityEntity> {
        var current = root
        prefix.lowercase().forEach { char ->
            current = current.children[char] ?: return emptyList()
        }
        return current.cities
    }

    private class TrieNode(
        val children: MutableMap<Char, TrieNode> = mutableMapOf(),
        val cities: MutableList<CityEntity> = mutableListOf()
    )
}
