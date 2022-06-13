package com.example.mona.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun SectionTop() {
    Box {
        val height = remember {
            mutableStateOf(0)
        }
        Column(
            Modifier
                .onGloballyPositioned { coordinates ->
                    height.value = coordinates.size.height
                }
                .zIndex(1f)) {
            SectionLocation()
            SectionGreeting()
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(8.dp)
            )
            SectionSearchFavorite()
            SectionBanner()
        }
        val red = Color(0xffC9000F)
        val purple = Color(0xff090955)
        val headerColors = listOf(red, purple)
        val radialGradient = Brush.radialGradient(
            colors = headerColors,
            radius = 550f,
            center = Offset(606f, -100f)
        )
        val heightInDp = with(LocalDensity.current) {
            height.value.toDp()
        }
        // 70 is the banner height (140) divided by two.
        val backgroundHeight = heightInDp - 70.dp
        // We can't see the background in preview
        // Because the height is calculated at runtime
        // We must to test it on emulator/device.
        Box(
            modifier = Modifier
                .background(radialGradient)
                .fillMaxWidth()
                .height(backgroundHeight)
                .zIndex(0f)
        )
    }
}

@Preview
@Composable
fun PreviewSectionTop() {
    SectionTop()
}
