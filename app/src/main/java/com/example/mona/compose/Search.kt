package com.example.mona.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mona.R

@Composable
fun Search(hint: String) {
    Row(
        modifier = Modifier
            .background(
                color = Color.White, shape = RoundedCornerShape(4.dp)
            )
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_search_outline_24),
            contentDescription = "Search icon"
        )
        Text(text = hint, color = Color.Blue)
    }

}

@Preview(showBackground = true, backgroundColor = 0xff212121, widthDp = 320, heightDp = 640)
@Composable
fun PreviewSearch() {
    val hint = "Cari produk disini"
    Search(hint)
}
