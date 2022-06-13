package com.example.mona

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
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
    fun setUp() {
        // Redirect Logcat to console
        ShadowLog.stream = System.out
    }

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

    @Test
    fun `backstack simulation test`() {
        ActivityScenario.launch(MainActivity::class.java)
            .use { scenario ->
                scenario.onActivity { activity: MainActivity ->
                    val greetingNode = composeTestRule.onNodeWithText("Hey Traveller")
                    val gridNode = composeTestRule.onNodeWithText("Makanan")
                    greetingNode.assertForNonClickable()
                    gridNode.assertForNonClickable()

                    val bottomNode = composeTestRule.onNodeWithContentDescription(BottomBarItem.Profile.route)
                    bottomNode.assertForClickable()
                    bottomNode.performClick()

                    val textNode = composeTestRule.onNodeWithText("This is profile screen")
                    textNode.assertForNonClickable()
                    greetingNode.assertDoesNotExist()
                    gridNode.assertDoesNotExist()

                    activity.onBackPressed()
                    greetingNode.assertForNonClickable()
                    gridNode.assertForNonClickable()
                }
            }

        // An alternative to ActivityScenario is to use AndroidComposeTestRule
        // val composeTestRule = createAndroidComposeRule<MainActivity>()
        // See: https://developer.android.com/reference/kotlin/androidx/compose/ui/test/junit4/AndroidComposeTestRule
    }
}
