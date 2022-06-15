package com.example.mona.ui.greeting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mona.R

@Preview(backgroundColor = 0xff212121, showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun PreviewSectionGreeting() {
    SectionGreeting()
}

@Composable
fun SectionGreeting(greeting: String = rememberGreetingState()) {
    Column(Modifier.padding(vertical = 4.dp, horizontal = 12.dp)) {
        Text(
            text = greeting,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Color.White,
                fontSize = 26.sp
            )
        )
    }
}

@Composable
fun rememberGreetingState(): String {
    val greeting = stringResource(id = R.string.section_greeting)
    return remember(greeting) {
        greeting
    }
}
