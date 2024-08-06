package com.example.data.features.cities.dataSourceImpl

import android.content.Context
import com.example.data.features.cities.dataSourceContract.CitiesDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class Di {

    @Binds
    abstract fun bindCitiesDataSource(
        citiesDataSourceImpl: CitiesDataSourceImpl
    ): CitiesDataSource

    companion object {
        @Provides
        @Singleton
        fun provideContext(@ApplicationContext context: Context): Context = context
    }

}