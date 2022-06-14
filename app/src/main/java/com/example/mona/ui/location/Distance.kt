package com.example.mona.ui.location

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Distance(modifier: Modifier = Modifier, distance: String) {
    val lightOrange = Color(0xffFFF4B1)
    val orange = Color(0xffE87600)
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(lightOrange)
            .padding(4.dp)
    ) {
        Text(
            text = distance,
            style = TextStyle(
                color = orange,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            ),
        )
    }
}

@Preview
@Composable
fun PreviewDistance() {
    Distance(distance = "15 menit")
}
