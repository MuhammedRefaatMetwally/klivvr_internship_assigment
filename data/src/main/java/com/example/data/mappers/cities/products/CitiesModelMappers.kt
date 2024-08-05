package com.example.data.mappers.cities.products

import com.example.data.model.City
import com.example.data.model.Coord
import com.example.domain.features.cities.model.CityEntity
import com.example.domain.features.cities.model.CoordEntity

fun CityEntity.toModel(): City {
    return City(
        country = this.country,
        name = this.name,
        id = this.id,
        coord = this.coord.toModel()
    )
}

fun CoordEntity.toModel(): Coord {
    return Coord(
        lon = this.lon,
        lat = this.lat
    )
}