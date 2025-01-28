package com.example.superapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.superapp.basic_layouts.HotelBookingScreen
import com.example.superapp.ui.theme.SuperAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HotelBookingScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
