package com.example.superapp.animations

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superapp.ui.theme.SuperAppTheme


@Composable
fun InfiniteAnimations(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(
        label = "infinite transition"
    )

    val ratio by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "ratio animation"
    )

    val color by transition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color animation"
    )

//    Box(
//        modifier = Modifier
//            .graphicsLayer{
//                rotationZ = ratio * 360
//                scaleX = ratio
//                scaleY = ratio
//            }
//            .size(100.dp)
//            .background(Color.Red)
//    )


    Box(
        modifier = Modifier
            .graphicsLayer{
                rotationZ = ratio * 360
                scaleX = ratio
                scaleY = ratio
            }
            .size(100.dp)
//            .background(Color.Red) // we not using this because it recompose on every color change
            .drawBehind{ // it not recompose on every color change
                drawRect(
                    color = color
                )
            }
    )
}

@Preview(showBackground = true)
@Composable
private fun InfiniteAnimationsPreview() {
    SuperAppTheme {
        InfiniteAnimations()
    }
}