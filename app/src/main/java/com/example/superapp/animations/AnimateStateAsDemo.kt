package com.example.superapp.animations

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun AnimateStateAsDemo(modifier: Modifier = Modifier) {
    var toggle by remember { mutableStateOf(false) }

    val ratio by animateFloatAsState(
        targetValue = if(toggle) 1f else 0f,
        animationSpec =
            tween (
            durationMillis = 3000
        )
//            spring(
//                dampingRatio = Spring.DampingRatioMediumBouncy,
//                stiffness = Spring.StiffnessLow
//            )
            ,
        label = "ratio animation"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ){
            Box(
                modifier = Modifier
                    .graphicsLayer{
                        rotationZ = 405f * ratio
                        scaleX = 1f - (ratio * 0.5f)
                        scaleY = 1f - (ratio * 0.5f)
                    }
                    .size(100.dp)
                    .background(Color.Red)
            )
        }

        Button(onClick = {
            toggle = !toggle
        }) {
            Text(
                text = "Toggle"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AnimateStateAsDemoPreview() {
    SuperAppTheme {
        AnimateStateAsDemo()
    }
}