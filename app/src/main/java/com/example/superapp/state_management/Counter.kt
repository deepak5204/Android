package com.example.superapp.state_management

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.superapp.ui.theme.SuperAppTheme
import androidx.compose.runtime.getValue


private val base_url = "https://..."
//private var count = 0; // normal Integer not able to recalled the composable when changes
//private  var count by mutableIntStateOf(0)
@Composable
fun Counter(
    count : Int,
    onCountClick: () -> Unit,
    modifier: Modifier = Modifier
) {
//    var count by remember { // not remember after Configuration change
//        mutableIntStateOf(0)
//    }


    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { // not a composable lambda, it is a normal lambda
                onCountClick()
            }
        ) {
//            count++ // this will infinite loop because of recomposition when state change
            Text(
                text = "Counter: ${count}"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CounterPreview() {
    SuperAppTheme {
        Counter(
            count = 0,
            onCountClick = {}
        )
    }
}