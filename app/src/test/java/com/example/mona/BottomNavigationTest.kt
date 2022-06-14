package com.example.mona

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ActivityScenario
import com.example.mona.compose.ScreenHome
import com.example.mona.state.BottomBarItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog


@RunWith(RobolectricTestRunner::class)
class BottomNavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun `set up`() {
        // Redirect Logcat to console
        ShadowLog.stream = System.out
    }

    @Test
    fun `profile screen navigation`() {
        // Given
        composeTestRule.setContent {
            ScreenHome()
        }

        // When
        val bottomNode = composeTestRule.onNodeWithContentDescription(BottomBarItem.Profile.route)
        bottomNode.assertDisplayedExistsClickable()
        bottomNode.performClick()

        // Then
        val textNode = composeTestRule.onNodeWithText("This is profile screen")
        textNode.assertDisplayedExists()
    }

    @Test
    fun `one screen navigation`(): Unit = ActivityScenario.launch(MainActivity::class.java)
        .use { scenario ->
            scenario.onActivity { activity: MainActivity ->
                // Home screen
                val greetingNode = composeTestRule.onNodeWithText("Hey Traveller")
                val gridNode = composeTestRule.onNodeWithText("Makanan")
                greetingNode.assertDisplayedExists()
                gridNode.assertDisplayedExists()

                // Click profile in bottom navigation
                val profileBottomNode =
                    composeTestRule.onNodeWithContentDescription(BottomBarItem.Profile.route)
                profileBottomNode.assertDisplayedExistsClickable()
                profileBottomNode.performClick()

                // Profile screen
                val profileTextNode = composeTestRule.onNodeWithText("This is profile screen")
                profileTextNode.assertDisplayedExists()
                greetingNode.assertDoesNotExist()
                gridNode.assertDoesNotExist()

                // Home screen again
                activity.onBackPressed()
                greetingNode.assertDisplayedExists()
                gridNode.assertDisplayedExists()
            }
        }

    @Test
    fun `multiple screen navigation`(): Unit = ActivityScenario.launch(MainActivity::class.java)
        .use { scenario ->
            scenario.onActivity { activity: MainActivity ->
                // Home screen
                val greetingNode = composeTestRule.onNodeWithText("Hey Traveller")
                val gridNode = composeTestRule.onNodeWithText("Makanan")
                greetingNode.assertDisplayedExists()
                gridNode.assertDisplayedExists()

                val profileBottomNode =
                    composeTestRule.onNodeWithContentDescription(BottomBarItem.Profile.route)
                profileBottomNode.assertDisplayedExistsClickable()
                profileBottomNode.performClick()

                val profileTextNode = composeTestRule.onNodeWithText("This is profile screen")
                profileTextNode.assertDisplayedExists()
                greetingNode.assertDoesNotExist()
                gridNode.assertDoesNotExist()

                val historyBottomNode =
                    composeTestRule.onNodeWithContentDescription(BottomBarItem.History.route)
                historyBottomNode.assertDisplayedExistsClickable()
                historyBottomNode.performClick()

                val textNode = composeTestRule.onNodeWithText("This is history screen")
                textNode.assertDisplayedExists()
                greetingNode.assertDoesNotExist()
                gridNode.assertDoesNotExist()

                activity.onBackPressed()

                greetingNode.assertDisplayedExists()
                gridNode.assertDisplayedExists()
            }
        }
}
