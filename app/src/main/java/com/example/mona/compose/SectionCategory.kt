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
fun PreviewLazySectionCategory() {
    val list = ItemCategoryData.itemList
    LazyVerticalGrid(
        userScrollEnabled = false,
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        this.items(list) { item ->
            CategoryItem(item)
        }
    }
}

@Preview
@Composable
fun PreviewSectionCategory() {
    SectionCategory()
}

@Composable
fun SectionCategory() {
    val columnCount = 3
    val list = ItemCategoryData.itemList.chunked(columnCount)
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        list.forEach { rowList ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                rowList.forEach { rowItem ->
                    CategoryItem(category = rowItem)
                }
            }
        }
    }
}
