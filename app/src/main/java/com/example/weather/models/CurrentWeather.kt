package com.example.weather.models

data class CurrentWeather(
    val currentWeather: String = "Rain",
    val locationName: String = "Turin",
    val temperature: Double = 284.2,
    val dateTime: Int = 1726660758,
    val feelsLike: Double = 282.93,
    val windSpeed: Double = 4.09,
    val uVIndex: Int = 3,
    val cloudCoverage: Int = 893,
    val humidity: Int = 60,
    val visibility: Int = 10000

)
