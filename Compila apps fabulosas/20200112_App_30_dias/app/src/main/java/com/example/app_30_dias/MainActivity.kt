package com.example.app_30_dias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_30_dias.model.RecetaRepository
import com.example.app_30_dias.ui.theme.App_30_diasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App_30_diasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Recetas("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Recetas(name: String, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBarReceta()}
    ) {
        val recetas = RecetaRepository.recetas
        ListReceta(recetas = recetas, contentPadding = it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarReceta(){
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.app_name))
        }
    )
}

@Preview(showBackground = true)
@Composable
fun RecetasPreview() {
    App_30_diasTheme {
        Recetas("Android")
    }
}