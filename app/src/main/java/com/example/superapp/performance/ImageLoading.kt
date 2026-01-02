package com.example.superapp.performance

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun ImageLoading(modifier: Modifier = Modifier
) {
    LazyColumn (
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ){
        items(100) {
            AsyncImage(
                model = "https://cdn.abcotvs.com/dip/images/16519120_052325-wpvi-kermit-the-frog-commencement-speech-AP-img-1.jpg?w=1600",
                // here only first image is loading from network, and cached the image next time it uses cached image, so that's why is so smooth scrolling
                contentDescription = null,
                modifier = Modifier
                    .fillParentMaxWidth(),
                contentScale = ContentScale.Crop
            )

//            Image(
//                painter = painterResource(com.example.superapp.R.drawable.img),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillParentMaxWidth(),
//                contentScale = ContentScale.Crop
//            )
        }
    }
}