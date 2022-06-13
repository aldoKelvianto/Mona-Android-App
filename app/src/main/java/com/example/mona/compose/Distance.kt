package com.example.mona.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mona.theme.Orange800
import com.example.mona.theme.YellowLight500

@Composable
fun Distance(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(YellowLight500)
            .padding(4.dp)
    ) {
        Text(
            text = "15 menit",
            style = TextStyle(
                color = Orange800
            ),
        )
    }
}

@Preview
@Composable
fun PreviewDistance() {
    Distance()
}
