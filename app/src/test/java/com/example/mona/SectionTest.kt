package com.example.mona

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithText
import com.example.mona.compose.SectionCategory
import com.example.mona.compose.SectionGreeting
import com.example.mona.compose.SectionLocation
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog


@RunWith(RobolectricTestRunner::class)
class SectionTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun `set up`() {
        // Redirect Logcat to console
        ShadowLog.stream = System.out
    }

    @Test
    fun `location section test`() {
        // Given
        composeTestRule.setContent {
            SectionLocation()
        }

        // When
        val textNode1 = composeTestRule.onNodeWithText("Mondstadt")
        val textNode2 = composeTestRule.onNodeWithText("15 menit")

        // Then
        textNode1.assertDisplayedExists()
        textNode2.assertDisplayedExists()
    }

    @Test
    fun `greeting section test`() {
        // Given
        composeTestRule.setContent {
            SectionGreeting()
        }

        // When
        val textNode = composeTestRule.onNodeWithText("Hey Traveller")

        // Then
        textNode.assertDisplayedExists()
    }

    @Test
    fun `category section test`() {
        // Given
        composeTestRule.setContent {
            SectionCategory()
        }

        // When
        val textNodes1 = composeTestRule.onAllNodesWithText("Sayur dan buah")
        val textNodes2 = composeTestRule.onAllNodesWithText("Osmanthus wine")

        // Then
        textNodes1.onFirst().assertDisplayedExists()
        textNodes2.onFirst().assertDisplayedExists()
    }
}
