package com.example.data.core.util

import com.example.domain.features.cities.model.CityEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TernarySearchTree {

    private var root: TSTNode? = null

    // Insert a city into the TST
    fun insert(city: CityEntity) {
        val cityName = city.name.lowercase() // Normalize to lowercase for consistent storage
        root = insert(root, cityName, city) // Insert recursively
    }

    // Recursive insert function
    private fun insert(node: TSTNode?, key: String, city: CityEntity): TSTNode {
        val currentNode = node ?: TSTNode().apply { char = key[0] } // Create a new node if needed

        when {
            key[0] < currentNode.char -> currentNode.left = insert(currentNode.left, key, city)
            key[0] > currentNode.char -> currentNode.right = insert(currentNode.right, key, city)
            else -> {
                if (key.length > 1) {
                    // Recur for the middle child
                    currentNode.middle = insert(currentNode.middle, key.substring(1), city)
                } else {
                    // Add city to the current node
                    currentNode.cityEntities.add(city)
                }
            }
        }
        return currentNode
    }

    // Search for cities by prefix
    fun search(prefix: String): List<CityEntity> {
        val result = mutableListOf<CityEntity>()

        // Check if the prefix is empty
        if (prefix.isEmpty() || root == null) return result

        // Start searching from the root
        search(root, prefix, 0, result)
        return result
    }

    // Recursive search function
    private fun search(node: TSTNode?, prefix: String, index: Int, result: MutableList<CityEntity>) {
        if (node == null) return // Base case: if node is null, return

        val char = prefix[index]

        when {
            char < node.char -> search(node.left, prefix, index, result) // Search in left subtree
            char > node.char -> search(node.right, prefix, index, result) // Search in right subtree
            else -> {
                // If we've reached the end of the prefix
                if (index == prefix.length - 1) {
                    collectAllCities(node, result) // Collect all cities from this node
                } else {
                    // Continue searching down the middle subtree
                    search(node.middle, prefix, index + 1, result)
                }
            }
        }
    }

    // Collect all cities from the current node
    private fun collectAllCities(node: TSTNode, result: MutableList<CityEntity>) {
        // Add cities at this node to the result
        result.addAll(node.cityEntities)
        // Recur for all children
        node.left?.let { collectAllCities(it, result) }
        node.middle?.let { collectAllCities(it, result) }
        node.right?.let { collectAllCities(it, result) }
    }

    // New function to get all cities in the TST
    fun getAllCities(): Flow<List<CityEntity>> = flow {
        val chunkSize = 1000 // Adjust based on your memory constraints
        val result = mutableListOf<CityEntity>()
        if (root != null) {
            collectAllCities(root!!, result)
        }
        result.chunked(chunkSize).forEach { chunk ->
            emit(chunk)
        }
    }
}

