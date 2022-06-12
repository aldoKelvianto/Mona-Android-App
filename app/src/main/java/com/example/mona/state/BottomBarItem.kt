package com.example.mona.state

import com.example.mona.R

enum class BottomBarItem(var isSelected: Boolean, val route: String, val icon: Int) {
    Home(true, "/home", R.drawable.ic_home_outline_24),
    Cart(false, "/cart", R.drawable.ic_cart_outline_24),
    History(false, "/history", R.drawable.ic_history_outline_24),
    Profile(false, "/profile", R.drawable.ic_profile_outline_24),
}
