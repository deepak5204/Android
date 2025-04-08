package com.example.superapp.composition_locals

import android.graphics.ColorFilter
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.superapp.ui.theme.SuperAppTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CompositionLocalDemo(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Red
        )
    ) {
        CompositionLocalProvider(
            LocalContentColor provides Color.Green
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
//                tint = Color.Gray // here overwrite the composition local color
            )
            Text(
                text = "Hello world"
            )
        }

    }
}

@Composable
fun MyCustomTopAppBar(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit
) {
    Row(
        modifier = modifier
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CompositionLocalProvider(
            LocalTextStyle provides LocalTextStyle.current.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )
        ){
            title()
        }
    }
}

@Preview
@Composable
private fun CompositionLocalDemoPreview() {
    SuperAppTheme {
//        CompositionLocalDemo()
        MyCustomTopAppBar {
            Text(text = "Hello world")
        }

    }
}