package com.example.mona.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(backgroundColor = 0xff212121, showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun PreviewSectionGreeting() {
    SectionGreeting()
}

@Composable
fun SectionGreeting() {
    Column(Modifier.padding(8.dp)) {
        Text(
            text = "Hey, Traveller",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 24.sp
        )
    }
}
