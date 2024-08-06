package com.example.klivvr_cities_assigment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.klivvr_cities_assigment.features.cities.views.CityListScreen
import com.example.klivvr_cities_assigment.ui.theme.Klivvr_cities_assigmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           KlivvrCities()
        }
    }
}

@Composable
fun KlivvrCities(modifier: Modifier = Modifier) {
    Klivvr_cities_assigmentTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

            CityListScreen(innerPadding)
        }
    }
}
