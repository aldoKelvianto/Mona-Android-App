package com.example.mona

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.example.mona.compose.ScreenHome
import com.example.mona.compose.ScreenText
import com.example.mona.state.BottomBarItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
class ScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        // Redirect Logcat to console
        ShadowLog.stream = System.out
    }

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
    fun negativeTest() {
        // Given
        composeTestRule.setContent {
            ScreenText(text = "A")
        }

        // When
        val textNode = composeTestRule.onNodeWithText("B")

        // Then
        textNode.assertDoesNotExist()
    }

    @Test
    fun cartScreenTest() {
        // Given
        composeTestRule.setContent {
            ScreenText(text = "This is cart screen")
        }

        // When
        val textNode = composeTestRule.onNodeWithText("This is cart screen")

        // Then
        textNode.assertForNonClickable()
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
