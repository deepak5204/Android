package com.example.superapp.mesurements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superapp.ui.theme.SuperAppTheme

@Composable
fun LazyScrolling(modifier: Modifier = Modifier) {
    LazyColumn {
      items(20) {
          Text(
              text = "item $it",
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(16.dp)
          )
      }

        item{
            LazyColumn (
                modifier = Modifier.height(300.dp)
            ){
                items(10){
                    Text(
                        text = "inner item $it"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LazyScrollingPreview() {
    SuperAppTheme {
        LazyScrolling()
    }
}