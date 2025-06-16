package com.example.superapp.mesurements

import android.R.attr.checked
import android.R.attr.text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.superapp.ui.theme.SuperAppTheme

@Composable
fun IntrinsicSizeDemo(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .width(IntrinsicSize.Max)
    ) {

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Option 1")
            Checkbox(
                checked = true,
                onCheckedChange = {}
            )
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Option 1, but in other way!")
            Checkbox(
                checked = true,
                onCheckedChange = {}
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun IntrinsicSizeDemoPreview() {
    SuperAppTheme {
        IntrinsicSizeDemo()
    }
}