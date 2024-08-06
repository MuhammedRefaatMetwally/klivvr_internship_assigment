package com.example.data.core.util

import com.example.domain.features.cities.model.CityEntity

class TSTNode {
    var char: Char = ' ' // Character stored in this node
    var left: TSTNode? = null // Left child for characters less than this node's character
    var middle: TSTNode? = null // Middle child for characters equal to this node's character
    var right: TSTNode? = null // Right child for characters greater than this node's character
    var cityEntities: MutableList<CityEntity> = mutableListOf() // List of cities at this node
}