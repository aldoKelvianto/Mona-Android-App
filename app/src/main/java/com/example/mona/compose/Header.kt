package com.example.mona.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Header() {
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
        Spacer(modifier = Modifier.size(100.dp))
    }
}
