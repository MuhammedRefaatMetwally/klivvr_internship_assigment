package com.example.data.features.products.repositoryImpl

import com.example.domain.products.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class Di {
    @Binds
    abstract fun bindProductRepository(
        repositoryImpl: ProductsRepositoryImpl
    ): ProductsRepository
}