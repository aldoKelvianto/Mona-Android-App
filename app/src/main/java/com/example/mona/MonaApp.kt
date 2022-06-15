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
fun MonaApp(appState: MonaAppState = rememberMonaAppState()) {
    val previousRoute = appState.previousRoute
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
                if (clickedBottomBarItem.route == previousRoute) {
                    return@SectionBottomBar
                }
                appState.navHostController.navigate(clickedBottomBarItem.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    appState.navHostController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    // Restore state when re-selecting a previously selected item
                    restoreState = true
                }
            }
        }
    )
}

