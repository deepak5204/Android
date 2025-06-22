package com.example.superapp.mesurements

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.superapp.ui.theme.SuperAppTheme


// measure children -> measure the layout itself -> place children
// measure children -> subcompose -> measure the layout itself -> place children

@Composable
fun BoxWithConstraintDemo(modifier: Modifier = Modifier) {
    BoxWithConstraints {
        if(this.constraints.hasFixedWidth){
            Text(text = "Fixed width")
        } else {
            Text(text = "dynamic width")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BoxWithConstraintDemoPreview() {
    SuperAppTheme {
        BoxWithConstraintDemo()
    }
}