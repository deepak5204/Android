package com.example.superapp.basic_layouts

import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.superapp.ui.theme.SuperAppTheme
import com.example.superapp.R

@Composable
fun HomeWorkDemo(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier

            .background(Color.Red, shape = RoundedCornerShape(8.dp))
            .padding(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {}, modifier = Modifier.weight(0.1f)
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null,
                    tint = Color.White,
                )
            }
            Text(
                text = "Project X",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier.weight(0.8f)
            )
            IconButton(
                onClick = {}, modifier = Modifier.weight(0.1f) .size(48.dp)
            ) {
                Box(
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ellipsis),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(), // Ensure it fills the Box
                        tint = Color.White // Keep original colors if needed
                    )
                }
            }
        }

        Row {
            Box(
                modifier = Modifier
                    .weight(0.1f)
            )
            Text(
                text = "This is a short description. It is a layout that is specific to material3 design actually. Material3 brings typically a lot of UI components that help us with navigation, may be implementing with certain menus for instance  topAppBar, bottomAppBar, floatingActionButton SnackBarHost etc.",
                fontSize = 30.sp,
                color = Color.White,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .weight(0.9f)
                    .align(Alignment.CenterVertically)
            )
        }

        Text(
            text = "Mar 5, 10:00",
            fontSize = 25.sp,
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.End)
        )

    }

//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color.Red, shape = RoundedCornerShape(8.dp))
//    ) {
//        IconButton(
//            onClick = {},
//            modifier = Modifier
//                .align(Alignment.TopStart)
//        ) {
//            Icon(
//                imageVector = Icons.Default.Check,
//                contentDescription = null,
//                tint = Color.White,
//            )
//        }
//
//        Column(
//            modifier = Modifier
//                .padding(20.dp)
//                .align(Alignment.TopStart),
//            verticalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//
//
//        }
//
//        IconButton(
//            onClick = {},
//            modifier = Modifier
//                .align(Alignment.TopEnd)
//        ) {
//            Icon(
//                imageVector = Icons.Default.,
//                contentDescription = null,
//            )
//        }
//
//        Text(
//            text = "Mar 5, 10:00",
//            modifier = Modifier
//                .padding(bottom = 10.dp, end = 10.dp)
//                .align(Alignment.BottomEnd)
//        )
//    }
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

@Preview(device = Devices.NEXUS_10)
@Composable
private fun HomeWorkDemoPreview() {
    SuperAppTheme {
        HomeWorkDemo()
    }
}