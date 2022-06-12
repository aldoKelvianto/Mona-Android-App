package com.example.mona.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun PreviewScreenHome() {
    ScreenHome()
}

@Composable
fun ScreenHome() {
    val scrollState = rememberScrollState()
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .verticalScroll(
                        state = scrollState,
                        enabled = true
                    )
                    .padding(bottom = paddingValues.calculateBottomPadding() + 12.dp)
            ) {
                SectionTop()
                SectionCategory()
            }
        },
        bottomBar = { SectionBottomBar() }
    )
}
