package com.example.mona

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mona.ui.ScreenHome
import com.example.mona.ui.ScreenText

@Preview
@Composable
fun PreviewMonaApp() {
    MonaApp()
}

@Composable
fun MonaApp() {
    val appState = rememberMonaAppState()
    Scaffold(
        content = { paddingValues ->
            NavHost(
                navController = appState.navHostController,
                startDestination = BottomBarItem.Home.route
            ) {
                composable(BottomBarItem.Home.route) {
                    ScreenHome(bottomPadding = paddingValues.calculateBottomPadding())
                }
                composable(BottomBarItem.Cart.route) {
                    ScreenText(text = appState.cartScreenText)
                }
                composable(BottomBarItem.History.route) {
                    ScreenText(text = appState.historyScreenText)
                }
                composable(BottomBarItem.Profile.route) {
                    ScreenText(text = appState.profileScreenText)
                }
            }
        },
        bottomBar = {
            SectionBottomBar(appState.currentRoute) { clickedBottomBarItem ->
                appState.navigateToBottomBarRoute(clickedBottomBarItem)
            }
        }
    )
}

