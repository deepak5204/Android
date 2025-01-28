package com.example.superapp.basic_layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.superapp.ui.theme.SuperAppTheme
import java.nio.file.WatchEvent
import kotlin.math.roundToInt

@Composable
fun RowColumnDemo() {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Hello Android", fontSize = 40.sp,
            modifier = Modifier
                .width(200.dp)
                .alignBy(FirstBaseline),

        )
        Text(text = "Hello Android", fontSize = 20.sp, modifier = Modifier.alignByBaseline())

//        Text(text = "Hello Android", fontSize = 40.sp, modifier = Modifier.alignBy(LastBaseline))
//        Text(text = "Hello Android", fontSize = 20.sp, modifier = Modifier.alignByBaseline())
//        Text(text = "Hello Android", fontSize = 40.sp, modifier = Modifier.alignBy(FirstBaseline))
//        Text(text = "Hello Android", fontSize = 20.sp, modifier = Modifier.alignByBaseline())

    }

//    Row(
//        modifier = Modifier
//            .size(300.dp)
//            .background(Color.Gray)
//           ,
//        horizontalArrangement = Arrangement
////            .aligned( // need to revise
////                Alignment.Horizontal{size, space , layoutDirection -> // here size = size of our parent layout
////                   (space * .2f).roundToInt()
////                }
////             )
////            .Absolute.SpaceEvenly
////            .Absolute.SpaceBetween
////            .Absolute.SpaceAround
////            .Absolute.Right
////            .Absolute.Left // default start position
////            .Absolute.Center
////            .SpaceBetween
////            .SpaceAround
////            .SpaceEvenly
////            .Center
////            .End
//            .Start // almost same Absolute.Left
////            .spacedBy(10.dp)
//        ,
//        verticalAlignment = Alignment
//////            .Top //default
//////            .Bottom
//            .CenterVertically
//    ) {
//
//
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .background(Color.Red)
////                .weight(1f)
////                .align(Alignment.CenterVertically)
//        )
//
//        Column (
//            modifier = Modifier.align(alignment = Alignment.CenterVertically)
//        ){
//            Box(
//            modifier = Modifier
//                .size(50.dp)
//                .background(Color.Green)
////                .weight(1f)
////                .align(Alignment.CenterVertically)
//        )
//
//            Box(
//            modifier = Modifier
//                .size(50.dp)
//                .background(Color.Blue)
////                .weight(1f)
//
//        )
//        }
//
////
////
////
//    }


//    Column(
//        modifier = Modifier
//            .fillMaxSize() // screen size
//            .background(Color.Gray),
//        verticalArrangement = Arrangement.Center
////            .SpaceEvenly // Equal distance between all items
////            .SpaceAround // same space both side(top & bottom)
////            .SpaceBetween // vertically space between
////            .Bottom
////            .Top // default
////            .End & .Start  not working
//        ,
//        horizontalAlignment = Alignment.CenterHorizontally
////            .Top & .Center & .Bottom & .BottomEnd
////            .Start // default
//        ,
//    ) {
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .background(Color.Red)
////                .weight(1f),
//
//        )
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .background(Color.Green)
////                .weight(1f)
////                .align(Alignment.CenterHorizontally)
//        )
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .background(Color.Blue)
////                .weight(1f)
//                .align(Alignment.End)
//
//        )
//    }
}


@Preview(
    showBackground = true,
    backgroundColor = 0xFFF // white
)
@Composable
private fun RowColumnDemoPreview() {
    SuperAppTheme {
        RowColumnDemo()
    }
}