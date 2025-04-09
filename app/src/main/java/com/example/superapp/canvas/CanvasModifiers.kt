package com.example.superapp.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.draw
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superapp.ui.theme.SuperAppTheme

@Composable
fun CanvasModifiersDemo(modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Green)
//        .drawBehind {
//           withTransform(
//               transformBlock = {
//                   rotate(
//                       180f
//                   )
//               },
//               drawBlock = {
//                   drawLine(
//                       brush = Brush.verticalGradient(
//                           colors = listOf(
//                               Color.Yellow,
//                               Color.Red
//                           )
//                       ),
//                       start = Offset.Zero,
//                       end = center,
//                       strokeWidth = 20.dp.toPx()
//                   )
//               },
//
//           )
//
//        },
//        .drawWithContent {
//            drawCircle(Color.Red)
//            drawContent()
//            drawCircle(Color.Yellow, radius = 10.dp.toPx())
//        }
        .drawWithCache {
            onDrawWithContent {
                drawCircle(Color.Red)
                drawContent()
                drawCircle(Color.Yellow, radius = 10.dp.toPx())
            }
        }
        ,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello World"
        )
    }

//    Box(modifier = Modifier
//        .fillMaxSize()
//        .background(Color.Green)
//        .drawBehind {
//            drawCircle(color = Color.Red)
//        },
//        contentAlignment = Alignment.Center
//    ){
//        Text(
//            text = "Hello World"
//        )
//    }
//    Canvas(modifier = Modifier
//        .fillMaxSize()
//    ) {
//        drawCircle(color = Color.Red)
//    }
}


@Preview (showBackground = true)
@Composable
private fun CanvasModifiersDemoPreview() {
    SuperAppTheme {
        CanvasModifiersDemo()
    }
}