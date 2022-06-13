package com.example.mona.compose

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import com.example.mona.R

@Composable
fun SectionLocation() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        ConstraintLayout(
            sectionLocationConstraint()
        ) {
            Text(
                modifier = Modifier.layoutId("text"),
                text = "Mondstadt",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Icon(
                modifier = Modifier
                    .layoutId("chevron")
                    .rotate(90f),
                painter = painterResource(id = R.drawable.ic_chevron_outline_24),
                contentDescription = "Location icon",
                tint = Color.White
            )
            Distance(
                modifier = Modifier.layoutId("distance")
            )
        }
    }
}

private fun sectionLocationConstraint() = ConstraintSet {
    // At the time of writing, we can't use `createRefs`
    // val (text, chevron, distance, point) = createRefs()
    val text = createRefFor("text")
    val chevron = createRefFor("chevron")
    val distance = createRefFor("distance")

    constrain(text) {
        top.linkTo(parent.top)
        start.linkTo(parent.start)
        bottom.linkTo(parent.bottom)
    }
    constrain(chevron) {
        top.linkTo(parent.top)
        start.linkTo(text.end)
        bottom.linkTo(parent.bottom)
    }
    constrain(distance) {
        top.linkTo(parent.top)
        start.linkTo(chevron.end)
        bottom.linkTo(parent.bottom)
    }
}

@Preview(backgroundColor = 0xff212121, showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun PreviewSectionLocation() {
    SectionLocation()
}
