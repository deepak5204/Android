package com.example.superapp.basic_layouts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superapp.ui.theme.SuperAppTheme
import kotlin.random.Random
import kotlin.random.nextInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyListDemo(modifier: Modifier = Modifier) {

//    LazyRow {
//        items(100) { i ->
//            Box(
//                modifier = Modifier
//                    .size(100.dp)
//                    .background(Color(Random.nextInt()))
//            )
//        }
//    }


    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
//            .padding(16.dp) // not scrollable padding for lazy column
            .background(Color.Gray),
//        contentPadding = PaddingValues(16.dp), // padding for items and it is scrollable
//        reverseLayout = true, // reverse the layout and start from bottom
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(100) { i->
            Text(text = "$i")
        }

        stickyHeader{
            Text(
                text = "A",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Green)
            )
        }

        items(100) { i ->
            Text(text = "${i + 100}")
        }

        stickyHeader{
            Text(
                text = "B",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Green)
            )
        }

        items(100) { i ->
            Text(text = "${i + 200}")
        }

        item {
            Text( // this text give lazy loading behaviour i.e. it comes at the end of the list
                text = "Reached the end",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red)
            )
        }



    }
}


@Preview (showBackground = true) // Adds a default background (usually white or light gray)
@Composable
private fun LazyListDemoPreview() {
    SuperAppTheme {
        LazyListDemo()
    }
}