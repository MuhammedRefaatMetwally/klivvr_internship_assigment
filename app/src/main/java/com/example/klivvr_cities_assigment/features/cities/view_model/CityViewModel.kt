package com.example.klivvr_cities_assigment.features.cities.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.features.cities.model.CityEntity
import com.example.domain.features.cities.usecase.LoadCitiesUseCase
import com.example.domain.features.cities.usecase.SearchCitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@OptIn(FlowPreview::class)
@HiltViewModel
class CityViewModel @Inject constructor(
    private val loadCitiesUseCase: LoadCitiesUseCase,
    private val searchCitiesUseCase: SearchCitiesUseCase
) : ViewModel() {
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _cities = MutableStateFlow<List<CityEntity>>(emptyList())

    val cities = searchText
        .debounce(1000L)
        .onEach { _isSearching.update { true } }
        .combine(_cities) { text, cities ->
            if (text.isBlank()) {
                cities
            } else {

                searchCitiesUseCase.invoke(text)
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _cities.value
        )



     fun loadAllCities() {
        viewModelScope.launch {
            loadCitiesUseCase.invoke()
                .collect { allCities ->
                    _cities.value = allCities
                }
        }
    }

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }
}
