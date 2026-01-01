package com.example.superapp.performance

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MyScreen(modifier: Modifier = Modifier) {
    var counter by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        MyCounter(
            counter = counter,
            onClick = { counter++ }
        )
    }
}

@Composable
fun MyCounter(
    modifier: Modifier = Modifier,
    counter: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick
    ) {
        Text("Counter: $counter")
    }
}