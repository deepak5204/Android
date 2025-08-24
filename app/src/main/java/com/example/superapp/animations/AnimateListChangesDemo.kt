package com.example.superapp.animations

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.superapp.ui.theme.SuperAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@Composable
fun AnimateListChangesDemo(modifier: Modifier = Modifier) {
    var items by remember {
        mutableStateOf(
            (1..100).map {
                "List item $it"
            }
        )
    }

    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Button(
            onClick = {
                items = items.shuffled()
            }
        ) {
            Text(
                text = "Shuffle"
            )
        }


        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(
                items = items,
                key = {it}
            ) {
                text ->

                Text(
                    text = text,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable{
                            items = items - text
                        }
                        .animateItem()
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun AnimateListChangesDemoPreview() {
    SuperAppTheme {
        AnimateListChangesDemo()
    }
}