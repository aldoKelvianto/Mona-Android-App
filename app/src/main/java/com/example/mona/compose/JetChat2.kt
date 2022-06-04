package com.example.mona.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun JetChat2() {
    Column {
        Row {
            Text("Aldo Kelvianto")
            Text("14:00")
        }
        Text("Let\'s go to Aeon mall!")
    }
}
