package com.example.data.features.products.dataSourceImpl

import com.example.data.features.cities.dataSourceContract.ProductDataSource
import com.example.data.features.cities.dataSourceImpl.CitiesDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class Di {

    @Binds
    abstract fun bindProductDataSource(
        productDataSourceImpl: CitiesDataSourceImpl
    ): ProductDataSource

}