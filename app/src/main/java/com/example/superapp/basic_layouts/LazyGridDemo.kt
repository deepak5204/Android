package com.example.superapp.basic_layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superapp.ui.theme.SuperAppTheme
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun LazyGridDemo(modifier: Modifier = Modifier) {

    LazyHorizontalGrid(
        rows = GridCells
//            .FixedSize(100.dp),
            .Adaptive(100.dp),
//            .Fixed(4),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(100) { i ->
            Box(
                modifier = Modifier
                    .width(
                        width = Random.nextInt(1..200).dp
                    )
//                    .size(100.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(Color(Random.nextInt()))

            )
        }
    }

//    LazyVerticalStaggeredGrid(
//        columns = StaggeredGridCells.Adaptive(50.dp),
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
//        verticalItemSpacing = 16.dp,
//    ) {
//
//        items(100) { i ->
//            Box(
//                modifier = Modifier
//                    .height(
//                        height = Random.nextInt(1..200).dp
//                    )
//                    .clip(RoundedCornerShape(10.dp))
//                    .background(Color(Random.nextInt()))
//            )
//        }
//    }


//    LazyVerticalGrid(
//        columns = GridCells
//            .Adaptive(70.dp),// at least 50.dp width, filled whole screen
////            .Fixed(5), // show five column in lazy vertical grid
////            .FixedSize(100.dp), // fixed size of grid, only show complete size box, if not space than use next row and left some space
//        verticalArrangement = Arrangement.spacedBy(16.dp),
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
//        ) {
//        items(100) { i ->
//            Box(
//                modifier = Modifier
////                    .width(
////                        width =
////                        Random.nextInt(1..200).dp
////                    )
//                    .height(height = Random.nextInt(1..200).dp)
//                    .size(200.dp) // width is override
//                    .clip(shape = RoundedCornerShape(10.dp))
//                    .background(Color(Random.nextInt()))
//
//            )
//        }
//    }
}

@Preview(showBackground = true)
@Composable
private fun LazyGridDemoPreview() {
    SuperAppTheme {
        LazyGridDemo()
    }
}