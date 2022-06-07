package com.example.mona.data

import com.example.mona.R

data class Category(val name: String, val icon1: Int, val icon2: Int)

val Category1 = Category("Sayur dan buah", R.drawable.ic_g1_vegs_a, R.drawable.ic_g1_vegs_b)

object ItemCategoryData {

    val itemList = listOf(
        Category1,
        Category("Osmanthus wine", R.drawable.ic_g2_osmanthus_a, R.drawable.ic_g2_osmanthus_b),
        Category("Produk internasional", R.drawable.ic_g3_prod_a, R.drawable.ic_g3_prod_b),
        Category("Makanan", R.drawable.ic_g4_food_a, R.drawable.ic_g4_food_b),
        Category("Obat-obatan", R.drawable.ic_g5_potions_a, R.drawable.ic_g5_potions_b),
        Category("Aksesoris", R.drawable.ic_g6_ac_a, R.drawable.ic_g6_ac_b),
        Category("Promo 40%", R.drawable.ic_g7_promo_a, R.drawable.ic_g7_promo_b),
        Category("Buku", R.drawable.ic_g8_book_a, R.drawable.ic_g8_book_b),
        Category("Special deals", R.drawable.ic_g9_deal_a, R.drawable.ic_g9_deal_b),
        Category("Crystal", R.drawable.ic_g10_crystal_a, R.drawable.ic_g10_crystal_b),
        Category("Kertas", R.drawable.ic_g11_paper_a, R.drawable.ic_g11_paper_b),
        Category("Terbaru", R.drawable.ic_g12_new_a, R.drawable.ic_g12_new_b),
        Category1,
        Category("Osmanthus wine", R.drawable.ic_g2_osmanthus_a, R.drawable.ic_g2_osmanthus_b),
        Category("Produk internasional", R.drawable.ic_g3_prod_a, R.drawable.ic_g3_prod_b),
        Category("Makanan", R.drawable.ic_g4_food_a, R.drawable.ic_g4_food_b),
        Category("Obat-obatan", R.drawable.ic_g5_potions_a, R.drawable.ic_g5_potions_b),
        Category("Aksesoris", R.drawable.ic_g6_ac_a, R.drawable.ic_g6_ac_b),
        Category("Promo 40%", R.drawable.ic_g7_promo_a, R.drawable.ic_g7_promo_b),
        Category("Buku", R.drawable.ic_g8_book_a, R.drawable.ic_g8_book_b),
        Category("Special deals", R.drawable.ic_g9_deal_a, R.drawable.ic_g9_deal_b),
        Category("Crystal", R.drawable.ic_g10_crystal_a, R.drawable.ic_g10_crystal_b),
        Category("Kertas", R.drawable.ic_g11_paper_a, R.drawable.ic_g11_paper_b),
        Category("Terbaru", R.drawable.ic_g12_new_a, R.drawable.ic_g12_new_b),
    )
}
