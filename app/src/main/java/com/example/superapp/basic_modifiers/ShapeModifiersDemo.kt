package com.example.superapp.basic_modifiers

import android.R.attr.x
import android.R.attr.y
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.superapp.R

@Composable
fun ShapeModifiersDemo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.img),
        contentDescription = null,
        modifier = Modifier
//            .background(androidx.compose.ui.graphics.Color.Red)
            .clip(RightAngleTriangle)
    )
}


data object TriangleShape: Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
       return Outline.Generic(
           path = Path().apply {
               moveTo(
                   x = size.width/2f,
                   y = 0f
               )
               lineTo(
                   x = 0f,
                   y = size.height
               )
               lineTo(
                   x = size.width,
                   y = size.height
               )
               close()
           }
       )
    }
}

data object RightAngleTriangle: Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = Path().apply {
                moveTo(
                    x = 0f,
                    y = 0f
                )
                lineTo(
                    x = 0f,
                    y = size.height
                )
                lineTo(
                    x = size.width,
                    y = size.height
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ShapeModifiersDemoPreview() {
    ShapeModifiersDemo()
}