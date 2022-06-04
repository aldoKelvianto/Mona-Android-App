package com.example.mona.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlin.random.Random

fun randomColor(): Color = Color(
    red = Random.nextInt(0, 255),
    green = Random.nextInt(0, 255),
    blue = Random.nextInt(0, 255)
)

@Composable
fun UserPhoto(
    drawableId: Int
) {
    val ringColor = remember {
        // By using `remember`, randomColor will not
        // get called everytime `recompose` happens
        randomColor()
    }
    Image(
        painter = painterResource(id = drawableId),
        contentDescription = "Description",
        modifier = Modifier
            .border(2.dp, ringColor, CircleShape)
            .padding(4.dp)
            .clip(CircleShape)
            .size(38.dp)
    )
}
