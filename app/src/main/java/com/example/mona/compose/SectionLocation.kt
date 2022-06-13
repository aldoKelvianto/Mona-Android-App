package com.example.mona.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mona.R

@Composable
fun SectionLocation() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        val (text, chevron) = createRefs()
        Text(
            modifier = Modifier.constrainAs(text) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            },
            text = "Mondstadt",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Icon(
            modifier = Modifier
                .constrainAs(chevron) {
                    top.linkTo(parent.top)
                    start.linkTo(text.end)
                    bottom.linkTo(parent.bottom)
                }
                .rotate(90f),
            painter = painterResource(id = R.drawable.ic_chevron_outline_24),
            contentDescription = "Location icon",
            tint = Color.White
        )
    }
}

@Preview(backgroundColor = 0xff212121, showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun PreviewSectionLocation() {
    SectionLocation()
}
