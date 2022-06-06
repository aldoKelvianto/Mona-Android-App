package com.example.mona.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mona.data.ItemCategoryData

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun ItemCategorySection() {
    val list = ItemCategoryData.itemList
    LazyVerticalGrid(cells = GridCells.Fixed(3), content = {
        items(list) { item -> ItemCategory(item) }
    })
}
