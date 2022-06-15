package com.example.mona.ui.category

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mona.data.Category
import com.example.mona.data.CategoryRepo

@Preview
@Composable
fun PreviewTwoImages() {
    TwoImages(
        imageRes1 = CategoryRepo.sampleCategory.icon1,
        imageRes2 = CategoryRepo.sampleCategory.icon2
    )
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
                .size(50.dp),
            contentDescription = "desc"
        )
    }
}

@Preview
@Composable
fun PreviewCategoryItem() {
    CategoryItem(CategoryRepo.sampleCategory)
}

private fun Modifier.categoryBackground(isHighlight: Boolean): Modifier {
    val lightBlue = Color(0xffD3E8FC)
    val darkBlue = Color(0xff2E6BB5)
    val colors = listOf(lightBlue, darkBlue)
    val gradient = Brush.radialGradient(
        colors = colors,
        radius = 170f,
        center = Offset(110f, 50f)
    )
    return if (isHighlight) {
        background(gradient)
    } else {
        background(Color.White)
    }
}

@Composable
fun CategoryItem(category: Category) {
    val blue = Color(0xff2E5992)
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .categoryBackground(category.isHighlight)
                .size(100.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = category.name,
                modifier = Modifier.width(82.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = blue,
                textAlign = TextAlign.Center
            )
            Row {
                TwoImages(imageRes1 = category.icon1, imageRes2 = category.icon2)
            }
        }
    }
}
