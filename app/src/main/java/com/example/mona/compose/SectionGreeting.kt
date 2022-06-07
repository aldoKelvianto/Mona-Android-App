package com.example.mona.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun PreviewSectionGreeting() {
    SectionGreeting()
}

@Composable
fun SectionGreeting() {
    Column(
        modifier = Modifier
            .background(
                Brush.radialGradient(
                    colors = HeaderColors,
                    radius = 250f,
                    center = Offset(240f, 10f)
                )
            )
    ) {
        Text(
            text = "Hey, Traveller",
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.size(100.dp))
    }
}
