package com.example.mona

import android.content.res.Resources
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberMonaAppState(
    navHostController: NavHostController = rememberNavController(),
    resources: Resources = resources()
) = remember(navHostController, resources) {
    MonaAppState(navHostController, resources)
}


@Stable
class MonaAppState(
    val navHostController: NavHostController,
    val resources: Resources
) {
    val currentRoute: String
        get() = navHostController.currentDestination?.route ?: BottomBarItem.Home.route

    val cartScreenText: String
        get() = resources.getString(R.string.screen_cart)

    val historyScreenText: String
        get() = resources.getString(R.string.screen_history)

    val profileScreenText: String
        get() = resources.getString(R.string.screen_profile)

    fun navigateToBottomBarRoute(clickedBottomBarItem: BottomBarItem) {
        if (clickedBottomBarItem.route == currentRoute) {
            return
        }
        navHostController.navigate(clickedBottomBarItem.route) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            navHostController.graph.startDestinationRoute?.let { route ->
                popUpTo(route) {
                    saveState = true
                }
            }
            // Restore state when re-selecting a previously selected item
            restoreState = true
        }
    }
}

@Composable
@ReadOnlyComposable
private fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}


