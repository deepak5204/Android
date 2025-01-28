package com.example.superapp.basic_layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superapp.ui.theme.SuperAppTheme
import com.example.superapp.R

@Composable
fun BoxDemo(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .background(Color.Gray),
        contentAlignment = Alignment.BottomCenter

    ) {
        Image(painter = painterResource(R.drawable.img), contentDescription = null)

        // below image because i want gradient over the image
        Box(
            modifier = Modifier
//                .fillMaxSize() // don't use bcz don't know the size of image and it occupy the full screen
                .matchParentSize() // fill the largest composable and here image is the largest
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        )
                    )
                )
        )

        IconButton(
            onClick = {},
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color.Yellow,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BoxDemoPreview() {
    SuperAppTheme {
        BoxDemo()
    }
}