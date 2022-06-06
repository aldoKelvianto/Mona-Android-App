package com.example.mona.compose

import android.util.Log
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mona.state.NavigationItem

@Composable
fun Home() {
    Scaffold(
        bottomBar = { BottomMenu() }
    ) {
    }
}

@Preview
@Composable
fun BottomMenu() {
    val list = listOf(
        NavigationItem.Home,
        NavigationItem.Cart,
        NavigationItem.History,
        NavigationItem.Profile,
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Green
    ) {
        list.forEach {
            BottomNavigationItem(
                icon = { Icon(painterResource(id = it.icon), contentDescription = "Desc") },
                label = { Text(text = it.name) },
                selectedContentColor = Blue700,
                unselectedContentColor = Color.Black,
                alwaysShowLabel = true,
                selected = it.name == "Home",
                onClick = {
                    Log.d("asdf", "clicked!")
                })
        }
    }
}
