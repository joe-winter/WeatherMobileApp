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


@Composable
fun WeatherScreen(
    modifier: Modifier,
    weatherViewModel: WeatherViewModel = viewModel()
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
        WeatherLocationTitle()
        WeatherLocationTime()
        Row {
            WeatherDataCard("Feels Like", "30", modifier = Modifier)
            WeatherDataCard("Wind Speed", "4.09 km/h", modifier = Modifier)
        }
        Row {
            WeatherDataCard("UV Index", "3", modifier = Modifier)
            WeatherDataCard("Cloud Coverage", "4.09 km/h", modifier = Modifier)
        }
        Row {
            WeatherDataCard("Humidity", "60%", modifier = Modifier)
            WeatherDataCard("Visibility", "10000km", modifier = Modifier)
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
fun WeatherLocationTitle() {
    Row {
        Column(
            modifier = Modifier
                .padding(6.dp)
        ) {
            Text(
                text = "Turin",
                fontSize = 32.sp
            )
        }
        Column(
            modifier = Modifier
                .padding(6.dp)
        ) {
            Text(
                text = "32°",
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
fun WeatherLocationTitlePreview() {
    WeatherLocationTitle()
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
