package com.example.mona.compose

import androidx.compose.foundation.Image
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mona.R

@Preview
@Composable
fun Banner() {
    Card(elevation = 8.dp) {
        Image(painter = painterResource(id = R.drawable.ic_banner_2), contentDescription = "Desc")
    }
}
