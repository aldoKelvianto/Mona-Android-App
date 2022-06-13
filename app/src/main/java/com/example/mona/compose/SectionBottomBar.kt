package com.example.mona.compose

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mona.state.BottomBarItem

@Preview
@Composable
fun PreviewMonaBottomBar() {
    SectionBottomBar()
}

@Composable
fun SectionBottomBar(
    bottomBarItemList: List<BottomBarItem> = BottomBarItem.values().asList(),
    onNavigationItemClick: (bottomBarItem: BottomBarItem) -> Unit = {}
) {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Green
    ) {
        val blue = Color(0xff2A5DC2)
        val black = Color(0xff242424)
        bottomBarItemList.forEach {
            BottomNavigationItem(
                icon = { Icon(painterResource(id = it.icon), contentDescription = "Desc") },
                selectedContentColor = blue,
                unselectedContentColor = black,
                selected = it.isSelected,
                onClick = {
                    onNavigationItemClick(it)
                })
        }
    }
}
