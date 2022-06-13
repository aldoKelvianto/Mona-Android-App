package com.example.mona

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.mona.compose.ScreenHome
import com.example.mona.state.BottomBarItem
import org.junit.Rule
import org.junit.Test

class BottomNavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun profileScreenNavigation() {
        // Given
        composeTestRule.setContent {
            ScreenHome()
        }

        // When
        val bottomNode = composeTestRule.onNodeWithContentDescription(BottomBarItem.Profile.route)
        bottomNode.assertForClickable()
        bottomNode.performClick()

        // Then
        val textNode = composeTestRule.onNodeWithText("This is profile screen")
        textNode.assertForNonClickable()
    }
}
