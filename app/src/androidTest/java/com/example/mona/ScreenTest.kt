package com.example.mona

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.example.mona.compose.ScreenHome
import com.example.mona.compose.ScreenText
import com.example.mona.state.BottomBarItem
import org.junit.Rule
import org.junit.Test

class ScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun homeScreenTest() {
        // Given
        composeTestRule.setContent {
            ScreenHome()
        }

        // When
        val textNode = composeTestRule.onNodeWithText("Hey Traveller")
        val gridNode = composeTestRule.onNodeWithText("Makanan")
        val bottomNode = composeTestRule.onNodeWithContentDescription(BottomBarItem.Home.route)

        // Then
        textNode.assertForNonClickable()
        gridNode.assertForNonClickable()
        bottomNode.assertForClickable()
    }

    @Test
    fun profileScreenTest() {
        // Given
        composeTestRule.setContent {
            ScreenText(text = "This is profile screen")
        }

        // When
        val textNode = composeTestRule.onNodeWithText("This is profile screen")

        // Then
        textNode.assertForNonClickable()
    }
}
