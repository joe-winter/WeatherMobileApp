package com.example.weather.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R

@Composable
fun WeatherScreen(modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WeatherSearchBar()
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
fun WeatherSearchBar() {
    TextField(
        value = "",
        onValueChange = {},
        label = { Text("Search...") }
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
    ) {
        Text(dataTitle)
        Text(dataText)
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherLocationTitlePreview() {
    WeatherLocationTitle()
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
