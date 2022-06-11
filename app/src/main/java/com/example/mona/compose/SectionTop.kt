package com.example.mona.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
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
        val brush = Brush.radialGradient(
            colors = HeaderColors,
            radius = 550f,
            center = Offset(766f, 10f)
        )
        val heightInDp = with(LocalDensity.current) {
            height.value.toDp()
        }
        Box(
            modifier = Modifier
                .background(brush)
                .fillMaxWidth()
                .height(heightInDp - 70.dp)
                .zIndex(0f)
        )
    }
}

@Preview
@Composable
fun PreviewSectionTop() {
    SectionTop()
}
