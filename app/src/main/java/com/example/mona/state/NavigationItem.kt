package com.example.mona.state

import com.example.mona.R

sealed class NavigationItem(val name: String, val icon: Int) {
    object Home : NavigationItem(
        "Home",
        R.drawable.ic_home_filled_24
    )

    object Cart : NavigationItem("Cart", R.drawable.ic_home_filled_24)
    object History : NavigationItem("History", R.drawable.ic_home_filled_24)
    object Profile : NavigationItem("Profile", R.drawable.ic_home_filled_24)
}
