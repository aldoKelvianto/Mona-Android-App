package com.example.mona

import android.content.res.Resources
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Stable
class MainState(
    val navHostController: NavHostController,
    private val resources: Resources
) {
    val previousRoute: String
        @Composable
        get() = navHostController.currentBackStackEntryAsState().value?.destination?.route
            ?: BottomBarItem.Home.route

    val currentRoute: String
        get() = navHostController.currentDestination?.route ?: BottomBarItem.Home.route

    val cartScreenText: String
        get() = resources.getString(R.string.screen_cart)

    val historyScreenText: String
        get() = resources.getString(R.string.screen_history)

    val profileScreenText: String
        get() = resources.getString(R.string.screen_profile)
}


