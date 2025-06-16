package com.example.superapp.mesurements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.example.superapp.ui.theme.SuperAppTheme

@Composable
fun SizeModifiersDemo(modifier: Modifier = Modifier) {

    Row(
        modifier = Modifier.height(100.dp)
            .fillMaxWidth()
            .background(Color.Red)
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
//                .widthIn(min = 150.dp, max = 250.dp)
                .requiredWidth(300.dp)
                .wrapContentWidth()
                .background(Color.Yellow)
        ) {
            Text(text = "hello world this is a text")
        }
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(0.5f)
                .background(Color.Green)
        )
    }
}

@Preview
@Composable
private fun SizeModifiersDemoPreview() {
    SuperAppTheme {
        SizeModifiersDemo()
    }
}