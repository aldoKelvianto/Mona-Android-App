package com.example.mona.ui.location

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
fun SectionLocation(state: LocationState) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 12.dp),
        constraintSet = sectionLocationConstraint()
    ) {
        Text(
            modifier = Modifier.layoutId("text"),
            text = state.location,
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
            modifier = Modifier.layoutId("distance"),
            distance = state.distance
        )
        Point(
            modifier = Modifier.layoutId("point"),
            point = state.point
        )
    }
}

private fun sectionLocationConstraint() = ConstraintSet {
    // At the time of writing, we can't use `createRefs`
    // val (text, chevron, distance, point) = createRefs()
    val text = createRefFor("text")
    val chevron = createRefFor("chevron")
    val distance = createRefFor("distance")
    val point = createRefFor("point")

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
    constrain(point) {
        top.linkTo(parent.top)
        end.linkTo(parent.end)
        bottom.linkTo(parent.bottom)
    }
}

@Preview(backgroundColor = 0xff212121, showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun PreviewSectionLocation() {
    val state = LocationState(
        "Mondstadt",
        "15 minutes",
        "0"
    )
    SectionLocation(state)
}
