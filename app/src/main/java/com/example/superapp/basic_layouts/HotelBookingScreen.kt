package com.example.superapp.basic_layouts

import android.health.connect.datatypes.Device
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.superapp.ui.theme.SuperAppTheme
import com.example.superapp.R
import org.w3c.dom.Text


private val tags = listOf(
    "City Center",
    "Luxury",
    "Instant Booking",
    "Exclusive Deal",
    "Early Bird Discount",
    "Romantic Gateway",
    "24/7 Support"
)

private val offers = mapOf(
    R.drawable.bed to "2 Bed",
    R.drawable.breakfast to "Breakfast",
    R.drawable.cutlery to "Cutlery",
    R.drawable.pawprint to "Pet Friendly",
    R.drawable.serving_dish to "Dinner",
    R.drawable.snowflake to "Air Conditioning",
    R.drawable.television to "TV",
    R.drawable.wi_fi_icon to "Wifi"
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HotelBookingScreen(modifier: Modifier = Modifier) {
     LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
         verticalArrangement = Arrangement.spacedBy(16.dp),
         horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item{
            Box(
                modifier = Modifier,
                contentAlignment = Alignment.BottomCenter
            ){
                Image(
                    painter = painterResource(R.drawable.living_room),
                    contentDescription = "living room",
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(
                            max = 250.dp
                        ),
                    contentScale = ContentScale.Crop
                )

                HotelFadedBanner(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                )
            }
        }

         item {
             HorizontalDivider(
                 modifier = Modifier.padding(horizontal = 16.dp)
             )
         }

         item{
             FlowRow (
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(16.dp),
                 horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
             ){
                 tags.forEach {tag ->
                     AssistChip(
                         onClick = {},
                         label = {
                             Text(text = tag)
                         }
                     )
                 }
             }
         }

         item {
             HorizontalDivider(
                 modifier = Modifier.padding(horizontal = 16.dp)
             )
         }

         item {
             Text(
                 text = """I agree with what Juan said. I remember having to debug code that used databinding only to find out that the issue was caused by one line in xml. You can spend many hours debugging code.""",
                 fontSize = 14.sp,
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(horizontal = 16.dp),
                 textAlign = TextAlign.Justify
             )
         }

         item {
             HorizontalDivider(
                 modifier = Modifier
                     .padding(horizontal = 16.dp)
             )
         }

         item{
             Text(
                 text = "What we offer",
                 fontSize = 18.sp,
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(horizontal = 16.dp),
                 textAlign = TextAlign.Center,
                 fontWeight = FontWeight.Bold
             )
         }

         item {
             LazyRow (
                 modifier = Modifier
                     .fillMaxWidth(),
                 horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
             ){
                items(offers.entries.toList()){ (drawableResId, label) ->
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .background(Color.Gray.copy(alpha = .3f))
                            .padding(8.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(drawableResId),
                            contentDescription = null,
                            modifier = Modifier.size(36.dp)
                        )
                        Text(
                            text = label,
                            fontSize= 14.sp
                        )
                    }

                }
             }
         }

         item{
             Button(
                 onClick = {},
                 modifier = Modifier
                     .padding(horizontal = 16.dp)
                     .widthIn(
                         max = 400.dp
                     )
                     .fillMaxWidth()
             ) {
                 Text(
                     text = "Book now!"
                 )
             }
         }
    }
}

@Composable
fun HotelFadedBanner(modifier: Modifier = Modifier) {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

    Row(
        modifier = modifier
            .background(Color.White.copy(alpha = 0.7f)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom

    ) {
        Column (
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ){
            Text(
                text = "Hotel California Strawberry",
                fontWeight = FontWeight.Bold,
                fontSize = when(windowSizeClass.windowWidthSizeClass){
                    WindowWidthSizeClass.COMPACT -> 20.sp
                    WindowWidthSizeClass.MEDIUM -> 24.sp
                    WindowWidthSizeClass.EXPANDED -> 28.sp
                    else -> {18.sp}
                },
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

           LabelledIcon(
               text = "Los Angeles, California",
               icon = {
                   Icon(
                       imageVector = Icons.Default.LocationOn,
                       contentDescription = "location icon",
                       tint = Color.DarkGray
                   )
               }
           )

            LabelledIcon(
                text = "4.9 (13K reviews",
                icon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "location icon",
                        tint = Color.Yellow
                    )
                }
            )
        }

        Text(
            text = buildAnnotatedString {
                val fontSizeMultiplier = when(windowSizeClass.windowWidthSizeClass){
                    WindowWidthSizeClass.COMPACT -> 1f
                    WindowWidthSizeClass.MEDIUM -> 1.2f
                    WindowWidthSizeClass.EXPANDED -> 1.5f
                    else -> {1f}
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp * fontSizeMultiplier
                    )
                ){
                     append("420$/")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp * fontSizeMultiplier
                    )
                ){
                    append("night")
                }
            }
        )
    }
}


@Composable
fun LabelledIcon(
    modifier: Modifier = Modifier,
    text: String,
    icon: @Composable () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Text(text = text, fontSize = 14.sp)
    }
}

@Preview
@Composable
private fun HotelBookingScreenPreview() {
    SuperAppTheme {
        HotelBookingScreen()

    }
}

@Preview(device = Devices.NEXUS_10)
@Composable
private fun HotelBookingDesktopScreenPreview() {
    SuperAppTheme {
        HotelBookingScreen()

    }
}