package com.example.mona

import android.os.Build
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ActivityScenario
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.TIRAMISU])
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
        val resText = getString(R.string.screen_profile)
        composeTestRule.setContent {
            ScreenMain()
        }

        // When
        val bottomNode = composeTestRule.onNodeWithContentDescription(BottomBarItem.Profile.route)
        bottomNode.assertDisplayedExistsClickable()
        bottomNode.performClick()

        // Then
        val textNode = composeTestRule.onNodeWithText(resText)
        textNode.assertDisplayedExists()
    }

    @Test
    fun `one screen navigation`(): Unit = ActivityScenario.launch(MainActivity::class.java)
        .use { scenario ->
            scenario.onActivity { activity: MainActivity ->
                // Home screen
                val resTextNode = getString(R.string.section_greeting)
                val resGridNode = getString(R.string.category_4)
                val greetingNode = composeTestRule.onNodeWithText(resTextNode)
                val gridNode = composeTestRule.onNodeWithText(resGridNode)
                greetingNode.assertDisplayedExists()
                gridNode.assertDisplayedExists()

                // Click bottom navigation - profile
                val profileBottomNode =
                    composeTestRule.onNodeWithContentDescription(BottomBarItem.Profile.route)
                profileBottomNode.assertDisplayedExistsClickable()
                profileBottomNode.performClick()

                // Profile screen
                val resProfileText = getString(R.string.screen_profile)
                val profileTextNode = composeTestRule.onNodeWithText(resProfileText)
                profileTextNode.assertDisplayedExists()
                greetingNode.assertDoesNotExist()
                gridNode.assertDoesNotExist()

                // Press back one time
                activity.onBackPressed()

                // Home screen
                greetingNode.assertDisplayedExists()
                gridNode.assertDisplayedExists()
            }
        }

    @Test
    fun `multiple screen navigation`(): Unit = ActivityScenario.launch(MainActivity::class.java)
        .use { scenario ->
            scenario.onActivity { activity: MainActivity ->
                // Home screen
                val resTextNode = getString(R.string.section_greeting)
                val resGridNode = getString(R.string.category_4)
                val greetingNode = composeTestRule.onNodeWithText(resTextNode)
                val gridNode = composeTestRule.onNodeWithText(resGridNode)
                greetingNode.assertDisplayedExists()
                gridNode.assertDisplayedExists()

                // Click bottom navigation - profile
                val profileBottomNode =
                    composeTestRule.onNodeWithContentDescription(BottomBarItem.Profile.route)
                profileBottomNode.assertDisplayedExistsClickable()
                profileBottomNode.performClick()

                // Profile screen
                val resProfileText = getString(R.string.screen_profile)
                val profileTextNode = composeTestRule.onNodeWithText(resProfileText)
                profileTextNode.assertDisplayedExists()
                greetingNode.assertDoesNotExist()
                gridNode.assertDoesNotExist()

                // Click bottom navigation - history
                val historyBottomNode =
                    composeTestRule.onNodeWithContentDescription(BottomBarItem.History.route)
                historyBottomNode.assertDisplayedExistsClickable()
                historyBottomNode.performClick()

                // History screen
                val resHistoryText = getString(R.string.screen_history)
                val historyTextNode = composeTestRule.onNodeWithText(resHistoryText)
                historyTextNode.assertDisplayedExists()
                greetingNode.assertDoesNotExist()
                gridNode.assertDoesNotExist()

                // Click bottom navigation - cart
                val cartBottomNode =
                    composeTestRule.onNodeWithContentDescription(BottomBarItem.Cart.route)
                cartBottomNode.assertDisplayedExistsClickable()
                cartBottomNode.performClick()

                // Cart screen
                val resCartText = getString(R.string.screen_cart)
                val cartTextNode = composeTestRule.onNodeWithText(resCartText)
                cartTextNode.assertDisplayedExists()
                greetingNode.assertDoesNotExist()
                gridNode.assertDoesNotExist()

                // Press back one time
                activity.onBackPressed()

                // Home screen
                greetingNode.assertDisplayedExists()
                gridNode.assertDisplayedExists()
            }
        }
}
