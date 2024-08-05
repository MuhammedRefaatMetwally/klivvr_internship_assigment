package com.example.data.features.cities.repositoryImpl

import CityRepositoryImpl
import com.example.domain.features.cities.repository.CitiesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class Di {
    @Binds
    abstract fun bindCitiesRepository(
        cityRepositoryImpl: CityRepositoryImpl
    ): CitiesRepository
}