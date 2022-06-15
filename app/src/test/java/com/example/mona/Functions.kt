package com.example.mona

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.test.platform.app.InstrumentationRegistry

fun SemanticsNodeInteraction.assertDisplayedExists() = run {
    assertIsDisplayed()
    assertExists()
}

fun SemanticsNodeInteraction.assertDisplayedExistsClickable() = run {
    assertIsDisplayed()
    assertExists()
    assertHasClickAction()
}


fun getString(id: Int): String =
    InstrumentationRegistry.getInstrumentation().targetContext.getString(id)
