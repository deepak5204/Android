package com.example.superapp.state_management

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.superapp.ui.theme.SuperAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun StateHoistingDemo(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Counter(
            count = count,
            onCountClick = {
                count++
            }
        )

        Button(
            onClick =  {
                count = 0
            }
        ) {
            Text(
                text = "Reset Counter"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StateHoistingDemoPreview() {
    SuperAppTheme {
        StateHoistingDemo()
    }
}