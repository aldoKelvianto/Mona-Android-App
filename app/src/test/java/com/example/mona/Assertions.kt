package com.example.mona

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed

fun SemanticsNodeInteraction.assertDisplayedExists() = run {
    assertIsDisplayed()
    assertExists()
}

fun SemanticsNodeInteraction.assertDisplayedExistsClickable() = run {
    assertIsDisplayed()
    assertExists()
    assertHasClickAction()
}
