package com.example.klivvr_cities_assigment.features.cities.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.klivvr_cities_assigment.features.cities.components.CityList
import com.example.klivvr_cities_assigment.features.cities.components.SearchTextField
import com.example.klivvr_cities_assigment.features.cities.view_model.CityViewModel

@Composable
fun CityListScreen(innerPadding: PaddingValues, viewModel: CityViewModel = hiltViewModel()) {
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    val focusRequester = remember { FocusRequester() }
    val searchText by viewModel.searchText.collectAsState()
    val cities by viewModel.cities.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    var isVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Color.White)
            .clickable(
                onClick = {
                    focusManager.clearFocus() // Unfocus the text field when clicking outside
                    isVisible = false
                },
                indication = null, // Removes the ripple effect
                interactionSource = remember { MutableInteractionSource() } // Prevents any focus indication
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            SearchTextField(
                searchText = searchText,
                onSearchTextChange = viewModel::onSearchTextChange,
                onClear = {
                    viewModel.onSearchTextChange("")
                    viewModel.loadAllCities()
                },
                onFocus = {
                    isVisible = true
                    viewModel.loadAllCities()
                },
                focusRequester = focusRequester
            )

            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }

            Spacer(modifier = Modifier.height(16.dp))
            if (isSearching) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            if (isVisible && cities.isNotEmpty()) {
                CityList(cities = cities, context = context, onCityClick = {
                    isVisible = false
                })
            }
        }
    }
}

