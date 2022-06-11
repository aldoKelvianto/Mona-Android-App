package com.example.mona.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mona.R

@Composable
fun SectionTop() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (column, spacer, newSpacer, sectionBanner) = createRefs()

        Column(modifier = Modifier
            .constrainAs(column) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .zIndex(1f)) {
            SectionLocation()
            SectionGreeting()
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(8.dp)
            )
            SectionSearchFavorite()
        }
        val brush = Brush.radialGradient(
            colors = HeaderColors,
            radius = 550f,
            center = Offset(766f, 10f)
        )
        Spacer(
            modifier = Modifier
                .constrainAs(newSpacer) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .background(brush)
                .size(100.dp)
                .zIndex(0f)
        )
        Column(modifier = Modifier
            .constrainAs(spacer) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .height(70.dp)
            .background(
                Color.Green
            )
            .zIndex(2f)) {
            Image(
                painter = painterResource(id = R.drawable.ic_g8_book_b),
                contentDescription = "book"
            )
        }

        SectionBanner(
            Modifier
                .constrainAs(sectionBanner) {
                    top.linkTo(column.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .background(Color.Blue)
                .zIndex(1f))
    }

}

@Preview
@Composable
fun PreviewSectionTop() {
    SectionTop()
}
