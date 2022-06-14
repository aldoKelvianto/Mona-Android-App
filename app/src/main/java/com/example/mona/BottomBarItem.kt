package com.example.mona

import com.example.mona.R

enum class BottomBarItem(val route: String, val icon: Int) {
    Home("/home", R.drawable.ic_home_outline_24),
    Cart("/cart", R.drawable.ic_cart_outline_24),
    History("/history", R.drawable.ic_history_outline_24),
    Profile("/profile", R.drawable.ic_profile_outline_24),
}
