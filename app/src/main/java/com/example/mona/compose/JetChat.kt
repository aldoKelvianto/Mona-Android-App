package com.example.mona.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mona.R


@Preview
@Composable
fun JetChat1() {
    Text("Aldo Kelvianto")
    Text("14:00")
    Text("Let\'s go to Aeon mall!")
}

@Preview
@Composable
fun JetChat2() {
    Column {
        Row {
            Text("Aldo Kelvianto")
            Text("14:00")
        }
        Text("Let\'s go to Aeon mall!")
    }
}

@Preview
@Composable
fun JetChat3() {
    Row {
        Image(painter = painterResource(id = R.drawable.mona), contentDescription = "User photo")
        Column {
            Row {
                Text("Mona")
                Text("14:00")
            }
            Text("Let\'s get some Mora!")
        }
    }
}

@Preview
@Composable
fun JetChat4() {
    Row {
        UserPhoto(drawableId = R.drawable.mona)
        Column {
            Row {
                Text("Mona")
                Text("14:00")
            }
            Text("Let\'s get some Mora!")
        }
    }
}
