package com.example.superapp.basic_layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.superapp.ui.theme.SuperAppTheme

@Composable
fun WindowSizeClassDemo(modifier: Modifier = Modifier) {
    val windowClass = currentWindowAdaptiveInfo().windowSizeClass

    Scaffold {paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
        ) {


            when (windowClass.windowWidthSizeClass) {
                WindowWidthSizeClass.COMPACT -> {
                    Text(text = "COMPACT")
                    MyLazyList()
                }

                WindowWidthSizeClass.MEDIUM -> {
                    Text(text = "MEDIUM")
//                    MyLazyList()
                }

                WindowWidthSizeClass.EXPANDED -> {
                    Text(text = "EXPANDED")
                    Row (
                        modifier = Modifier.fillMaxSize()
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(3f)
                                .background(Color.Red)
                        ) {
                            Text(text = "menu item 1")
                            Text(text = "menu item 2")
                            Text(text = "menu item 3")
                            Text(text = "menu item 4")
                            Text(text = "menu item 5")
                            Text(text = "menu item 6")
                            Text(text = "menu item 7")
                        }

                        MyLazyList(
                            modifier = Modifier
                                .weight(7f)
                                .fillMaxHeight()
                        )
                    }

                }


            }
        }
    }
}

@Composable
fun MyLazyList(modifier: Modifier = Modifier){
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
//            .background(Color.Blue)
    ) {
        items(20) { index ->
            Text(
                text = "Item $index",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}




//@PreviewScreenSizes
@Preview(
    showBackground = true,
    device = Devices.NEXUS_10

)
@Composable
private fun WindowSizeClassDemoPreview() {
    SuperAppTheme {
        WindowSizeClassDemo()
    }
}