package com.example.mona.compose

import android.util.Log
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mona.state.NavigationItem

@Preview
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
        backgroundColor = Color.Gray,
        contentColor = Color.Black
    ) {
        list.forEach {
            BottomNavigationItem(
                icon = { Icon(painterResource(id = it.icon), contentDescription = "Desc") },
                label = { Text(text = it.name) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    Log.d("asdf", "clicked!")
                })
        }

    }
}
