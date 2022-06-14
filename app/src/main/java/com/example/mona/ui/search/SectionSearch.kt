package com.example.mona.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, backgroundColor = 0xff212121, widthDp = 320, heightDp = 640)
@Composable
fun PreviewSectionSearchFavorite() {
    SectionSearch("Cari produk disini")
}

@Composable
fun SectionSearch(hint: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Search(hint = hint)
        Spacer(modifier = Modifier.size(8.dp))
        Favorite()
    }
}
