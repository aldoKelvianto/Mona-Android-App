package com.example.mona

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mona.ui.ScreenHome
import com.example.mona.ui.ScreenText

@Preview
@Composable
fun PreviewMonaApp() {
    MonaApp()
}

@Composable
fun MonaApp(monaAppState: MonaAppState) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: BottomBarItem.Home.route
    Scaffold(
        content = { paddingValues ->
            NavHost(navController = navController, startDestination = BottomBarItem.Home.route) {
                composable(BottomBarItem.Home.route) {
                    bottomPadding = paddingValues.calculateBottomPadding()
                    ScreenHome(monaAppState.screenHomeState)
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
            SectionBottomBar(currentRoute) { clickedBottomBarItem ->
                if (clickedBottomBarItem.route == currentRoute) {
                    return@SectionBottomBar
                }
                navController.navigate(clickedBottomBarItem.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    navController.graph.startDestinationRoute?.let { route ->
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

