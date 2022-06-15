package com.example.mona.data

import com.example.mona.R

data class Category(
    val name: Int,
    val icon1: Int,
    val icon2: Int,
    val isHighlight: Boolean = false
)

object CategoryRepo {

    val sampleCategory =
        Category(R.string.category_1, R.drawable.ic_g1_vegs_a, R.drawable.ic_g1_vegs_b, true)

    val itemList = listOf(
        sampleCategory,
        Category(
            R.string.category_2,
            R.drawable.ic_g2_osmanthus_a,
            R.drawable.ic_g2_osmanthus_b,
            true
        ),
        Category(R.string.category_3, R.drawable.ic_g3_prod_a, R.drawable.ic_g3_prod_b, true),
        Category(R.string.category_4, R.drawable.ic_g4_food_a, R.drawable.ic_g4_food_b, true),
        Category(R.string.category_5, R.drawable.ic_g5_potions_a, R.drawable.ic_g5_potions_b, true),
        Category(R.string.category_6, R.drawable.ic_g6_ac_a, R.drawable.ic_g6_ac_b),
        Category(R.string.category_7, R.drawable.ic_g7_promo_a, R.drawable.ic_g7_promo_b),
        Category(R.string.category_8, R.drawable.ic_g8_book_a, R.drawable.ic_g8_book_b),
        Category(R.string.category_9, R.drawable.ic_g9_deal_a, R.drawable.ic_g9_deal_b),
        Category(R.string.category_10, R.drawable.ic_g10_crystal_a, R.drawable.ic_g10_crystal_b),
        Category(R.string.category_11, R.drawable.ic_g11_paper_a, R.drawable.ic_g11_paper_b),
        Category(R.string.category_12, R.drawable.ic_g12_new_a, R.drawable.ic_g12_new_b),
        sampleCategory,
        Category(R.string.category_2, R.drawable.ic_g2_osmanthus_a, R.drawable.ic_g2_osmanthus_b),
        Category(R.string.category_3, R.drawable.ic_g3_prod_a, R.drawable.ic_g3_prod_b),
    )
}
