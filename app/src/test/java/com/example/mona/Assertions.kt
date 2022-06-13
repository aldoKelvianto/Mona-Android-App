package com.example.mona

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed

fun SemanticsNodeInteraction.assertForNonClickable() = run {
    assertIsDisplayed()
    assertExists()
}

fun SemanticsNodeInteraction.assertForClickable() = run {
    assertIsDisplayed()
    assertExists()
    assertHasClickAction()
}
