package com.example.mona.data

import com.example.mona.R

data class Category(val name: String, val icon1: Int, val icon2: Int)

val Category1 = Category("Sayur dan buah", R.drawable.ic_g1_vegs_a, R.drawable.ic_g1_vegs_b)

object ItemCategoryData {

    val itemList = listOf(
        Category1,
        Category1,
        Category1,
        Category1,
        Category1,
    )
}
