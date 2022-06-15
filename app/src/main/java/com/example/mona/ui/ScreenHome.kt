package com.example.mona.ui

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.mona.ui.banner.SectionBanner
import com.example.mona.ui.category.SectionCategory
import com.example.mona.ui.greeting.SectionGreeting
import com.example.mona.ui.location.SectionLocation
import com.example.mona.ui.search.SectionSearch

@Preview
@Composable
fun PreviewScreenHome() {
    ScreenHome(bottomPadding =0.dp)
}

@Composable
fun ScreenHome(
    state: ScreenHomeState = rememberScreenHomeState(),
    scrollState: ScrollState = rememberScrollState(),
    bottomPadding: Dp
) {
    Column(
        modifier = Modifier
            .verticalScroll(
                state = scrollState,
                enabled = true
            )
            .padding(bottom = bottomPadding + 12.dp)
    ) {
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
                SectionSearch()
                SectionBanner(state.bannerList)
            }
            val heightInDp = with(LocalDensity.current) {
                height.value.toDp()
            }
            // 70 is the banner height (140) divided by two.
            val backgroundHeight = heightInDp - 70.dp
            // Height is calculated at runtime, we must use device to see the preview.
            Box(
                modifier = Modifier
                    .background(getRadialGradient())
                    .fillMaxWidth()
                    .height(backgroundHeight)
                    .zIndex(0f)
            )
        }
        SectionCategory(state.categoryList)
    }
}

private fun getRadialGradient(): Brush {
    val red = Color(0xffC9000F)
    val purple = Color(0xff090955)
    val headerColors = listOf(red, purple)
    return Brush.radialGradient(
        colors = headerColors,
        radius = 550f,
        center = Offset(606f, -100f)
    )
}

@Composable
private fun rememberScreenHomeState(): ScreenHomeState {
    return remember {
        ScreenHomeState(
            locationState =

        )
    }

}
