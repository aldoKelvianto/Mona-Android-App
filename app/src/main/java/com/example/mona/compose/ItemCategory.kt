package com.example.mona.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mona.R
import com.example.mona.data.Category
import com.example.mona.data.Category1

@Preview
@Composable
fun PreviewTwoImages() {
    TwoImages(imageRes1 = Category1.icon1, imageRes2 = Category1.icon2)
}

@Composable
fun TwoImages(imageRes1: Int, imageRes2: Int) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageRes1),
            modifier = Modifier
                .offset(x = (-10).dp)
                .size(60.dp),
            contentDescription = "desc"
        )
        Image(
            painter = painterResource(id = imageRes2),
            modifier = Modifier
                .offset(x = 10.dp)
                .size(40.dp),
            contentDescription = "desc"
        )
    }
}

@Preview
@Composable
fun PreviewItemCategory() {
    ItemCategory(Category1)
}

@Composable
fun ItemCategory(category: Category) {
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(
                    Brush.radialGradient(
                        colors = ItemCategoryColors,
                        radius = 250f,
                        center = Offset(120f, 50f)
                    )
                )
                .size(100.dp)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = category.name,
                modifier = Modifier.width(70.dp),
                color = Blue700,
                textAlign = TextAlign.Center
            )
            Row(
            ) {
                Image(
                    painter = painterResource(id = category.icon1),
                    modifier = Modifier
                        .size(40.dp)
                        .offset(x = 10.dp),
                    contentDescription = "desc"
                )
                Image(
                    painter = painterResource(id = category.icon2),
                    modifier = Modifier
                        .size(40.dp)
                        .offset(x = (-10).dp),
                    contentDescription = "desc"
                )
            }
        }
    }
}
