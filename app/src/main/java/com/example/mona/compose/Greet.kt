package com.example.mona.compose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun Greet(name: String = "Elvan") {
    Text("Hello, $name")
}
