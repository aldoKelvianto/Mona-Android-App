package com.example.mona.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.mona.data.Banner
import com.example.mona.data.BannerData
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

@Preview
@Composable
fun PreviewSectionBanner() {
    SectionBanner()
}

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun SectionBanner() {
    val items = BannerData.items
    val lazyListState = rememberLazyListState()
    val contentPadding = PaddingValues(8.dp)
    LazyRow(
        contentPadding = contentPadding,
        flingBehavior = rememberSnapperFlingBehavior(
            lazyListState = lazyListState,
            endContentPadding = contentPadding.calculateEndPadding(LayoutDirection.Ltr),
        ),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(items) { item ->
            Banner(item)
        }
    }
}

@Preview
@Composable
fun PreviewBanner() {
    Banner(BannerData.banner1)
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

