package com.example.mona.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mona.data.ItemCategoryData

@Preview
@Composable
fun OldItemCategorySection() {
    val list = ItemCategoryData.itemList
    LazyVerticalGrid(
        userScrollEnabled = false,
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        this.items(list) { item ->
            ItemCategory(item)
        }
    }
}

@Composable
fun ItemCategorySection() {
    val columnCount = 3
    val list = ItemCategoryData.itemList.chunked(columnCount)
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        list.forEach { rowList ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                rowList.forEach { rowItem ->
                    ItemCategory(category = rowItem)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewItemCategorySection() {
    ItemCategorySection()
}
