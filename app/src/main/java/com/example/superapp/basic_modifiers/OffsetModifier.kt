package com.example.superapp.basic_modifiers

import android.R.attr.text
import android.R.attr.x
import android.R.attr.y
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superapp.ui.theme.SuperAppTheme

@Composable
fun OffsetModifierDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .size(100.dp)
            .background(Color.Red)
//            .offset( // it occupy the complete column
//                x = 50.dp,
//                y = 20.dp
//            )
    ) {


        Text(
            text = "Hello World",
            modifier = modifier
                .offset( // it doesn't impact other fields, here it doesn't impact other text
                    x = 50.dp,
                    y = 20.dp
                )
                .background(Color.Green)
        )

        Text(
            text = "Hello World",
            modifier = modifier
                .background(Color.Yellow)
        )

    }
}


@Preview(showBackground = true)
@Composable
private fun OffsetModifierDemoPreview() {
    SuperAppTheme {
        OffsetModifierDemo()
    }
}