package com.example.mona.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mona.data.ItemCategoryData

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
