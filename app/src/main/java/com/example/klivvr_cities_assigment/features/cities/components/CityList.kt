package com.example.klivvr_cities_assigment.features.cities.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.domain.features.cities.model.CityEntity

@Composable
fun CityList(cities: List<CityEntity>, context: Context, onCityClick: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 16.dp) // Same padding as SearchTextField
            .imePadding() // Ensure this handles keyboard
    ) {
        items(cities) { city ->
            CityListItem(city = city, context = context, onClick = onCityClick)
            HorizontalDivider()
        }
    }
}
