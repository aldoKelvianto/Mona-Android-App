package com.example.mona.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mona.state.BottomBarItem

@Preview
@Composable
fun PreviewScreenHome() {
    ScreenHome()
}

@Composable
fun ScreenHome() {
    val scrollState = rememberScrollState()
    val navController = rememberNavController()
    val bottomBarItemList = remember {
        mutableStateListOf<BottomBarItem>().apply { addAll(BottomBarItem.values()) }
    }
    Scaffold(
        content = { paddingValues ->
            NavHost(navController = navController, startDestination = BottomBarItem.Home.route) {
                composable(BottomBarItem.Home.route) {
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
                }
                composable(BottomBarItem.Cart.route) {
                    ScreenText(text = "This is cart screen")
                }
                composable(BottomBarItem.History.route) {
                    ScreenText(text = "This is history screen")
                }
                composable(BottomBarItem.Profile.route) {
                    ScreenText(text = "This is profile screen")
                }
            }
        },
        bottomBar = {
            SectionBottomBar(bottomBarItemList) { clickedBottomBarItem ->
                bottomBarItemList.apply {
                    clear()
                    addAll(BottomBarItem.values().toMutableList().map {  item ->
                        item.isSelected = item.route == clickedBottomBarItem.route
                        item
                    })
                }
                navController.navigate(clickedBottomBarItem.route)
            }
        }
    )
}

