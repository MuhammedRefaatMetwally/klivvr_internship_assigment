package com.example.data.mappers.cities.products

import com.example.data.model.City
import com.example.data.model.Coord
import com.example.domain.features.cities.model.CityEntity
import com.example.domain.features.cities.model.CoordEntity


fun City.toEntity(): CityEntity {
    return CityEntity(
        country = this.country,
        name = this.name,
        id = this.id,
        coord = this.coord.toEntity()
    )
}

fun Coord.toEntity(): CoordEntity {
    return CoordEntity(
        lon = this.lon,
        lat = this.lat
    )
}