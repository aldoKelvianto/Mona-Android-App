package com.example.mona.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SectionTop() {
    Column(
        modifier = Modifier
            .background(
                Brush.radialGradient(
                    colors = HeaderColors,
                    radius = 550f,
                    center = Offset(766f, 10f)
                )
            )
    ) {
        SectionLocation()
        SectionGreeting()
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .size(8.dp))
        SectionSearchFavorite()
    }

}

@Preview
@Composable
fun PreviewSectionTop() {
    SectionTop()
}
