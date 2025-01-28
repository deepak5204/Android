package com.example.superapp.basic_layouts

import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.superapp.ui.theme.SuperAppTheme

@Composable
fun HomeWorkDemo(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Red)
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier
                .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = Color.White,
            )
        }

        Column(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.TopStart),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Project X",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Text(
                text = "This is a short description. It is a layout that is specific to material3 design actually. Material3 brings typically a lot of UI components that help us with navigation, may be implementing with certain menus for instance  topAppBar, bottomAppBar, floatingActionButton SnackBarHost etc.",
                fontSize = 20.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
            )
        }

        IconButton(
            onClick = {},
            modifier = Modifier
                .align(Alignment.TopEnd)
        ) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
            )
        }

        Text(
            text = "Mar 5, 10:00",
            modifier = Modifier
                .padding(bottom = 10.dp, end = 10.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun TaskCard(modifier: Modifier = Modifier) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null
            )

            Text(
                text = "Project X",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        }
    }
}

@Preview
@Composable
private fun HomeWorkDemoPreview() {
    SuperAppTheme {
        HomeWorkDemo()
    }
}