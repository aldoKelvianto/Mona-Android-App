package com.example.mona

import android.os.Build
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithText
import com.example.mona.ui.category.SectionCategory
import com.example.mona.ui.greeting.SectionGreeting
import com.example.mona.ui.location.SectionLocation
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.TIRAMISU])
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
        val resTextNode1 = getString(R.string.section_location)
        val resTextNode2 = getString(R.string.section_distance)
        composeTestRule.setContent {
            SectionLocation()
        }

        // When
        val textNode1 = composeTestRule.onNodeWithText(resTextNode1)
        val textNode2 = composeTestRule.onNodeWithText(resTextNode2)

        // Then
        textNode1.assertDisplayedExists()
        textNode2.assertDisplayedExists()
    }

    @Test
    fun `greeting section test`() {
        // Given
        val resTextNode = getString(R.string.section_greeting)
        composeTestRule.setContent {
            SectionGreeting()
        }

        // When
        val textNode = composeTestRule.onNodeWithText(resTextNode)

        // Then
        textNode.assertDisplayedExists()
    }

    @Test
    fun `category section test`() {
        // Given
        val resCategory1 = getString(R.string.category_1)
        val resCategory2 = getString(R.string.category_2)
        composeTestRule.setContent {
            SectionCategory()
        }

        // When
        val textNodes1 = composeTestRule.onAllNodesWithText(resCategory1)
        val textNodes2 = composeTestRule.onAllNodesWithText(resCategory2)

        // Then
        textNodes1.onFirst().assertDisplayedExists()
        textNodes2.onFirst().assertDisplayedExists()
    }
}
