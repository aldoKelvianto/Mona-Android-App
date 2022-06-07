package com.example.mona.compose

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mona.state.BottomBarItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MonaTheme(
    Content: @Composable () -> Unit
) {
    val sysUiController = rememberSystemUiController()
    SideEffect {
        sysUiController.setSystemBarsColor(
            color = Color.Transparent
        )
    }
    Content()
}

@Preview
@Composable
fun Home() {
//    MonaTheme {
    Scaffold(
        content = {
            it
            Column {
                Header()
                HelloWorld()
                BannerSection()
                ItemCategorySection()
            }
        },
        bottomBar = { MonaBottomBar() }
    )
//    }
}

@Preview
@Composable
fun MonaBottomBar() {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Green
    ) {
        BottomBarItem.values().forEach {
            BottomNavigationItem(
                icon = { Icon(painterResource(id = it.icon), contentDescription = "Desc") },
                selectedContentColor = Blue700,
                unselectedContentColor = Grey900,
                selected = it.name == "Home",
                onClick = {
                    Log.d("asdf", "clicked!")
                })
        }
    }
}
