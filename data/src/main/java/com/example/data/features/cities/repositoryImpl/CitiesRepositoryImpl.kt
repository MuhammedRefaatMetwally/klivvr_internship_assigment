import com.example.data.features.cities.dataSourceContract.CitiesDataSource
import com.example.data.mappers.cities.products.toEntity
import com.example.data.mappers.cities.products.toModel
import com.example.data.model.City
import com.example.domain.features.cities.model.CityEntity
import com.example.domain.features.cities.repository.CitiesRepository


class CityRepositoryImpl(private val dataSource: CitiesDataSource) : CitiesRepository {
    override fun searchCitiesByPrefix(prefix: String): List<CityEntity> {
        return dataSource.searchCitiesByPrefix(prefix).map { it.toEntity() }
    }

    override fun loadCitiesFromJson(): List<CityEntity> {
        return dataSource.loadCitiesFromJson().map { it.toEntity() }
    }
}