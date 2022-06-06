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

@Preview
@Composable
fun Greet(name: String = "Traveller") {
    Text(
        text = "Hey, $name",
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun HelloWorld() {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(text = "Hello, world!")
    }
}
