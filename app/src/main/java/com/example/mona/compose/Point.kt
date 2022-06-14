package com.example.mona.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mona.R

@Composable
fun Point(modifier: Modifier = Modifier, point: String = "0") {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .padding(vertical = 4.dp, horizontal = 6.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_mora),
                contentDescription = "Mora icon",
                modifier = Modifier
                    .size(24.dp)
                    .padding(2.dp)
            )
            val black = Color(0xff242424)
            Text(
                text = point,
                modifier = Modifier.padding(start = 4.dp),
                style = TextStyle(color = black, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            )
        }
    }
}

@Preview
@Composable
fun PreviewPoint() {
    Point()
}
