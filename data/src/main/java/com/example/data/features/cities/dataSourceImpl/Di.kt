package com.example.data.features.cities.dataSourceImpl

import com.example.data.features.cities.dataSourceContract.CitiesDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class Di {

    @Binds
    abstract fun bindCitiesDataSource(
        citiesDataSourceImpl: CityDataSourceImpl
    ): CitiesDataSource

}