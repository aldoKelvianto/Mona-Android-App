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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mona.R

fun Modifier.gradientBackground(
    colors: List<Color>
) = background(
    Brush.radialGradient(
        colors = colors,
        radius = 250f,
        center = Offset(120f, 50f)
    )
)

@Preview
@Composable
fun ItemCategory() {
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .gradientBackground(ItemCategoryGradient)
        ) {
            Text(
                text = "Sayur dan buah",
                modifier = Modifier.padding(12.dp),
                color = Blue700,
                textAlign = TextAlign.Center
            )
            Box(modifier = Modifier.width(100.dp).padding(8.dp), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.ic_g1_vegs_a),
                    modifier = Modifier
                        .offset(x = (-10).dp)
                        .size(60.dp),
                    contentDescription = "desc"
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_g1_vegs_b),
                    modifier = Modifier
                        .offset(x = 10.dp)
                        .size(40.dp),
                    contentDescription = "desc"
                )
            }

        }
    }
}
