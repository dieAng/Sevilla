package com.example.sevilla

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.sevilla.ui.SevillaApp
import com.example.sevilla.ui.theme.SevillaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SevillaTheme {
                SevillaApp()
            }
        }
    }
}
