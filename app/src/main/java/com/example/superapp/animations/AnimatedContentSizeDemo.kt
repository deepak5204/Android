package com.example.superapp.animations

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.superapp.ui.theme.SuperAppTheme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedContentSizeDemo(modifier: Modifier = Modifier) {
    var toggle by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Button(onClick = {
            toggle = !toggle
        }) {
            Text(
                text = "Toggle"
            )
        }

        Box(
            modifier = Modifier
                .background(Color.Blue)
                .animateContentSize()
                .height(if(toggle) 400.dp else 200.dp)
                .fillMaxWidth()
        )

        Text(
            text = "I am below",
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AnimatedContentSizeDemoPreview() {
    SuperAppTheme {
        AnimatedContentSizeDemo()
    }
}