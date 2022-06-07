package com.example.mona.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun PreviewScreenHome() {
    ScreenHome()
}

@Composable
fun ScreenHome() {
    ThemeMona {
        Scaffold(
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(bottom = paddingValues.calculateBottomPadding())
                ) {
                    PreviewSectionGreeting()
                    PreviewDeviceInfo()
                    SectionBanner()
                    SectionCategory()
                }
            },
            bottomBar = { SectionBottomBar() }
        )
    }
}
