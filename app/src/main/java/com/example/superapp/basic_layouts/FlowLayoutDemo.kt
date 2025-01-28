package com.example.superapp.basic_layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowColumnOverflow
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowOverflow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superapp.ui.theme.SuperAppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowLayoutDemo(modifier: Modifier = Modifier) {

    FlowColumn (
        modifier = modifier
            .fillMaxSize(),
//        horizontalArrangement = Arrangement.spacedBy(
//            16.dp,
//            alignment = Alignment.CenterHorizontally
//        ),
//        verticalArrangement = Arrangement.SpaceBetween,
//        maxItemsInEachRow = 3,
        maxItemsInEachColumn = 10,
        maxLines = 2, // it decide the not of items' line to show, remaining items will not show


        overflow = FlowColumnOverflow.expandOrCollapseIndicator(
            expandIndicator = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null)
                }
            },
            collapseIndicator = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null)
                }
            },
            minColumnsToShowCollapse = 2 // it decide to show collapse button or not

        )

//        overflow = FlowRowOverflow.expandOrCollapseIndicator(
//            expandIndicator = {
//                IconButton(
//                    onClick = {}
//                ) {
//                    Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null)
//                }
//            },
//            collapseIndicator = {
//                Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = null)
//            }
//        )


    ){
            for(i in 1..30){
        AssistChip(
            onClick = {},
            label = {
                Text(
                    text = "item $i"
                )
            }
        )
    }
    }
}

@Preview(showBackground = true)
@Composable
private fun FlowLayoutDemoPreview() {
    SuperAppTheme {
        FlowLayoutDemo()
    }
}