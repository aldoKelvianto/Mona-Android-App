package com.example.mona.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mona.R

@Composable
fun SectionLocation() {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Mondstadt", color = Color.White)
        Icon(
            painter = painterResource(id = R.drawable.ic_chevron_outline_24),
            contentDescription = "Location icon",
            modifier = Modifier.rotate(90f),
            tint = Color.White
        )
    }

}


@Preview(backgroundColor = 0xff212121, showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun PreviewSectionLocation() {
    SectionLocation()
}
