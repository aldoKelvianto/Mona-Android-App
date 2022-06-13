package com.example.mona.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.mona.data.Banner
import com.example.mona.data.BannerData
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

@Preview(showBackground = true, backgroundColor = 0xff212121, widthDp = 320, heightDp = 640)
@Composable
fun PreviewSectionBanner() {
    SectionBanner()
}

// Command, option, shift, R
@OptIn(ExperimentalSnapperApi::class)
@Composable
fun SectionBanner() {
    val items = BannerData.items
    val lazyListState = rememberLazyListState()
    val contentPadding = PaddingValues(12.dp)
    LazyRow(
        contentPadding = contentPadding,
        flingBehavior = rememberSnapperFlingBehavior(
            lazyListState = lazyListState,
            endContentPadding = contentPadding.calculateEndPadding(LayoutDirection.Ltr),
        ),
        state = lazyListState,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(items) { item ->
            Banner(item)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xff212121, widthDp = 320, heightDp = 640)
@Composable
fun PreviewBanner() {
    Banner(BannerData.banner1)
}

@Composable
fun Banner(banner: Banner) {
    Image(
        painter = painterResource(id = banner.resId),
        contentDescription = "Banner item",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .size(328.dp, 140.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}

