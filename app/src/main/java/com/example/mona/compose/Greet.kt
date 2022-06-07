package com.example.mona.compose

import android.os.Build
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun Greet(name: String = "Traveller") {
    Text(
        text = "Hey, $name",
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun HelloWorld() {
    Column(modifier = Modifier.padding(10.dp)) {
        val androidVersion = getAndroidVersion()
        Text(text = androidVersion)
        val density = LocalContext.current.resources.displayMetrics.density
        Text(text = "Density: $density")
    }
}

fun getAndroidVersion(): String {
    val release = Build.VERSION.RELEASE
    val sdkVersion = Build.VERSION.SDK_INT
    return "Android SDK: $sdkVersion ($release)"
}
