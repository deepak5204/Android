package com.example.superapp.side_effect

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SideEffectDemo(modifier: Modifier = Modifier, value: Int) {
    SideEffect {
        println("Current value: $value")
    }

    Text(
        text ="Value: $value",
        modifier = modifier
            .fillMaxSize()
            .padding(top = 200.dp)
            .wrapContentWidth(Alignment.CenterHorizontally),

    )
}