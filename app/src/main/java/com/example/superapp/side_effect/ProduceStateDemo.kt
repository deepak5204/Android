package com.example.superapp.side_effect

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.superapp.ui.theme.SuperAppTheme
import kotlinx.coroutines.delay

@Composable
fun ProduceStateDemo(modifier: Modifier = Modifier) {

    val counter by produceState(0) {
        while (true) {
            delay(1000L)
            value += 1
        }
    }

//    var counter by remember { mutableIntStateOf(0) }
//    LaunchedEffect(true) {
//        while(true){
//            delay(1000L)
//            counter++
//        }
//    }

    Text(
        text = counter.toString(),
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}

@Preview(showBackground = true)
@Composable
private fun ProduceStateDemoPreview() {
    SuperAppTheme {
        ProduceStateDemo()
    }
}