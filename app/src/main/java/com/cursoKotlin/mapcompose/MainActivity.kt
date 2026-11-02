package com.cursoKotlin.mapcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cursoKotlin.mapcompose.ui.theme.MapComposeTheme
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.MapType
import androidx.compose.runtime.getValue


// IMPORTANTE: Importación del mapa de Google Maps Compose
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MapComposeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { padding ->
                    MyGoogleMaps(modifier = Modifier.padding(padding))
                }
            }
        }
    }
}

@Composable
fun MyGoogleMaps(
    modifier: Modifier = Modifier
) {
    // Coordenadas que utiliza AristiDevs en la práctica (El Teide)
    val coordinates = LatLng(28.2722, -16.6425)
    val properties by remember { mutableStateOf(MapProperties(mapType = MapType.HYBRID)) }
    val uiSettings by remember { mutableStateOf(MapUiSettings(zoomControlsEnabled = false)) }

    GoogleMap(
        modifier = modifier, // Usamos el modifier que viene del Scaffold
        properties = properties,
        uiSettings= uiSettings
    ) {
        // Marcadores añadidos en la práctica:
        Marker(
            state = MarkerState(position = LatLng(20.2722, -26.6425)),
            title = "El Teide",
            snippet = "Aún no te has suscrito"
        )
        Marker(
            state = MarkerState(position = LatLng(18.2722, -36.6425)),
            title = "El Teide",
            snippet = "Aún no te has suscrito"
        )
        Marker(
            state = MarkerState(position = LatLng(22.2722, -12.6425)),
            title = "El Teide",
            snippet = "Aún no te has suscrito"
        )
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MapComposeTheme {
        Greeting("Android")
    }
}