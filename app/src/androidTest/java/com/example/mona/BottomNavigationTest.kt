package com.example.mona

import androidx.compose.ui.test.SemanticsNodeInteraction
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
    fun homeScreenTest() {
        // Given
        composeTestRule.setContent {
            ScreenHome()
        }
        // When
        val textNode: SemanticsNodeInteraction =
            composeTestRule.onNodeWithText("Hey Traveller")
        // Then
        textNode.assertExists()
    }

    @Test
    fun test1() {
        // Given
        composeTestRule.setContent {
            ScreenHome()
        }
        // When
        val bottomItemNode: SemanticsNodeInteraction =
            composeTestRule.onNodeWithContentDescription(BottomBarItem.Cart.route)
        bottomItemNode.performClick()
        // Then
        val textNode = composeTestRule.onNodeWithText("This is cart screen")
        textNode.assertExists()
    }
}
