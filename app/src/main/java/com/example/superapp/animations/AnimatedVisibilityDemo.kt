package com.example.superapp.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseInExpo
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.superapp.ui.theme.SuperAppTheme

@Composable
fun AnimatedVisibilityDemo(modifier: Modifier = Modifier) {
    var toggle by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

        Button(onClick = {
            toggle = !toggle
        }) {
            Text(
                text = "Toggle"
            )
        }

        val easing = EaseIn

        AnimatedVisibility(
            visible = toggle,
            enter = scaleIn(
                animationSpec = tween(
                    durationMillis = 5000,
                    delayMillis = 300,
                    easing = easing
                )
            ) + fadeIn(
                animationSpec = tween(
                    durationMillis = 5000,
                    delayMillis = 300,
                    easing = easing
                )
            ),
            exit = scaleOut(
                animationSpec = tween(
                    durationMillis = 5000,
                    delayMillis = 300,
                    easing = easing
                )
            ) + fadeOut(
                animationSpec = tween(
                    durationMillis = 5000,
                    delayMillis = 300,
                    easing = easing
                )
            )
        ){
            Text(
                text = "Hello world",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
                    .border(
                        width = 5.dp,
                        color = Color.Red
                    )
                    .wrapContentSize()
            )
        }

        Text(
            text = "Hello World"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AnimatedVisibilityDemoPreview() {
    SuperAppTheme {
        AnimatedVisibilityDemo()
    }
}