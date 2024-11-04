package com.example.weather.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel

class WeatherViewModel: ViewModel() {


    var location by mutableStateOf("")
        private set

    fun updateLocation(input: String) {
        location = input
    }
}