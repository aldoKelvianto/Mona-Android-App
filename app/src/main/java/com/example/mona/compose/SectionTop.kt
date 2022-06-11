package com.example.mona.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun SectionTop() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (column, spacer, sectionBanner) = createRefs()

        Column(modifier = Modifier
            .constrainAs(column) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .background(Color.Red)
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

        Spacer(modifier = Modifier
            .constrainAs(spacer) {
                top.linkTo(column.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .height(70.dp)
            .background(
                Color.Green
            )
            .zIndex(0f))

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
