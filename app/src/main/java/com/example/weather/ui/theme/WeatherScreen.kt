package com.example.weather.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weather.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.weather.models.CurrentWeather


@Composable
fun WeatherScreen(
    modifier: Modifier,
    weatherViewModel: WeatherViewModel = viewModel(),
    weather: CurrentWeather = CurrentWeather(),
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WeatherSearchBar(
            onLocationChange = { weatherViewModel.updateLocation(it) },
            onKeyboardDone = { },
            location = weatherViewModel.location
        )
        WeatherImage()
        WeatherLocationTitle(
            location = weather.locationName,
            temperature = weather.temperature.toString()
        )
        WeatherLocationTime()
        Row {
            WeatherDataCard("Feels Like", weather.feelsLike.toString(), modifier = Modifier)
            WeatherDataCard("Wind Speed", weather.windSpeed.toString(), modifier = Modifier)
        }
        Row {
            WeatherDataCard("UV Index", weather.uVIndex.toString(), modifier = Modifier)
            WeatherDataCard("Cloud Coverage", weather.cloudCoverage.toString(), modifier = Modifier)
        }
        Row {
            WeatherDataCard("Humidity", weather.humidity.toString(), modifier = Modifier)
            WeatherDataCard("Visibility", weather.visibility.toString(), modifier = Modifier)
        }
    }
}

@Composable
fun WeatherSearchBar(
    onLocationChange: (String) -> Unit,
    onKeyboardDone: () -> Unit,
    location: String
) {
    TextField(
        value = location,
        onValueChange = onLocationChange,
        keyboardActions = KeyboardActions(onDone = { onKeyboardDone() }),
        label = { Text("Search...") },
    )
}

@Composable
fun WeatherLocationTitle(
    location: String,
    temperature: String
) {
    Row {
        Column(
            modifier = Modifier
                .padding(6.dp)
        ) {
            Text(
                text = location,
                fontSize = 32.sp
            )
        }
        Column(
            modifier = Modifier
                .padding(6.dp)
        ) {
            Text(
                text = temperature,
                fontSize = 32.sp
            )
        }
    }
}

@Composable
fun WeatherImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.sun)
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .size(100.dp)
    )
}

@Composable
fun WeatherLocationTime() {
    Text("Current time: 23.33pm")
}

@Composable
fun WeatherDataCard(dataTitle: String, dataText: String, modifier: Modifier) {
    Card(
        modifier = modifier
            .padding(6.dp)
            .size(width = 120.dp, height = 60.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)

    ) {
        Column(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxSize()
        ) {
            Text(text = dataTitle, fontSize = 12.sp)
            Text(dataText, fontWeight = FontWeight.Bold)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WeatherDataCardPreview() {
    WeatherDataCard("Humidity", "60%", modifier = Modifier)
}

@Preview(showBackground = true)
@Composable
fun WeatherScreenPreview() {
    WeatherTheme {
        WeatherTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                WeatherScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}
