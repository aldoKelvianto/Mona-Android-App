package com.example.mona

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.example.mona.ui.ScreenText
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
    fun `set up`() {
        // Redirect Logcat to console
        ShadowLog.stream = System.out
    }

    @Test
    fun `home screen test`() {
        // Given
        val resTextNode = getString(R.string.section_greeting)
        val resGridNode = getString(R.string.category_4)
        composeTestRule.setContent {
            MonaApp()
        }

        // When
        val textNode = composeTestRule.onNodeWithText(resTextNode)
        val gridNode = composeTestRule.onNodeWithText(resGridNode)
        val bottomNode = composeTestRule.onNodeWithContentDescription(BottomBarItem.Home.route)

        // Then
        textNode.assertDisplayedExists()
        gridNode.assertDisplayedExists()
        bottomNode.assertDisplayedExistsClickable()
    }

    @Test
    fun `negative case test`() {
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
    fun `cart screen test`() {
        // Given
        val resText = getString(R.string.screen_cart)
        composeTestRule.setContent {
            ScreenText(text = resText)
        }

        // When
        val textNode = composeTestRule.onNodeWithText(resText)

        // Then
        textNode.assertDisplayedExists()
    }

    @Test
    fun `profile screen test`() {
        // Given
        val resText = getString(R.string.screen_profile)
        composeTestRule.setContent {
            ScreenText(text = resText)
        }

        // When
        val textNode = composeTestRule.onNodeWithText(resText)

        // Then
        textNode.assertDisplayedExists()
    }
}
