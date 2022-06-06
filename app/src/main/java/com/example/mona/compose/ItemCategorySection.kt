package com.example.mona.compose

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mona.data.ItemCategoryData

@Preview
@Composable
fun ItemCategorySection() {
    val list = ItemCategoryData.itemList
    LazyVerticalGrid(columns = GridCells.Fixed(3), content = {
        this.items(list) { item ->
            ItemCategory(item)
        }
    })
}
