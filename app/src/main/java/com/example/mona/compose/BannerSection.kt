package com.example.mona.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mona.data.Banner
import com.example.mona.data.BannerData

@Preview
@Composable
fun BannerSection() {
    val items = BannerData.items
    LazyRow(
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(items) { item ->
            Banner(item)
        }
    }
}

@Composable
fun Banner(banner: Banner) {
    Card(
        elevation = 8.dp,
    ) {
        Image(
            painter = painterResource(id = banner.resId),
            contentDescription = "Banner item"
        )
    }
}

@Preview
@Composable
fun PreviewBanner() {
    Banner(BannerData.banner1)
}
